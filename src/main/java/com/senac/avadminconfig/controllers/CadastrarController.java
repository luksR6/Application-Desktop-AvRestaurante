package com.senac.avadminconfig.controllers;

import com.senac.Utils.JPAUtils;
import com.senac.avadminconfig.model.DAO.UsuarioDAO;
import com.senac.avadminconfig.model.Usuario;
import jakarta.persistence.EntityManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class CadastrarController {

    @FXML
    private TextField txtNome;
    @FXML
    private TextField txtEmail;
    @FXML
    private PasswordField txtSenha;

    @FXML private TextField txtCpf;

    @FXML
    public void salvar(ActionEvent event) {

        String nome = txtNome.getText();
        String email = txtEmail.getText();
        String senha = txtSenha.getText();
        String cpf = txtCpf.getText();



        if (nome.isEmpty() || email.isEmpty() || senha.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.WARNING, "Por favor, preencha todos os campos obrigatórios.");
            alert.showAndWait();
            return;
        }

        Usuario novoUsuario = new Usuario();
        novoUsuario.setNome(nome);
        novoUsuario.setEmail(email);
        novoUsuario.setSenha(senha);
        novoUsuario.setCpf(cpf);
        novoUsuario.setRole("ROLE_ADMIN_NORMAL");

        try {
            EntityManager em = JPAUtils.getEntityManager();
            UsuarioDAO usuarioDAO = new UsuarioDAO(em);
            usuarioDAO.salvar(novoUsuario);
            em.close();

            showAlert(Alert.AlertType.INFORMATION, "Sucesso", "Administrador cadastrado com sucesso!");
            limparCampos();

        } catch (Exception e) {
            e.printStackTrace();
            showAlert(Alert.AlertType.ERROR, "Erro no Banco de Dados", "Ocorreu um erro ao salvar o administrador.");
        }
    }

    @FXML
    void voltar(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/senac/avadminconfig/menu-view.fxml"));
        Scene scene = new Scene(loader.load());
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    private void showAlert(Alert.AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    private void limparCampos() {
        txtNome.clear();
        txtEmail.clear();
        txtSenha.clear();
        txtCpf.clear();
    }
}