package application;

import java.sql.*;
import java.util.ArrayList;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.util.Callback;

public class InvoicesController {
	public TextField itemID;
	public TextField orderID;
	public TextField productID;
	public TextField itemPrice;
	public TextField amnt;
	
	public TableView tableview;
	private ObservableList<ObservableList> data;
	private boolean isRefreshed=false;
	private boolean isFilled=false;
	private static ObservableList o;
	
	
	//opens select order 
	public void openSelectOrder() {
		
		try {
			Stage primaryStage = new Stage();
			BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("SelectOrder.fxml"));
			Scene scene = new Scene(root,800,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//opens select category
	public void openSelectCat() {
		
		try {
			Stage primaryStage = new Stage();
			BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("SelectCat.fxml"));
			Scene scene = new Scene(root,600,200);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//opens select product
	public void openSelectProd() {
		
		try {
			Stage primaryStage = new Stage();
			BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("SelectProd.fxml"));
			Scene scene = new Scene(root,800,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//opens select product
	public void openSelectCust() {
		
		try {
			Stage primaryStage = new Stage();
			BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("SelectCust.fxml"));
			Scene scene = new Scene(root,800,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void openSelectStore() {
		try {
			Stage primaryStage = new Stage();
			BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("SelectStore.fxml"));
			Scene scene = new Scene(root,800,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void openSelectEmployee() {
		try {
			Stage primaryStage = new Stage();
			BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("SelectEmployee.fxml"));
			Scene scene = new Scene(root,800,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void initilize() {
		if(this.isRefreshed==false) {
			buildData();
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
           String SQL = "SELECT * from OrderItems";
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
	 
	 public void deleteOrderItem() {
			String id = o.get(0).toString();
			Data.removeOrderItemById(id);
			
			
		}
	 
	 //do these****************
	 public void addOrderItem() {
		 try {
				Stage primaryStage = new Stage();
				BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("AddInvoice.fxml"));
				Scene scene = new Scene(root,800,400);
				scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
				primaryStage.setScene(scene);
				primaryStage.show();
			} catch(Exception e) {
				e.printStackTrace();
			}
	 }
	 
	 public void edit() {
		 try {
				Stage primaryStage = new Stage();
				BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("EditInvoice.fxml"));
				Scene scene = new Scene(root,800,400);
				scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
				primaryStage.setScene(scene);
				primaryStage.show();
			} catch(Exception e) {
				e.printStackTrace();
			}
	 }
	 
	 public void editEnter() {
		 Data.updateOrderItemById(itemID.getText(), orderID.getText(), productID.getText(), itemPrice.getText(), amnt.getText());
		 
		 editExit();
	 }
	 
	 public void editExit() {
		 Stage s = (Stage) amnt.getScene().getWindow();
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
				this.itemID.setText(a.get(0));
				this.orderID.setText(a.get(1));
				this.productID.setText(a.get(2));
				this.itemPrice.setText(a.get(3));
				this.amnt.setText(a.get(4));
				this.isFilled=true;
			}
			
			
			
		}
	
	
}
