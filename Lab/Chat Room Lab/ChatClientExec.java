
/**
 * The client follows the Chat Protocol which is as follows.
 * When the server sends "SUBMITNAME" the client replies with the
 * desired screen name.  The server will keep sending "SUBMITNAME"
 * requests as long as the client submits screen names that are
 * already in use.  When the server sends a line beginning
 * with "NAMEACCEPTED" the client is now allowed to start
 * sending the server arbitrary strings to be broadcast to all
 * chatters connected to the server.  When the server sends a
 * line beginning with "MESSAGE " then all characters following
 * this string should be displayed in its message area.
 */
public class ChatClientExec implements ChatClientExecInterface {

    private int CHAT_ROOM_PORT=0;

    private static double clientX = 30.0;
    private static double clientY = 10.0;
    /**
     * Constructs the client by laying out the GUI and registering a
     * listener with the textfield so that pressing Return in the
     * listener sends the textfield contents to the server.  Note
     * however that the textfield is initially NOT editable, and
     * only becomes editable AFTER the client receives the NAMEACCEPTED
     * message from the server.
     */
    public ChatClientExec(int port) {
    	CHAT_ROOM_PORT=port;
    }
    
	/**
     * Runs the client
     */
    public void startClient() throws Exception {
    	setClientY(getClientY() + 50.0);
    	setClientX(getClientX() + 50.0);
    	ChatClient client = new ChatClient(CHAT_ROOM_PORT);
    	//TODO STUDENT: create a thread with client in it
    	Thread clientThread=new Thread(client);
    	clientThread.start();
    }

	public static double getClientX() {
		return clientX;
	}

	public static void setClientX(double clientX) {
		ChatClientExec.clientX = clientX;
	}

	public static double getClientY() {
		return clientY;
	}

	public static void setClientY(double clientY) {
		ChatClientExec.clientY = clientY;
	}


}
