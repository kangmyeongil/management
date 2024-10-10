package com.manage.user.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.manage.user.domain.UserDO;

@Component()
public class UserRowMapper implements RowMapper<UserDO> {

	@Override
	public UserDO mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		UserDO user = new UserDO();
		user = new UserDO();
		user.setUserid(rs.getString("USERID"));
		user.setUserpassword(rs.getString("USERPASSWORD"));
		user.setRole(rs.getString("ROLE"));
		user.setUsername(rs.getString("USERNAME"));
		user.setEmail(rs.getString("EMAIL"));
		user.setTeamid(rs.getString("TEAMID"));
		return user;
	}

}
