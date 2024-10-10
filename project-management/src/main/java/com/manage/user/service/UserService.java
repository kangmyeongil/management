package com.manage.user.service;

import java.util.List;

import com.manage.user.domain.UserDO;

public interface UserService {
	public int insertUser(UserDO board);
	public int updateUser(UserDO board);
	public int deleteUser(UserDO board);
	public UserDO getUser(UserDO board);
	public List<UserDO> getUserList(String teamid);
}
