package application;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class SelectProdController {
	public TextField catID;
	public TextField prodCode;
	public TextField prodName;
	public TextField prodPrice;
	public TextArea desc;
	public ComboBox prodID;
	public Button exit;
	
	public void openAddProd() {
		
		try {
			Stage primaryStage = new Stage();
			BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("AddProd.fxml"));
			Scene scene = new Scene(root,800,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void openEditProd() {
		
		try {
			Stage primaryStage = new Stage();
			BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("EditProd.fxml"));
			Scene scene = new Scene(root,800,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void deleteProd() {
		
	}
	
	public void exit() {
		
	}

}
