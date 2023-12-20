
/**
 * A multithreaded chat room server.  
 * The  chat server executive calls startServer, which runs 
 * ChatServer in a thread, in order not to block the GUI.
 * This top-level thread listens for a client to connect, 
 * asks for the client's Screen Name, checks it for duplication,
 * and if ok, starts a new thread by which the server will
 * interact with this client. This thread allows the server
 * to interact with many clients at once.  The names of all
 * clients are kept in a field HashSet<String> names to allow
 * checking for duplicate screen names, and the output streams 
 * are kept in a field named HashSet<PrintWriter> writers, in order
 * that each message can be retransmitted to all the clients.
 * 
 * When a client connects the
 * server requests a screen name by sending the client the
 * text "SUBMITNAME", and keeps requesting a name until
 * a unique one is received.  After a client submits a unique
 * name, the server acknowledges with "NAMEACCEPTED".  Then
 * all messages from that client will be broadcast to all other
 * clients that have submitted a unique screen name.  The
 * broadcast messages are prefixed with "MESSAGE ".
 * 
 */
public interface ChatServerExecInterface {

    /**
     * Starts an instance of a server in a thread so that GUI thread can continue to operate asynchronously
     * @param port
     */
   public void startServer(int port);
    
}