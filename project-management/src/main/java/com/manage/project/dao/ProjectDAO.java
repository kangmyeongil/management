package com.manage.project.dao;

import java.sql.SQLException;

import java.util.List;

import com.manage.project.domain.ProjectDO;
import com.manage.user.domain.UserDO;

public interface ProjectDAO {
	public int insertProject(ProjectDO pj) throws SQLException;
	public int updateProject(ProjectDO pj) throws SQLException;
	public int deleteProject(ProjectDO pj) throws SQLException;
	public ProjectDO getProject(ProjectDO pj) throws SQLException;
	public List<ProjectDO> getProjectList(String userId) throws SQLException;
}
