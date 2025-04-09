package com.tpobjetperdu.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Owner {
    //attributes
    private int id;
    private String name;
    private String number;
    private String email;
    private static final String tableName = "Owner";

    //Constructor
    public Owner(String name, String number, String email) {
        //this.id = id;
        this.name = name;
        this.number = number;
        this.email = email;
    }

    //method too insert an object in a database
    public int save() {
        Connection connection = DatabaseConnection.getConnection();
        
        if (connection == null) {
            return -1;
        }
        String request = "INSERT INTO " + tableName + "(owner_name, owner_number, owner_email)" + "VALUES (?,?,?)";
        try {
            PreparedStatement pstmt = connection.prepareStatement(request);
            
            //pstmt.setInt(1, this.id);
            pstmt.setString(1, this.name);
            pstmt.setString(2, number);
            pstmt.setString(3, email);

            pstmt.executeUpdate();
            return 0;
        } catch (SQLException e){
            e.printStackTrace();
            return -1;
        }
        finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch(SQLException e) {

                }
            }
        }
    }

    //method to delete an object in the database
    public int delete() {
        Connection connection = DatabaseConnection.getConnection();
        
        if (connection == null) {
            return -1;
        }
        String request = "DELETE FROM " + tableName + "WHERE owner_id = ?";
        try {
            PreparedStatement pstmt = connection.prepareStatement(request);

            pstmt.setInt(1, id);

            pstmt.executeUpdate();
            return 0;
        } catch(SQLException e) {
            return -1;
        }
        finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch(SQLException e) {
                    
                }
            }
        }
    }
}
