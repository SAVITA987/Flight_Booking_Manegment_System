import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

	public class Admin {
		static Scanner sc= new Scanner(System.in);
	    public static void admin() throws SQLException, ClassNotFoundException {
	       
	            
					Class.forName("com.mysql.cj.jdbc.Driver");
	            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/flight_db", "root", "Savita@123");

	            
	            String createTableQuery = "CREATE TABLE flight00 (" +
	                    "flight_id INT PRIMARY KEY," +
	                    "flight_number INT," +
	                    "departure_city VARCHAR(20)," +
	                    "arrival_city VARCHAR(20)," +
	                    "departure_time VARCHAR(20)," +
	                    "arrival_time VARCHAR(20)," +
	                    "price INT" +
	                    ");";

	            PreparedStatement pstmt = con.prepareStatement(createTableQuery);
	            pstmt.executeUpdate(); 

	            System.out.println("Table 'flights' created successfully.");
	          
	        }
	    
	

	public static void updateFlightDetails() throws SQLException {
		Connection con = MyConnection.getConnection();
        Scanner sc = new Scanner(System.in);
        {

       System.out.println("Enter flight ID to update:");
       int flightId = sc.nextInt();

       System.out.println("Enter new price:");
       int newPrice = sc.nextInt();

       String updateQuery = "UPDATE flight00 SET price = ? WHERE flight_id = ?";
       PreparedStatement preparedStatement = con.prepareStatement(updateQuery);

       preparedStatement.setInt(1, newPrice);
       preparedStatement.setInt(2, flightId);

       int rowsUpdated = preparedStatement.executeUpdate();

       if (rowsUpdated > 0) {
           System.out.println(rowsUpdated + " record(s) updated successfully.....");
       } else {
           System.out.println("No records were updated.");
       }
       System.out.println("flight_id\tprice");

    
	
	System.out.println(flightId + "\t\t" + newPrice );

   }
	    }
		
	

	public static void deleteFlightDetails() throws SQLException {
	
		 Scanner sc = new Scanner(System.in);
	        System.out.println("Enter Flight ID to delete:");
	        int flightIdToDelete = sc.nextInt();

	        String deleteQuery = "DELETE FROM flight00 WHERE flight_id = ?";

	        try (Connection connection = MyConnection.getConnection();
	             PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery)) {

	            preparedStatement.setInt(1, flightIdToDelete);

	            int rowsDeleted = preparedStatement.executeUpdate();
	            System.out.println(rowsDeleted + " record(s) deleted successfully.");
	        }
	        System.out.println("flight_id");

	        
	    	
	    	System.out.println(flightIdToDelete + "\t\t" );

		
	}



	
	public static void insertFlightsDetails() throws SQLException {
		Scanner sc = new Scanner(System.in);
	             Connection con = MyConnection.getConnection();
	             {

	            System.out.println("Enter Flight Id: ");
	            int flightId = sc.nextInt();
	            
	            System.out.println("Enter Flight No: ");
	            int flightNo = sc.nextInt();
	           

	            System.out.println("Enter Departure city: ");
	            String departure_city = sc.next();

	            System.out.println("Enter Arrival city: ");
	            String arrival_city = sc.next();

	            System.out.println("Enter Departure Time: ");
	            String departure_time = sc.next();

	            System.out.println("Enter Arrival Time: ");
	            String arrival_time = sc.next();

	            System.out.println("Enter Price: ");
	            int price = sc.nextInt();

	            String insertQuery = "INSERT INTO flight00 (flight_id, flight_number, departure_city, arrival_city, departure_time, arrival_time, price) VALUES (?, ?, ?, ?, ?, ?, ?)";

	          
	            PreparedStatement preparedStatement = con.prepareStatement(insertQuery);


	            preparedStatement.setInt(1, flightId);
	            preparedStatement.setInt(2, flightNo);
	            preparedStatement.setString(3, departure_city);
	            preparedStatement.setString(4, arrival_city);
	            preparedStatement.setString(5, departure_time);
	            preparedStatement.setString(6, arrival_time);
	            preparedStatement.setInt(7, price);

	          
	            int rowsInserted = preparedStatement.executeUpdate();

	            if (rowsInserted > 0) {
	                System.out.println(".......Data inserted successfully.......");
	            } else {
	                System.out.println("Data insertion failed.");
	            }
		        System.out.println("flight_id\tflight_number\tdeparture_city\tarrival_city\tdeparture_time\tarrival_time\tprice");

	            System.out.println(flightId + "\t\t" + flightNo + "\t\t" + departure_city + "\t\t" + arrival_city + "\t\t" + departure_time + "\t\t" + arrival_time + "\t\t" + price );

	        } 
	}
	}