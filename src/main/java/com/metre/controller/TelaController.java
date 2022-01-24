package com.metre.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;


import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class TelaController implements Initializable {

    @FXML
    public TextField txtNome, txtIdade, txtUsuario;
    @FXML
    public PasswordField txtSenha;
    @FXML
    public Button btnSalvar;
    @FXML
    public ToggleButton botao2;
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

        try {
            Connection connection = DriverManager.getConnection("jdbc:mariadb://localhost:3307/arthurTeste?user=metre&password=durama@357");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void captureInfo(ActionEvent event) {

        lblResultados.setText("Nome " + txtNome.getText() + "\n" +
                "Idade: " + txtIdade.getText() + "\n" +
                "Função: " + comboFuncao.getValue() + "\n" +
                "Data Nascimento: " + data.getValue() + "\n" +
                "Sexo: " + sexoFuncionario() + "\n" +
                "Usuario: " + txtUsuario.getText() + "\n" +
                "Senha: " + txtSenha.getText() + "\n"
        );
    }

    private String sexoFuncionario() {
        if (checkF.isSelected() && !checkM.isSelected()) {
            return "Feminino";
        }
        if (!checkF.isSelected() && checkM.isSelected()) {
            return "Masculino";
        }
        if (checkF.isSelected() && checkM.isSelected()) {
            return "Selecione apenas UMA opção";
        } else {
            return "Selecione uma opção";
        }
    }

    @FXML
    private void mudaStatus(ActionEvent evento){
        if (botao2.isSelected()){
            botao2.setText("Ativo");
        } else {
            botao2.setText("Inativo");
        }
    }


}
