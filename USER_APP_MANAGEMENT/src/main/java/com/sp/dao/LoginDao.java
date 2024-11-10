
package com.sp.dao;

import java.sql.*;

import com.sp.bean.UserBean;
import com.sp.common.DbConnection;

public class LoginDao {
	public UserBean ub = null;

	public UserBean login(String un, String pw) {
		try {
			Connection con = DbConnection.geCon();
			PreparedStatement ps = con.prepareStatement("select*from userapp65 where userid=? and pwd=?");
			ps.setString(1, un);
			ps.setString(2, pw);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				ub = new UserBean();
				ub.setUserid(rs.getString(1));
				ub.setPwd(rs.getString(2));
				ub.setUfn(rs.getString(3));
				ub.setUln(rs.getString(4));
				ub.setUad(rs.getString(5));
				ub.setUmid(rs.getString(6));
				ub.setUno(rs.getLong(7));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ub;
	}

}
