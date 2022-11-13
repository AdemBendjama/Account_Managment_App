package View;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

public class LoginPage {
    //
    private GridPane gridPane;
    private Label emailLabel;
    private Label passwordLabel;
    private Label errorLabel;
    private TextField emailField;
    private TextField passwordField;
    private Button loginButton;
    private HBox hboxEmail;
    private HBox hboxPassword;
    private HBox hboxLoginButton;
    private Scene scene;

    //
    public LoginPage() {
        //
        // ! Elements
        gridPane = new GridPane();
        emailLabel = new Label("Email :");
        passwordLabel = new Label("Password :");
        errorLabel = new Label();
        emailField = new TextField();
        passwordField = new PasswordField();
        loginButton = new Button("Login");


        hboxEmail = new HBox(emailLabel, emailField);
        hboxPassword = new HBox(passwordLabel, passwordField);
        hboxLoginButton = new HBox(loginButton,errorLabel);

        // ! HBox
        hboxEmail.setSpacing(100);
        hboxPassword.setSpacing(75);
        hboxLoginButton.setSpacing(0);

        // ! GridPane
        gridPane.setAlignment(Pos.TOP_LEFT);
        gridPane.setPadding(new Insets(120, 30, 30, 200));
        gridPane.setVgap(10);
        gridPane.setHgap(20);
        gridPane.add(hboxEmail, 0, 0);
        gridPane.add(hboxPassword, 0, 1);
        gridPane.add(hboxLoginButton, 0, 2);
        gridPane.add(errorLabel, 0, 3);

        // ! Scene
        scene = new Scene(gridPane);
    }

    public GridPane getGridPane() {
        return gridPane;
    }


    public Label getEmailLabel() {
        return emailLabel;
    }


    public Label getPasswordLabel() {
        return passwordLabel;
    }


    public Label getErrorLabel() {
        return errorLabel;
    }


    public TextField getEmailField() {
        return emailField;
    }


    public TextField getPasswordField() {
        return passwordField;
    }


    public Button getLoginButton() {
        return loginButton;
    }


    public HBox getHboxEmail() {
        return hboxEmail;
    }


    public HBox getHboxPassword() {
        return hboxPassword;
    }


    public HBox getHboxLoginButton() {
        return hboxLoginButton;
    }


    public Scene getScene() {
        return scene;
    }



}
