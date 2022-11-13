package View;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

public class StatsPage {
    //
    private GridPane gridPane;
    private Scene scene;
    private Button buttonHome;
    private HBox hboxheader;
    private Label labelCount;
    private Label labelCountValue;
    private HBox hboxCount;
    private Label labelAverage;
    private Label labelAverageValue;
    private HBox hboxAverage;
    private Label labelVariance;
    private Label LabelVarianceValue;
    private HBox hboxVariance;
    private Label labelStandardDeviation;
    private Label LabelStandardDeviationValue;
    private HBox hboxStandardDeviation;

    //
    public StatsPage() {

        gridPane = new GridPane();

        //
        buttonHome = new Button("Home");
        hboxheader = new HBox(buttonHome);
        hboxheader.setAlignment(Pos.CENTER_RIGHT);

        // Count
        labelCount = new Label("The Number Of Users :");
        labelCountValue = new Label("0.0");
        hboxCount = new HBox(labelCount, labelCountValue);
        hboxCount.setSpacing(193);

        // Average
        labelAverage = new Label("The Average :");
        labelAverageValue = new Label("0.0");
        hboxAverage = new HBox(labelAverage, labelAverageValue);
        hboxAverage.setSpacing(250);

        // Variance
        labelVariance = new Label("The Variance :");
        LabelVarianceValue = new Label("0.0");
        hboxVariance = new HBox(labelVariance, LabelVarianceValue);
        hboxVariance.setSpacing(248);

        // StandardDeviation
        labelStandardDeviation = new Label("The Standard Deviation :");
        LabelStandardDeviationValue = new Label("0.0");
        hboxStandardDeviation = new HBox(labelStandardDeviation, LabelStandardDeviationValue);
        hboxStandardDeviation.setSpacing(185);
        // ! Gridpane
        gridPane.setAlignment(Pos.TOP_LEFT);
        gridPane.setPadding(new Insets(40, 30, 30, 170));
        gridPane.setVgap(30);
        gridPane.setHgap(20);
        gridPane.add(hboxheader, 0, 0);
        gridPane.add(hboxCount, 0, 1);
        gridPane.add(hboxAverage, 0, 2);
        gridPane.add(hboxVariance, 0, 3);
        gridPane.add(hboxStandardDeviation, 0, 4);

        // ! Scene
        scene = new Scene(gridPane);

    }

    public GridPane getGridPane() {
        return gridPane;
    }



    public Button getButtonHome() {
        return buttonHome;
    }


    public HBox getHboxheader() {
        return hboxheader;
    }


    public Label getLabelCount() {
        return labelCount;
    }


    public Label getLabelCountValue() {
        return labelCountValue;
    }


    public HBox getHboxCount() {
        return hboxCount;
    }


    public Label getLabelAverage() {
        return labelAverage;
    }


    public Label getLabelAverageValue() {
        return labelAverageValue;
    }


    public HBox getHboxAverage() {
        return hboxAverage;
    }


    public Label getLabelVariance() {
        return labelVariance;
    }


    public Label getLabelVarianceValue() {
        return LabelVarianceValue;
    }


    public HBox getHboxVariance() {
        return hboxVariance;
    }


    public Label getLabelStandardDeviation() {
        return labelStandardDeviation;
    }


    public Label getLabelStandardDeviationValue() {
        return LabelStandardDeviationValue;
    }


    public HBox getHboxStandardDeviation() {
        return hboxStandardDeviation;
    }


    public Scene getScene() {
        return scene;
    }
}
