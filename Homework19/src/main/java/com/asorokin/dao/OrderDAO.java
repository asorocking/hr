package com.asorokin.dao;

import com.asorokin.beans.ProductRepository;
import com.asorokin.model.Good;
import com.asorokin.model.Order;
import com.asorokin.model.OrderGood;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class OrderDAO {

    private Connection jdbcConnection;
    
    ApplicationContext context = new ClassPathXmlApplicationContext("config-bean.xml");
    ProductRepository productRepository = (ProductRepository) context.getBean("productRepository");

    public OrderDAO() {
        
    }
    
    protected void connect() throws SQLException {
        if (jdbcConnection == null || jdbcConnection.isClosed()) {
            jdbcConnection = productRepository.getConnection();
        }
    }

    protected void disconnect() throws SQLException {
        if (jdbcConnection != null && !jdbcConnection.isClosed()) {
            jdbcConnection.close();
        }
    }

    public void createTable() throws SQLException {
        connect();

        try (Statement statement = jdbcConnection.createStatement()) {
            statement.execute("CREATE TABLE ORDERS (id number auto_increment, user_id number, total_price number)");
        } catch (SQLException ex) {
            System.out.println("initDB() failed: "
                    + ex.getMessage());
        }

        try (Statement statement = jdbcConnection.createStatement()) {
            statement.execute("CREATE TABLE ORDER_GOOD (id number auto_increment, order_id number, good_id number)");
        } catch (SQLException ex) {
            System.out.println("initDB() failed: "
                    + ex.getMessage());
        }

        disconnect();

    }

    public boolean insertOrder(Order order) throws SQLException {
        String sql = "INSERT INTO ORDERS (user_id, total_price) VALUES (?, ?)";
        connect();

        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setInt(1, order.getUserID());
        statement.setFloat(2, order.getTotalPrice());

        boolean rowInserted = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowInserted;
    }

    public boolean insertOrderGood(OrderGood orderGood) throws SQLException {
        String sql = "INSERT INTO ORDER_GOOD (order_id, good_id) VALUES (?, ?)";
        connect();

        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setInt(1, orderGood.getOrderID());
        statement.setInt(2, orderGood.getGoodID());

        boolean rowInserted = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowInserted;
    }

    public List<Order> listAllOrders() throws SQLException {
        List<Order> listOrder = new ArrayList<>();

        String sql = "SELECT * FROM ORDERS";
        connect();

        Statement statement = jdbcConnection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            int userID = resultSet.getInt("user_id");
            float totalPrice = resultSet.getFloat("total_price");

            Order order = new Order(id, userID, totalPrice);
            listOrder.add(order);
        }

        resultSet.close();
        statement.close();

        disconnect();

        return listOrder;
    }

    public List<OrderGood> listAllOrderGood() throws SQLException {
        List<OrderGood> listOrderGood = new ArrayList<>();

        String sql = "SELECT * FROM ORDER_GOOD";
        connect();

        Statement statement = jdbcConnection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            int orderID = resultSet.getInt("order_id");
            int goodID = resultSet.getInt("good_id");

            OrderGood orderGood = new OrderGood(id, orderID, goodID);
            listOrderGood.add(orderGood);
        }

        resultSet.close();
        statement.close();

        disconnect();

        return listOrderGood;
    }

    public List<Good> listAllSelectedGood() throws SQLException {
        List<Good> listSelectedGood = new ArrayList<>();

        String sql = "SELECT g.title, g.price FROM GOOD g INNER JOIN ORDER_GOOD og ON g.id = og.good_id";
        connect();

        Statement statement = jdbcConnection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            String title = resultSet.getString("title");
            float price = resultSet.getFloat("price");

            Good good = new Good(title, price);
            listSelectedGood.add(good);
        }

        resultSet.close();
        statement.close();

        disconnect();

        return listSelectedGood;
    }

    public void deleteOrder(Order order) throws SQLException {
        System.out.println("Deleted ORDERS");
    }

    public boolean updateOrder(Order order) throws SQLException {
        String sql = "UPDATE ORDERS SET user_id = ?, total_price = ? WHERE id = ?";
        connect();

        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setInt(1, order.getUserID());
        statement.setFloat(2, order.getTotalPrice());
        statement.setInt(3, order.getID());

        boolean rowUpdated = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowUpdated;
    }

    public Order getOrder(int id) throws SQLException {
        Order order = null;
        String sql = "SELECT * FROM ORDERS WHERE id = ?";

        connect();

        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setInt(1, id);

        ResultSet resultSet = statement.executeQuery();

        if (resultSet.next()) {
            int userID = resultSet.getInt("user_id");
            float totalPrice = resultSet.getFloat("total_price");

            order = new Order(id, userID, totalPrice);
        }

        resultSet.close();
        statement.close();

        return order;
    }
}
