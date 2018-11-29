package application;

import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AddCustController {
	public TextField emailAddress;
	public TextField pass;
	public TextField firstName;
	public TextField lastName;
	public TextField shipAddressID;
	public TextField billAddressID;
	
	
	public void enter() {
		Data.addCustomer(emailAddress.getText(), pass.getText(), firstName.getText(), lastName.getText(),
				shipAddressID.getText(), billAddressID.getText());
		exit();
	}
	
	public void exit() {
		Stage s = (Stage) pass.getScene().getWindow();
		s.close();
	}

}
