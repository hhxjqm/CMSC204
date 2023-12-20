import java.util.ArrayList;
import java.util.Comparator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.TitledPane;
import javafx.scene.control.ToggleGroup;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
 
public class DoubleLinkedListDriver extends Application {

	private TextField newElementField, retrievedElementField, getElementField;
	private TextField removeField,iteratorField;
	private String newElement;
	private Label newElementLabel, retrievedElementLabel, getElementLabel, removeLabel;
	private Label basicLabel, sortedLabel,iteratorLabel;
	private RadioButton basicDLL, sortedDLL;
	private ToggleGroup myToggleGroup;
	private int basicIterCount, sortedIterCount;
	private Button exitBtn, addFront, addEnd, add, retrieveFirst, retrieveLast;
	private Button getFirst, getLast, remove,startIterator, next, prev, hasNext, hasPrev;
	private Alert alert = new Alert(AlertType.INFORMATION);
	private Alert alertUser = new Alert(AlertType.INFORMATION);
	private BasicDoubleLinkedList<String> basic;
	private SortedDoubleLinkedList<String> sorted;
	private StringComparator sComp;
	private TextArea basicArea, sortedArea, basicIterArea, sortedIterArea;
	private ListIterator<String> basicIter, sortedIter;
	 
	
	// Handler class for all buttons.
	private class ButtonEventHandler implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent e) {
			ArrayList<String> result;
			//Add to front button (basic DLL)
			if (e.getSource() == addFront) {
				newElement = newElementField.getText();
				basic.addToFront(newElement);
				result = basic.toArrayList();
				System.out.println(result);
				//print out the result
				showLists("basic",result);
			} 
			//Add to end button (basic DLL)
			else if (e.getSource() == addEnd) {
				newElement = newElementField.getText();
				basic.addToEnd(newElement);
				result = basic.toArrayList();
				//print out the result
				showLists("basic",result);
			} 
			//Add button (sorted DLL)
			else if (e.getSource() == add) {
						newElement = newElementField.getText();
						sorted.add(newElement);
						result = sorted.toArrayList();
						//print out the result
						showLists("sorted",result);
			} 
			//Retrieve first button (deletes from list)
			if (e.getSource() == retrieveFirst) {
				String retrieved;
				if(basicDLL.isSelected()){
					retrieved = basic.retrieveFirstElement();
					retrievedElementField.setText(retrieved);
					result = basic.toArrayList();
					showLists("basic",result);
				}
				else {
					retrieved = sorted.retrieveFirstElement();
					retrievedElementField.setText(retrieved);
					result = sorted.toArrayList();
					showLists("sorted",result);
				}
			}
			//Retrieve last button (deletes from list)
			if (e.getSource() == retrieveLast) {
				String retrieved;
				if(basicDLL.isSelected()){
					retrieved = basic.retrieveLastElement();
					retrievedElementField.setText(retrieved);
					result = basic.toArrayList();
					showLists("basic",result);
				}
				else {
					retrieved = sorted.retrieveLastElement();
					retrievedElementField.setText(retrieved);
					result = sorted.toArrayList();
					showLists("sorted",result);
				}	
			} 
			//Get last button (does not delete from list)
			if (e.getSource() == getLast) {
				String retrieved;
				if(basicDLL.isSelected()){
					retrieved = basic.getLast();
					getElementField.setText(retrieved);
					result = basic.toArrayList();
					showLists("basic",result);
				}
				else {
					retrieved = sorted.getLast();
					result = sorted.toArrayList();
					getElementField.setText(retrieved);
					showLists("sorted",result);
				}	
			} 
			//Get first button (does not delete from list)
			if (e.getSource() == getFirst) {
				String retrieved;
				if(basicDLL.isSelected()){
					retrieved = basic.getFirst();
					getElementField.setText(retrieved);
					result = basic.toArrayList();
					showLists("basic",result);
				}
				else {
					retrieved = sorted.getFirst();
					getElementField.setText(retrieved);
					result = sorted.toArrayList();
					showLists("sorted",result);
				}		
			} 
			//remove button
			if (e.getSource() == remove) {
				newElement = removeField.getText();
				if(basicDLL.isSelected()){
					basic.remove(newElement, sComp);
					result = basic.toArrayList();
					showLists("basic",result);
				}
				else {
					sorted.remove(newElement, sComp);
					result = sorted.toArrayList();
					showLists("sorted",result);
				}			
			} 
			//hasNext button
			if (e.getSource() == hasNext) {
				boolean answer;
				if(basicDLL.isSelected()){
					answer = basicIter.hasNext();
					result = basic.toArrayList();
					showLists("basic",result);
				}
				else {
					answer = sortedIter.hasNext();
					result = sorted.toArrayList();
					showLists("sorted",result);
				}
				if(answer)
				iteratorField.setText("true");
				else
					iteratorField.setText("false");
			} 
			//hasPrev button
			if (e.getSource() == hasPrev) {
				boolean answer;
				if(basicDLL.isSelected()){
					answer = basicIter.hasPrevious();
					result = basic.toArrayList();
					showLists("basic",result);
				}
				else {
					answer = sortedIter.hasPrevious();
					result = sorted.toArrayList();
					showLists("sorted",result);
				}
				if(answer)
				iteratorField.setText("true");
				else
					iteratorField.setText("false");
			} 
			//start iterator button
			if (e.getSource() == startIterator) {
				if(basicDLL.isSelected()){
					basicIter = basic.iterator();
					iteratorField.setText("");
					basicIterArea.setText("-->");
					basicIterCount = 0;
				}
				else {
					sortedIter = sorted.iterator();
					iteratorField.setText("");
					sortedIterArea.setText("-->");
					sortedIterCount = 0;
				}		
			} 
			//next button
			if (e.getSource() == next) {
				String printIter = "\n";
				try {
					if(basicDLL.isSelected()){
						iteratorField.setText(basicIter.next());
						basicIterCount++;
						for(int i=0;i<basicIterCount;i++)
						{
							printIter += "\n";
							printIter += "\n";
						}
						printIter += "-->";
						basicIterArea.setText(printIter);
					}
					else {
						iteratorField.setText(sortedIter.next());
						sortedIterCount++;
						for(int i=0;i<sortedIterCount;i++)
						{
							printIter += "\n";
							printIter += "\n";
						}
						printIter += "-->";
						sortedIterArea.setText(printIter);
					}
				}
				catch(NoSuchElementException ex)
				{
					alertUser.setHeaderText(null);
					alertUser.setContentText("Next Failure! At end of list");
					alertUser.showAndWait();
				}
			} 
			//prev button
			if (e.getSource() == prev) {
				String printIter = "\n";
				try {
				if(basicDLL.isSelected()){;
					iteratorField.setText(basicIter.previous());
					basicIterCount--;
					for(int i=0;i<basicIterCount;i++)
					{
						printIter += "\n";
						printIter += "\n";
					}
					printIter += "-->";
					basicIterArea.setText(printIter);
				}
				else {
					iteratorField.setText(sortedIter.previous());
					sortedIterCount--;
					for(int i=0;i<sortedIterCount;i++)
					{
						printIter += "\n";
						printIter += "\n";
					}
					printIter += "-->";
					sortedIterArea.setText(printIter);
				}
				}
				catch(NoSuchElementException ex)
				{
					alertUser.setHeaderText(null);
					alertUser.setContentText("Previous Failure! At beginning of list");
					alertUser.showAndWait();
				}
				
				
			} 
			//For exit button
			else if (e.getSource() == exitBtn){

				System.exit(0);
			} 
			//For radio buttons, display appropriate buttons for add
			else {
				if (basicDLL.isSelected()){
					addFront.setDisable(false);
					addEnd.setDisable(false);
					add.setDisable(true);
					
				} if (!basicDLL.isSelected()){
					addFront.setDisable(true);
					addEnd.setDisable(true);
					add.setDisable(false);
				}
			}
		}
	}

	@Override
	public void start(Stage stage) {
		
		sComp = new StringComparator();
		basic = new BasicDoubleLinkedList<String>();
		sorted = new SortedDoubleLinkedList<String>(sComp);
		
		//everything is displayed in an alert
		alert.setTitle("Doubly Linked List Manager");
		alert.setHeaderText(null);
		
		// Create labels
		newElementLabel = new Label("Element to Add: ");
		retrievedElementLabel = new Label("Retrieved: ");
		getElementLabel = new Label("Returned: ");
		removeLabel = new Label("To be Removed: ");
		iteratorLabel = new Label("Returns: ");

		// create text fields
		newElementField = new TextField();
		newElementField.setMaxWidth(150);
		retrievedElementField = new TextField();
		retrievedElementField.setMaxWidth(150);
		getElementField = new TextField();
		getElementField.setMaxWidth(150);
		removeField = new TextField();
		removeField.setMaxWidth(150);
		iteratorField = new TextField();
		iteratorField.setMaxWidth(150);
		
		//create radio buttons
		myToggleGroup = new ToggleGroup();
		basicDLL = new RadioButton("Basic");
		sortedDLL = new RadioButton("Sorted");
		basicDLL.setToggleGroup(myToggleGroup);
		sortedDLL.setToggleGroup(myToggleGroup);
		basicDLL.setOnAction(new ButtonEventHandler());
		sortedDLL.setOnAction(new ButtonEventHandler());

		HBox radioPane1 = new HBox(20);
		radioPane1.getChildren().addAll(basicDLL,sortedDLL);
		radioPane1.setPadding(new Insets(20, 10, 5, 10));
		
		// Create buttons
		addFront = new Button("Add Front");
		addFront.setDisable(true);
		addEnd = new Button("Add End");
		addEnd.setDisable(true);
		add = new Button("Add");
		add.setDisable(true);
		retrieveFirst = new Button("Retrieve First");
		retrieveLast = new Button("Retrieve Last");
		getFirst = new Button("Get First");
		getLast = new Button("Get Last");
		remove = new Button("Remove");
		startIterator = new Button("Start");
		next = new Button("Next");
		prev = new Button("Previous");
		hasNext = new Button("Has Next");
		hasPrev = new Button("Has Previous");
		exitBtn = new Button("Exit");

		addFront.setOnAction(new ButtonEventHandler());
		addEnd.setOnAction(new ButtonEventHandler());
		add.setOnAction(new ButtonEventHandler());
		retrieveFirst.setOnAction(new ButtonEventHandler());
		retrieveLast.setOnAction(new ButtonEventHandler());
		getFirst.setOnAction(new ButtonEventHandler());
		getLast.setOnAction(new ButtonEventHandler());
		remove.setOnAction(new ButtonEventHandler());
		startIterator.setOnAction(new ButtonEventHandler());
		next.setOnAction(new ButtonEventHandler());
		prev.setOnAction(new ButtonEventHandler());
		hasNext.setOnAction(new ButtonEventHandler());
		hasPrev.setOnAction(new ButtonEventHandler());
		exitBtn.setOnAction(new ButtonEventHandler());
		
		HBox buttonPane1 = new HBox(20);
		buttonPane1.getChildren().addAll(exitBtn);
		buttonPane1.setPadding(new Insets(20, 10, 5, 10));
		buttonPane1.setAlignment(Pos.CENTER);
		
		HBox addButtons = new HBox(20);
		addButtons.getChildren().addAll(addFront, addEnd, add);
		
		HBox retrieveButtons = new HBox(20);
		retrieveButtons.getChildren().addAll(retrieveFirst, retrieveLast);
		
		HBox getButtons = new HBox(20);
		getButtons.getChildren().addAll(getFirst, getLast);
		
		HBox iterButtons = new HBox(20);
		iterButtons.getChildren().addAll(startIterator, next, prev, hasNext, hasPrev);
		
		HBox hasIterButtons = new HBox(20);
		hasIterButtons.getChildren().addAll(hasNext, hasPrev);

		// Main Pane
		VBox mainPane = new VBox();

		// 
		HBox addPane = new HBox();
		addPane.getChildren().addAll(newElementLabel, newElementField,addButtons);

		TitledPane addTitlePane = new TitledPane("Add to List",
				addPane);
		addTitlePane.setCollapsible(false);
		addTitlePane.setMaxWidth(550);
		addTitlePane.setPadding(new Insets(20, 10, 5, 10));
		
		//Remove pane
				HBox removePane = new HBox();
				removePane.getChildren().addAll(removeLabel, removeField, remove);
				
				TitledPane removeTitlePane = new TitledPane("Remove from List",
						removePane);
				removeTitlePane.setCollapsible(false);
				removeTitlePane.setMaxWidth(550);
				removeTitlePane.setPadding(new Insets(20, 10, 5, 10));
		
		//Retrieve pane
		HBox retrievePane = new HBox();
		retrievePane.getChildren().addAll(retrievedElementLabel, retrievedElementField, retrieveButtons);
		
		TitledPane retrieveTitlePane = new TitledPane("Retrieve from List (deletes from list)",
				retrievePane);
		retrieveTitlePane.setCollapsible(false);
		retrieveTitlePane.setMaxWidth(550);
		retrieveTitlePane.setPadding(new Insets(20, 10, 5, 10));
		
		TitledPane mainRadioPane = new TitledPane("Type of Doubly Linked List",
				retrievePane);
		retrieveTitlePane.setCollapsible(false);
		retrieveTitlePane.setMaxWidth(550);
		retrieveTitlePane.setPadding(new Insets(20, 10, 5, 10));
		
		HBox getPane = new HBox();
		getPane.getChildren().addAll(getElementLabel, getElementField, getButtons);
		TitledPane getTitlePane = new TitledPane("Get from List (doesn't deletes from list)",
				getPane);
		getTitlePane.setCollapsible(false);
		getTitlePane.setMaxWidth(550);
		getTitlePane.setPadding(new Insets(20, 10, 5, 10));


		basicArea = new TextArea();
		basicArea.setMaxWidth(200);
		basicArea.setStyle("-fx-font-size: 13");
		basicIterArea = new TextArea();
		basicIterArea.setMaxWidth(20);
		basicIterArea.setStyle("-fx-font-size: 6");
		sortedArea = new TextArea();
		sortedArea.setMaxWidth(200);
		sortedArea.setStyle("-fx-font-size: 13");
		sortedIterArea = new TextArea();
		sortedIterArea.setMaxWidth(20);
		sortedIterArea.setStyle("-fx-font-size: 6");
		basicLabel = new Label("Basic List");
		sortedLabel = new Label("Sorted List");
		VBox basicListPane = new VBox();
		basicListPane.getChildren().addAll(basicLabel, basicArea);
		VBox sortedListPane = new VBox();
		sortedListPane.getChildren().addAll(sortedLabel, sortedArea);
		HBox listPane = new HBox();
		listPane.getChildren().addAll(basicIterArea,basicListPane,sortedIterArea,sortedListPane);
		
		TitledPane listTypePane = new TitledPane("Type of lists",
				radioPane1);
		listTypePane.setCollapsible(false);
		listTypePane.setMaxWidth(550);
		listTypePane.setPadding(new Insets(20, 10, 5, 10));
		
		TitledPane listAreaPane = new TitledPane("Contents of lists",
				listPane);
		listAreaPane.setCollapsible(false);
		listAreaPane.setMaxWidth(550);
		listAreaPane.setPadding(new Insets(20, 10, 5, 10));
		
		HBox iteratorPane = new HBox();
		iteratorPane.getChildren().addAll(iteratorLabel, iteratorField, iterButtons);
		
		VBox mainIterPane = new VBox();
		mainIterPane.getChildren().addAll(iteratorPane, hasIterButtons);
		
		TitledPane iterPane = new TitledPane("Iterator (upon add, retrieve or remove, restart iterator)",
				mainIterPane);
		iterPane.setCollapsible(false);
		iterPane.setMaxWidth(550);
		iterPane.setPadding(new Insets(20, 10, 5, 10));
		

		mainPane.getChildren().addAll(listTypePane,addTitlePane, retrieveTitlePane,
				getTitlePane,removeTitlePane,iterPane, listAreaPane, buttonPane1);
		Scene scene = new Scene(mainPane, 550, 900);
		stage.setScene(scene);

		// Set stage title and show the stage.
		stage.setTitle("Doubly Linked List ");
		stage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
	
	/**
	 * Displays the current contents of the basic and sorted
	 * @param type type of list - basic or sorted
	 * @param list Arraylist of Strings with contents of the lists
	 */
	private void showLists(String type, ArrayList<String> list)
	{
		String result="";
		for(String element : list)
			result+=element + "\n";
		if(type.equals("basic"))
			basicArea.setText(result);
		else if(type.equals("sorted"))
			sortedArea.setText(result);
	}
	
	/**
	 * Comparator needed for the sorted list
	 * @author Professor Jeannette Kartchner
	 *
	 */
	private class StringComparator implements Comparator<String>
	{

		@Override
		public int compare(String arg0, String arg1) {
			// TODO Auto-generated method stub
			return arg0.compareTo(arg1);
		}
		
	}
}