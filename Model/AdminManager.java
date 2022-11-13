package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminManager {
    //
    private Connection connection;
    private PreparedStatement preparedStatement;
    private String url = "jdbc:mysql://localhost:3306/TQL_APP_BD";
    private String root = "root";
    private String password = "password";

    //
    public AdminManager() {
        //
        try {
            this.connection = DriverManager.getConnection(url, root, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }

    //
    public boolean checkCredentials(String email,String password){
        //
        try {
            preparedStatement = connection.prepareStatement("select * from admins where admin_email=? && admin_password = ?");
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();
            return resultSet.next();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
