package application;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class SelectCustController {
	public ComboBox custID;
	public TextField emailAddress;
	public TextField pass;
	public TextField firstName;
	public TextField lastName;
	public TextField shipAddressID;
	public TextField billAddressID;
	
	public void openAddCust() {
		
		try {
			Stage primaryStage = new Stage();
			BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("AddCust.fxml"));
			Scene scene = new Scene(root,800,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void openEditCust() {
		
		try {
			Stage primaryStage = new Stage();
			BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("EditCust.fxml"));
			Scene scene = new Scene(root,800,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void deleteCust() {
		
	}
	
	public void exit() {
		
	}

}
