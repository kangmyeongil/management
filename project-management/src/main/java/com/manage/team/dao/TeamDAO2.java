package com.manage.team.dao;

import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.manage.team.domain.TeamsDO;
import com.manage.team.dao.TeamDAO;

@Repository("teamDAO")
public class TeamDAO2 extends JdbcDaoSupport implements TeamDAO {
	@Autowired
	private TeamRowMapper teamRowMapper;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public void setSuperDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}
	
	private final String USER_INSERT = "insert into TEAMS values(?, ?, ?)";
	
	private final String USER_UPDATE = "update TEAMS set TEAMNAME=? where TEAMID=? ";
	
	private final String USER_DELETE = "delete from PROJECTS where PROJECTID=?";
	
	private final String USER_GET = "select * from PROJECTS where UserID = ?";
	
	private final String USER_LIST = "select * from PROJECTS where TeamID = ? order by PROJECTID desc";
	
	
	
	@Override
	public int insertTeam(TeamsDO t) throws SQLException {
		jdbcTemplate.update(USER_INSERT, t.getTeamid(), t.getTeamname(), t.getProjectid());
		return 0;
	}

	@Override
	public int updateTeam(TeamsDO t) throws SQLException {
		jdbcTemplate.update(USER_UPDATE, t.getTeamname(), t.getTeamid());
		return 0;
	}

	@Override
	public int deleteTeam(TeamsDO t) throws SQLException {
		jdbcTemplate.update(USER_DELETE, t.getTeamid());
		return 0;
	}

	@Override
	public TeamsDO getTeam(TeamsDO t) throws SQLException {
	    try {
	        // 아이디와 비밀번호를 함께 조회
	        return jdbcTemplate.queryForObject(USER_GET, teamRowMapper, t.getTeamid());
	    } catch (EmptyResultDataAccessException e) {
	        // 결과가 없을 경우 null 반환
	        return null;
	    }
	}

	@Override
	public List<TeamsDO> getTeamList(TeamsDO t) throws SQLException {
		// TODO Auto-generated method stub
		return jdbcTemplate.query(USER_LIST, teamRowMapper, t.getTeamid());
	}

}
