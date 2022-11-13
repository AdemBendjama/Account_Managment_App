package Controller;

import java.util.List;

import Model.AdminManager;
import Model.User;
import Model.UserManager;

public class AppController {
    private AdminManager adminManager;
    private UserManager userManager;

    public AppController() {
        this.adminManager = new AdminManager();
        this.userManager = new UserManager();
    }

    public boolean addUser(String email,String username, String password , String rank){
        //
        return userManager.addUser(new User(email, password, username, rank));
    }

    public boolean updateUser(String oldEmail,String email,String username, String password , String rank){
        //
        return userManager.updateUser(oldEmail, new User(email, password, username, rank));
    }

    public boolean deleteUser(String email) {
        //
        return userManager.deleteUser(email);
    }

    public boolean checkCredentials(String email, String password) {
        return adminManager.checkCredentials(email, password);
    }

    public String getListOfUsers() {
        //
        List<User> users = userManager.getUsers();
        String listOfUsers = "";
        int i = 1;
        for (User user : users) {
            listOfUsers = listOfUsers + "[" + i + "] " + user + "\n";
            i++;
        }

        return listOfUsers;
    }
}
