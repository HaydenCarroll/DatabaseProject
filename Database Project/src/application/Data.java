package application;

import java.sql.*;

import javafx.collections.ObservableList;
public class Data {
	
	public static void main(String[] args) {
		// Create a variable for the connection string.
		
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        String connectionUrl = "jdbc:sqlserver://127.0.0.1:1434;databaseName=MyGuitarShop;integratedSecurity=true";
        String user = "sa";
        String pass = "password";

        String dbURL = "jdbc:sqlserver://localhost;integratedSecurity=true;";
        Connection conn;
        try (Connection con = DriverManager.getConnection(connectionUrl); Statement stmt = con.createStatement();) {
            String SQL = "SELECT TOP 10 * FROM dbo.Categories";
            ResultSet rs = stmt.executeQuery(SQL);

            // Iterate through the data in the result set and display it.
            while (rs.next()) {
                System.out.println(rs.getString("CategoryID"));
            }
        }
        // Handle any errors that may have occurred.
        catch (SQLException e) {
            e.printStackTrace();
        }
		try {
			
			conn = DriverManager.getConnection(connectionUrl);
			if (conn != null) {
	            System.out.println("Connected");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        }
	
	public static ObservableList<String> getItemId(){
		//ObservableList<String> list = new 
	}
	
	public static ObservableList<String> getOrderId(){
		
	}
	
	public static ObservableList<String> getProductId(){
		
	}
	
	public static ObservableList<String> getItemPrice(){
		
	}
	
}


