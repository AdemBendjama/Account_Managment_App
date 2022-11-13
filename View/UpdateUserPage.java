package View;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

public class UpdateUserPage {
    //
    private GridPane gridPane;
    private Scene scene;
    private HBox hboxheader;
    private Button buttonHome;
    private Label labelOldEmail;
    private TextField textFieldOldEmail;
    private HBox hboxOldEmail;
    private Label labelEmail;
    private TextField textFieldEmail;
    private HBox hboxEmail;
    private Label labelUsername;
    private TextField textFieldUsername;
    private HBox hboxUsername;
    private Label labelPassword;
    private TextField textFieldPassword;
    private HBox hboxPassword;
    private Label labelRank;
    private TextField textFieldRank;
    private HBox hboxRank;
    private Button buttonUpdate;
    private HBox hboxUpdate;
    private Label labelDisplay;
    private HBox hboxDisplay;

    //
    public UpdateUserPage() {

        gridPane = new GridPane();

        //
        buttonHome = new Button("Home");
        hboxheader = new HBox(buttonHome);
        hboxheader.setAlignment(Pos.CENTER_RIGHT);

        // Old Email
        labelOldEmail = new Label("Old Email :");
        textFieldOldEmail = new TextField();
        hboxOldEmail = new HBox(labelOldEmail, textFieldOldEmail);
        hboxOldEmail.setSpacing(115);

        // Email
        labelEmail = new Label("Email :");
        textFieldEmail = new TextField();
        hboxEmail = new HBox(labelEmail, textFieldEmail);
        hboxEmail.setSpacing(140);

        // Username
        labelUsername = new Label("Username :");
        textFieldUsername = new TextField();
        hboxUsername = new HBox(labelUsername, textFieldUsername);
        hboxUsername.setSpacing(110);

        // Password
        labelPassword = new Label("Password :");
        textFieldPassword = new TextField();
        hboxPassword = new HBox(labelPassword, textFieldPassword);
        hboxPassword.setSpacing(115);

        // Rank
        labelRank = new Label("Rank :");
        textFieldRank = new TextField();
        hboxRank = new HBox(labelRank, textFieldRank);
        hboxRank.setSpacing(143);

        //
        buttonUpdate = new Button("Update");
        hboxUpdate = new HBox(buttonUpdate);
        hboxUpdate.setAlignment(Pos.CENTER_RIGHT);

        //
        labelDisplay = new Label();
        hboxDisplay = new HBox(labelDisplay);
        hboxDisplay.setAlignment(Pos.CENTER_RIGHT);

        // ! Gridpane
        gridPane.setAlignment(Pos.TOP_LEFT);
        gridPane.setPadding(new Insets(25, 30, 30, 170));
        gridPane.setVgap(13);
        gridPane.setHgap(20);
        gridPane.add(hboxheader, 0, 0);
        gridPane.add(hboxOldEmail, 0, 1);
        gridPane.add(hboxEmail, 0, 2);
        gridPane.add(hboxUsername, 0, 3);
        gridPane.add(hboxPassword, 0, 4);
        gridPane.add(hboxRank, 0, 5);
        gridPane.add(hboxUpdate, 0, 6);
        gridPane.add(hboxDisplay, 0, 7);

        // ! Scene
        scene = new Scene(gridPane);

    }

    public Label getLabelDisplay() {
        return labelDisplay;
    }

    public Scene getScene() {
        return scene;
    }

    public GridPane getGridPane() {
        return gridPane;
    }



    public HBox getHboxheader() {
        return hboxheader;
    }


    public Button getButtonHome() {
        return buttonHome;
    }


    public Label getLabelOldEmail() {
        return labelOldEmail;
    }


    public TextField getTextFieldOldEmail() {
        return textFieldOldEmail;
    }


    public HBox getHboxOldEmail() {
        return hboxOldEmail;
    }


    public Label getLabelEmail() {
        return labelEmail;
    }


    public TextField getTextFieldEmail() {
        return textFieldEmail;
    }


    public HBox getHboxEmail() {
        return hboxEmail;
    }


    public Label getLabelUsername() {
        return labelUsername;
    }


    public TextField getTextFieldUsername() {
        return textFieldUsername;
    }


    public HBox getHboxUsername() {
        return hboxUsername;
    }


    public Label getLabelPassword() {
        return labelPassword;
    }


    public TextField getTextFieldPassword() {
        return textFieldPassword;
    }


    public HBox getHboxPassword() {
        return hboxPassword;
    }


    public Label getLabelRank() {
        return labelRank;
    }


    public TextField getTextFieldRank() {
        return textFieldRank;
    }


    public HBox getHboxRank() {
        return hboxRank;
    }


    public Button getButtonUpdate() {
        return buttonUpdate;
    }


    public HBox getHboxUpdate() {
        return hboxUpdate;
    }

}
