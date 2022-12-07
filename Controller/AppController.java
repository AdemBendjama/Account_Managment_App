package Controller;

import java.util.List;
import java.util.Random;

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

    public boolean addUser(String email, String username, String password, String rank) {
        //
        return userManager.addUser(new User(email, password, username, rank));
    }

    public boolean updateUser(String oldEmail, String email, String username, String password, String rank) {
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

    public int getNumberOfUsers() {
        //
        return userManager.getNumberOfUsers();
    }

    //
    public double getAverageUserNote() {
        // Adding all The Ids Together and then dividing them on the number of users
        // to get a hypothetical avrg of ids
        // since there is nothing to get an average value from
        int numberOfUsers = getNumberOfUsers();
        double countOfUserNotes = 0;
        Random random = new Random();
        int note = random.nextInt(20)+1; 

        //
        for (int i = 1; i <= numberOfUsers; i++) {
            //
            countOfUserNotes = countOfUserNotes + note;
            note = random.nextInt(20)+1;
        }
        countOfUserNotes = countOfUserNotes / numberOfUsers;

        //
        return countOfUserNotes;

    }

    //
    public double getStandardDeviation(double avg, double count) {
        //
        return Math.sqrt(getVariance(avg, count));

    }

    //
    public double getVariance(double avg, double count) {
        //
        double equationResult = 0;

        //
        for (int i = 1; i <= count; i++) {
            double value = i;
            equationResult = equationResult + ((value - avg) * (value - avg));
        }

        //
        return equationResult / count;
    }

    //
    public String formatDouble(double number) {
        // bascily a double value will always be limited to #.####### decimal places
        // example 1.256485654654 becomes 1.256485
        // mainly to avoid values going off screen
        int temp = (int) (number * 1000000.0);
        number = (temp) / 1000000.0;

        //
        return String.valueOf(number) ;
    }

}
