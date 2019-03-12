package memo;

import java.sql.*;

/**
 * Author:lorrie
 * Create:2019/2/25
 */
public class JDBCUtil {
    private static Connection connection;
    private static Statement statement;
    private static ResultSet resultSet;
    public static void main(String[] args) {
        try {

            //1.加载驱动
            Class.forName("com.mysql.jdbc.Driver");

            //2.建立连接
            String url="jdbc:mysql://localhost:3306/chatroom";
            String user="root";
            String password="123456";
            connection=DriverManager.getConnection(url,user,password);

            //3.创建操作命令
             statement=connection.createStatement();

            //4.执行sql语句
            resultSet=statement.executeQuery("select id,name from allClients");

            //5.处理结果集
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                System.out.println(String.format("Memo: id=%d, name=%s", id, name));
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
