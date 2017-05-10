package com.bmpl.sampleapp.actions;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.NamingException;

import com.bmpl.sampleapp.dao.UserDAO;
import com.bmpl.sampleapp.dto.UserDTO;
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
	
	public String addUser(){
		UserDTO userDTO = new UserDTO();
		userDTO.setUsername(this.getUserid());
		userDTO.setPassword(this.getPwd());
		UserDAO userDAO =new UserDAO();
		boolean isAdded;
		try {
			isAdded = userDAO.addNewUser(userDTO);
			if(isAdded){
				this.setMessage("Record Added...");
			}
			else
			{
				this.setMessage("Record Can't Be Added..");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			this.setMessage("Error in Record Addition");
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			this.setMessage("Error in Record Addition");
		}
		
		return SUCCESS;
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
	
	private ArrayList<UserDTO> userList;
	
	
	public ArrayList<UserDTO> getUserList() {
		return userList;
	}

	public void setUserList(ArrayList<UserDTO> userList) {
		this.userList = userList;
	}

	public String fetchAllUsers(){
		UserDAO userDAO = new UserDAO();
		try {
			ArrayList<UserDTO> userList = userDAO.getAllUsers();
			this.setUserList(userList);
			System.out.println("Data is "+this.getUserList());
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return SUCCESS;
	}
	
	
	@Override
	public String execute(){
		this.setMessage("Welcome User");
		return SUCCESS;
	}

}
