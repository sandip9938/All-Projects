package com.sp.dao;

import java.sql.*;

import com.sp.bean.EmployeeBean;
import com.sp.common.DbConnection;
public class EmployeeLoginDao {
	public EmployeeBean eb = null;

	 public EmployeeBean login(String eid) {
		 
		try {
			Connection con=DbConnection.geCon();
			System.out.println("Hello");
			PreparedStatement ps=con.prepareStatement("select * from Employee65 where EMPID=?");
			ps.setString(1, eid);
			ResultSet rs=ps.executeQuery();
			if (rs.next()) {
		
				eb= new EmployeeBean();
				eb.setEid(rs.getString(1));
				eb.setEname(rs.getString(2));
				eb.setEdesg(rs.getString(3));
				eb.setEbsal(rs.getInt(4));
				eb.setEhra(rs.getFloat(5));
				eb.setEda(rs.getFloat(6));
				eb.setEtsal(rs.getFloat(7));
			
		
			}
		} catch (Exception e) {
		e.printStackTrace();
		}
		return eb;


	}
}
