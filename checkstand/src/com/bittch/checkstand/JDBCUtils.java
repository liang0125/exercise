package com.bittch.checkstand;

import java.sql.*;

/**
 * Author:lorrie
 * Create:2019/3/5
 */
public class JDBCUtils {
    private static Statement statement;
    private static ResultSet resultSet;

    public static Connection getConnection() {
        Connection connection = null;
        try {
            //加载驱动
            Class.forName("com.mysql.jdbc.Driver");
            //建立连接
            String url = "jdbc:mysql://localhost:3306/checkstand";
            String user = "root";
            String password = "123456";
            connection = DriverManager.getConnection(url, user, password);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static void closed(Connection connection, Statement statement) {
        try {
            if (statement!=null) {
                statement.close();
                statement=null;
            }
            if (connection != null) {
                connection.close();
                connection=null;
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    public static void closed(Connection connection, ResultSet resultSet, Statement statement) {
        if(resultSet!=null){
            try {
                resultSet.close();
                resultSet=null;
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        closed(connection,statement);
    }
}


