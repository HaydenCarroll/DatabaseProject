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
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.util.Callback;

public class SelectProdController {
	public TableView tableview;
	private ObservableList<ObservableList> data;
	private boolean isRefreshed=false;
	private boolean isFilled=false;
	private static ObservableList o;
	public TextField catID;
	public TextField prodCode;
	public TextField prodName;
	public TextField prodPrice;
	public TextArea desc;
	public TextField prodID;
	
	public void openAddProd() {
		
		try {
			Stage primaryStage = new Stage();
			BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("AddProd.fxml"));
			Scene scene = new Scene(root,800,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void openEditProd() {
		
		try {
			Stage primaryStage = new Stage();
			BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("EditProd.fxml"));
			Scene scene = new Scene(root,800,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void deleteProd() {
		String id = o.get(0).toString();
		Data.removeProductById(id);
		
	}
	
	public void editExit() {
		Stage s = (Stage) desc.getScene().getWindow();
		s.close();
	}
	
	public void editEnter() {
		Data.updateProductById(catID.getText(), catID.getText(), prodCode.getText(), prodName.getText(), desc.getText(), prodPrice.getText());
		editExit();
	}
	
	public void exit() {
		Stage s = (Stage) tableview.getScene().getWindow();
		s.close();
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
			this.prodID.setText(a.get(0));
			this.catID.setText(a.get(1));
			this.prodCode.setText(a.get(2));
			this.prodName.setText(a.get(3));
			this.desc.setText(a.get(4));
			this.prodPrice.setText(a.get(5));
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
	           String SQL = "SELECT * from Products";
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

}
