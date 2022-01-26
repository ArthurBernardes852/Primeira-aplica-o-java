package com.metre.controller;

import com.metre.app.App;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.ResourceBundle;

public class WelcomeController implements Initializable {
    @FXML
    public Button btnEntrar, btnCadastrar;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML
    public void telaCadastro(ActionEvent event){
        App.changeScreen("cadastro");
    }
}
