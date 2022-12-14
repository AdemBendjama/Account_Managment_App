package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserManager {
    //
    private Connection connection;
    private PreparedStatement preparedStatement;
    private String url = "jdbc:mysql://localhost:3306/TQL_APP_BD";
    private String root = "root";
    private String password = "password";

    //
    public UserManager() {
        //
        try {
            this.connection = DriverManager.getConnection(url, root, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //
    public boolean testConnection(){
        //
        try {
            DriverManager.getConnection(url, root, password);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false ;
        }
    }

    //
    public boolean checkUser(String email) {
        //
        boolean foundOrNot = false;
        try {
            preparedStatement = connection.prepareStatement("select * from users where user_email=?");
            preparedStatement.setString(1, email);
            ResultSet resultSet = preparedStatement.executeQuery();
            foundOrNot = resultSet.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //
        return foundOrNot;
    }

    //
    public User getUser(String email) {
        //
        User user = new User("", "", "", "");
        try {
            preparedStatement = connection.prepareStatement("select * from users where user_email=?");
            preparedStatement.setString(1, email);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            user = new User(resultSet.getString(1), resultSet.getString(2),
                    resultSet.getString(3), resultSet.getString(4));

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    //
    public List<User> getUsers() {
        //
        List<User> users = new ArrayList<>();
        try {
            preparedStatement = connection.prepareStatement("select * from users");
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                //
                User user = new User(resultSet.getString(1), resultSet.getString(2),
                        resultSet.getString(3), resultSet.getString(4));

                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return users;
    }

    //
    public int getNumberOfUsers() {
        //
        try {
            preparedStatement = connection.prepareStatement("select COUNT(*) from users");
            ResultSet resultSet = preparedStatement.executeQuery();

            resultSet.next();
            return resultSet.getInt(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //
        return 0;
    }

    //
    public boolean addUser(User user) {
        //
        if (checkUser(user.getEmail())) {
            System.out.println("User Already Exists in the Database");
            return false;
        }

        //
        try {

            preparedStatement = connection.prepareStatement("insert into users values (?,?,?,?)");
            preparedStatement.setString(1, user.getEmail());
            preparedStatement.setString(2, user.getUsername());
            preparedStatement.setString(3, user.getPassword());
            preparedStatement.setString(4, user.getRank());
            preparedStatement.executeUpdate();
            System.out.println("Added !");
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    //
    public boolean deleteUser(String email) {
        //
        if (!checkUser(email)) {
            System.out.println("User doesnt exist");
            return false;
        }

        //
        try {

            preparedStatement = connection.prepareStatement("delete from users where user_email=?");
            preparedStatement.setString(1, email);
            preparedStatement.executeUpdate();
            System.out.println("Deleted !");
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    //
    public boolean updateUser(String email, User user) {
        //
        if (!checkUser(email)) {
            System.out.println("User doesnt exist");
            return false;
        }

        //
        try {

            preparedStatement = connection.prepareStatement(
                    "update users set user_email=?, user_name=?, user_password=?, user_rank=?  where user_email=? ");
            preparedStatement.setString(1, user.getEmail());
            preparedStatement.setString(2, user.getUsername());
            preparedStatement.setString(3, user.getPassword());
            preparedStatement.setString(4, user.getRank());
            preparedStatement.setString(5, email);
            preparedStatement.executeUpdate();
            System.out.println("Updated !");
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
