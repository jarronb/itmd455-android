/*Jarron Bailey
 * 11/19/2017
 * DataRecords.java
 * Lab 3
 * Description: To perform CRUD operations to our already existing BankRecords data using a DAO file which will
 * be used as the link to the database. Also to view result set in a nice column like fashion.
*/

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DataRecords {

	    //static objects for IO processing  
		static DataRecords robjs[] = new DataRecords[101]; //array of DataRecords objects
		static ArrayList<List<String>> array = new ArrayList<>();  //arraylist to hold spreadsheet data

		/**
		 * @return the salary
		 */
		public double getSalary() {
			return salary;
		}
		/**
		 * @param salary the salary to set
		 */
		public void setSalary(double salary) {
			this.salary = salary;
		}
		//instance fields
		private String name;
	    private double salary;
		 /**
		 * @return the name
		 */
		public String getName() {
			return name;
		}
		/**
		 * @param name the name to set
		 */
		public void setName(String name) {
			this.name = name;
		}
		public void readData() {
			BufferedReader br;
			try {
				br = new BufferedReader(new FileReader(new File("data.csv")));

				String line;
				while ((line = br.readLine()) != null) {
					array.add(Arrays.asList(line.split(",")));
				}
			} catch (Exception e) {
				System.out.println("There was a problem loading the file");
			}

	    processData();
		}

		public void processData() {
		 
			 int idx=0;
			    //create loop to grab each array index containing a list of values
			    //and PASS that data into your record objects' setters 
			    for (List<String> rowData: array){
			      	//initialize array of objects
			    	robjs[idx] = new DataRecords();
			    	//call setters below 
			    robjs[idx].setName(rowData.get(0)); //get first column
			    robjs[idx].setSalary(Double.parseDouble(rowData.get(7))); //get seventh column
				idx++;
			    }
		}
}
