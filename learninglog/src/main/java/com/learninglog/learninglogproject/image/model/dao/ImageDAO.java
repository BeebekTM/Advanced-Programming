package com.learninglog.learninglogproject.image.model.dao;

import com.learninglog.learninglogproject.utils.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ImageDAO {
    public static boolean insertImageDetails(String name, String image_Path) throws SQLException {
        String query = "INSERT INTO image_upload (name, image_Path) VALUES (?,?)";
        try(Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(query);
            ){
            ps.setString(1,name);
            ps.setString(2,image_Path);

            int rowsInserted = ps.executeUpdate();
            if(rowsInserted>0){
                return true;
            }else{
                return false;
            }
        }
    }
}
