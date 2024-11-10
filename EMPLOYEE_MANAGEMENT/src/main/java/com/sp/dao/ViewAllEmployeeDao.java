package com.sp.dao;

import java.sql.*;
import java.util.*;

import com.sp.bean.EmployeeBean;
import com.sp.common.DbConnection;
public class ViewAllEmployeeDao {
public ArrayList<EmployeeBean> al= new ArrayList<EmployeeBean>();
public ArrayList<EmployeeBean> retrieve()
{
	try {
		Connection con = DbConnection.geCon();
		PreparedStatement ps= con.prepareStatement("select * from Employee65");
		ResultSet rs=ps.executeQuery();
		while(rs.next())
		{
			EmployeeBean eb=new EmployeeBean();
			eb.setEid(rs.getString(1));
			eb.setEname(rs.getString(2));
			eb.setEdesg(rs.getString(3));
			eb.setEbsal(rs.getInt(4));
			eb.setEhra(rs.getFloat(5));
			eb.setEda(rs.getFloat(6));
			eb.setEtsal(rs.getFloat(7));
			al.add(eb);
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
	System.out.println(al);
	return al;
	
}
}