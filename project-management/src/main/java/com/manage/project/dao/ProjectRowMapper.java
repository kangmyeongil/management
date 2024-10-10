package com.manage.project.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.manage.project.domain.ProjectDO;
import com.manage.user.domain.UserDO;

@Component()
public class ProjectRowMapper implements RowMapper<ProjectDO> {

	@Override
	public ProjectDO mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		ProjectDO pj = new ProjectDO();
		pj = new ProjectDO();
		pj.setProjectid(rs.getString("ProjectID"));
		pj.setProjectname(rs.getString("ProjectName"));
		pj.setDetail(rs.getString("Detail"));
		pj.setProgress(rs.getDouble("Progress"));
		pj.setDeadline(rs.getDate("Deadline"));
		pj.setTeamid(rs.getString("TeamID"));
		return pj;
	}

}
