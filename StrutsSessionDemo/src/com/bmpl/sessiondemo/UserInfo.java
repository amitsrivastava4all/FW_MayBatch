package com.bmpl.sessiondemo;

import java.util.Date;

public class UserInfo {
	
	private String userid;
	private Date loginDateTime;
	
	public UserInfo(String userid){
		this.userid = userid;
		this.loginDateTime = new Date();
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public Date getLoginDateTime() {
		return loginDateTime;
	}

	public void setLoginDateTime(Date loginDateTime) {
		this.loginDateTime = loginDateTime;
	}
	
	

}
