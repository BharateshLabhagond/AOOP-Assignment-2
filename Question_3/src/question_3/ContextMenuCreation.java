/* 
 *Name: Bharatesh Nagaraj Labhagond
 *Date: 14/10/2022
 *Place: Dharawad
 *Sem:  5th (5B)
 *USN:2SD20CS031
 *
 *Q3) Write a Java program to build the GUI application using JavaFX for the following requirements:
 *    a) Create Context menu involving the menu items in the order: New & View.
 *    b) Create sub menus for the above main context menu: New → File, Folder & Image.
         View → Large, Medium & Small.
         The context menu must be displayed on right-click of the mouse button.
 */

package question_3;

import java.io.FileNotFoundException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.ContextMenuEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class ContextMenuCreation extends Application {
	 public static void main(String args[]){
	      launch(args);
	   }
   @Override
   public void start(Stage primaryStage) throws FileNotFoundException {
     
      Label txt=new Label("Press right click of the mouse button to display Context Menu :");
      txt.setFont(new Font("Times New Roman", 28));
      
      BorderPane root = new BorderPane();
      
      root.getChildren().add(txt);
      
      
     
      //Creating a context menu
      ContextMenu contextMenu = new ContextMenu();
     
      //Creating the menu Items for the context menu
      Menu New = new Menu("New");
      Menu View = new Menu("View");
      
      contextMenu.getItems().addAll(New, View);
     
      
      MenuItem file = new MenuItem("File");
      MenuItem folder = new MenuItem("Folder");
      MenuItem image = new MenuItem("Image");
      
      New.getItems().addAll(file,folder,image);
      
      MenuItem large = new MenuItem("Large");
      MenuItem medium = new MenuItem("Medium");
      MenuItem small = new MenuItem("Small");
      
      View.getItems().addAll(large,medium,small);
      
     Label response = new Label("Context menu demo");
      root.setOnContextMenuRequested(new EventHandler<ContextMenuEvent>() {
    	  public void handle(ContextMenuEvent event) {
    	  contextMenu.show(root,event.getScreenX(),event.getScreenY());
    	  }
	});
   
      EventHandler<ActionEvent> MEHandler = new EventHandler<ActionEvent>() {
			public void handle(ActionEvent ae) {
				String name = ((MenuItem) ae.getTarget()).getText();
				
				response.setText(name + " selected");
			}
		};  
      
      New.setOnAction(MEHandler);
      file.setOnAction(MEHandler);
      folder.setOnAction(MEHandler);
      image.setOnAction(MEHandler);
      
      View.setOnAction(MEHandler);
      large.setOnAction(MEHandler);
      medium.setOnAction(MEHandler);
      small.setOnAction(MEHandler);
      
      Scene sc = new Scene(root,500,500);
      
      FlowPane fpRoot = new FlowPane(10, 10);
      root.setCenter(fpRoot);
      fpRoot.setAlignment(Pos.CENTER);
      fpRoot.getChildren().addAll(txt,response);
      response.setWrapText(true);
      txt.setWrapText(true);
      root.setTop(txt);
      
      
      primaryStage.setTitle("CustomMenuItem");
      primaryStage.setScene(sc);
      primaryStage.setWidth(500);
      primaryStage.setHeight(500);
      primaryStage.show();
   }
  
}