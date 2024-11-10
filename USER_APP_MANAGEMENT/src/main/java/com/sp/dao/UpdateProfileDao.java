
package com.sp.dao;

import java.sql.*;

import com.sp.bean.UserBean;
import com.sp.common.DbConnection;

public class UpdateProfileDao {

	public int update(UserBean ub) {
		int k = 0;
		try {
			Connection con = DbConnection.geCon();
			PreparedStatement pStatement = con
					.prepareStatement("update userapp65 set uad=?,umid=?,uno=? where userid=? and pwd=?");
			pStatement.setString(4, ub.getUserid());
			pStatement.setString(5, ub.getPwd());
			pStatement.setString(1, ub.getUad());
			pStatement.setString(2, ub.getUmid());
			pStatement.setLong(3, ub.getUno());
			k = pStatement.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return k;

	}
}
