package com.vrtic.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.vrtic.model.Login;
import com.vrtic.util.DBConnectionUtil;

public class LoginDAOImpl implements LoginDAO {

	@Override
	public String loginCheck(Login loginBean) {
		String query = "select * from dijete2 where d_6_4=? and telefon=?";

		try {
			Connection con = DBConnectionUtil.openConnection();
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, loginBean.getEmail());
			ps.setString(2, loginBean.getPassword());

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				return "true";
			} else {
				return "false";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "error";
	}

}
