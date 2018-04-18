package com.asorokin.service;

import com.asorokin.controller.ServletController;
import com.asorokin.dao.GoodDAO;
import com.asorokin.dao.OrderDAO;
import com.asorokin.dao.UserDAO;
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
    
    public static void init() {

        String jdbcURL = "jdbc:h2:mem:shop;DB_CLOSE_DELAY=-1";
        goodDAO = new GoodDAO(jdbcURL);
        orderDAO = new OrderDAO(jdbcURL);
        userDAO = new UserDAO(jdbcURL);

        try {
            goodDAO.createTable();
            orderDAO.createTable();
            userDAO.createTable();
        } catch (SQLException ex) {
            Logger.getLogger(ServletController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
