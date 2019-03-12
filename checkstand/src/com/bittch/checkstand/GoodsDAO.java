package com.bittch.checkstand;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Author:lorrie
 * Create:2019/3/5
 */
public class GoodsDAO {
    //按照商品编号查找
    public Goods search(int id){
        Connection conn=null;
        Statement stmt=null;
        ResultSet rs=null;
        try{
            conn = JDBCUtils.getConnection();
            stmt = conn.createStatement();
            String sql = "select * from goods where id="+id;
            rs = stmt.executeQuery(sql);
            if(rs.next()){
                int goodsId=rs.getInt("id");
                String goodName=rs.getString("name");
                double goodPrice=rs.getDouble("price");
                Goods goods=new Goods(goodsId,goodName,goodPrice);
                return goods;
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            JDBCUtils.closed(conn,rs,stmt);
        }
        return null;
    }


    //查找所有商品
    public ArrayList<Goods> searchAll(){
        Connection conn=null;
        Statement stmt=null;
        ResultSet rs=null;
        ArrayList<Goods> arrayList=new ArrayList<>();
        try{
            conn = JDBCUtils.getConnection();
            stmt = conn.createStatement();
            String sql = "select * from goods";
            rs = stmt.executeQuery(sql);
            while (rs.next()){
                int goodsId=rs.getInt("id");
                String goodName=rs.getString("name");
                double goodPrice=rs.getDouble("price");
                Goods goods=new Goods(goodsId,goodName,goodPrice);
                arrayList.add(goods);
            }
            return arrayList;
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            JDBCUtils.closed(conn,rs,stmt);
        }
        return null;
    }




    //添加商品
    public void add(int id,String name,double price){
        Connection connection=null;
        Statement statement=null;
        ResultSet resultSet=null;
        try{
            connection = JDBCUtils.getConnection();
            statement = connection.createStatement();
            String sql= "INSERT INTO goods (id,name,price) VALUES("+id+",'"+name+"',"+price+")";

            int num = statement.executeUpdate(sql);
            if(num>0){
                System.out.println("添加成功!");
            }

        }catch(Exception e){
            e.printStackTrace();
        }finally{
            JDBCUtils.closed(connection,resultSet,statement);
        }

    }
    //删除商品
    public void delete(int id){
        Connection connection=null;
        Statement statement=null;
        ResultSet resultSet=null;
        try{
            connection = JDBCUtils.getConnection();
            statement = connection.createStatement();
            String sql= "delete from goods where id="+id;

            int num = statement.executeUpdate(sql);
            if(num>0){
                System.out.println("删除成功!");
            }

        }catch(Exception e){
            e.printStackTrace();
        }finally{
            JDBCUtils.closed(connection,resultSet,statement);
        }

    }
}
