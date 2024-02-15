package edu.cscc;

import java.sql.*;

/**@author Margaret Riordan**/

// TODO - add SQL Server driver to project and Build Path
public class Main {

	// JDBC driver name and database URL
	// static final String JDBC_DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";

	//Database credentials
	// TODO - replace with actual connection information
	static final String USER = "rdonly";
	static final String PASS = "purpleAvocado218";
	static final String PORT = "1433";
	static final String HOST = "csci2469-01.czlyasswa9el.us-east-2.rds.amazonaws.com";
	static final String DATABASE = "Northwind";

	// Build connection URL
	static final String connectionURL = "jdbc:sqlserver://" + HOST + ":" + PORT +
			";databaseName=" + DATABASE + ";user=" + USER + ";password=" + PASS + 
			";encrypt=true;TrustServerCertificate=true";
	
	public static void main(String[] args) {
		// You may see this in older code to load the JDBC driver
		// This is no longer required - as of Java 6
		// Class.forName(JDBC_DRIVER);
		//System.out.println("Connection URL: "+connectionURL);
		//System.out.println("Connecting to database...");
		//System.out.println("Creating statement...");
		// Open a connection using Connection URL - auto close connection and statement
		System.out.printf("%-40s %-60s %-25s %-15s %-15s %-15s\n", "Company Name", "Address", "City", "Region", "Postal", "Country");
		System.out.print("===========================================================================================================================================================================\n");
		try (Connection conn = DriverManager.getConnection(connectionURL); 
				Statement stmt = conn.createStatement();
				) {

			String sql = "SELECT CompanyName, Address, City, Region, PostalCode, Country FROM Customers";
			ResultSet resultSet = stmt.executeQuery(sql);

			// Extract data from result set (Only 1 row)
			while (resultSet.next()) {
				
				String companyName = resultSet.getString("CompanyName"); //40 not null
				String address = resultSet.getString("Address"); //60
				String city = resultSet.getString("City"); //15
				String region = resultSet.getString("Region");  //15
				String postalCode = resultSet.getString("PostalCode"); //10
				String country = resultSet.getString("Country"); //15
				
				address = (address == null) ? "n/a" : address;
				city = (city == null) ? "n/a" : city;
				region = (region == null) ? "n/a" : region;
				postalCode = (postalCode == null) ? "n/a" : postalCode;
				country = (country == null) ? "n/a" : country;
				
				System.out.printf("%-40s %-60s %-25s %-15s %-15s %-15s\n", companyName, address, city, region, postalCode, country);
			}
			// Clean-up result set
			resultSet.close();
		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} 
		System.out.println("\nDone! Bye!");
	}
}