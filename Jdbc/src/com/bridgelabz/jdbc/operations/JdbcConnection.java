
package com.bridgelabz.jdbc.Operations;

import java.sql.*;

/**
 * 
 * @author :Premsai Manthani
 * @purpose : this class implement connection of application to database .
 *
 */
public class JdbcConnection {

	public Statement connect() throws ClassNotFoundException, SQLException {

		String url = "jdbc:mysql://localhost:3306/prem";
		String uname = "root";
		String password = "root";
		Class.forName("com.mysql.jdbc.Driver");// driver fi
		Connection con = DriverManager.getConnection(url, uname, password);
		Statement st = con.createStatement();

		return st;

	}

}
