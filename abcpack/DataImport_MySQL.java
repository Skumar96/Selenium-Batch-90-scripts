package abcpack;
import java.sql.*;
class DataImport_MySQL
{
    public static void main(String args[]) throws SQLException
     {
    	Connection conn=null;
    	try
    	{
    	   // Load the Driver class. 
       	   Class.forName("com.mysql.jdbc.Driver");
           // Create the connection using the static getConnection method 
           conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/MySQL","root","password12");
           //Create a Statement class to execute the SQL statement 
           Statement stmt=conn.createStatement();
           //Execute the SQL statement and get the results in a Resultset 
           ResultSet rs=stmt.executeQuery("select * from studentinfo;");
           // Iterate through the ResultSet, displaying two values 
           // for each row using the getString method 
           while(rs.next())
            {
               System.out.println(rs.getString("Name")+"||"+rs.getString("Ph")+"||"+rs.getString("Email"));
            }
    	}
    	catch(Exception se)
    	{
    		System.out.println("Sql Exception"+se);
    	}
        finally
        {
        	 try 
        	 {
        		 if(conn != null)
  	             conn.close();
        	 }
	         catch(SQLException e) {
	         e.printStackTrace();
	         } 
        }
                            
       }
  }
