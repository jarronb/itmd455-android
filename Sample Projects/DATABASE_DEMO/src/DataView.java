/*Jarron Bailey
 * 11/19/2017
 * DataView.java
 * Lab 3
 * Description: To perform CRUD operations to our already existing BankRecords data using a DAO file which will
 * be used as the link to the database. Also to view result set in a nice column like fashion.
*/

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class DataView  extends JFrame{
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DataView()
	{
	   //set DAO_DEMO instance
	   DAO_DEMO dao = new DAO_DEMO();
	   
	   //set up Vectors for JTable
	    Vector<Vector<Object>> data = new Vector<Vector<Object>>();
        Vector<String> column = new Vector<String>();
		try {
			ResultSet rs = dao.retrieveRecords();
			ResultSetMetaData metaData = rs.getMetaData();
		    int columns = metaData.getColumnCount();

			 //get column names from table!
	    	    String cols = ""; 
	    	 
	    	    for (int i = 1; i <= columns ; i++) {
	    	       cols = metaData.getColumnName(i);
	    	       column.add(cols);
	    	    }
	    	    //get row data from table!
	    	    while (rs.next()) {
	    	       Vector<Object> row = new Vector<Object>(columns);
	    	          
	    	       for (int i = 1; i <= columns; i++) {
	    	        row.addElement(rs.getObject(i));
	    	       } 
	    	       data.addElement(row);
	    	    }
	    	    rs.close(); 
	    	   
	    	    DefaultTableModel model = new DefaultTableModel(data,column);
	    		
	    		JTable table = new JTable(model);
	    	    
		    JFrame frame = new JFrame("Details");
	    		frame.setSize(700, 200);
	    		frame.add(new JScrollPane(table));
	        frame.setDefaultCloseOperation( EXIT_ON_CLOSE );
	    		frame.pack();
	    		frame.setVisible(true);
	            		       		
		} 
		  catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		  } catch (Exception ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		} 
		
	}
	
}
