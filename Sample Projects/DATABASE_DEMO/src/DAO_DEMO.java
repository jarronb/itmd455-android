

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*CRUD demo- table creation, record insertions & retrievals*/
public class DAO_DEMO {

	// Define database URL
	static final String DB_URL = "jdbc:mysql://www.papademas.net/411labs?autoReconnect=true&useSSL=false";
 
	// Define Database credentials
	static final String USER = "db411";
	static final String PASS = "411";

	// Define DB objects
	Connection conn = null;
	Statement stmt = null;

	// CREATE TABLE METHOD
	public void createTable() {
		try {
			// Open a connection
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			// setup connection statement
			stmt = conn.createStatement();

			String sql = "CREATE TABLE data_tab " + "(uid INTEGER not NULL, " + " name VARCHAR(30), "
					 + " salary numeric(8,2), " + " PRIMARY KEY ( uid ))";

			stmt.executeUpdate(sql);
			System.out.println("Created table in given database...");
		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} finally {
			// finally block used to close resources
			try {
				if (stmt != null)
					conn.close();
			} catch (SQLException se) {
			} // do nothing
		} // end try
	}

	// INSERT RECORDS METHOD
	public void insertRecords(DataRecords [] robjs) {

		try{
		  //Open a DB connection
	      System.out.println("Connecting to a selected database for Inserts...");
	      conn = DriverManager.getConnection(DB_URL, USER, PASS);
	      System.out.println("Connected database successfully...");
	      
	      //STEP 4: Execute a query
	      System.out.println("Inserting records into the table...");
	      stmt = conn.createStatement();
	      
	      //include all object data to the database table
	      for(int i=0;i<robjs.length;++i) {
	      String sql = "INSERT INTO data_tab (uid,name,salary) " +
	                   "VALUES ('"+(i+1)+"','"+robjs[i].getName()+"','"+robjs[i].getSalary()+"' )";
	      stmt.executeUpdate(sql); //run query to insert record by record
	      }

	      System.out.println("Inserted records into the table...");

	   }catch(SQLException se){
		// Handle errors for JDBC
		se.printStackTrace();
	  }finally {
		// finally block used to close resources
		try {
			if (stmt != null)
				conn.close();
		} catch (SQLException se) {  } // do nothing
	}// end finally try
}

	// RETRIEVE RECORDS METHOD
	public ResultSet retrieveRecords() {
		ResultSet rs = null;
		try {
			// Open a connection
			conn = DriverManager.getConnection(DB_URL, USER, PASS);

			stmt = conn.createStatement();

			String sql = "SELECT * from data_tab order by name";

			// Execute a query
			rs = stmt.executeQuery(sql);

			System.out.println("Retrieving record(s)...");

		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		}
		return rs; // return result set
	}
}
