package application;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class InvoicesController {
	
	
	//opens select order 
	public void openSelectOrder() {
		
		try {
			Stage primaryStage = new Stage();
			BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("SelectOrder.fxml"));
			Scene scene = new Scene(root,800,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//opens select category
	public void openSelectCat() {
		
		try {
			Stage primaryStage = new Stage();
			BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("SelectCat.fxml"));
			Scene scene = new Scene(root,600,200);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//opens select product
	public void openSelectProd() {
		
		try {
			Stage primaryStage = new Stage();
			BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("SelectProd.fxml"));
			Scene scene = new Scene(root,800,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//opens select product
	public void openSelectCust() {
		
		try {
			Stage primaryStage = new Stage();
			BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("SelectCust.fxml"));
			Scene scene = new Scene(root,800,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
