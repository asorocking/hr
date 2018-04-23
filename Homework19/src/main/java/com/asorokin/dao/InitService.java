package com.asorokin.dao;

import com.asorokin.controller.ServletController;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class InitService {

    public static GoodDAO goodDAO;
    public static OrderDAO orderDAO;
    public static UserDAO userDAO;
    public static int userID = 1;
    public static int orderID = 1;
    public static float total_price = 0;
    private static String jdbcURL;
    private static Connection jdbcConnection;

    public static void init() {
        goodDAO = new GoodDAO();
        orderDAO = new OrderDAO();
        userDAO = new UserDAO();

        try {
            goodDAO.createTable();
            orderDAO.createTable();
            userDAO.createTable();
        } catch (SQLException ex) {
            Logger.getLogger(ServletController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    protected static void connect() throws SQLException {
        if (jdbcConnection == null || jdbcConnection.isClosed()) {
            try {
                Class.forName("org.h2.Driver");
            } catch (ClassNotFoundException e) {
                throw new SQLException(e);
            }
            jdbcConnection = DriverManager.getConnection(jdbcURL);
        }
    }

    protected static void disconnect() throws SQLException {
        if (jdbcConnection != null && !jdbcConnection.isClosed()) {
            jdbcConnection.close();
        }
    }
}
