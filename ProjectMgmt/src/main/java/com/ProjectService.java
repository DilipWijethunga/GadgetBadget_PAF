package com;

import java.sql.*;

public class ProjectService {

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

	public String insertItem() {
		
	}
}
