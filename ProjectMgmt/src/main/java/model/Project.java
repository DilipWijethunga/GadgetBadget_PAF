package model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Project {

	// DB connection
	private Connection connect() {

		Connection con = null;

		try {

			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/GadgetBadget", "root", "1234");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;

	}

	public String insertItem(String name, String description, Date date, String patent_no, String cost) {

		String output = "";

		try {

			Connection con = connect();

			if (con == null) {
				{
					return "DB connection error while inserting";
				}

				// prepared statement
				String query = "insert into project ('p_id', 'proj_name', 'description', 'manufac_date, 'patent_no', 'cost')"
						+ "values (?, ?, ?, ?, ?, ?)";

				PreparedStatement stmt = con.prepareStatement(query);

				stmt.setInt(1, 0);
				stmt.setString(2, name);
				stmt.setString(3, description);
				stmt.setDate(4, date);
				stmt.setString(5, patent_no);
				stmt.setDouble(6, Double.parseDouble(cost));

				// Execute the statement
				stmt.execute();
				con.close();

				output = "Inserted Successfully";
			}

		}

		catch (Exception e) {
			output = "Insert error!";
			System.err.println(e.getMessage());
		}
		return output;

	}
	
	
	

	public String readProject() {
		
		String output = "";
		
		try {
			
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
}
