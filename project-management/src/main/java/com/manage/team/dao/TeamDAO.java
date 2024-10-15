package com.manage.team.dao;

import java.sql.SQLException;
import java.util.List;

import com.manage.team.domain.TeamsDO;

public interface TeamDAO {
	public int insertTeam(TeamsDO t) throws SQLException;
	public int updateTeam(TeamsDO t) throws SQLException;
	public int deleteTeam(TeamsDO t) throws SQLException;
	public TeamsDO getTeam(TeamsDO t) throws SQLException;
	public List<TeamsDO> getTeamList(TeamsDO t) throws SQLException;
}
