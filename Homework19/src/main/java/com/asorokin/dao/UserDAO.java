package com.asorokin.dao;

import com.asorokin.beans.ProductRepository;
import com.asorokin.model.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserDAO {

    private Connection jdbcConnection;
    
    ApplicationContext context = new ClassPathXmlApplicationContext("config-bean.xml");
    ProductRepository productRepository = (ProductRepository) context.getBean("productRepository");
    
    public UserDAO() {
    
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
            statement.execute("CREATE TABLE USER (id number auto_increment, login varchar(50), password varchar(20))");
        } catch (SQLException ex) {
            System.out.println("initDB() failed: "
                    + ex.getMessage());
        }
        disconnect();
    }

    public boolean insertUser(User user) throws SQLException {
        String sql = "INSERT INTO USER (id, login, password) VALUES (?, ?, ?)";
        connect();

        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setInt(1, user.getID());
        statement.setString(2, user.getLogin());
        statement.setString(3, user.getPassword());

        boolean rowInserted = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowInserted;
    }

    public List<User> listAllUsers() throws SQLException {
        List<User> listUser = new ArrayList<>();

        String sql = "SELECT * FROM USER";
        connect();

        Statement statement = jdbcConnection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String login = resultSet.getString("login");
            String password = resultSet.getString("password");

            User user = new User(id, login, password);
            listUser.add(user);
        }

        resultSet.close();
        statement.close();

        disconnect();

        return listUser;
    }

    public void deleteUser(User user) throws SQLException {
        System.out.println("Deleted user");
    }

    public void updateUser(User user) throws SQLException {
        System.out.println("Updated user");
    }

    public User getUser(int id) throws SQLException {
        User user = null;
        String sql = "SELECT * FROM USER WHERE id = ?";

        connect();

        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setInt(1, id);

        ResultSet resultSet = statement.executeQuery();

        if (resultSet.next()) {
            String login = resultSet.getString("login");
            String password = resultSet.getString("password");

            user = new User(id, login, password);
        }

        resultSet.close();
        statement.close();

        return user;
    }
}
