package com.sp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class DbConnecton1 {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system", "root");
			PreparedStatement ps = con.prepareStatement("Insert into users Values(?,?,?)");

			// Printing And Taking User Details
			System.out.println("****************Enter User Details*************");
			System.out.print("Enter User Name: ");
			String name = scanner.nextLine();
			System.out.print("Enter User Email: ");
			String email = scanner.nextLine();
			System.out.print("Enter User Password: ");
			String password = scanner.nextLine();

			// Insert Value
			ps.setString(1, name);
			ps.setString(2, email);
			ps.setString(3, password);

			int k = ps.executeUpdate();
			if (k > 0) {
				System.out.println("User Added Sucessfully.........");
			}
		} catch (Exception e) {
			System.out.println(e.toString());
		}

	}

}
