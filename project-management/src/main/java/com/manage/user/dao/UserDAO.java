package com.manage.user.dao;

import java.sql.SQLException;

import java.util.List;

import com.manage.user.domain.UserDO;

public interface UserDAO {
	public int insertUser(UserDO borad) throws SQLException;
	public int updateUser(UserDO borad) throws SQLException;
	public int deleteUser(UserDO borad) throws SQLException;
	public UserDO getUser(UserDO borad) throws SQLException;
	public List<UserDO> getUserList(String teamid) throws SQLException;
}
