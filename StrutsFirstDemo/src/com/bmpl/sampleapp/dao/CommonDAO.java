package com.bmpl.sampleapp.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class CommonDAO {
	private CommonDAO(){}
	private static CommonDAO commonDAO ;
	public static   CommonDAO getInstance(){
		synchronized(CommonDAO.class){
		if(commonDAO ==null){
			commonDAO= new CommonDAO();
		}
		}
		return commonDAO;
	}
	
	private ResourceBundle rb = ResourceBundle.getBundle("db");
	public  Connection getConnection() throws NamingException, SQLException{
		Context initContext  = new InitialContext();
		Context envContext  = (Context)initContext.lookup("java:/comp/env");
		String jndiName = rb.getString("jndiname");
		DataSource dataSource = (DataSource)envContext.lookup(jndiName);
		Connection connection = dataSource.getConnection();
		return connection;
		
		
	}

}
