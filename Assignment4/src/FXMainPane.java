import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.swing.JOptionPane;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Tooltip;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;

/**
 * This panel is the basic panel, inside which other panels are placed.  
 * Before beginning to implement, design the structure of your GUI in order to 
 * understand what panels go inside which ones, and what buttons or other components
 * go in which panels.  
 * @author ralexander
 *
 */
//make the main panel's layout be a VBox
public class FXMainPane extends VBox {
	
	private RadioButton courseFile, courseArray;
	Button inputButton, dbButton, showDB, getCourse, selectFile, selectArray, clear, exit, findCourseButton;
	Label label1= new Label("Course ID");
	Label label2= new Label("CRN");
	Label label3= new Label("Credits");
	Label label4= new Label("Room Number");
	Label label5= new Label("Instructor");
	Label label6= new Label("CRN to retrieve");

	private File inputFile;
	ToggleGroup group;
	TextField textfield1, textfield2, textfield3, textfield4, textfield5, DBTextField, textfield6;
	//  declare two HBoxes
	HBox hBox1, hBox2, hBox3;
	//declare five VBoxes
	VBox vBox1, vBox2, vBox3, vBox4, vBox5, vBox6;
	private Alert alert = new Alert(AlertType.INFORMATION);
	
	//  declare an instance of DataManager
	CourseDBManager dataMgr;
	
	public void createRadioButtons () {
		
		HBox radioPanel = new HBox();
		
		courseFile = new RadioButton("Create Database from File     ");
		courseArray = new RadioButton("Add to Database from Fields");
		group = new ToggleGroup();
		courseFile.setToggleGroup(group);
		courseArray.setToggleGroup(group);
		courseFile.setSelected(true);
		dbButton.setDisable(true);
		showDB.setDisable(true);
		getCourse.setDisable(true);
		textfield1.setDisable(true);
		textfield2.setDisable(true);
		textfield3.setDisable(true);
		textfield4.setDisable(true);
		textfield5.setDisable(true);
		
		textfield6.setDisable(true);
		label6.setDisable(true);
		findCourseButton.setDisable(true);
		
		courseFile.setOnAction(new RadioListener());
		courseArray.setOnAction(new RadioListener());
		
		radioPanel.getChildren().addAll(courseFile,courseArray);
		TitledPane radioTitlePane = new TitledPane("Please Select from Following Options:",
				radioPanel);
		radioTitlePane.setCollapsible(false);
		Insets inset = new Insets(100, 10, 100, 10);
		HBox.setMargin(radioPanel,inset);
		getChildren().addAll(radioTitlePane);
	}
	
