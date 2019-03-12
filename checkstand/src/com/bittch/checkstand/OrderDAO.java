package com.bittch.checkstand;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Author:lorrie
 * Create:2019/3/5
 */
public class OrderDAO {

    //添加订单
    public void addOrder(int goodsId,int count) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            connection = JDBCUtils.getConnection();
            statement = connection.createStatement();
            String sql = "INSERT INTO orders (goodsId,count) VALUES("+ goodsId +","+ count + ")";

            int num = statement.executeUpdate(sql);
            if (num > 0) {
                System.out.println("添加成功!");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closed(connection, resultSet, statement);
        }
    }

    //删除订单
    public void delOrder(Order order) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            connection = JDBCUtils.getConnection();
            statement = connection.createStatement();
            String sql = "delete from orders where orderId=" + order.getOrderId();

            int num = statement.executeUpdate(sql);
            if (num > 0) {
                System.out.println("删除成功!");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closed(connection, resultSet, statement);
        }
    }

    //修改订单
    public void updateOrder(int goodsId,int count) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            connection = JDBCUtils.getConnection();
            statement = connection.createStatement();
            String sql = "update orders set goodsId=" + goodsId+",count="+count +" where goodsId="+goodsId;

            int num = statement.executeUpdate(sql);
            if (num > 0) {
                System.out.println("修改成功!");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closed(connection, resultSet, statement);
        }
    }

    public Order searchOrder(int goodId) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            connection = JDBCUtils.getConnection();
            statement = connection.createStatement();
            String sql = "SELECT  * FROM orders where goodsId="+goodId;

            resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                int orderId = resultSet.getInt("orderId");
                int goodsId = resultSet.getInt("goodsId");
                int count = resultSet.getInt("count");
                Order order = new Order(orderId, count);
                return order;
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closed(connection, resultSet, statement);
        }
        return null;
    }
}
