package application;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.util.Callback;

public class SelectEmployeeController {
	public TextField empID;
	public TextField fName;
	public TextField lName;
	public TextField pay;
	public TextField position;
	public TextField hireDate;
	public TextField phoneNum;
	public TextField street;
	public TextField city;
	public TextField state;
	
	public TableView tableview;
	private ObservableList<ObservableList> data;
	private boolean isRefreshed=false;
	private boolean isFilled=false;
	private static ObservableList o;
	public void openAddEmployee() {
		
		try {
			Stage primaryStage = new Stage();
			BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("AddEmployee.fxml"));
			Scene scene = new Scene(root,800,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void openEditEmployee() {
		
		try {
			Stage primaryStage = new Stage();
			BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("EditEmployee.fxml"));
			Scene scene = new Scene(root,800,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void selectItem() {
		o = FXCollections.observableArrayList();
		o= (ObservableList) tableview.getSelectionModel().getSelectedItem();
		System.out.println(o.toString());
	}
	public void fillEdit() {
		
		if(this.isFilled==false) {
			
			System.out.println(o.get(0));
			ArrayList<String> a = new ArrayList<String>();
			for(int i=0;i<o.size();i++) {
				a.add(o.get(i).toString());
			}
			this.empID.setText(a.get(0));
			this.fName.setText(a.get(1));
			this.lName.setText(a.get(2));
			this.pay.setText(a.get(3));
			this.position.setText(a.get(4));
			this.hireDate.setText(a.get(5));
			this.phoneNum.setText(a.get(6));
			this.street.setText(a.get(7));
			this.city.setText(a.get(8));
			this.state.setText(a.get(9));
			this.isFilled=true;
		}
		
		
		
	}
	
	
	public void initilize() {
		if(this.isRefreshed==false) {
			buildData();
			System.out.println("Building Data");
			//this.isRefreshed=true;
		}
	}
	
	 @SuppressWarnings("unchecked")
		public void buildData(){
		 tableview.getColumns().clear();
	         Connection c = Data.getConnection();
	         data = FXCollections.observableArrayList();
	         try{
	           //SQL FOR SELECTING ALL OF CUSTOMER
	           String SQL = "SELECT * from Employees";
	           //ResultSet
	           ResultSet rs = c.createStatement().executeQuery(SQL);

	           /**********************************
	            * TABLE COLUMN ADDED DYNAMICALLY *
	            **********************************/
	           for(int i=0 ; i<rs.getMetaData().getColumnCount(); i++){
	               //We are using non property style for making dynamic table
	               final int j = i;                
	               TableColumn col = new TableColumn(rs.getMetaData().getColumnName(i+1));
	               col.setCellValueFactory(new Callback<CellDataFeatures<ObservableList,String>,ObservableValue<String>>(){                    
	                   public ObservableValue<String> call(CellDataFeatures<ObservableList, String> param) {                                                                                              
	                       return new SimpleStringProperty(param.getValue().get(j).toString());                        
	                   }                    
	               });

	               tableview.getColumns().addAll(col); 
	               System.out.println("Column ["+i+"] ");
	           }

	           /********************************
	            * Data added to ObservableList *
	            ********************************/
	           while(rs.next()){
	               //Iterate Row
	               ObservableList<String> row = FXCollections.observableArrayList();
	               for(int i=1 ; i<=rs.getMetaData().getColumnCount(); i++){
	                   //Iterate Column
	                   row.add(rs.getString(i));
	               }
	               System.out.println("Row [1] added "+row );
	               data.add(row);

	           }

	           //FINALLY ADDED TO TableView
	           tableview.setItems(data);
	         }catch(Exception e){
	             e.printStackTrace();
	             System.out.println("Error on Building Data");             
	         }
	     }
	
	public void deleteEmployee() {
		String id = o.get(0).toString();
		Data.removeEmployeeById(id);
		
	}
	
	public void exit() {
		Stage s = (Stage) tableview.getScene().getWindow();
		s.close();
	}
	
	public void exitEdit() {
		Stage s = (Stage) empID.getScene().getWindow();
		s.close();
	}
	
	public void enterEdit() {
		Data.updateEmployeeById(empID.getText(), fName.getText(), lName.getText(), pay.getText(), position.getText(),
				hireDate.getText(), phoneNum.getText(), street.getText(), city.getText(), state.getText());
		
		exitEdit();
		
	}

}
