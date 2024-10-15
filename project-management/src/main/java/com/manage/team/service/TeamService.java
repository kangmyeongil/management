package com.manage.team.service;

import java.util.List;

import com.manage.project.domain.ProjectDO;
import com.manage.team.domain.TeamsDO;

public interface TeamService {
	public int insertTeam(TeamsDO t);
	public int updateTeam(TeamsDO t);
	public int deleteTeam(TeamsDO t);
	public TeamsDO getTeam(TeamsDO t);
	public List<TeamsDO> getTeamList(TeamsDO t);
}
