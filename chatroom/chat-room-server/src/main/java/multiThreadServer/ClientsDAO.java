package multiThreadServer;

import java.net.Socket;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Author:lorrie
 * Create:2019/2/26
 */
public class ClientsDAO {

    //显示所有当前在线用户
    public ArrayList<Clients> displayAllClients() {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        ArrayList<Clients> list = new ArrayList<>();
        try {
            connection = JDBCUtils.getConnection();
            statement = connection.createStatement();
            String sql = "select * from allClients";
            resultSet=statement.executeQuery(sql);

            while (resultSet.next()){
                Clients clients=new Clients();
                clients.setId(Integer.parseInt(resultSet.getString("id")));
                clients.setName(resultSet.getString("name"));
                list.add(clients);
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.closed(connection,resultSet,statement);
        }
        return null;
    }

    public String search(String username){
        Connection conn=null;
        Statement stmt=null;
        ResultSet rs=null;

        try{
            conn = JDBCUtils.getConnection();
            stmt = conn.createStatement();
            String sql = "select * from allclients where allclients.name='"+username+"';";
            rs = stmt.executeQuery(sql);
            if(rs.next()){
                String clientName=rs.getString("name");
                return clientName;
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            JDBCUtils.closed(conn,rs,stmt);
        }
        return null;
    }

    public void add(String username){
        Connection connection=null;
        Statement statement=null;
        ResultSet resultSet=null;
        try{
            connection = JDBCUtils.getConnection();
            statement = connection.createStatement();
            String sql = "INSERT INTO allclients (name) VALUES('"+username+"');";
            int num = statement.executeUpdate(sql);
            if(num>0){
                System.out.println("发送成功");
            }

        }catch(Exception e){
            e.printStackTrace();
        }finally{
            JDBCUtils.closed(connection,resultSet,statement);
        }

    }

    //用户下线
    public void del(String delClient){
        Connection conn=null;
        Statement stmt=null;
        ResultSet rs=null;
        try{
            conn = JDBCUtils.getConnection();
            stmt = conn.createStatement();
            String sql = "DELETE FROM mrooms WHERE name="+delClient;
            int num = stmt.executeUpdate(sql);
            if(num>0){
                System.out.println("用户"+delClient+"下线");
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            JDBCUtils.closed(conn,rs,stmt);
        }
    }


}
