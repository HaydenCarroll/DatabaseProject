package application;

import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AddStoreController {
	public TextField address;
	public TextField numOfEmployees;
	public TextField manager;
	
	public void enter() {
		Data.addStore(address.getText(), numOfEmployees.getText(), manager.getText());
		exit();
	}
	
	public void exit() {
		Stage s = (Stage) address.getScene().getWindow();
		s.close();
	}

}
