package com.sp.dao;

import java.sql.*;

import com.sp.bean.EmployeeBean;
import com.sp.common.DbConnection;
public class AddEmployeeDao {
public int k=0;
public int insert(EmployeeBean eb)
{
	try {
		Connection con=DbConnection.geCon();
		PreparedStatement ps=con.prepareStatement("insert into Employee65 values(?,?,?,?,?,?,?)");
		ps.setString(1, eb.getEid());
		ps.setString(2, eb.getEname());
		ps.setString(3,eb.getEdesg());
		ps.setInt(4, eb.getEbsal());
		ps.setFloat(5, eb.getEhra());
		ps.setFloat(6, eb.getEda());
		ps.setFloat(7, eb.getEtsal());
		k=ps.executeUpdate();
		
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	return k;
}
}
