package com.sp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DaoConnection1 {

	public static void main(String[] args) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system", "root");
			PreparedStatement ps = con.prepareStatement("select*from users");
			ResultSet rs = ps.executeQuery();
			System.out.println("********** User Details ***********");
			while (rs.next()) {
				System.out.println(rs.getString(1) + "\t" + rs.getString(2) + "\t" + rs.getString(3));
			}
			con.close();
		} catch (Exception e) {
			System.out.println(e.toString());
		}

	}

}
