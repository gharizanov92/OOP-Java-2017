/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab8f17javafx;

import com.sun.javafx.beans.event.AbstractNotifyListener;
import javafx.application.Application;
import javafx.beans.Observable;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import week8b.CipherGenerator;
import week8b.Result;
import week8b.Wrapper;

/**
 *
 * @author Georgi
 */
public class Lab8F17JavaFX extends Application {

    private TextField txtSizeInput;
    private TextField txtSeedInput;

    private static final String SIZE_PROMPT = "Enter size";
    private static final String SEED_PROMPT = "Enter seed";
    private Button btnGenerate;
    private Button btnSubset;
    private Button btnExit;
    private Alert resultMessage;
    private Alert errorMessage;

    private void displayResult(Result result) {
        resultMessage.setTitle("Result");
        resultMessage.setContentText(result.toString());
        resultMessage.showAndWait();
    }
    
    private void displayError(String text) {
        errorMessage.setContentText(text);
        errorMessage.showAndWait();
    }

    @Override
    public void start(Stage primaryStage) {
        FlowPane root = new FlowPane(16, 16);
        root.setAlignment(Pos.CENTER);

        txtSizeInput = new TextField("Enter size");
        txtSeedInput = new TextField("Enter seed");

        txtSizeInput.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                try {
                    int val = Integer.parseInt(newValue);
                } catch (NumberFormatException e) {
                    txtSizeInput.setText(oldValue);
                }
            }
        });

        txtSeedInput.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                try {
                    int val = Integer.parseInt(newValue);
                } catch (NumberFormatException e) {
                    txtSeedInput.setText(oldValue);
                }
            }
        });

        btnGenerate = new Button("Generate random A - Z");
        btnSubset = new Button("Generate subset A - Z");
        btnExit = new Button("Quit");
        btnExit.setMinWidth(150);

        resultMessage = new Alert(Alert.AlertType.INFORMATION);
        errorMessage = new Alert(Alert.AlertType.ERROR);

        btnGenerate.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String seedInput = txtSeedInput.getText();
                int seed;
                int size;

                if (SEED_PROMPT.equals(seedInput)) {
                    displayError("Please enter seed");
                    return;
                } else {
                    seed = Integer.parseInt(seedInput);
                }

                if (SIZE_PROMPT.equals(seedInput)) {
                    displayError("Please enter size");
                       return;
             } else {
                    size = Integer.parseInt(seedInput);
                }

                CipherGenerator generator = new CipherGenerator();
                Wrapper wrapper = new Wrapper(size);
                Result result = generator.countDistinct(
                        wrapper.createFixedRandom(), seed);

                displayResult(result);
            }
        });

        btnExit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.exit(0);
            }
        });

        Scene scene = new Scene(root, 300, 250);
        root.getChildren().addAll(txtSeedInput, txtSizeInput, btnGenerate, btnSubset, btnExit);

        primaryStage.setTitle("Cipher Test");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
