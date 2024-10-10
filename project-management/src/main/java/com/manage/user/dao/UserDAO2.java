package com.manage.user.dao;

import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.manage.user.domain.UserDO;

@Repository("userDAO")
public class UserDAO2 extends JdbcDaoSupport implements UserDAO {
	@Autowired
	private UserRowMapper userRowMapper;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public void setSuperDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}
	
	private final String USER_INSERT = "insert into USERS values(?, ?, ?, ?, ?, ?)";
	
	private final String USER_UPDATE = "update USERS set USERNAME=?, ROLE=? where USERID=? ";
	
	private final String USER_DELETE = "delete from USERS where USERID=?";
	
	private final String USER_GET = "select * from USERS where USERID=?";
	
	private final String USER_LIST = "select * from USERS order by USERID desc";
	
	
	
	@Override
	public int insertUser(UserDO user) throws SQLException {
		jdbcTemplate.update(USER_INSERT, user.getUserid(), user.getUserpassword(), user.getRole(), user.getUsername(), user.getEmail(), null);
		return 0;
	}

	@Override
	public int updateUser(UserDO user) throws SQLException {
		jdbcTemplate.update(USER_UPDATE, user.getUsername(), user.getRole(), user.getUserid());
		return 0;
	}

	@Override
	public int deleteUser(UserDO user) throws SQLException {
		jdbcTemplate.update(USER_DELETE, user.getUserid());
		return 0;
	}

	@Override
	public UserDO getUser(UserDO user) throws SQLException {
	    try {
	        // 아이디와 비밀번호를 함께 조회
	        return jdbcTemplate.queryForObject(USER_GET, userRowMapper, user.getUserid());
	    } catch (EmptyResultDataAccessException e) {
	        // 결과가 없을 경우 null 반환
	        return null;
	    }
	}

	@Override
	public List<UserDO> getUserList(String teamid) throws SQLException {
		// TODO Auto-generated method stub
		return jdbcTemplate.query(USER_LIST, userRowMapper);
	}

}
