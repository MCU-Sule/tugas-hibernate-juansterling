package com.example.PT08_2072009.Controller;

import com.example.PT08_2072009.Dao.UserDao;
import com.example.PT08_2072009.Model.User;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;

public class UserController {
    public TextField txtUserName;
    public TextField txtPassword;

    public void submit(){
        UserDao dao = new UserDao();
        if (txtUserName.getText() != null && txtPassword.getText() != null) {
            User u = new User();
            u.setIdUser(0);
            u.setUserName(txtUserName.getText());
            u.setUserPassword(txtPassword.getText());
            dao.addData(u);
            txtUserName.getScene().getWindow().hide();
        } else {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Please Fill all the field", new ButtonType[]{ButtonType.OK});
            alert.showAndWait();
        }
    }
}
