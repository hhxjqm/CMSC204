import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Reader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashSet;
import javax.swing.JOptionPane;

//TODO STUDENT: edit the class header so that ChatServer can run in a thread
public class ChatServer  implements Runnable{ 
    private String name;
    private Socket clientSocket;
    private BufferedReader in;
    private PrintWriter out;

	ChatServer(int port) {
		CHAT_ROOM_PORT = port;
	}
    
    /**
     * The port that the server listens on.
     */
    private static int CHAT_ROOM_PORT;

    /**
     * The set of all names of clients in the chat room.  Maintained
     * so that we can check that new clients are not registering name
     * already in use.
     */
    private static HashSet<String> names = new HashSet<String>();

    /**
     * The set of all the print writers for all the clients.  This
     * set is kept so we can easily broadcast messages.
     */
    private static HashSet<PrintWriter> writers = new HashSet<PrintWriter>();
	
	//@Override
	public void run() {
        ServerSocket listener = null;
		try {
			//TODO STUDENT: create a server socket
			listener=new ServerSocket(CHAT_ROOM_PORT);
			System.out.println("The chat server is running.");
            while (true) {	
            	//TODO STUDENT: listen for a client to join, then setup input and output channels
            	clientSocket=listener.accept();
            	InputStream inStream=clientSocket.getInputStream();
            	OutputStream outStream=clientSocket.getOutputStream();
            	out=new PrintWriter(outStream);
            	Reader readIn=new InputStreamReader(inStream);
    			in= new BufferedReader(readIn);
                // Request a name from this client.  Keep requesting until
                // a name is submitted that is not already used.  Note that
                // checking for the existence of a name and adding the name
                // must be done while locking the set of names.
                name=null;
                while (name==null) {
                    out.println("SUBMITNAME");
                    out.flush();
                    name = in.readLine();
                    //add name to list of valid names if name!=null and name is not a duplicate
                    if (name.equals("")) name=null;  //note: readLine() returns a string, so it returns "null", not null
                    else if (name.equals("null")) name=null;
                    else if (names.contains(name)) {
                    	//JOptionPane.showMessageDialog(null, "Screen Name "+name+" is already in use.");
                    	out.println("WRONGNAME");
                    	Thread.sleep(100);
                    	name=null;
                    }
                    else names.add(name);	                    
                }
                // Now that a successful name has been chosen, add the
                // socket's print writer to the set of all writers so
                // this client can receive broadcast messages and start a 
                // new server thread to handle the client
                out.println("NAMEACCEPTED");
                out.flush();
                writers.add(out);
                ServerThreadForClient svrForClient = new ServerThreadForClient(in,out,name);
                
                Thread t = new Thread(svrForClient);
                t.start();
            }
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
            
    private class ServerThreadForClient implements Runnable {
    	BufferedReader in;
    	PrintWriter out;
    	String name;
    	
    	ServerThreadForClient (BufferedReader in, PrintWriter out, String name) {
    		this.in =in;
    		this.out =out;
    		this.name= name;
    	}
    	
    	@Override
		public void run() {
            // Accept messages from this client and broadcast them.
            // Ignore other clients that cannot be broadcasted to.
    		try {
                while (true) {
                    String input;
					try {
						input = in.readLine();
					
	                    if (input == null) {
	                        return;
	                    }
	                    for (PrintWriter writer : writers) {
	                        writer.println("MESSAGE " + name + ": " + input);
	                        writer.flush();
	                    }
	                } catch (IOException e) {
						e.printStackTrace();
					}
                }
    		}
            finally {
            // This client is going down!  Remove its name and its print
            // writer from the sets, and close its socket.
            if (name != null) {
                names.remove(name);
            }
            if (out != null) {
                writers.remove(out);
            }
            try {
                clientSocket.close();
            } catch (IOException e) {
            }
        }
			
	}
    	
   }
    
}