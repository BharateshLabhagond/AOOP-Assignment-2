/* 
 *Name: Bharatesh Nagaraj Labhagond
 *Date: 14/10/2022
 *Place: Dharawad
 *Sem:  5th (5B)
 *USN:2SD20CS031
 *
 *Q2) Write a Java program to build the GUI application using JavaFX for the following requirements:
 *    a) Create a Menu control to display the menu items: File, Edit & Help.
 *    b) Create sub menus in the order: File → New, Open & Save. Edit → Cut, Copy & Paste.
         Help → Help Centre, About Us
      The program must use Mnemonics and Accelerators (wherever appropriate) to Menu Items.
 */

package question_2;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
public class menuCreation extends Application{

	public static void main(String[] args) {
		
        launch();
	}
	
	public void start(Stage primaryStage) throws Exception {
		//Creation of main menu File,Edit,Help
		MenuBar main_menu = new MenuBar();
		
		Menu File = new Menu("File");
		Menu Edit = new Menu("Edit");
		Menu Help = new Menu("Help");
		
		main_menu.getMenus().add(File);
		main_menu.getMenus().add(Edit);
		main_menu.getMenus().add(Help);
		
		MenuItem New = new MenuItem("New");
		MenuItem Open = new MenuItem("Open");
		MenuItem Save = new MenuItem("Save");
		//Adding Submenus New,Open and Save to File Menu
		File.getItems().addAll(New,Open,Save);
		
		MenuItem Cut = new MenuItem("Cut");
		MenuItem Copy = new MenuItem("Copy");
		MenuItem Paste = new MenuItem("Paste");
		//Adding Submenus Cut,Copy and Paste to Edit Menu
		Edit.getItems().addAll(Cut,Copy,Paste);
		
		MenuItem Help_Centre = new MenuItem("Help Centre");
		MenuItem About_Us = new MenuItem("About Us");
		//Adding Submenus Help_Centre and About_Us to Help menu
		Help.getItems().addAll(Help_Centre,About_Us);
		
		BorderPane root = new BorderPane();
	    root.setTop(main_menu);
	    //Creating Scene 
	    Scene sc=new Scene(root);
	    //Adding Scene to Stage
	    primaryStage.setScene(sc);
	    primaryStage.setTitle("Menu Control");
	    primaryStage.setWidth(500);
	    primaryStage.setHeight(500);
	    primaryStage.show();
	}

}

