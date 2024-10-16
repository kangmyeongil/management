package com.manage.project.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.manage.project.domain.ProjectDO;
import com.manage.project.dao.ProjectDAO;

@Service("projectService")
public class ProjectServiceImpl implements ProjectService {
	@Autowired
	@Qualifier("projectDAO")
	private ProjectDAO dao;
	
	@Override
	public int insertProject(ProjectDO pj) {
		// TODO Auto-generated method stub
		try {
			return dao.insertProject(pj);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int updateProject(ProjectDO pj) {
		// TODO Auto-generated method stub
		try {
			return dao.updateProject(pj);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int deleteProject(ProjectDO pj) {
		// TODO Auto-generated method stub
		try {
			return dao.deleteProject(pj);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public ProjectDO getProject(ProjectDO pj) {
		// TODO Auto-generated method stub
		try {
			return dao.getProject(pj);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<ProjectDO> getProjectList(String teamId) {
		// TODO Auto-generated method stub
		try {
			return dao.getProjectList(teamId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}



}
