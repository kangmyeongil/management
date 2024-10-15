package com.manage.team.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.manage.team.domain.TeamsDO;

@Component()
public class TeamRowMapper implements RowMapper<TeamsDO> {

	@Override
	public TeamsDO mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		TeamsDO t = new TeamsDO();
		t = new TeamsDO();
		t.setTeamid(rs.getString("TeamID"));
		t.setTeamname(rs.getString("TeamName"));
		t.setProjectid(rs.getString("Projectid"));
		return t;
	}

}
