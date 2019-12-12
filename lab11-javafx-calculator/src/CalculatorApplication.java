import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class CalculatorApplication extends Application {

    private Button clear;
    private Button plus;
    private Button minus;
    private Button mult;
    private Button div;
    private Button equals;

    private Button zero;
    private Button one;
    private Button two;
    private Button three;
    private Button four;
    private Button five;
    private Button six;
    private Button seven;
    private Button eight;
    private Button nine;

    private TextField display;

    private Calculator calculator = new Calculator();

    @Override
    public void start(Stage primaryStage) throws Exception {
        // layout
        VBox vBox = new VBox();
        layoutView(vBox);
        vBox.getStylesheets().add("calculator.css");

        // event handlers
        // 补全逻辑代码
        zero    .setOnAction(event -> display.setText(display.getText() + "0"));
        clear   .setOnAction(this::handleButtonAction);
        plus    .setOnAction(this::handleButtonAction);
        minus   .setOnAction(this::handleButtonAction);
        mult    .setOnAction(this::handleButtonAction);
        div     .setOnAction(this::handleButtonAction);
        equals  .setOnAction(this::handleButtonAction);

        // structure
        Scene scene = new Scene(vBox, 400, 500);
        primaryStage.setTitle("Calculator Demo");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // 补全代码
    private void handleButtonAction(ActionEvent event) {
        if (event.getSource() == clear) {
            calculator.clear();
            display.setText("");
        } else if (event.getSource() == plus) {

        } else if (event.getSource() == minus) {

        } else if (event.getSource() == mult) {

        } else if (event.getSource() == div) {

        } else if (event.getSource() == equals) {

        }
    }

    private void layoutView(VBox vBox) {
        display = new TextField();
        display.setAlignment(Pos.CENTER_RIGHT);
        GridPane gridPane = new GridPane();
        zero    = new Button("0");
        one     = new Button("1");
        two     = new Button("2");
        three   = new Button("3");
        four    = new Button("4");
        five    = new Button("5");
        six     = new Button("6");
        seven   = new Button("7");
        eight   = new Button("8");
        nine    = new Button("9");

        clear   = new Button("CL");
        plus    = new Button("+");
        minus   = new Button("-");
        mult    = new Button("*");
        div     = new Button("/");
        equals  = new Button("=");

        gridPane.add(one,   0, 0); gridPane.add(two,    1, 0); gridPane.add(three, 2, 0); gridPane.add(plus,  3, 0);
        gridPane.add(four,  0, 1); gridPane.add(five,   1, 1); gridPane.add(six,   2, 1); gridPane.add(minus, 3, 1);
        gridPane.add(seven, 0, 2); gridPane.add(eight,  1, 2); gridPane.add(nine,  2, 2); gridPane.add(mult,  3, 2);
        gridPane.add(zero,  0, 3); gridPane.add(equals, 1, 3); gridPane.add(clear, 2, 3); gridPane.add(div,   3, 3);

        vBox.getChildren().addAll(display, gridPane);
    }
}
