package com.bmpl.sampleapp.dao;

import static com.bmpl.sampleapp.dao.DAOConstants.USER_INSERT_SQL;
import static com.bmpl.sampleapp.dao.DAOConstants.USER_SELECT_SQL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.NamingException;

import com.bmpl.sampleapp.dto.UserDTO;

public class UserDAO {
		public ArrayList<UserDTO> getAllUsers() throws NamingException, SQLException{
			Connection connection = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			ArrayList<UserDTO> userList = new ArrayList<>();
			try
			{
				connection = CommonDAO.getInstance().getConnection();
				pstmt = connection.prepareStatement(USER_SELECT_SQL);
				rs = pstmt.executeQuery();
				while(rs.next()){
					UserDTO userDTO =new UserDTO();
					userDTO.setUsername(rs.getString("userid"));
					userDTO.setPassword(rs.getString("password"));
					userList.add(userDTO);
					
				}
			}
			finally{
				if(rs!=null){
					rs.close();
				}
				if(pstmt!=null){
					pstmt.close();
				}
				if(connection!=null){
					connection.close();
				}
			}
			return userList;
		}
	
		public boolean addNewUser(UserDTO userDTO) throws SQLException, NamingException{
			Connection connection =null;
			PreparedStatement pstmt = null;
			try{
				CommonDAO  commonDAO = CommonDAO.getInstance();
				connection = commonDAO.getConnection();
				pstmt = connection.prepareStatement(USER_INSERT_SQL);
				pstmt.setString(1, userDTO.getUsername());
				pstmt.setString(2, userDTO.getPassword());
				int rowAdded = pstmt.executeUpdate();
				return rowAdded>0?true:false;
			}
			finally{
				if(pstmt!=null){
					pstmt.close();
				}
				if(connection!=null){
					connection.close();
				}
			}
			
		}
}
