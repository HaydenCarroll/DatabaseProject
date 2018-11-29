package application;

import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AddInvoiceController {
	public TextField orderID;
	public TextField productID;
	public TextField itemPrice;
	public TextField amnt;
	
	public void enter() {
		Data.addOrderItems(orderID.getText(), productID.getText(), itemPrice.getText(), amnt.getText());
		exit();
	}
	
	public void exit() {
		Stage s = (Stage) amnt.getScene().getWindow();
		s.close();
	}

}
