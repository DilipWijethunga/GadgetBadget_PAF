package model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mysql.cj.protocol.Resultset;

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

	public String insertItem(String name, String description, String patent_no, String cost) {

		String output = "";

		try {

			Connection con = connect();

			if (con == null) {
				{
					return "DB connection error while inserting";
				}

				// prepared statement
				String query = "insert into project ('p_id', 'proj_name', 'description', 'patent_no', 'cost')"
						+ "values (?, ?, ?, ?, ?)";

				PreparedStatement stmt = con.prepareStatement(query);

				stmt.setInt(1, 0);
				stmt.setString(2, name);
				stmt.setString(3, description);
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
			
			Connection con = connect();
			
			if(con == null)
			{return "DB connection error while reading"; }
			
			//HTML table to view
			output = "<table border ='s'> <tr> <th> Project ID </th> <th> Project Name </th> <th> Description </th>"
					+ "<th>Patent Number</th> <th>Cost</th> <th>Update</th> <th>Delete</th> </tr>";
			
			String query = "select * from project";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			
			
			//show all results in the result set
			while (rs.next())
			{
				String projID = Integer.toString(rs.getInt("p_id"));
				String projName = rs.getString("proj_name");
				String Description = rs.getString("description");
				String PatentNo = rs.getString("patent_no");
				String Cost = Double.toString(rs.getDouble("cost"));
				
				//HTML table
				output += "<tr><td>" + projID + "</td>";
				output += "<td>" + projName + "</td>";
				output += "<td>" + Description + "</td>";
				output += "<td>" + PatentNo + "</td>";
				output += "<td>" + Cost + "</td> </tr>";
				
				
				output += "<td><input name='btnUpdate' type='button' value='Update'	class='btn btn-secondary'></td>"
						+ "<td><form method='post' action='project.jsp'>"
						+ "<input name='btnRemove' type='submit' value='Remove'	class='btn btn-danger'>"
						+ "<input name='itemID' type='hidden' value='" + projID	+ "'>" + "</form></td></tr>";
			}
			con.close();
			
			//complete HTML table
			output += "</table>";
			
			
			
			
		} catch (Exception e) {
			output = "Error while reading";
			System.err.println(e.getMessage());
		}
		return output;
		
	}
}
