package edu.cscc;

import java.sql.*;
import java.util.Scanner;

/**@author Margaret Riordan**/

// TODO - add SQL Server driver to project and Build Path
public class Main {

	// JDBC driver name and database URL
	// static final String JDBC_DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";

	//Database credentials
	static final String USER = "username";
	static final String PASS = "password";
	static final String PORT = "0000";
	static final String HOST = "host.rds.amazonaws.com";
	static final String DATABASE = "databaseName";

	// Build connection URL
	static final String connectionURL = "jdbc:sqlserver://" + HOST + ":" + PORT +
			";databaseName=" + DATABASE + ";user=" + USER + ";password=" + PASS + 
			";encrypt=true;TrustServerCertificate=true";
	
	static final String divider = "===========================================================================================================================================================================";
	
	private static Scanner input = new Scanner(System.in);
	
	
	public static void main(String[] args) {
		
		
		PreparedStatement preparedStatement = null;
		
		try (Connection conn = DriverManager.getConnection(connectionURL); 
				Statement stmt = conn.createStatement();
				) {
			while(true) {
				
				System.out.println("Customer Search by Country");
				System.out.print("Enter country: ");
				String userInput = input.nextLine();
				System.out.println();
				
				if("quit".equalsIgnoreCase(userInput)) {
					System.out.println("Bye!");
					break;
				}
				
				String sql = "SELECT CompanyName, Address, City, Region, PostalCode, Country FROM Customers WHERE Country = ?";
				
				preparedStatement = conn.prepareStatement(sql);
				preparedStatement.setString(1, userInput);
			
				ResultSet resultSet = preparedStatement.executeQuery();
				
				System.out.printf("%-40s %-60s %-25s %-15s %-15s %-15s\n", "Company Name", "Address", "City", "Region", "Postal", "Country");
				System.out.println(divider);
				
				
				int count = 0;
				while (resultSet.next()) {
				
					count++;
					
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
			if (count == 0) {
				System.out.printf("\n%95s", "*** No results found for " + userInput + " ***\n\n");
				System.out.println(divider + "\n");

				continue;
			} 
			
			System.out.println(divider + "\n");
			
			// Clean-up result set
			resultSet.close();
			}
			
		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} finally {
			closePreparedStatement(preparedStatement);
			
		}
		
	}
	
	private static void closePreparedStatement(PreparedStatement stmt) {
		if (stmt != null) {
			try {
				stmt.close();
			} catch (SQLException e) { /* ignore */ }
		}
	}
}