/*Jarron Bailey
 * 11/19/2017
 * DataProcessing.java
 * Lab 3
 * Description: To perform CRUD operations to our already existing BankRecords data using a DAO file which will
 * be used as the link to the database. Also to view result set in a nice column like fashion.
*/
import java.sql.ResultSet;
import java.sql.SQLException;

public class DataProcessing extends DataRecords{

	public static void main(String[] args) {
		   //Instantiating DataRecords object in order to add 
			//
		   DataRecords dr = new DataRecords();
		   dr.readData();
		   
		   //DAO_DEMO instance
		   DAO_DEMO dao = new DAO_DEMO();
		   
		   //dao.createTable(); 
		   //dao.insertRecords(robjs);  //perform inserts
		   ResultSet rs = dao.retrieveRecords(); //fill result set object
	  
		   //Show JTable from DataView 
		   new DataView(); //initiate constructor call from class
		    
		  //Create heading for display
		  System.out.println("ID:\t\t Name\t\t\t   Salary");
		  try {
			//Extract data from result set
			while(rs.next()){
			     //Retrieve by column name
			     int uid  = rs.getInt("uid");
			     String name  = rs.getString("name");
			     double salary = rs.getDouble("salary");
			     //Display values
			     System.out.printf("%d\t\t%-10s\t\t%10.2f%n", uid ,name.replace("\""," "),salary);
			  }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
