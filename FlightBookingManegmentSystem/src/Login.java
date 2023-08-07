import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.util.Scanner;


public class Login {
	
	static Scanner sc=new Scanner(System.in);
		public static void login() throws SQLException {
		
			System.out.print("Enter UserName:");	  
			  String username =sc.nextLine();
		  
			  System.out.print("Enter Password:");
				  String password=sc.nextLine() ;
			 
			  Connection con= MyConnection.getConnection();
			PreparedStatement pstsmt = null;


			String selectQuery = ("SELECT * FROM users WHERE username=? AND password=?");
	        pstsmt = con.prepareStatement(selectQuery);
		
			      pstsmt.setString(1, username);
			      pstsmt.setString(2, password);
			        
			      ResultSet resultSet = pstsmt.executeQuery();

			        while (resultSet.next()) {

			            String Username = resultSet.getString("username");
			            String Password = resultSet.getString("password");

			           			      }

		          boolean Login;
				if (Login=true) {
		            System.out.println("........WELCOME TO FLIGHT BOOKING MANEGMENTS SYSTEM........");
		          } else {
		              System.out.println("Login failed,Invalid User");
		          }
		
		}

		public static void searchFlights(Flights flights) throws SQLException {
			// TODO Auto-generated method stub
			System.out.print("Enter departure city: ");
	        String departureCity = sc.next();
	        System.out.print("Enter arrival city: ");
	        String arrivalCity = sc.next();

	        Connection con= MyConnection.getConnection();
	    	PreparedStatement pstsmt = null;
	    	
	        String selectQuery = "SELECT * FROM flight00 WHERE departure_city = ? AND arrival_city = ?";
	        pstsmt = con.prepareStatement(selectQuery);
	        pstsmt.setString(1, departureCity);
	        pstsmt.setString(2, arrivalCity);
	        
	         ResultSet resultSet = pstsmt.executeQuery();
	        
	         System.out.println("Flight ID\tFlight Number\tDeparture City\tArrival City\tDeparture Time\tArrival Time\tPrice ");
	        while (resultSet.next()) {
	            int flightId = resultSet.getInt("flight_id");
	            String flightNumber = resultSet.getString("flight_number");
	            String departure = resultSet.getString("departure_city");
	            String arrival = resultSet.getString("arrival_city");
	            Time departureTime = resultSet.getTime("departure_time");
	            Time arrivalTime = resultSet.getTime("arrival_time");
	            int price = resultSet.getInt("price");

	            System.out.println(flightId + "\t\t" + flightNumber + "\t\t" + departure + "\t\t" + arrival + "\t\t" + departureTime + "\t\t" + arrivalTime +"\t\t" + price);
	       
	        boolean resultset;
			if (resultset=true ) {

	                  System.out.println("Flights Search successfully....!");

	               } 
	         else {
	            System.out.println("Flight not found.");
	        }
			return;
		}
		

}    
		
		public static void bookTicket() throws SQLException {

	        Scanner sc = new Scanner(System.in);

			System.out.print("Enter flight ID: ");
	        int flightId = sc.nextInt();
	        sc.nextLine();
	        System.out.print("Enter flight Number: ");
	        int flightNumber = sc.nextInt();
	        
	        System.out.print("Enter passenger name: ");
	        String passengerName = sc.next();

	        
	        System.out.print("Enter passenger email: ");
	        String passengerEmail = sc.next();
	        
	        System.out.print("Enter bookingdate: ");
	        String bookingdate = sc.next();
	        
	        System.out.print("Enter Status:");
	        String status=sc.next();
        
	        Connection con= MyConnection.getConnection();

	        
	       
	        String insertQuery = "INSERT INTO booking (flight_id, flight_number,passenger_name, passenger_email, booking_date,status) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement pstsmt = con.prepareStatement(insertQuery);
	        pstsmt.setInt(1, flightId);
	        pstsmt.setInt(2 ,  flightNumber);
	        pstsmt.setString(3, passengerName);
	        pstsmt.setString(4, passengerEmail);
	        pstsmt.setString(5, bookingdate);
	        pstsmt.setString(6, status);
	        pstsmt.executeUpdate();
	        
	        System.out.println("Your Booking is Confirmed ....");
		}
	      

//	        String updateQuery = "UPDATE bookings SET status = ? WHERE flight_id = ?";
//	        System.out.println("Check Available Status....");
////	      
//	        String status1 = sc.nextLine();
//	        
//	        pstsmt = con.prepareStatement(updateQuery);
//	        pstsmt.setString(1, status1);
//	        pstsmt.setInt(2, flightId);
//	        pstsmt.executeUpdate();
//	        
//		boolean Status;
//	
//			if(Status=true){
//	    	  System.out.println(".....Yes....");
//	      }else {
//	    	  System.out.println(".....No.....");
//	      }
//		
//		}		
//	    


