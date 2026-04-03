package com.learninglog.learninglogproject.topic.model.dao;

import com.learninglog.learninglogproject.topic.model.Topic;
import com.learninglog.learninglogproject.utils.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TopicDAO {
    public static boolean insertTopic(Topic topicObj) throws SQLException {
        String query = "INSERT INTO topic(name, user_Id, createdDate) VALUES(?,?,?)";
        try(Connection conn = DBConnection.getConnection();
        PreparedStatement st = conn.prepareStatement(query)){
            st.setString(1,topicObj.getName());
            st.setInt(2,topicObj.getUser_Id());
            st.setTimestamp(3,topicObj.getCreated_Date());

            int insertedRows = st.executeUpdate();
            if(insertedRows == 0){
                return false;
            }else{
                return true;
            }
        }
    }
}
