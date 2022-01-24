package com.metre.app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class App extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception {
        AnchorPane cena = FXMLLoader.load(getClass().getResource("/fxml/TelaFXML.fxml"));
        primaryStage.setScene(new Scene(cena));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
