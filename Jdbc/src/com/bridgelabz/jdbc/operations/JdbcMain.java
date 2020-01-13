package com.bridgelabz.jdbc.Operations;

import java.sql.SQLException;
import java.util.Scanner;
/**
 * 
 * @author :Premsai Manthani
 * @purpose : this class performed operation on a database such as crud operations .
 *
 */

public class JdbcMain {

	// @SuppressWarnings("static-access")
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		jdbcOperations op = new jdbcOperations();

		Scanner sc = new Scanner(System.in);
		System.out.println("1.create new database");
		System.out.println("2.open existing database");
		System.out.println("3:drop table");
		System.out.println("4:truncate");
		System.out.println("enter the choice");

		int opt1 = 0;
		do {
			int choose = sc.nextInt();
			switch (choose) {
			case 1:
				op.createtable();

				System.out.println("the table is created and name is created_table");
				break;

			case 2:
				System.out.println("which table do you want to open");
				System.out.println("1.created");
				System.out.println("2.existing");
				int opt = sc.nextInt();
				op.method(opt);
				break;
			case 3:
				System.out.println("are you willing to delete ");
				System.out.println("1.existing  ");
				System.out.println("2.created");
				int option = sc.nextInt();
				op.deletebyid(option);
				break;

			case 4:
				op.truncate();
				break;
			default:
				System.out.println("enter the correct option");

			}
			System.out.println("do you want to countinue");
			System.out.println("1.countinue");
			System.out.println("2.exit");
		} while (opt1 == 1);

		sc.close();
	}
}
