

import javax.swing.JOptionPane;

import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 * This panel is the basic panel, inside which other panels are placed.  
 * @author ralexander
 *
 */
//make the main panel's layout be a BorderPane
public class ChatRoomMainFX extends BorderPane {

	private static final int CHAT_ROOM_PORT = 5001;
	private Button startClientButton, exitButton, startServerButton;
	private Label titleLabel, instructionsLabel1, instructionsLabel2,instructionsLabel3, instructionsLabel4, instructionsLabel5;

	private boolean serverStarted = false;

	
	/**
	 * The MainPanel constructor sets up the entire GUI in this template.  
	 * This application assumes that the server and clients will be run
	 * on the same computer.
	 */
	ChatRoomMainFX() {
		
		Insets inset1 = new Insets(10); //for setting margins		
		titleLabel = new Label("\tChat Room Controller");
		titleLabel.setStyle("-fx-font-size: 20;");
		instructionsLabel1 = new Label("\t\t1.  Start the server.");
		instructionsLabel2 = new Label("\t\t2.  Start a client.");
		instructionsLabel3 = new Label("\t\t3.  Enter a screen name in the client's GUI.");
		instructionsLabel4 = new Label("\t\t4.  Start more clients.");
		instructionsLabel5 = new Label("\t\t5.  Enter a message in a client's GUI.");
		
		VBox centerPane = new VBox();
		centerPane.setAlignment(Pos.CENTER_LEFT);
		centerPane.getChildren().addAll(titleLabel, instructionsLabel1, instructionsLabel2,
				instructionsLabel3, instructionsLabel4, instructionsLabel5);
		centerPane.setStyle("-fx-border-color: gray;");

	    setCenter(centerPane);
	    
	    //create the buttons and add them to the bottom region
	    //create the exitButton
	    exitButton = new Button("_Exit");
		//_ in label specifies that the next character is the mnemonic, ie, type Alt-m as a shortcut
	    //this activates the mnemonic on exitButton when the Alt key is pressed
	    exitButton.setMnemonicParsing(true);  
	    exitButton.setTooltip(new Tooltip("Select to close the server, all clients, and the application"));
	    //use a lambda expression for the EventHandler class for exitButton
        exitButton.setOnAction(
        		event -> {
        		 System.out.println("Closing the server, all clients, and the application");
            	 Platform.exit();
                 System.exit(0);
        		}
        	);
	    
	    //create another button
	    startClientButton = new Button("Start each _Client");
	    startClientButton.setMnemonicParsing(true);  
	    startClientButton.setTooltip(new Tooltip("Select this to start a Chat Room client. Can be selected multiple times."));
	    //create a listener for the other button using a lambda expression
	    startClientButton.setOnAction(event -> {
	    	if (serverStarted)	{
	    		System.out.println("Starting a new client at port: "+CHAT_ROOM_PORT);
	    		ChatClientExec chatClientExec = new ChatClientExec(CHAT_ROOM_PORT);
	    		try {
					chatClientExec.startClient();
				} catch (Exception e) {
					e.printStackTrace();
				}
	    	}
	    	else JOptionPane.showMessageDialog(null, "Start the server first.");
		});
	    
	    
	    //create the mgrButton
	    startServerButton = new Button("Start the _Server");
	    startServerButton.setMnemonicParsing(true);  
	    startServerButton.setTooltip(new Tooltip("Select this to start the Chat Room server - do this once only"));
	    //create a listener for the startServerButton button using a lambda expression
	    startServerButton.setOnAction(event -> {
	    	if (serverStarted)	JOptionPane.showMessageDialog(null, "Server is already running - not restarted");
	    	else {
	    		serverStarted=true;
	    		System.out.println("Starting the server at hostname localhost at port: "+CHAT_ROOM_PORT);
	    		//create the ChatServer instance and start the server
	    		ChatServerExec chatServerExec = new ChatServerExec(CHAT_ROOM_PORT);
	    		chatServerExec.startServer();
	    	}
	    });
	    
	    HBox bottomBox = new HBox();
	    HBox.setMargin(startClientButton, inset1);
	    HBox.setMargin(startServerButton, inset1);
	    HBox.setMargin(exitButton, inset1);
	    bottomBox.getChildren().addAll( startServerButton, startClientButton, exitButton); // 
	    setBottom(bottomBox);
	    bottomBox.setAlignment(Pos.CENTER);
		
		

	}
}
	