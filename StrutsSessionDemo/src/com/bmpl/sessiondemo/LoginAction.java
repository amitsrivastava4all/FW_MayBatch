package com.bmpl.sessiondemo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport implements SessionAware {
	private String userid;
	private String pwd;
	private Map<String,Object> sessionMap;
	private String message;
	

	public String saveEmp(){
		this.setMessage("Record Saved ");
		return SUCCESS;
	}
	
	
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String execute(){
		if(userid.equals(pwd)){
			UserInfo userInfo = new UserInfo(userid);
			sessionMap.put("uid", userInfo);
			setMessage("Welcome "+userid);
		}
		else
		{
			setMessage("Invalid Userid or Password");
		}
		return SUCCESS;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	@Override
	public void setSession(Map<String, Object> arg0) {
		// TODO Auto-generated method stub
		this.sessionMap = arg0;
		
	}
	
	

}
