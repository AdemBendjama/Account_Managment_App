package View;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

public class HomePage {
    //
    private GridPane gridPane;
    private Scene scene;
    private Button logOutButton;
    private Button viewStatsButton;
    private Button addUserButton;
    private Button updateUserButton;
    private Button deleteUserButton;
    private Label listOfUsersLabel;
    private ScrollPane listOfUsersPane;
    private HBox headerHbox;
    private HBox functionalButtonsHbox;
    private HBox listOfUserHbox;

    //
    public HomePage(){

        gridPane= new GridPane();
        //
        logOutButton = new Button("Logout");
        viewStatsButton = new Button("View Statistics");
        headerHbox = new HBox(viewStatsButton,logOutButton);
        headerHbox.setSpacing(20);
        headerHbox.setAlignment(Pos.CENTER_RIGHT);

        //
        addUserButton = new Button("Add User");
        updateUserButton = new Button("Update User");
        deleteUserButton = new Button("Delete User");
        functionalButtonsHbox = new HBox(addUserButton,updateUserButton,deleteUserButton);
        functionalButtonsHbox.setSpacing(100);

        //
        listOfUsersLabel = new Label();
        listOfUserHbox = new HBox(listOfUsersLabel);
        listOfUsersPane = new ScrollPane(listOfUserHbox);
        listOfUsersPane.setPrefSize(120, 180);
        listOfUserHbox.setPadding(new Insets(5,0,0,5));





        // ! Gridpane
        gridPane.setAlignment(Pos.TOP_LEFT);
        gridPane.setPadding(new Insets(40, 30, 30, 110));
        gridPane.setVgap(30);
        gridPane.setHgap(20);
        gridPane.add(headerHbox, 0, 0);
        gridPane.add(functionalButtonsHbox, 0, 1);
        gridPane.add(listOfUsersPane, 0, 2);

        // ! Scene
        scene = new Scene(gridPane);

    }

    public Scene getScene() {
        return scene;
    }

    public GridPane getGridPane() {
        return gridPane;
    }



    public Button getLogOutButton() {
        return logOutButton;
    }


    public Button getViewStatsButton() {
        return viewStatsButton;
    }


    public Button getAddUserButton() {
        return addUserButton;
    }


    public Button getUpdateUserButton() {
        return updateUserButton;
    }


    public Button getDeleteUserButton() {
        return deleteUserButton;
    }


    public Label getListOfUsersLabel() {
        return listOfUsersLabel;
    }


    public ScrollPane getListOfUsersPane() {
        return listOfUsersPane;
    }


    public HBox getHeaderHbox() {
        return headerHbox;
    }


    public HBox getFunctionalButtonsHbox() {
        return functionalButtonsHbox;
    }


    public HBox getListOfUserHbox() {
        return listOfUserHbox;
    }

}