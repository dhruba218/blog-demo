//************************DONE************************
package com.upgrad.blog.dao;

import com.upgrad.blog.db.DatabaseConnection;
import com.upgrad.blog.dto.UserDTO;
import com.upgrad.blog.interfaces.UserCRUD;

import java.sql.*;

/**
 * TODO: 6.5. Implement the UserCRUD interface.
 * TODO: 6.6. findByEmail() method should take email id as an input parameter and
 * return the user details corresponding to the email id from the USERS table defined
 * in the database.
 * TODO: 6.7. create() method should take user details as input and insert these details
 * into the USERS table. Return the same UserDAO object which was passed as an input argument.
 */
public class UserDAO implements UserCRUD {


    /**
     *
     * @param emailId
     * @return
     * @throws SQLException
     */
    @Override
    public UserDTO findByEmail(String emailId) throws SQLException {
        UserDTO userDTO=new UserDTO();

        try{
            Connection con = DatabaseConnection.getConnection();
            PreparedStatement ps=con.prepareStatement("select * from users where email_id=?");
            ps.setString(1,emailId);
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
                userDTO.setUserId(rs.getInt(1));
                userDTO.setEmailId(rs.getString(2));
                userDTO.setPassword(rs.getString(3));
            }

        }catch(Exception ex){ex.printStackTrace();}

        return userDTO;

    }

    /**
     *
     * @param userDTO
     * @return
     * @throws SQLException
     */
    @Override
    public UserDTO create(UserDTO userDTO) throws SQLException, ClassNotFoundException {
//        Get connections
        Connection connection = DatabaseConnection.getConnection();

//        Get statement object to execute query
        Statement statement = connection.createStatement();
        String sql = "INSERT INTO USERS (email_id, password) VALUES('"+userDTO.getEmailId()+"', '"+userDTO.getPassword()+"')";
        statement.executeUpdate(sql);
        return userDTO;
    }

//    public static void main(String[] args) {
//		try {
//			UserDAO userDAO = new UserDAO();
//			UserDTO temp = new UserDTO();
//			temp.setUserId(1);
//			temp.setEmailId("temp@temp.temp");
//			temp.setPassword("temp");
//			userDAO.create(temp);
//			System.out.println(userDAO.findByEmail("temp@temp.temp"));
//		} catch (Exception e) {
//			System.out.println("FAILED");
//		}
//
//		/**
//		 * Following should be the desired output of the main method.
//		 * UserDTO{userId=11, emailId='temp@temp.temp', password='temp'}
//		 */
//	}
}
