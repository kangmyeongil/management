package com.manage.project.dao;

import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.manage.project.domain.ProjectDO;
import com.manage.user.domain.UserDO;

@Repository("projectDAO")
public class ProjectDAO2 extends JdbcDaoSupport implements ProjectDAO {
	@Autowired
	private ProjectRowMapper projectRowMapper;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public void setSuperDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}
	
	private final String USER_INSERT = "insert into PROJECTS values(?, ?, ?, ?, ?, ?)";
	
	private final String USER_UPDATE = "update PROJECTS set PROJECTNAME=? where PROJECTID=? ";
	
	private final String USER_DELETE = "delete from PROJECTS where PROJECTID=?";
	
	private final String USER_GET = "select * from PROJECTS where UserID = ?";
	
	private final String USER_LIST = "select * from PROJECTS order by PROJECTID desc";
	
	
	
	@Override
	public int insertProject(ProjectDO pj) throws SQLException {
		jdbcTemplate.update(USER_INSERT, pj.getProjectid(), pj.getProjectname(), pj.getDetail(), pj.getProgress(), pj.getDeadline(), pj.getTeamid());
		return 0;
	}

	@Override
	public int updateProject(ProjectDO pj) throws SQLException {
		jdbcTemplate.update(USER_UPDATE, pj.getProjectname(), pj.getProjectid());
		return 0;
	}

	@Override
	public int deleteProject(ProjectDO pj) throws SQLException {
		jdbcTemplate.update(USER_DELETE, pj.getProjectid());
		return 0;
	}

	@Override
	public ProjectDO getProject(ProjectDO pj) throws SQLException {
	    try {
	        // 아이디와 비밀번호를 함께 조회
	        return jdbcTemplate.queryForObject(USER_GET, projectRowMapper, pj.getProjectid());
	    } catch (EmptyResultDataAccessException e) {
	        // 결과가 없을 경우 null 반환
	        return null;
	    }
	}

	@Override
	public List<ProjectDO> getProjectList(String userId) throws SQLException {
		// TODO Auto-generated method stub
		return jdbcTemplate.query(USER_LIST, projectRowMapper);
	}

}
