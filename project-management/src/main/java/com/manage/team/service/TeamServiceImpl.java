package com.manage.team.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.manage.project.dao.ProjectDAO;
import com.manage.project.domain.ProjectDO;
import com.manage.team.domain.TeamsDO;

@Service("teamService")
public class TeamServiceImpl implements TeamService {
	@Autowired
	@Qualifier("teamDAO")
	private ProjectDAO dao;
	
	@Override
	public int insertTeam(TeamsDO t) {
		// TODO Auto-generated method stub
		try {
			return dao.insertTeam(t);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int updateTeam(TeamsDO t) {
		// TODO Auto-generated method stub
		try {
			return dao.updateTeam(t);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int deleteTeam(TeamsDO t) {
		// TODO Auto-generated method stub
		try {
			return dao.deleteTeam(t);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public TeamsDO getTeam(TeamsDO t) {
		// TODO Auto-generated method stub
		try {
			return dao.getTeam(t);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<TeamsDO> getTeamList(TeamsDO t) {
		// TODO Auto-generated method stub
		try {
			return dao.getTeamList(t);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}



}
