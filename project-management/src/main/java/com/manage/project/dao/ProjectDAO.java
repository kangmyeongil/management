package com.manage.project.dao;

import java.sql.SQLException;

import java.util.List;

import com.manage.project.domain.ProjectDO;

public interface ProjectDAO {
	public int insertProject(ProjectDO pj) throws SQLException;
	public int updateProject(ProjectDO pj) throws SQLException;
	public int deleteProject(ProjectDO pj) throws SQLException;
	public ProjectDO getProject(ProjectDO pj) throws SQLException;
	public List<ProjectDO> getProjectList(String teamId) throws SQLException;
}
