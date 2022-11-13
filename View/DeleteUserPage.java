package View;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

public class DeleteUserPage {
    //
    private GridPane gridPane;
    private Scene scene;
    private HBox hboxheader;
    private Button buttonHome;
    //
    private Label labelEmail;
    private TextField textFieldEmail;
    private HBox hboxEmail;
    private Button buttonDelete;
    private HBox hboxDelete;
    private Label labelDisplay;
    private HBox hboxDisplay;

    public DeleteUserPage() {

        gridPane = new GridPane();

        //
        buttonHome = new Button("Home");
        hboxheader = new HBox(buttonHome);
        hboxheader.setAlignment(Pos.CENTER_RIGHT);

        //
        labelEmail = new Label("Email :");
        textFieldEmail = new TextField();
        hboxEmail = new HBox(labelEmail, textFieldEmail);
        hboxEmail.setSpacing(100);

        
        //
        buttonDelete = new Button("Delete");
        hboxDelete = new HBox(buttonDelete);
        hboxDelete.setAlignment(Pos.CENTER_RIGHT);
       
        //
        labelDisplay = new Label();
        hboxDisplay = new HBox(labelDisplay);
        hboxDisplay.setAlignment(Pos.CENTER_RIGHT);

        // ! Gridpane
        gridPane.setAlignment(Pos.TOP_LEFT);
        gridPane.setPadding(new Insets(80, 30, 30, 200));
        gridPane.setVgap(20);
        gridPane.setHgap(20);
        gridPane.add(hboxheader, 0, 0);
        gridPane.add(hboxEmail, 0, 1);
        gridPane.add(hboxDelete, 0, 2);
        gridPane.add(hboxDisplay, 0, 3);

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

    public Label getLabelEmail() {
        return labelEmail;
    }

    public TextField getTextFieldEmail() {
        return textFieldEmail;
    }

    public HBox getHboxEmail() {
        return hboxEmail;
    }

    public Button getButtonDelete() {
        return buttonDelete;
    }

    public HBox getHboxDelete() {
        return hboxDelete;
    }

}