		public static void viewBookings() throws SQLException {
		    Connection con = MyConnection.getConnection();
		    Statement stmt = con.createStatement();
		    String selectQuery = "SELECT * FROM booking";
		    ResultSet resultSet = stmt.executeQuery(selectQuery);

		    System.out.println("Flight No\tFlight ID\tPassenger Name\tPassenger Email\tBooking Date\tStatus");
		    while (resultSet.next()) {
		        int flightNo = resultSet.getInt("flight_number");
		        int flightId = resultSet.getInt("flight_id");
		        String passengerName = resultSet.getString("passenger_name");
		        String passengerEmail = resultSet.getString("passenger_email");
		        String bookingDate = resultSet.getString("booking_date");
		        String status = resultSet.getString("Status"); // Ensure case sensitivity here

		        System.out.println(
		            flightNo + "\t\t" +
		            flightId + "\t\t" +
		            passengerName + "\t\t" +
		            passengerEmail + "\t\t" +
		            bookingDate + "\t\t" +
		            status
		        );
		    }
		    
		    // Close resources (important to avoid resource leaks)
		    resultSet.close();
		    stmt.close();
		    con.close();
		}

		
		public static void paymentNow() throws SQLException {
	        try (Connection con = MyConnection.getConnection()) {
	            Statement stmt = con.createStatement();
	            String selectQuery = "SELECT * FROM Booking_PaymentDetails";
	            ResultSet resultSet = stmt.executeQuery(selectQuery);

	            System.out.println("Payment Details:");
	            System.out.println("------------------------");
	            while (resultSet.next()) {
	                String cardHolderName = resultSet.getString("card_holder_name");
	                String cardNumber = resultSet.getString("card_number");
	                String cvv = resultSet.getString("cvv");
	                String expiryDate = resultSet.getString("expiry_date");

	                System.out.println("Card Holder's Name: " + cardHolderName);
	                System.out.println("Card Number: " + cardNumber);
	                System.out.println("CVV: " + cvv);
	                System.out.println("Expiry Date: " + expiryDate);
	                System.out.println("------------------------");
	            }
	            System.out.println("Payment details fetched successfully.");
	        }
	    }

		
		


		 public static void saveBookingWithPaymentDetails() throws SQLException {
		        Scanner sc = new Scanner(System.in);
		            System.out.println("Enter cardHolderName:");
		            String cardHolderName = sc.nextLine();

		            System.out.println("Enter cardNumber:");
		            String cardNumber = sc.nextLine();

		            System.out.println("Enter cvv:");
		            String cvv = sc.nextLine();

		            System.out.println("Enter expiryDate (MM/YY):");
		            String expiryDate = sc.nextLine();

		            Connection con = MyConnection.getConnection();
		                String insertQuery = "INSERT INTO Booking_PaymentDetails (card_holder_name, card_number, cvv, expiry_date) VALUES (?, ?, ?, ?)";
		                PreparedStatement pstsmt = con.prepareStatement(insertQuery);

		                pstsmt.setString(1, cardHolderName);
		                pstsmt.setString(2, cardNumber);
		                pstsmt.setString(3, cvv);
		                pstsmt.setString(4, expiryDate);

		                int rowsAffected = pstsmt.executeUpdate();
		                if (rowsAffected == 1) {
		                    System.out.println("Booking with payment details saved successfully.");
		                } else {
		                    System.out.println("Failed to save booking with payment details.");
		                }
		            }
		        
		 
		    
		 static void showConfirmationMessage() {
		        System.out.println(" scuccessfuly recevied your payment......Thank You..... " );
		    }
	            
        	public static void logout() {
				  boolean isLogin = false;
					 
					System.out.println("successfully logout...");
				
			}

			public static void viewFlights() throws SQLException {
				  Connection con= MyConnection.getConnection();

				  Statement stmt = con.createStatement();
				 String selectQuery = "SELECT * FROM flight00";
			        ResultSet resultSet = stmt.executeQuery(selectQuery);

			        System.out.println("flight_id\tflight_number\tdeparture_city\tarrival_city\tdeparture_time\tarrival_time\tprice");
			        while (resultSet.next()) {
			            int flight_id = resultSet.getInt("flight_id");
			            int flight_number = resultSet.getInt("flight_number");
			            String departure_city = resultSet.getString("departure_city");
			            String arrival_city = resultSet.getString("arrival_city");
			            String departure_time = resultSet.getString("departure_time");
			            
			            String arrival_time = resultSet.getString("arrival_time");
			            int price = resultSet.getInt("price");


			            System.out.println(flight_id + "\t\t" + flight_number + "\t\t" + departure_city + "\t\t" + arrival_city + "\t\t" + departure_time + "\t\t" + arrival_time + "\t\t" + price );
			            }
			
				
			    }
			}

