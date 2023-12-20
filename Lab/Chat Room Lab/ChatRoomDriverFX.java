

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class ChatRoomDriverFX extends Application {
	   
	/**
	 * The main method for the GUI for ChatRoomControlFX (JavaFX version)
	 * Note: launch sets up GUI infrastructure and calls start(Stage stage)
	 * This application was derived from one by Professor Ray Toal, Ph.D.,
	 * Loyola MaryMount University, http://www.cs.lmu.edu/faculty
	 * @param args not used
	 */
	public static void main(String[] args) {
		launch(args);   
	}
		   
	/**
	 * Called from launch(...) of program's main method.  This is the starting point
	 * of the GUI and the overall application
	 * @param stage the top-level container of the JavaFX application.  
	 * 				Provided by launch when it calls start(...)
	 * @throws Exception
	 */
	@Override
	public void start(Stage stage) throws Exception {
		//call the main scene which is a BorderPane
		ChatRoomMainFX root = new ChatRoomMainFX();
        stage.setScene(new Scene(root, 500, 200));
		// Set stage title and show the stage.
		stage.setTitle("Chat Room Controller");
		stage.show();

	}
}
