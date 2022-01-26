package com.metre.app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {

    private static Stage stage;
    private static Scene cena;
    private static Scene cadastro;

    @Override
    public void start(Stage primaryStage) throws Exception {
        stage = primaryStage;

        primaryStage.setTitle("PROGRAMA DO ARTHUR");

        Parent fxmlMain = FXMLLoader.load(getClass().getResource("/fxml/WelcomeFXML.fxml"));
        cena = new Scene(fxmlMain);
        Parent fxmlCadastro = FXMLLoader.load(getClass().getResource("/fxml/TelaFXML.fxml"));
        cadastro = new Scene(fxmlCadastro);

        primaryStage.setScene(cena);
        primaryStage.show();
    }

    public static void changeScreen(String scr){
        switch (scr){
            case "cena":
                stage.setScene(cena);
                break;
            case "cadastro":
                stage.setScene(cadastro);
        }
    }

    public static void main(String[] args)  {
        try {
            Class.forName("org.mariadb.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        launch(args);
    }
}
