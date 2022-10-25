/* 
 *Name: Bharatesh Nagaraj Labhagond
 *Date: 14/10/2022
 *Place: Dharawad
 *Sem:  5th (5B)
 *USN:2SD20CS031
 *
 *Q1) Write a Java program to build the GUI application using JavaFX for the following requirements:
 *    a) Read user name and password using appropriate JavaFX controls.
 *    b) Validate the input. If user name and password are matched with the assumed values, then 
         display the welcome scene with proper text.
      c) If user name and password don’t match, then raise appropriate exception.
 */

package question_1;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Login extends Application{
	
	@SuppressWarnings("serial")
	class InvalidUserNameOrPasswordException extends Exception{
		public InvalidUserNameOrPasswordException() {
			super("please enter valid UserName or Password!!!");
		}
	}
  
	public static void main(String[] args) {
		launch();
	}
	
	public void start(Stage primaryStage) throws Exception{
		
        Label lb1 = new Label("Username: ");  
        Label lb3 = new Label(); 
        lb3.setWrapText(true);
		TextField user = new TextField();
		user.setMaxWidth(200);
		
		Label lb2 = new Label("Password: ");  
          
		PasswordField passwd = new PasswordField();
		user.setMaxWidth(200);
		
		Button bt = new Button("LOGIN");
	
		bt.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent arg0) {
			  try {
				if(user.getText().equalsIgnoreCase("bharatesh")&&passwd.getText().equals("b@123")) {
				       lb3.setText("Login Successful");
				       lb3.setTextFill(javafx.scene.paint.Color.GREY); 
				       lb3.setFont(new Font("Times New Roman", 32));
					}
					else {
							throw new InvalidUserNameOrPasswordException();
						 }
			   } catch (InvalidUserNameOrPasswordException e) {
							System.out.println(e);
			     }
		    }
						
	    });


		GridPane gp = new GridPane();
		gp.setHgap(10);
		gp.setVgap(10);
		
		gp.add(lb1, 0, 0);
		gp.add(user, 1,0 );
		gp.add(lb2, 0, 1);
		gp.add(passwd, 1,1 );
		gp.add(bt, 1, 2);
		gp.add(lb3, 1, 3);
		
		gp.setAlignment(Pos.CENTER);
		Scene sc = new Scene(gp);
		primaryStage.setScene(sc);
		primaryStage.setWidth(500);
		primaryStage.setHeight(500);
		primaryStage.show();
		
	} 
	
}
