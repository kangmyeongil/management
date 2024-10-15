package com.manage.project.service;

import java.util.List;

import com.manage.project.domain.ProjectDO;

public interface ProjectService {
	public int insertProject(ProjectDO pj);
	public int updateProject(ProjectDO pj);
	public int deleteProject(ProjectDO pj);
	public ProjectDO getProject(ProjectDO pj);
	public List<ProjectDO> getProjectList(String teamId);
}
