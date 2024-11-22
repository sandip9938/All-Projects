package com.sp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class DbConnecton1 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system", "root");
			PreparedStatement ps = con.prepareStatement("Delete from users where username=?");
			System.out.println("Enter Delete UserName: ");
			String name = scanner.nextLine();
			ps.setString(1, name);
			int k = ps.executeUpdate();
			if (k > 0) {
				System.out.println("User Deleted Succsfully........");
			}
		} catch (Exception e) {
			System.out.println(e.toString());
		}

	}

}
