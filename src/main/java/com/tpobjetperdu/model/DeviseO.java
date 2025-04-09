package com.tpobjetperdu.model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DeviseO {
    //attributes
    private int id;
    private String type;
    private String address;
    private LocalDate date;
    private String region;
    private int owner_id;
    private static final String tableName = "Object";

    //constructors
    public DeviseO(String type, String address, LocalDate date, String region, int owner_id) {
        //this.id = id;
        this.type = type;
        this.address = address;
        this.date = date;
        this.region = region;
        this.owner_id = owner_id;
    }

    public DeviseO(String type, String address) {
        //this.id = id;
        this.type = type;
        this.address = address;
    }

    //method too insert an object in a database
    public int save() {
        Connection connection = DatabaseConnection.getConnection();
        
        if (connection == null) {
            return -1;
        }
        String request = "INSERT INTO " + tableName + "(object_type, object_mac_adress, object_losing_date, object_losing_region, object_owner_id)" + "VALUES (?,?,?,?,?)";
        try {
            PreparedStatement pstmt = connection.prepareStatement(request);
            //formatage de la date
            Date sqlDate = Date.valueOf(date);
            
            //pstmt.setInt(1, this.id);
            pstmt.setString(1, this.type);
            pstmt.setString(2, address);
            pstmt.setDate(3, sqlDate);
            pstmt.setString(4, region);
            pstmt.setInt(5, owner_id);

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
        String request = "DELETE FROM " + tableName + "WHERE object_id = ?";
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

    //Method to verify if an object is in a database
    public int verify(String type, String address1) {
        Connection connection = DatabaseConnection.getConnection();
        if (connection == null) {
            return -1;
        }
        String request = "SELECT * FROM " + tableName;
        try {
            PreparedStatement pstmt = connection.prepareStatement(request);
            ResultSet res = pstmt.executeQuery();

            while(res.next()) {
                String address = res.getString("object_mac_adress");
                String name = res.getString("object_type");

                if (address.equals(address1) && name.equals(type)) {
                    return 0;
                }
            }

            return 1;

        } catch (SQLException e) {
            return -1;
        }
        finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {}
            }
        }
    }

}
 