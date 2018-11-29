package application;

import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AddOrderController {
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
	
	public void enter() {
		Data.addOrders(custID.getText(), orderDate.getText(), shipAmnt.getText(), taxAmnt.getText(), shipDate.getText(),
				shipAddressID.getText(), cardType.getText(), cardNum.getText(), cardExpires.getText(), billingAddressID.getText());
		exit();
	}
	
	public void exit() {
		Stage s = (Stage) cardNum.getScene().getWindow();
		s.close();
	}

}
