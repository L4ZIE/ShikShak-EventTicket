package gui.controller;

import be.Account;
import gui.model.AccountModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class loginViewController {

    private AccountModel accountModel;
    @FXML
    private TextField usernameFld;
    @FXML
    private PasswordField passwordFld;

    public loginViewController() {
        accountModel = new AccountModel();
    }

    public void login(ActionEvent event) {
        String username = usernameFld.getText();
        String password = passwordFld.getText();

        boolean isAuthenticated = accountModel.logInUser(username, password);

        if (isAuthenticated) {
            Account loggedInAccount = accountModel.getAccountByName(username);
            boolean isAdmin = false;
            if (loggedInAccount != null) {
                isAdmin = loggedInAccount.getAccountType();
            }
            openNextWindow(event, isAdmin);
        } else {
            displayLoginError();
        }
    }

    private void openNextWindow(ActionEvent event, boolean isAdmin) {
        try {
            String fxmlPath = isAdmin ? "/gui/view/admin.fxml" : "/gui/view/coordinator.fxml";
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPath));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();

            Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            currentStage.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void displayLoginError() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Login Error");
        alert.setHeaderText(null);
        alert.setContentText("Invalid username or password. Please try again.");
        alert.showAndWait();
    }

    public void closeWindow(ActionEvent event) {
        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        currentStage.close();
    }
}