package View;

import Controller.AppController;
import javafx.application.Application;
import javafx.stage.Stage;

public class GUI extends Application {
    //
    private LoginPage loginPage = new LoginPage();
    private HomePage homePage = new HomePage();
    private AddUserPage addUserPage = new AddUserPage();
    private DeleteUserPage deleteUserPage = new DeleteUserPage();
    private UpdateUserPage updateUserPage = new UpdateUserPage();
    private StatsPage statsPage = new StatsPage();
    private AppController appController = new AppController();

    @Override
    public void start(Stage window) {
        //
        startFunctions(window);

        //
        window.setScene(loginPage.getScene());
        // window.setScene(loginPage.getScene());
        window.setTitle("Account Managment App");
        window.fullScreenProperty();
        window.setHeight(400);
        window.setWidth(700);
        window.show();

    }

    public void startFunctions(Stage window) {
        //
        loginPageFunctionality(window);
        homePageFunctionality(window);
        statsPageFunctionality(window);
        addUserPageFunctionality(window);
        updateUserPageFunctionality(window);
        deleteUserPageFunctionality(window);
    }

    public void loginPageFunctionality(Stage window) {
        // this.appController.loginButtonFunction(email, password)
        // loginPageFunctionality(window);
        loginPage.getLoginButton().setOnAction(arg0 -> {
            //
            String email = loginPage.getEmailField().getText();
            String password = loginPage.getPasswordField().getText();

            boolean validate = appController.checkCredentials(email, password);

            if (validate) {
                window.setScene(homePage.getScene());
                loginPage.getErrorLabel().setText("");
            } else {
                loginPage.getErrorLabel().setText("Wrong Credentials !");
            }
            loginPage.getEmailField().setText("");
            loginPage.getPasswordField().setText("");

        });

    }

    public void updateList() {
        //
        String list = appController.getListOfUsers();
        homePage.getListOfUsersLabel().setText(list);
    }

    public void homePageFunctionality(Stage window) {
        //
        updateList();

        //
        homePage.getLogOutButton().setOnAction(arg0 -> window.setScene(loginPage.getScene()));

        homePage.getViewStatsButton().setOnAction(arg0 -> {
            statsPageFunctionality(window);
            window.setScene(statsPage.getScene());
        });

        homePage.getAddUserButton().setOnAction(arg0 -> {
            addUserPage.getLabelDisplay().setText("");
            window.setScene(addUserPage.getScene());
        });

        homePage.getUpdateUserButton().setOnAction(arg0 -> {
            updateUserPage.getLabelDisplay().setText("");
            window.setScene(updateUserPage.getScene());
        });

        homePage.getDeleteUserButton().setOnAction(arg0 -> {
            deleteUserPage.getLabelDisplay().setText("");
            window.setScene(deleteUserPage.getScene());
        });

    }

    public void statsPageFunctionality(Stage window) {
        //
        statsPage.getButtonHome().setOnAction(arg0 -> {
            updateList();
            window.setScene(homePage.getScene());
        });
        // Number of users
        int nbrUsers = appController.getNumberOfUsers();
        statsPage.getLabelCountValue().setText(String.valueOf(nbrUsers));

        // Average ID of Users
        double avgUsersId = appController.getAverageUserNote();
        statsPage.getLabelAverageValue().setText(appController.formatDouble(avgUsersId));

        //
        double avg = appController.getAverageUserNote();
        double count = appController.getNumberOfUsers();
        // The Variance
        double variance = appController.getVariance(avg, count);
        statsPage.getLabelVarianceValue().setText(appController.formatDouble(variance));

        // Standard Deviation
        double standardDeviation = appController.getStandardDeviation(avg, count);
        statsPage.getLabelStandardDeviationValue().setText(appController.formatDouble(standardDeviation));
    }

    public void addUserPageFunctionality(Stage window) {
        //
        addUserPage.getButtonHome().setOnAction(arg0 -> {
            //
            updateList();
            //
            window.setScene(homePage.getScene());
        });

        //
        addUserPage.getButtonAdd().setOnAction(arg0 -> {
            //
            String email = addUserPage.getTextFieldEmail().getText();
            String username = addUserPage.getTextFieldEmail().getText();
            String password = addUserPage.getTextFieldEmail().getText();
            String rank = addUserPage.getTextFieldEmail().getText();

            //

            if (appController.addUser(email, username, password, rank)) {
                addUserPage.getLabelDisplay().setText("User Added Successfully !");
            } else {
                addUserPage.getLabelDisplay().setText("User Already Exists !");
            }

            addUserPage.getTextFieldEmail().setText("");
            addUserPage.getTextFieldPassword().setText("");
            addUserPage.getTextFieldUsername().setText("");
            addUserPage.getTextFieldRank().setText("");
        });

    }

    public void updateUserPageFunctionality(Stage window) {
        //
        updateUserPage.getButtonHome().setOnAction(arg0 -> {
            //
            updateList();
            //
            window.setScene(homePage.getScene());
        });

        //
        updateUserPage.getButtonUpdate().setOnAction(arg0 -> {
            //
            String oldEmail = updateUserPage.getTextFieldOldEmail().getText();
            String email = updateUserPage.getTextFieldEmail().getText();
            String username = updateUserPage.getTextFieldUsername().getText();
            String password = updateUserPage.getTextFieldPassword().getText();
            String rank = updateUserPage.getTextFieldRank().getText();

            //
            if (appController.updateUser(oldEmail, email, username, password, rank)) {
                //
                updateUserPage.getLabelDisplay().setText("User Updated Successfully !");
            } else {
                //
                updateUserPage.getLabelDisplay().setText("User Wasn't Found !");
            }
            //
            updateUserPage.getTextFieldOldEmail().setText("");
            updateUserPage.getTextFieldEmail().setText("");
            updateUserPage.getTextFieldUsername().setText("");
            updateUserPage.getTextFieldPassword().setText("");
            updateUserPage.getTextFieldRank().setText("");
        });
    }

    public void deleteUserPageFunctionality(Stage window) {
        //
        deleteUserPage.getButtonHome().setOnAction(arg0 -> {
            //
            updateList();
            //
            window.setScene(homePage.getScene());
        });

        //
        deleteUserPage.getButtonDelete().setOnAction(event -> {
            //
            String email = deleteUserPage.getTextFieldEmail().getText();
            if (appController.deleteUser(email)) {
                deleteUserPage.getLabelDisplay().setText("Deleted User Successfully !");
            } else {
                deleteUserPage.getLabelDisplay().setText("User Wasn't Found !");
            }
            deleteUserPage.getTextFieldEmail().setText("");

        });
    }

}
