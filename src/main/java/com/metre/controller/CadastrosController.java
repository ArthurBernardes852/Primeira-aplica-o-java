package com.metre.controller;

import com.metre.app.App;
import com.metre.model.DBConnector;
import com.metre.model.Pessoa;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.*;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CadastrosController implements Initializable {
    @FXML
    public TableView<Pessoa> tvPessoa = new TableView<>();
    @FXML
    public TableColumn<Pessoa, Integer> colId, colIdade;
    public TableColumn<Pessoa, String> colNome, colFuncao;
    public TableColumn<Pessoa, Date> colDt;

    public ObservableList<Pessoa> lista = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Connection con;
        try {
            con = DBConnector.getConnection();
            ResultSet rs = con.createStatement().executeQuery("select * from arthurteste.pessoa");
            while (rs.next()) {
                lista.add(new Pessoa(rs.getInt(1), rs.getString(2), rs.getInt(3),
                        rs.getString(4), rs.getDate(5)));
            }
        } catch (SQLException e) {
            Logger.getLogger(CadastrosController.class.getName()).log(Level.SEVERE, null, e);
        }

        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        colIdade.setCellValueFactory(new PropertyValueFactory<>("idade"));
        colFuncao.setCellValueFactory(new PropertyValueFactory<>("funcao"));
        colDt.setCellValueFactory(new PropertyValueFactory<>("dt_nasc"));

        tvPessoa.setItems(lista);
    }

    @FXML
    public void voltaMain(ActionEvent event) {
        App.changeScreen("cena");
    }
}
