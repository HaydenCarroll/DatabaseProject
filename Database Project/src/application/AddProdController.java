package application;


import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AddProdController {
	public TextField catID;
	public TextField prodCode;
	public TextField prodName;
	public TextField prodPrice;
	public TextArea desc;
	
	public void enter() {
		Data.addProduct(catID.getText(), prodCode.getText(), prodName.getText(), desc.getText(), prodPrice.getText());
		exit();
	}
	
	public void exit() {
		Stage s = (Stage) desc.getScene().getWindow();
		s.close();
	}

}
