package application;

import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AddCatController {
	public TextField name;
	
	public void enter() {
		Data.addCategory(name.getText());
		exit();
	}
	
	public void exit() {
		Stage s = (Stage) name.getScene().getWindow();
		s.close();
	}

}
