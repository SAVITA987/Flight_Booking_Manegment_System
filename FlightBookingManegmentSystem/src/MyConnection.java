

	import java.sql.Connection;

	import java.sql.DriverManager;

	public class MyConnection {

		 public static Connection getConnection()
		    {
		        try{
		        
		        Class.forName("com.mysql.cj.jdbc.Driver");
		        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/flight_db","root","Savita@123");
		      
		        return con;
		        
		        }catch(Exception ex)
		        {
		           System.out.println(ex.getMessage()); 
		        }
		        return null;
		    }
		}


