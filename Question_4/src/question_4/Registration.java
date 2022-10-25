/* 
 *Name: Bharatesh Nagaraj Labhagond
 *Date: 19/10/2022
 *Place: Dharawad
 *Sem:  5th (5B)
 *USN:2SD20CS031
 *
 *Q4) Write a JavaFX program that produces the following output when executed and displays Dialog Box
      (as shown in Figure.2) on click of Register button (as shown in Figure.1):
 */

package question_4;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Registration extends Application{
	
	public void start(Stage primaryStage) throws Exception{
		
		VBox root = new VBox();
		root.setAlignment(Pos.CENTER);
		root.setSpacing(10);
		root.setPadding(new Insets(0,10,0,50));
		
		//Adding 'Employee Registration Form' label 
		Label lb1 = new Label("Employee Registration Form");
		lb1.setWrapText(true);
		lb1.setFont(new Font(20));
		
		//Adding label lb1 control to BorderPane layout
		BorderPane bp = new BorderPane(lb1);
		BorderPane.setAlignment(lb1, Pos.TOP_CENTER);
		
		//Adding Name field
		HBox name = new HBox();
	    Label lb2 = new Label("Enter your Name:");
	    TextField tf1 = new TextField();
	    tf1.setPromptText("Enter your Name");
	    tf1.setFocusTraversable(false);
	    name.setSpacing(10);
	    name.getChildren().addAll(lb2,tf1);
	    
	    //Adding Gender Radiobuttons
	    HBox gender = new HBox();
	    Label lb3 = new Label("Select Your Gender:");
	    ToggleGroup tg = new ToggleGroup();
	    RadioButton rb1 = new RadioButton("Male");
	    RadioButton rb2 = new RadioButton("Female");
	    rb1.setToggleGroup(tg);
	    rb2.setToggleGroup(tg);
	    gender.setSpacing(10);
	    gender.getChildren().addAll(lb3,rb1,rb2);
	    
	    //Adding DatePicker
	    HBox date = new HBox();
	    Label lb4 = new Label("Enter Date of Birth:");
	    DatePicker dp = new DatePicker();
	    date.setSpacing(10);
	    date.getChildren().addAll(lb4,dp);
	    
	    //Adding State field
	    HBox state = new HBox();
	    Label lb5 = new Label("Select Your State:");
	    ComboBox<String> cb = new ComboBox<String>();
	    cb.getItems().addAll("Karnataka","Maharashtra","Goa","AndhraPradesh","Tamilnadu","Kerala");
	    state.setSpacing(10);
	    state.getChildren().addAll(lb5,cb);
	    
	    //Adding Qualification Selection checkbox 
	    HBox qualification = new HBox();
	    Label lb6 = new Label("Select Your Qualification:");
	    CheckBox ch1 = new CheckBox("UG");
	    CheckBox ch2 = new CheckBox("PG");
	    CheckBox ch3 = new CheckBox("PhD");
	    qualification.setSpacing(10);
	    qualification.getChildren().addAll(lb6,ch1,ch2,ch3);
	    
	    //Adding register button
	    Button button = new Button("Register");
	    
	    button.setOnAction((ae)->{
	    	
	    	if((!(ch1.isSelected() || ch2.isSelected() || ch3.isSelected())) || cb.getSelectionModel().isEmpty() || (!(rb1.isSelected() || rb2.isSelected())) || tf1.getText().isEmpty())
	    	{
	    		Alert registration = new Alert(AlertType.ERROR);
		    	registration.setTitle("Registration Unsuccessful");
		    	registration.setHeaderText("Registration Error");
		    	registration.setContentText("Kindly Fill All The Details!!");
		    	registration.showAndWait();
	    	}
	    	
	    	else 
	    	{
	    	Alert registration = new Alert(AlertType.INFORMATION);
	    	registration.setTitle("Registration Successful");
	    	registration.setHeaderText("Registration Status");
	    	registration.setContentText("Employee Registration Successful!!");
	    	registration.showAndWait();
	    	}
	    });
	    
	    //Adding all controls to layout
		root.getChildren().addAll(bp,name,gender,date,state,qualification,button);
		
		//Adding layout to scene
		Scene sc = new Scene(root);
		//Adding scene to stage
		primaryStage.setScene(sc);
		primaryStage.setWidth(500);
		primaryStage.setHeight(350);
		primaryStage.setTitle("Registration Form");
		primaryStage.show();
		
	}

	public static void main(String[] args) {
		launch();

	}


}
