package application;

import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AddEmployeeController {
	public TextField fName;
	public TextField lName;
	public TextField pay;
	public TextField position;
	public TextField hireDate;
	public TextField phoneNum;
	public TextField street;
	public TextField city;
	public TextField state;
	
	public void enter() {
		Data.addEmployee(fName.getText(), lName.getText(), pay.getText(), position.getText(),
				hireDate.getText(), phoneNum.getText(), street.getText(), city.getText(), state.getText());
		exit();
	}
	
	public void exit() {
		Stage s = (Stage) pay.getScene().getWindow();
		s.close();
	}

}
