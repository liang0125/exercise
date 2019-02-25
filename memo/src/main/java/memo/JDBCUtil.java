package memo;

import java.sql.*;

/**
 * Author:lorrie
 * Create:2019/2/25
 */
public class JDBCUtil {
    public static void main(String[] args) {
        try {

            //1.加载驱动
            Class.forName("com.mysql.jdbc.Driver");

            //2.建立连接
            String url="jdbc:mysql://localhost:3306/memo";
            String user="root";
            String password="123456";
            Connection connection=DriverManager.getConnection(url,user,password);

            //3.创建操作命令
            Statement statement=connection.createStatement();

            //4.执行sql语句
            ResultSet resultSet=statement.executeQuery("select id,group_id,title,content,is_protected, background,is_remind,remind_time,created_time,modify_time from memo_info");

            //5.处理结果集
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String title = resultSet.getString("title");
                String content = resultSet.getString("content");
                Date createTime = resultSet.getDate("created_time");
                System.out.println(String.format("Memo: id=%d, title=%s, content=%s, createTime=%s", id, title, content, createTime.toString()));
            }

            //关闭结果集
            if(resultSet==null){
                resultSet.close();
            }
            //关闭命令
            if(statement==null){
                statement.close();
            }
            //关闭连接
            if(connection==null){
                connection.close();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
