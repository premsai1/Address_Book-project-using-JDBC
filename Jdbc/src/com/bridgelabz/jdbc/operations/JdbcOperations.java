package com.bridgelabz.jdbc.Operations;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.concurrent.Callable;

import com.mysql.jdbc.Statement;

/**
 * 
 * @author :Premsai Manthani
 * @purpose : this class performes the implementation on a database such as crud
 *          operations .
 *
 */
public class JdbcOperations {
	// Static int count=('"select count"("*") "from student1"');
	static JdbcConnection jcon;
	static {
		jcon = new JdbcConnection();
	}
	static Scanner s1 = new Scanner(System.in);

	public static void fetch1() throws ClassNotFoundException, SQLException {
		Statement st = (Statement) jcon.connect();

		ResultSet rs = st.executeQuery("select*from student1 ");
		while (rs.next()) {

			System.out.println(rs.getInt(1));
			System.out.println(rs.getString(2));
			System.out.println(rs.getString(3));
			System.out.println(rs.getString(4));
			System.out.println(rs.getString(5));
			System.out.println(rs.getInt(6));
			System.out.println(rs.getInt(7));
		}

	}

	public static void fetch() throws ClassNotFoundException, SQLException {
		Statement st = (Statement) jcon.connect();

		ResultSet rs = st.executeQuery("select*from student ");
		while (rs.next()) {

			System.out.println(rs.getInt(1));
			System.out.println(rs.getString(2));
			System.out.println(rs.getString(3));
			System.out.println(rs.getString(4));
			System.out.println(rs.getString(5));
			System.out.println(rs.getInt(6));
			System.out.println(rs.getInt(7));
		}

	}

	public static void deletebyid1(int sid) throws ClassNotFoundException, SQLException {
		Statement st = (Statement) jcon.connect();
		int c = st.executeUpdate("delete from student where sid =" + sid + "");
		System.out.println(c + " rows affected");
	}

	public static void deletebyid(int sid) throws ClassNotFoundException, SQLException {
		Statement st = (Statement) jcon.connect();
		int c = st.executeUpdate("delete from student where sid =" + sid + "");
		System.out.println(c + " rows affected");
	}

	public static void deletebyname1(String sname) throws ClassNotFoundException, SQLException {
		Statement st = (Statement) jcon.connect();
		int c = st.executeUpdate("delete from student1 where sname ='" + sname + "'");
		System.out.println(c + " rows affected");
	}

	public static void deletebyname(String sname) throws ClassNotFoundException, SQLException {
		Statement st = (Statement) jcon.connect();
		int c = st.executeUpdate("delete from student where sname ='" + sname + "'");
		System.out.println(c + " rows affected");
	}

	public static void updateData1(int sid, String sname) throws ClassNotFoundException, SQLException {
		Statement st = (Statement) jcon.connect();
		int c = st.executeUpdate("update student1 set sname='" + sname + "' where sid =" + sid + "");
		System.out.println(c + " rows affected");

	}

	public static void updateData(int sid, String sname) throws ClassNotFoundException, SQLException {
		Statement st = (Statement) jcon.connect();
		int c = st.executeUpdate("update student set sname='" + sname + "' where sid =" + sid + "");
		System.out.println(c + " rows affected");

	}

	public static void delete(int option) throws ClassNotFoundException, SQLException {
		Statement st = (Statement) jcon.connect();
		if (option == 1) {
			System.out.println("are sure do you want to delete");
			System.out.println("1.delete");
			System.out.println("2.cancel");
			int option2 = s1.nextInt();
			if (option2 == 1) {
				st.executeUpdate("delete table student1");
			} else {
				st.executeUpdate("delete table student");
			}
		}
	}

	public static void insertdata1(int sid, String sname, String address, String city, String state, int zip,
			int phoneno) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Statement st = (Statement) jcon.connect();
		int count = st.executeUpdate("insert into student1 values(" + sid + ",'" + sname + "','" + address + "','"
				+ city + "','" + state + "'," + zip + "," + phoneno + ")");

