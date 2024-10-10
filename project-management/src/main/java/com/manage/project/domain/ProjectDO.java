package com.manage.project.domain;

import java.util.Date;

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
public class ProjectDO {

	private String projectid;
	private String projectname;
	private String detail;
	private double progress;
	private Date deadline;
	private String teamid;

}
