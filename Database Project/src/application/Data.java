package application;

import java.sql.*;
import java.util.ArrayList;

import javafx.collections.ObservableList;
public class Data {
	static String connectionUrl = "jdbc:sqlserver://127.0.0.1:1434;databaseName=ToolShop;integratedSecurity=true";
    String user = "sa";
    String pass = "password";
    static Connection con;
    
    public static void connect() {
    	
    	try {
			con = DriverManager.getConnection(connectionUrl);
			System.out.println("Connected");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }
    public static Connection getConnection() {
    	return con;
    }
	
	
	public static void addCategory(String categoryName) {
		try {
			//this is to find the total number of categories
			PreparedStatement countStatement = con.prepareStatement("SELECT COUNT(*) as COUNT FROM Categories");
			ResultSet count = countStatement.executeQuery();
			int num = 0;
			while(count.next()) {
				num=count.getInt("COUNT");
			}
			
			
			PreparedStatement ps = con.prepareStatement("SET IDENTITY_INSERT Categories ON;"
					+ "INSERT INTO Categories (CategoryID, CategoryName) VALUES(?,?)");
			//the one represents the first question mark '?' which is the CategoryID value in the table
			//the Integer.toString(num+1) is assigning the id number
			ps.setString(1, Integer.toString(num+1));
			//the two represents the second question mark which is the CategoryName value in the table
			ps.setString(2, categoryName);
			ps.executeUpdate();
			
			
			
			PreparedStatement insertOff = con.prepareStatement("SET IDENTITY_INSERT Categories OFF");
			insertOff.execute();
			//be sure to close the resultSet and PreparedStatemnt to reallocate the memory
			ps.close();
			count.close();
			insertOff.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void addAddress(String customerID, String line1, String line2, String city, String state, String zip, String phone, String disabled) {
		try {
			//this is to find the total number of categories
			PreparedStatement countStatement = con.prepareStatement("SELECT COUNT(*) as COUNT FROM Addresses");
			ResultSet count = countStatement.executeQuery();
			int num = 0;
			while(count.next()) {
				num=count.getInt("COUNT");
			}
			
			
			PreparedStatement ps = con.prepareStatement("SET IDENTITY_INSERT Addresses ON;"
					+ "INSERT INTO Addresses (AddressID, CustomerID, Line1, Line2, City, State, ZipCode, Phone, Disabled) VALUES(?,?,?,?,?,?,?,?,?)");
			//the one represents the first question mark '?' which is the CategoryID value in the table
			//the Integer.toString(num+1) is assigning the id number
			ps.setString(1, Integer.toString(num+1));
			//the two represents the second question mark which is the CategoryName value in the table
			ps.setString(2, customerID);
			ps.setString(3, line1);
			ps.setString(4, line2);
			ps.setString(5, city);
			ps.setString(6, state);
			ps.setString(7, zip);
			ps.setString(8, phone);
			ps.setString(9, disabled);
			
			ps.executeUpdate();
			
			
			
			PreparedStatement insertOff = con.prepareStatement("SET IDENTITY_INSERT Addresses OFF");
			insertOff.execute();
			//be sure to close the resultSet and PreparedStatemnt to reallocate the memory
			ps.close();
			count.close();
			insertOff.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void addCustomer(String email, String pass, String first, String last, String shippingID, String billingID) {
		try {
			//this is to find the total number of categories
			PreparedStatement countStatement = con.prepareStatement("SELECT COUNT(*) as COUNT FROM Customers");
			ResultSet count = countStatement.executeQuery();
			int num = 0;
			while(count.next()) {
				num=count.getInt("COUNT");
			}
			
			
			PreparedStatement ps = con.prepareStatement("SET IDENTITY_INSERT Customers ON;"
					+ "INSERT INTO Customers (CustomerID, EmailAddress, Password, FirstName, LastName, ShippingAddressID, BillingAddressID) VALUES(?,?,?,?,?,?,?)");
			//the one represents the first question mark '?' which is the CategoryID value in the table
			//the Integer.toString(num+1) is assigning the id number
			ps.setString(1, Integer.toString(num+1));
			//the two represents the second question mark which is the CategoryName value in the table
			ps.setString(2, email);
			ps.setString(3, pass);
			ps.setString(4, first);
			ps.setString(5, last);
			ps.setString(6, shippingID);
			ps.setString(7, billingID);
			
			ps.executeUpdate();
			
			
			
			PreparedStatement insertOff = con.prepareStatement("SET IDENTITY_INSERT Customers OFF");
			insertOff.execute();
			//be sure to close the resultSet and PreparedStatemnt to reallocate the memory
			ps.close();
			count.close();
			insertOff.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void addEmployee(String first, String last, String pay, String position, String date, String phone, String street, String city, String state) {
		try {
			//this is to find the total number of categories
			PreparedStatement countStatement = con.prepareStatement("SELECT COUNT(*) as COUNT FROM Employees");
			ResultSet count = countStatement.executeQuery();
			int num = 0;
			while(count.next()) {
				num=count.getInt("COUNT");
			}
			
			
			PreparedStatement ps = con.prepareStatement("SET IDENTITY_INSERT Employees ON;"
					+ "INSERT INTO Employees (EmpID, FName, LName, Pay, Postion, HireDate, PhoneNum, AddressLine, City, State) VALUES(?,?,?,?,?,?,?,?,?,?)");
			//the one represents the first question mark '?' which is the CategoryID value in the table
			//the Integer.toString(num+1) is assigning the id number
			ps.setString(1, Integer.toString(num+1));
			//the two represents the second question mark which is the CategoryName value in the table
			ps.setString(2, first);
			ps.setString(3, last);
			ps.setString(4, pay);
			ps.setString(5, position);
			ps.setString(6, date);
			ps.setString(7, phone);
			ps.setString(8, street);
			ps.setString(9, city);
			ps.setString(10, state);
			
			ps.executeUpdate();
			
			
			
			PreparedStatement insertOff = con.prepareStatement("SET IDENTITY_INSERT Employees OFF");
			insertOff.execute();
			//be sure to close the resultSet and PreparedStatemnt to reallocate the memory
			ps.close();
			count.close();
			insertOff.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void addOrderItems(String orderID, String productID, String itemPrice, String amnt) {
		try {
			//this is to find the total number of categories
			PreparedStatement countStatement = con.prepareStatement("SELECT COUNT(*) as COUNT FROM OrderItems");
			ResultSet count = countStatement.executeQuery();
			int num = 0;
			while(count.next()) {
				num=count.getInt("COUNT");
			}
			
			
			PreparedStatement ps = con.prepareStatement("SET IDENTITY_INSERT OrderItems ON;"
					+ "INSERT INTO OrderItems (ItemID, OrderID, ProductID, ItemPrice, Quantity) VALUES(?,?,?,?,?)");
			//the one represents the first question mark '?' which is the CategoryID value in the table
			//the Integer.toString(num+1) is assigning the id number
			ps.setString(1, Integer.toString(num+1));
			//the two represents the second question mark which is the CategoryName value in the table
			ps.setString(2, orderID);
			ps.setString(3, productID);
			ps.setString(4, itemPrice);
			ps.setString(5, amnt);
			
			ps.executeUpdate();
			
			
			
			PreparedStatement insertOff = con.prepareStatement("SET IDENTITY_INSERT OrderItems OFF");
			insertOff.execute();
			//be sure to close the resultSet and PreparedStatemnt to reallocate the memory
			ps.close();
			count.close();
			insertOff.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void addOrders(String custID, String orderDate,String shipAmnt, String taxAmnt, String shipDate, String shipAddressID, String cardType,
			String cardNumber, String cardExpires, String billingAddressID) {
		try {
			//this is to find the total number of categories
			PreparedStatement countStatement = con.prepareStatement("SELECT COUNT(*) as COUNT FROM Orders");
			ResultSet count = countStatement.executeQuery();
			int num = 0;
			while(count.next()) {
				num=count.getInt("COUNT");
			}
			
			
			PreparedStatement ps = con.prepareStatement("SET IDENTITY_INSERT Orders ON;"
					+ "INSERT INTO Orders (OrderID, CustomerID, OrderDate, ShipAmount, TaxAmount, ShipDate, ShipAddressID, CardType, CardNumber, CardExpires, BillingAddressID) VALUES(?,?,?,?,?,?,?,?,?,?)");
			//the one represents the first question mark '?' which is the CategoryID value in the table
			//the Integer.toString(num+1) is assigning the id number
			ps.setString(1, Integer.toString(num+1));
			//the two represents the second question mark which is the CategoryName value in the table
			ps.setString(2, custID);
			ps.setString(3, orderDate);
			ps.setString(4, shipAmnt);
			ps.setString(5, taxAmnt);
			ps.setString(6, shipDate);
			ps.setString(7, shipAddressID);
			ps.setString(8, cardType);
			ps.setString(9, cardNumber);
			ps.setString(10, cardExpires);
			ps.setString(11, billingAddressID);
			
			ps.executeUpdate();
			
			
			
			PreparedStatement insertOff = con.prepareStatement("SET IDENTITY_INSERT Orders OFF");
			insertOff.execute();
			//be sure to close the resultSet and PreparedStatemnt to reallocate the memory
			ps.close();
			count.close();
			insertOff.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	public static void addProduct(String catID, String code,String name, String desc, String price) {
		try {
			//this is to find the total number of categories
			PreparedStatement countStatement = con.prepareStatement("SELECT COUNT(*) as COUNT FROM Products");
			ResultSet count = countStatement.executeQuery();
			int num = 0;
			while(count.next()) {
				num=count.getInt("COUNT");
			}
			
			
			PreparedStatement ps = con.prepareStatement("SET IDENTITY_INSERT Products ON;"
					+ "INSERT INTO Orders (ProductID, CategoryID, ProductCode, ProductName, Description, ListPrice) VALUES(?,?,?,?,?,?)");
			//the one represents the first question mark '?' which is the CategoryID value in the table
			//the Integer.toString(num+1) is assigning the id number
			ps.setString(1, Integer.toString(num+1));
			//the two represents the second question mark which is the CategoryName value in the table
			ps.setString(2, catID);
			ps.setString(3, code);
			ps.setString(4, name);
			ps.setString(5, desc);
			ps.setString(6, price);
			
			ps.executeUpdate();
			
			
			
			PreparedStatement insertOff = con.prepareStatement("SET IDENTITY_INSERT Products OFF");
			insertOff.execute();
			//be sure to close the resultSet and PreparedStatemnt to reallocate the memory
			ps.close();
			count.close();
			insertOff.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void addStore(String address, String numOfEmp, String manager) {
		try {
			//this is to find the total number of categories
			PreparedStatement countStatement = con.prepareStatement("SELECT COUNT(*) as COUNT FROM Store");
			ResultSet count = countStatement.executeQuery();
			int num = 0;
			while(count.next()) {
				num=count.getInt("COUNT");
			}
			
			
			PreparedStatement ps = con.prepareStatement("SET IDENTITY_INSERT Products ON;"
					+ "INSERT INTO Store (StoreID, StoreAddress, NumberOfEmployees, Manager) VALUES(?,?,?,?)");
			//the one represents the first question mark '?' which is the CategoryID value in the table
			//the Integer.toString(num+1) is assigning the id number
			ps.setString(1, Integer.toString(num+1));
			//the two represents the second question mark which is the CategoryName value in the table
			ps.setString(2, address);
			ps.setString(3, numOfEmp);
			ps.setString(4, manager);
			
			ps.executeUpdate();
			
			
			
			PreparedStatement insertOff = con.prepareStatement("SET IDENTITY_INSERT Store OFF");
			insertOff.execute();
			//be sure to close the resultSet and PreparedStatemnt to reallocate the memory
			ps.close();
			count.close();
			insertOff.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void removeCategoryById(String id) {
		
		try {
			
			PreparedStatement ps = con.prepareStatement("DELETE FROM Categories WHERE CategoryID ="+id);
			ps.execute();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void removeAddressById(String id) {
		try {
			
			PreparedStatement ps = con.prepareStatement("DELETE FROM Addresses WHERE AddressID ="+id);
			ps.execute();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void removeCustomerById(String id) {
		try {
			
			PreparedStatement ps = con.prepareStatement("DELETE FROM Customers WHERE CustomerID ="+id);
			ps.execute();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void removeEmployeeById(String id) {
		try {
			
			PreparedStatement ps = con.prepareStatement("DELETE FROM Employees WHERE EmpID ="+id);
			ps.execute();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void removeOrderItemById(String id) {
		try {
			
			PreparedStatement ps = con.prepareStatement("DELETE FROM OrderItems WHERE ItemID ="+id);
			ps.execute();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void removeOrderById(String id) {
		try {
			
			PreparedStatement ps = con.prepareStatement("DELETE FROM Orders WHERE OrderID ="+id);
			ps.execute();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void removeProductById(String id) {
		try {
			
			PreparedStatement ps = con.prepareStatement("DELETE FROM Products WHERE ProductID ="+id);
			ps.execute();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void removeStoreById(String id) {
		try {
			
			PreparedStatement ps = con.prepareStatement("DELETE FROM Store WHERE StoreID ="+id);
			ps.execute();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void updateCategoryById(String id, String newNameCat) {
		
		try {
			
			PreparedStatement update = con.prepareStatement("UPDATE Categories SET CategoryName = '"+newNameCat+"' WHERE CategoryID = "+id);
			
			update.execute();
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void updateAddressById(String id, String customerID, String line1, String line2, String city, String state, String zip, String phone, String disabled) {

		try {
			
			PreparedStatement update = con.prepareStatement("UPDATE Addresses SET CustomerID = '"+customerID+"', Line1='"+line1+"', Line2='"+line2+"', City='"+city
					+"', State='"+state+"', ZipCode='"+zip+"', Phone='"+phone+"', Disabled='"+disabled+"'  WHERE AddressID = "+id);
			
			update.execute();
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void updateCustomerById(String id, String email, String pass, String first, String last, String shippingID, String billingID) {

		try {
			
			PreparedStatement update = con.prepareStatement("UPDATE Customers SET EmailAddress = '"+email+"', Password='"+pass+"', FirstName='"+first+"', LastName='"+last
					+"', ShippingAddressID='"+shippingID+"', BillingAddressID='"+billingID+"'  WHERE CustomerID = "+id);
			
			update.execute();
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void updateEmployeeById(String id, String first, String last, String pay, String position, String date, String phone, String street, String city, String state) {

		try {
			
			PreparedStatement update = con.prepareStatement("UPDATE Employees SET FName = '"+first+"', LName='"+last+"', Pay='"+pay+"', Position='"+position
					+"', HireDate='"+date+"', PhoneNum='"+phone+"', AddressLine='"+street+"', City='"+city+"', State='"+state+"'  WHERE EmpID = "+id);
			
			update.execute();
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void updateOrderItemById(String id, String orderID, String productID, String itemPrice, String amnt) {

		try {
			
			PreparedStatement update = con.prepareStatement("UPDATE OrderItems SET OrderID = '"+orderID+"', ProductID='"+productID+"', ItemPrice='"+itemPrice+"', Quantity='"+amnt
					+"'  WHERE ItemID = "+id);
			
			update.execute();
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void updateOrderById(String id, String custID, String orderDate,String shipAmnt, String taxAmnt, String shipDate, String shipAddressID, String cardType,
			String cardNumber, String cardExpires, String billingAddressID) {

		try {
			
			PreparedStatement update = con.prepareStatement("UPDATE Orders SET CustomerID = '"+custID+"', OrderDate='"+orderDate+"', ShipAmount='"+shipAmnt+"', TaxAmount='"+taxAmnt
					+"', ShipDate='"+shipDate+"', ShipAddressID='"+shipAddressID+"', CardType='"+cardType+"', CardNumber='"+cardNumber+"', CardExpires='"+cardExpires+"', BillingAddressID='"+
					billingAddressID+"'  WHERE OrderID = "+id);
			
			update.execute();
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void updateProductById(String id, String catID, String code,String name, String desc, String price) {

		try {
			
			PreparedStatement update = con.prepareStatement("UPDATE Products SET CategoryID = '"+catID+"', ProductCode='"+code+"', ProductName='"+name+"', Description='"+desc
					+"', ListPrice='"+price+"'  WHERE ProductID = "+id);
			
			update.execute();
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void updateStoreById(String id, String address, String numOfEmp, String manager) {

		try {
			
			PreparedStatement update = con.prepareStatement("UPDATE Store SET StoreAddress = '"+address+"', NumberOfEmployees='"+numOfEmp+"', Manager='"+manager+"'  WHERE StoreID = "+id);
			
			update.execute();
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
}