		System.out.println(count + " rows affected");
	}

	public static void insertdata(int sid, String sname, String address, String city, String state, int zip,
			int phoneno) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Statement st = (Statement) jcon.connect();
		int count = st.executeUpdate("insert into student values(" + sid + ",'" + sname + "','" + address + "','" + city
				+ "','" + state + "'," + zip + "," + phoneno + ")");

		System.out.println(count + " rows affected");
	}

	public static void truncate() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Statement st = (Statement) jcon.connect();
		System.out.println("select table to be truncated ");
		System.out.println("1.existing ");
		System.out.println("2.created");
		int option = s1.nextInt();
		if (option == 1) {
			st.executeUpdate("truncate table student1");
		} else {
			st.executeUpdate("truncate table student");
		}

	}

	public static void createtable() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Statement st = (Statement) jcon.connect();
		st.executeUpdate("CREATE TABLE student LIKE student1; ");
	}

	public static void method(int option) throws ClassNotFoundException, SQLException {
		if (option == 2) {
			System.out.println("in existing table");
			System.out.println("1:enter the data");
			System.out.println("2:show all entities in table");
			System.out.println("3:Delete data by id");
			System.out.println("4:Delete data by name");
			System.out.println("5:update data");
			int opti = s1.nextInt();
			switch (opti) {
			case 1:
				System.out.println("Enter the student1 id");
				int sid = s1.nextInt();
				System.out.println("Enter the student1 name");
				String sname = s1.next();

				System.out.println("enter the address");
				String address = s1.next();
				System.out.println("enter the city ");
				String city = s1.next();
				System.out.println("enter the state ");
				String state = s1.next();
				System.out.println("enter the zip");
				int zip = s1.nextInt();
				System.out.println("enter the phonenumber");
				int phoneno = s1.nextInt();
				insertdata1(sid, sname, address, city, state, zip, phoneno);
				break;

			case 2:
				fetch1();
				break;

			case 3:
				System.out.println("Enter the student1 id");
				int sidd = s1.nextInt();
				deletebyid1(sidd);
				break;

			case 4:
				System.out.println("Enter the name of the student1");
				String name = s1.next();
				deletebyname1(name);
				break;

			case 5:
				System.out.println("Enter the student1 id");
				int siidd = s1.nextInt();
				System.out.println("Enter the student name to be updated");
				String snamee = s1.next();
				updateData1(siidd, snamee);
				break;

			default:
				System.out.println("enter the correct option");

			}

		}

		else if (option == 1) {
			System.out.println("in created table");
			System.out.println("1:enter the data");
			System.out.println("2:show all entities in table");
			System.out.println("3:Delete data by id");
			System.out.println("4:Delete data by name");
			System.out.println("5:update data");
			int opti = s1.nextInt();
			switch (opti) {
			case 1:
				System.out.println("Enter the student1 id");
				int sid = s1.nextInt();
				System.out.println("Enter the student1 name");
				String sname = s1.next();

				System.out.println("enter the address");
				String address = s1.next();
				System.out.println("enter the city ");
				String city = s1.next();
				System.out.println("enter the state ");
				String state = s1.next();
				System.out.println("enter the zip");
				int zip = s1.nextInt();
				System.out.println("enter the phonenumber");
				int phoneno = s1.nextInt();
				insertdata(sid, sname, address, city, state, zip, phoneno);
				break;

			case 2:
				fetch();
				break;

			case 3:
				System.out.println("Enter the student id");
				int sidd = s1.nextInt();
				deletebyid(sidd);
				break;

			case 4:
				System.out.println("Enter the name of the student");
				String name = s1.next();
				deletebyname(name);
				break;

			case 5:
				System.out.println("Enter the student id");
				int siidd = s1.nextInt();
				System.out.println("Enter the student name to be updated");
				String snamee = s1.next();
				updateData(siidd, snamee);
				break;

			default:
				System.out.println("enter the correct option");
			}
		}
	}
}
