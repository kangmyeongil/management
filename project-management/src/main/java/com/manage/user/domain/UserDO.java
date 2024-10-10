package com.manage.user.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(exclude= {"searchCondition", "searchKeyword"})
@NoArgsConstructor
@AllArgsConstructor
public class UserDO {

	private String userid;
	private String userpassword;
	private String role;
	private String username;
	private String email;
	private String teamid;

}
