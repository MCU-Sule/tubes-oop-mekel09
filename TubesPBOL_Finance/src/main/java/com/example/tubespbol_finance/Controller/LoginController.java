package com.example.tubespbol_finance.Controller;

import com.example.tubespbol_finance.DAO.UserDAO;
import com.example.tubespbol_finance.HelloApplication;
import com.example.tubespbol_finance.Model.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
//18720003-Edward Michael
//1872005-Michael Sebastian Gunadi
public class LoginController implements Initializable {

    public TextField tfUsername;
    public TextField tfPassword;
    public Button btnLogin;
    public Button btnBuatAkun;

    private UserDAO userDAO;
    private User user;

    public User getUser() {
        return user;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        userDAO = new UserDAO();
        user = new User();
    }

    public void btnLoginClicked(ActionEvent actionEvent) throws IOException {
        String username = tfUsername.getText();
        String password = tfPassword.getText();

        user.setUsername(username);
        user.setPassword(password);
        try {
            user = userDAO.fetchUser(user);
            if(user.getNama()!= null) {

                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(HelloApplication.class.getResource("pageHome.fxml"));
                loader.setResources(ResourceBundle.getBundle("bundle"));
                Parent root = loader.load();
                HomeController hc = loader.getController();
                hc.setLoginController(this);
                Stage homeStage = new Stage();
                homeStage.setTitle("my Finance");
                homeStage.setScene(new Scene(root));
                homeStage.initModality(Modality.APPLICATION_MODAL);
                homeStage.show();

//                FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("pageHome.fxml"));
//                Parent root = loader.load();
//                HomeController hc = loader.getController();
//                hc.setLoginController(this);
//                Stage homeStage = new Stage();
//                homeStage.setTitle("my Finance");
//                homeStage.setScene(new Scene(root));
//                homeStage.initModality(Modality.APPLICATION_MODAL);
//                homeStage.show();
            }
            else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Username dan password tidak sesuai");
                alert.showAndWait();
            }
        }  catch (SQLException exception) {
            exception.printStackTrace();
        }


    }

    public void btnBuatAkunCliocked(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("pageCreateUser.fxml"));
        Parent root = loader.load();
        CreateUserController cuc = loader.getController();
        Stage createuserStage = new Stage();
        createuserStage.setTitle("Buat Akun");
        createuserStage.setScene(new Scene(root));
        createuserStage.initModality(Modality.APPLICATION_MODAL);
        createuserStage.showAndWait();
    }


}