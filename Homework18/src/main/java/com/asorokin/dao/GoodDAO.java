package com.asorokin.dao;

import com.asorokin.model.Good;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class GoodDAO {

    private String jdbcURL;
    private Connection jdbcConnection;

    public GoodDAO(String jdbcURL) {
        this.jdbcURL = jdbcURL;
    }

    public GoodDAO(String jdbcURL, String jdbcUsername, String jdbcPassword) {
        this.jdbcURL = jdbcURL;
    }

    protected void connect() throws SQLException {
        if (jdbcConnection == null || jdbcConnection.isClosed()) {
            try {
                Class.forName("org.h2.Driver");
            } catch (ClassNotFoundException e) {
                throw new SQLException(e);
            }
            jdbcConnection = DriverManager.getConnection(jdbcURL);
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
            statement.execute("CREATE TABLE GOOD (id number, title varchar(50), price number)");

            statement.execute("INSERT into GOOD values(1,'Mobile Phone',10)");
            statement.execute("INSERT into GOOD values(2,'Book',5)");
            statement.execute("INSERT into GOOD values(3,'Pencil',0.3)");
            statement.execute("INSERT into GOOD values(4,'Pen',1.2)");
            statement.execute("INSERT into GOOD values(5,'Fireball',100)");
        } catch (SQLException ex) {
            System.out.println("initDB() failed: "
                    + ex.getMessage());
        }
        disconnect();

    }

    public void insertGood(Good good) throws SQLException {
        System.out.println("Inserted good");
    }

    public List<Good> listAllGoods() throws SQLException {
        List<Good> listGood = new ArrayList<>();

        String sql = "SELECT * FROM GOOD";
        connect();

        Statement statement = jdbcConnection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String title = resultSet.getString("title");
            float price = resultSet.getFloat("price");

            Good good = new Good(id, title, price);
            listGood.add(good);
        }

        resultSet.close();
        statement.close();

        disconnect();

        return listGood;
    }

    public void deleteGood(Good good) throws SQLException {
        System.out.println("Deleted good");
    }

    public void updateGood(Good good) throws SQLException {
        System.out.println("Updated good");
    }

    public Good getGood(int id) throws SQLException {
        Good good = null;
        String sql = "SELECT * FROM GOOD WHERE id = ?";

        connect();

        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setInt(1, id);

        ResultSet resultSet = statement.executeQuery();

        if (resultSet.next()) {
            String title = resultSet.getString("title");
            float price = resultSet.getFloat("price");

            good = new Good(id, title, price);
        }

        resultSet.close();
        statement.close();

        return good;
    }
}
