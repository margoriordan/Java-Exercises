package edu.cscc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PizzaStore {
	private final String user;
	private final String pass;
	private final String port;
	private final String host;
	private final String database;
	
	private String connectionURL = null;
	
	// TODO - add a String here with your student e-mail name. 
	// Example: if your student email address  is afenwick2@student.cscc.edu set the prefix to afenwick2
	private static final String prefix = "mriordan1";
	private static String ordersTableName = prefix+"_Orders";
	
	// DDL to delete orders table
	private static final String DELETE_DDL =
			"DROP TABLE IF EXISTS "+ordersTableName+";";
	
	// DDL to create orders table
	private static final String CREATE_DDL = 
		"CREATE TABLE "+ordersTableName+"(" + 
				"id INT NOT NULL IDENTITY PRIMARY KEY," +
				"quantity INT NOT NULL, "+
				"orderDate VARCHAR(40) NOT NULL," +
				"size VARCHAR(10) NOT NULL,"+ 
				"type VARCHAR(10) NOT NULL,"+ 
				"toppings VARCHAR(10) NOT NULL);";
	
	private final static String INSERTSQL = "INSERT INTO "+ordersTableName+"(quantity,orderDate,size,type,toppings) VALUES(?,?,?,?,?);";
	
	public PizzaStore(String user, String pass, String port, String host, String database) {
		super();
		this.user = user;
		this.pass = pass;
		this.port = port;
		this.host = host;
		this.database = database;
		this.connectionURL = "jdbc:sqlserver://" + host + ":" + port + ";databaseName=" + database + ";user=" + user
				+ ";password=" + pass + ";encrypt=true;TrustServerCertificate=true";
	}

	public boolean createOrdersTable() {
		boolean result = true;
		try (Connection conn = DriverManager.getConnection(connectionURL);) {
			// TODO - add code here to create delete the orders table if it exists
			// TODO - add code here to create the orders table
			
			try (Statement stmt = conn.createStatement();){
				stmt.execute(DELETE_DDL);
				stmt.execute(CREATE_DDL);
			} 
			
		} catch (SQLException e) {
			System.out.println(connectionURL);
			System.out.println(e.getMessage());
			e.printStackTrace();
			result = false;
		}
		return result;
	}
	
	public boolean placeOrder(PizzaOrder order) throws SQLException {
		int numrows = 0;
		PreparedStatement pstmt = null;
		//quantity,orderDate,size,type, toppings
		// TODO - add code here to place a pizza order
		
		try(Connection conn = DriverManager.getConnection(connectionURL);) {
			
				pstmt = conn.prepareStatement(INSERTSQL);
				pstmt.setInt(1, order.getQuantity());
				pstmt.setString(2, order.getOrderDate());
				pstmt.setString(3, order.getSize().toString());
				pstmt.setString(4, order.getType().toString());
				pstmt.setString(5, order.getTopping().toString());
				numrows = pstmt.executeUpdate(); 
			
		} catch (SQLException e){
			System.out.println(connectionURL);
			System.out.println(e.getMessage());
			e.printStackTrace();
	
		}finally {
			if (pstmt != null) {
				pstmt.close();
			}
		}
		
		return (numrows == 1);
		
	}
		
	
	public int getOrderCount() {
		// TODO - add code to get the number of placed orders
		int orderCount = 0;
		try (Connection conn = DriverManager.getConnection(connectionURL);) {
			try (Statement stmt = conn.createStatement();){
				ResultSet rs = stmt.executeQuery("SELECT COUNT(*) AS ORDER_COUNT FROM " + ordersTableName);
				rs.next();
				orderCount = rs.getInt("ORDER_COUNT");
			} 
			
		} catch (SQLException e) {
			System.out.println(connectionURL);
			System.out.println(e.getMessage());
			e.printStackTrace();
			
		}
		return orderCount;
	}

	public String getUser() {
		return user;
	}

	public String getPass() {
		return pass;
	}

	public String getPort() {
		return port;
	}

	public String getHost() {
		return host;
	}

	public String getDatabase() {
		return database;
	}
}
