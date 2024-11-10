package com.sp.dao;

import java.sql.*;

import com.sp.bean.AdminBean;
import com.sp.common.DbConnection;

public class AdminLogDao {
	public AdminBean aBean = null;

	public AdminBean login(String uid, String upw) {
		try {
			Connection con = DbConnection.geCon();
			PreparedStatement ps = con.prepareStatement("select * from Admin65 where uname=? and pword=?");
			ps.setString(1, uid);
			ps.setString(2, upw);
			ResultSet rSet = ps.executeQuery();
		//	System.out.println(uid+"         "+upw);
			if (rSet.next()) {
				aBean = new AdminBean();
				aBean.setUname(rSet.getString(1));
				aBean.setPword(rSet.getString(2));
				aBean.setFname(rSet.getString(3));
				aBean.setLname(rSet.getString(4));
				aBean.setAddr(rSet.getString(5));
				aBean.setMid(rSet.getString(6));
				aBean.setPhno(rSet.getLong(7));
			//	System.out.println(aBean);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return aBean;

	}
}
