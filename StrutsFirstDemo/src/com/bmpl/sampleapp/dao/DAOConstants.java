package com.bmpl.sampleapp.dao;

public interface DAOConstants {
	String USER_INSERT_SQL = "insert into user_info (userid,password) values(?,?)";
	String USER_SELECT_SQL = "select userid, password from user_info";
}
