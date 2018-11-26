package application;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class SelectOrderController {
	public TextField custID;
	public TextField orderDate;
	public TextField shipAmnt;
	public TextField taxAmnt;
	public TextField shipAddressID;
	public TextField cardType;
	public TextField cardNum;
	public TextField cardExpires;
	public TextField billingAddressID;
	public TextField shipDate;
	public ComboBox orderID;
	
	public void openAddOrder() {
		
		try {
			Stage primaryStage = new Stage();
			BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("AddOrder.fxml"));
			Scene scene = new Scene(root,800,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void openEditOrder() {
		
		try {
			Stage primaryStage = new Stage();
			BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("EditOrder.fxml"));
			Scene scene = new Scene(root,800,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void deleteOrder() {
		
	}
	
	public void exit() {
		
	}

}
