package com.bmpl.sampleapp.actions;

import com.opensymphony.xwork2.Action;
/**
 * This is a WelcomeAction and it contains the Message Logic
 * @author amit
 *
 */
public class WelcomeAction implements Action {
	/**
	 * this is a message variable which contains the welcome message
	 */
	private String message;
	private String userid;
	private String pwd;

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

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	public String checkLogin(){
		if(userid.equals(pwd)){
			this.setMessage("Welcome User "+userid);
			return SUCCESS;
		}
		else{
			this.setMessage("Invalid Userid or Password");
			return ERROR;
		}
	}
	
	@Override
	public String execute(){
		this.setMessage("Welcome User");
		return SUCCESS;
	}

}
