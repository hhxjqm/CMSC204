

import java.io.IOException;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class CourseDBGUI extends Application {  
	/**
	 * The main method for the GUI JavaFX version
	 * @param args not used
	 * @throws IOException
	 */
	public static void main(String[] args) {
		launch(args);   
	}
	
	@Override
	public void start(Stage stage) throws Exception {
		//  instantiate the FXMainPane, name it root
		FXMainPane root = new FXMainPane();
		//  set the scene to hold root
		stage.setScene(new Scene(root, 600,700));
		//set stage title
		stage.setTitle("Course Database");
		//display the stage
		stage.show();
	}
}