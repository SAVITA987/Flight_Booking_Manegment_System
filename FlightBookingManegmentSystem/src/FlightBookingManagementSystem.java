import java.sql.SQLException;
import java.util.Scanner;

public class FlightBookingManagementSystem {

    public static void main(String[] args) throws SQLException {

        Scanner sc = new Scanner(System.in);
        
        boolean running = true;
        while (running) {
        System.out.println("******Flight Booking Management System******");
        System.out.println("1. Login");
        System.out.println("2. Admin");
        System.out.println("3. Logout");
        System.out.println("4. Exit");
        System.out.print("Enter your choice:> ");
        int choice = sc.nextInt();

        switch (choice) {
            case 1:
                User user = new User();
                Login.login();
                boolean running1 = true;
                while (running1) {
                System.out.println(".....Dashaboard.....");	
                System.out.println("1. Search Flights");
                System.out.println("2. Book Ticket");
                System.out.println("3. Payment");
                System.out.println("4. View Flights Bookings");
                System.out.println("5 .Logout");
                System.out.println("6. Exit");
                System.out.print("Enter your choice: ");
               

                int choice1 = sc.nextInt();

                switch (choice1) {

                            case 1:
                                Flights flights = new Flights();
                                Login.searchFlights(flights);
                                break;
                            case 2:
                                Bookings bookings = new Bookings();
                                Login.bookTicket();
                                break;
                            case 3:
                            	  boolean running2 = true;
                                  while (running2) {
                               System.out.println("........Enter Your Payment Details......");
                                System.out.println("1. BookingWithPaymentDetails");
                                System.out.println("2. Display Payment Details");
                                System.out.println("3. showConfirmationMessage");
                                System.out.println("4. Exit");
                                System.out.print("Enter the option:");
                                int choice3 = sc.nextInt();

                                switch (choice3) {
                                case 1:
                                    Booking_PaymentDetails booking_PaymentDetails = new Booking_PaymentDetails();
                                    Login.saveBookingWithPaymentDetails();
                                    break;
                                    
                                    case 2:
                                        Login payment = new Login();
                                        Login.paymentNow();
                                        break;
                                  
                                    case 3:
									  
                                    	Login.showConfirmationMessage();
                                    case 4:
                                        running2 = false;
                                        break;
                                    default:
                                        System.out.println("Invalid option.");
                                        break;
                                }
                            }
                
                                break;


                            case 4:
                            	System.out.println("1. View Bookings");
                                System.out.println("2. view Flights");
                                System.out.println("3. Exit");

                                System.out.print("Enter the option:");
                                boolean running3 = true;
                                while (running3) {
                             
//                                  System.out.print("Enter the option:");

                              int choice4 = sc.nextInt();
                           

                              switch (choice4) 
                              {
                              case 1:
                                Bookings book = new Bookings();
                                Login.viewBookings();
                                break;
                              case 2:
                                  Bookings bookings1 = new Bookings();
                                  Login.viewFlights();
                                  break;
                              case 3:
                                  running3 = false;
                                  break;
                              default:
                                  System.out.println("Invalid option.");
                                  break;
                              }
                            }
                              
                
                             break;  
                            case 5:
                            	Login.logout();
                            	break;
                            case 6:
                                running1 = false;
                                break;
                            default:
                                System.out.println("Invalid option.");
                                break;
                            }
                         }
        
                        break;
                        

            case 2:
                boolean running5 = true;
                while (running5) {
                    System.out.println(".....Admin Panel.....");
                    System.out.println("1. Add Flight ");
                    System.out.println("2. Update Flight ");
                    System.out.println("3. Cansal Flight ");
                    System.out.println("4. Exit");
                    System.out.print("Enter your choice: ");
                    int choice2 = sc.nextInt();
                    switch (choice2) {
                        case 1:
                            Admin.insertFlightsDetails();
                            break;
                        case 2:
                            Admin.updateFlightDetails();
                            break;
                        case 3:
                            Admin.deleteFlightDetails();
                            break;
                        case 4:
                            running5 = false;
                            break;
                        default:
                            System.out.println("Invalid option.");
                            break;
                    }
                }
                break;
                    case 3:
                        Logout logout = new Logout();
                        Logout.logout();
                        break;
                    case 4:
                        running = false;
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                        break;
                }
              
        }
         
     }
}
