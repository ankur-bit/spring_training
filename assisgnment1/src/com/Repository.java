package com;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Repository {
	public int login(String username, String password) {
		Connection con = DButil.getCon();
		int flag=0;
		String sql = "select user_name from login where user_name=? and password=?";
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, username);
			pst.setInt(2, Integer.parseInt(password));
			ResultSet rs = pst.executeQuery();
			if(rs.next())
				flag=1;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return flag;
	}
}
