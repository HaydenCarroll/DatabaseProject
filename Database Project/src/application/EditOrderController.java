package application;

import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class EditOrderController {
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
	public TextField orderID;
	
	private ObservableList o=FXCollections.observableArrayList();
	
	
	
	public EditOrderController() {
		
	}
	public void sendData(ObservableList o) {
		this.o=o;
	}
	
	

}
