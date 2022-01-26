package com.metre.controller;

import com.metre.app.App;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class TelaController implements Initializable {

    @FXML
    public TextField txtNome, txtIdade, txtUsuario;
    @FXML
    public PasswordField txtSenha;
    @FXML
    public Button btnSalvar, btnVoltar;
    @FXML
    public DatePicker data;
    @FXML
    public CheckBox checkM, checkF;
    @FXML
    public ComboBox comboFuncao;
    @FXML
    public TextArea txtListagem;

    private ObservableList Funcoes = FXCollections.observableArrayList();
    Connection connection = null;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Funcoes.add("Gerência");
        Funcoes.add("Administrativo");
        Funcoes.add("Operacional");
        comboFuncao.setItems(Funcoes);

        try {
            connection = DriverManager.getConnection("jdbc:mariadb://localhost:3307/arthurTeste?user=metre&password=durama@357");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void captureInfo(ActionEvent event) {
        try {
            PreparedStatement stms = connection.prepareStatement("INSERT INTO pessoa (nome, idade, funcao, dt_nasc, sexo, user, password)  VALUES(?, ?, ?, ?, ?, ? , ?);");
            stms.setString(1, txtNome.getText());
            stms.setInt(2, Integer.parseInt(txtIdade.getText()));
            stms.setString(3, comboFuncao.getValue().toString());
            stms.setDate(4, Date.valueOf(data.getValue()));
            stms.setString(5, sexoFuncionario());
            stms.setString(6, txtUsuario.getText());
            stms.setString(7, txtSenha.getText());
            int registrosAfetados = stms.executeUpdate();
            System.out.println(registrosAfetados);
            stms.close();
        } catch (Exception e) {

        }
    }

    @FXML
    private void listInfo(ActionEvent event) {
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("select * from pessoa");
            while (rs.next()) {
                txtListagem.setText(txtListagem.getText() + "" + rs.getInt(1) + " - " + rs.getString(2)
                        + " " + rs.getInt(3) + ", Cargo: " + rs.getString(4) + " " + rs.getDate(5)
                        + " " + rs.getString(6) + " " + rs.getString(7) + " "
                        + rs.getString(8) + "\n");
            }
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String sexoFuncionario() {
        if (checkF.isSelected() && !checkM.isSelected()) {
            return "Feminino";
        } else {
            return "Masculino";
        }
    }

    @FXML
    private void onMaculino(ActionEvent event) {
        if (checkM.isSelected()) {
            checkF.setSelected(false);
        } else
            checkF.setSelected(true);
    }

    @FXML
    private void onFeminino(ActionEvent event) {
        if (checkF.isSelected()) {
            checkM.setSelected(false);
        } else
            checkM.setSelected(true);
    }

    @FXML
    public void voltarTela(ActionEvent event) {
        App.changeScreen("cena");
    }
}