	private class RadioListener implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent e) {

			if(courseFile.isSelected())
			{
				// make inputfile button enabled
				inputButton.setDisable(false);
				dbButton.setDisable(true);
				//showDB.setDisable(true);
				findCourseButton.setDisable(true);
				textfield1.setDisable(true);
				textfield2.setDisable(true);
				textfield3.setDisable(true);
				textfield4.setDisable(true);
				textfield5.setDisable(true);

				textfield6.setDisable(true);
				label6.setDisable(true);
				findCourseButton.setDisable(true);		 
			}
			// 
			else
			{
				inputButton.setDisable(true);
				dbButton.setDisable(false);
				//showDB.setDisable(true);
				findCourseButton.setDisable(true);
				//showDB.setDisable(false);
				textfield1.setDisable(false);
				textfield2.setDisable(false);
				textfield3.setDisable(false);
				textfield4.setDisable(false);
				textfield5.setDisable(false);
				
				textfield6.setDisable(true);
				label6.setDisable(true);
				findCourseButton.setDisable(true);
				
				
				//textTitlePane.setVisible(true);
			 
			}
		}
	}

	/**
	 * The MainPanel constructor sets up the entire GUI in this approach.  Remember to
	 * wait to add a component to its containing component until the container has
	 * been created.  This is the only constraint on the order in which the following 
	 * statements appear.
	 */
	FXMainPane() {

		inputButton = new Button("Input File");
		dbButton = new Button("Add to DB");
		showDB = new Button("Show DB");
		getCourse = new Button("Get Course");
		clear = new Button("Clear");
		exit = new Button("Exit");
		findCourseButton = new Button("Find Course");
		
		
		//textfield = new TextField();
		//  instantiate the HBoxes
		hBox1 = new HBox();
		hBox2 = new HBox();
		hBox3 = new HBox();
		//  instantiate the VBoxes
		vBox1 = new VBox();
		vBox2 = new VBox();
		vBox3 = new VBox();
		vBox4 = new VBox();
		vBox5 = new VBox();
		vBox6 = new VBox();
		textfield1 = new TextField();
		textfield2 = new TextField();
		textfield3 = new TextField();
		textfield4 = new TextField();
		textfield5 = new TextField();
		textfield6 = new TextField();
		
		DBTextField = new TextField();

		inputButton.setOnAction(new ButtonHandler());
		//outputButton.setOnAction(new ButtonHandler());
		dbButton.setOnAction(new ButtonHandler());
		showDB.setOnAction(new ButtonHandler());
		getCourse.setOnAction(new ButtonHandler());
		findCourseButton.setOnAction(new ButtonHandler());

		

		//  instantiate the DataManager instance
		 dataMgr = new CourseDBManager();
		
			
		createRadioButtons();
		
		hBox1.getChildren().addAll(vBox1,vBox2,vBox3,vBox4,vBox5);
	//  add the label and textfield to each of the VBoxes
		vBox1.getChildren().addAll(label1, textfield1);
		vBox2.getChildren().addAll(label2, textfield2);
		vBox3.getChildren().addAll(label3, textfield3);
		vBox4.getChildren().addAll(label4, textfield4);
		vBox5.getChildren().addAll(label5, textfield5);
		vBox6.getChildren().addAll(label6, textfield6, findCourseButton);
		//  add the buttons to the other HBox
		hBox2.getChildren().addAll(inputButton, dbButton, showDB, getCourse, clear,exit);
		hBox3.getChildren().addAll(vBox6);
		//  add the HBoxes to this FXMainPanel (a VBox)
		getChildren().addAll(hBox1,hBox2,hBox3);
		
		clear.setOnAction(new ButtonHandler());
		exit.setOnAction(new ButtonHandler());
		
		hBox1.setAlignment(Pos.CENTER);
		hBox2.setAlignment(Pos.CENTER);
		hBox3.setAlignment(Pos.CENTER);
		
		Insets inset = new Insets(100, 10, 100, 10);
		HBox.setMargin(inputButton, inset);
		HBox.setMargin(dbButton, inset);
		HBox.setMargin(findCourseButton, inset);
		HBox.setMargin(clear, inset);
		HBox.setMargin(exit, inset);
		
		inset = new Insets(30, 10, 10, 10);
		vBox1.setAlignment(Pos.CENTER);
		vBox2.setAlignment(Pos.CENTER);
		vBox3.setAlignment(Pos.CENTER);
		vBox4.setAlignment(Pos.CENTER);
		vBox5.setAlignment(Pos.CENTER);
		vBox6.setAlignment(Pos.CENTER);
		VBox.setMargin(label1, inset);
		VBox.setMargin(label2, inset);
		VBox.setMargin(label3, inset);
		VBox.setMargin(label4, inset);
		VBox.setMargin(label5, inset);
		VBox.setMargin(label6, inset);

		inset = new Insets(1, 10, 10, 10);
		VBox.setMargin(textfield1, inset);
		VBox.setMargin(textfield2, inset);
		VBox.setMargin(textfield3, inset);
		VBox.setMargin(textfield4, inset);
		VBox.setMargin(textfield5, inset);
		VBox.setMargin(textfield6, inset);
		

	}
	
	//  create a private inner class to handle the button clicks
	private class ButtonHandler implements EventHandler<ActionEvent> {

		@Override
		public void handle(ActionEvent event) {
		
			if (event.getTarget()==clear) {
				textfield1.setText("");
				textfield2.setText("");
				textfield3.setText("");
				textfield4.setText("");
				textfield5.setText("");
				textfield6.setText("");
			} else if (event.getTarget()==inputButton) { 
				FileChooser chooser = new FileChooser();
				chooser.setTitle("Choose a file to read from");
				if ((inputFile = chooser.showOpenDialog(null)) != null) {

					if (!inputFile.canRead())
						try {
							throw new IOException();
						} catch (IOException e1) {
							e1.printStackTrace();
						}
		
					try {
						String list = "";
						dataMgr.readFile(inputFile);
					} catch (FileNotFoundException e) {
						e.printStackTrace();
					}
					showDB.setDisable(false);
					getCourse.setDisable(false);
					
				}
			} 
			
			else if (event.getTarget()==dbButton) {
				String id = textfield1.getText();
				String crnStr = textfield2.getText();
				int crn=0; 
				if(!crnStr.equals("")) 
					crn =  Integer.parseInt(crnStr);
				String creditsStr = textfield3.getText();
				int credits=0; 
				if(!creditsStr.equals("")) 
					credits =  Integer.parseInt(creditsStr);
				String roomNum = textfield4.getText();
				String instructor = textfield5.getText();
				//System.out.println(id+" "+crn+" "+credits+" "+roomNum+" "+instructor);
				dataMgr.add(id,crn,credits,roomNum,instructor);
				showDB.setDisable(false);
				getCourse.setDisable(false);
			} else if (event.getTarget()==showDB) {
				//System.out.println(dataMgr.showAll());
				String list = "";
				ArrayList<String> elements = dataMgr.showAll();
				for(String element : elements) {
					list = list+"\n"+element;
				}
				System.out.println("list =" + list);
				alert.setContentText(list);
				alert.showAndWait();
			}
			else if (event.getTarget()==getCourse) {
				//System.out.println("getCourse button selected");
				textfield6.setDisable(false);
				label6.setDisable(false);
				findCourseButton.setDisable(false);
			}
			else if (event.getTarget()==findCourseButton) {
				//System.out.println("findCourseButton selected");
				String crnStr = textfield6.getText();
				
				CourseDBElement cde = new CourseDBElement();
				cde.setCRN(Integer.parseInt(crnStr));
				System.out.println(dataMgr.get(Integer.parseInt(crnStr)));
				alert.setContentText(""+dataMgr.get(Integer.parseInt(crnStr)));
				alert.showAndWait();
				//System.out.println(cde);
			}
			else if (event.getTarget()==exit) {
				System.exit(0);;
				
			}
		}
		

	}
	private void setupFields() {
		textfield1.setDisable(false);
		textfield2.setDisable(false);
		textfield3.setDisable(false);
		textfield4.setDisable(false);
		textfield5.setDisable(false);
		textfield1.setText("");
		textfield2.setText("");
		textfield3.setText("");
		textfield4.setText("");
		textfield5.setText("");
		textfield1.setDisable(true);
		textfield3.setDisable(true);
		textfield4.setDisable(true);
		textfield5.setDisable(true);
		
	}
	
	
}