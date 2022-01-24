package com.metre.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;


import java.net.URL;
import java.util.ResourceBundle;

public class TelaController implements Initializable {

    String sexo;

    @FXML
    public TextField txtNome, txtIdade, txtUsuario;
    @FXML
    public PasswordField txtSenha;
    @FXML
    public Button btnSalvar;
    @FXML
    public DatePicker data;
    @FXML
    public Label lblResultados;
    @FXML
    public CheckBox checkM, checkF;
    @FXML
    public ComboBox comboFuncao;

    private ObservableList Funcoes = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Funcoes.add("Gerência");
        Funcoes.add("Administrativo");
        Funcoes.add("Operacional");

        comboFuncao.setItems(Funcoes);
    }

    @FXML
    private void captureInfo(ActionEvent event) {

        lblResultados.setText(
                "Nome " + txtNome.getText() + "\n" +
                "Idade: " + txtIdade.getText() + "\n" +
                "Função: " + comboFuncao.getValue() + "\n" +
                "Data Nascimento: " + data.getValue() + "\n" +
                "Sexo: " + sexoFuncionario() + "\n" +
                "Usuario: " + txtUsuario.getText() + "\n" +
                "Senha: " + txtSenha.getText() + "\n"
        );
    }

    private String sexoFuncionario(){
        if (checkF.isSelected() && !checkM.isSelected()){
            return sexo = "Feminino";
        } if (!checkF.isSelected() && checkM.isSelected()) {
            return sexo = "Masculino";
        } if (checkF.isSelected() && checkM.isSelected()){
            return "Selecione apenas UMA opção";
        }
        else {
            return "Selecione uma opção";
        }
    }
}
