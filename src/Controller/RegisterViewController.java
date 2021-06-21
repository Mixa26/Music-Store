package Controller;

import Model.Database;
import Model.User;
import View.RegisterView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;

public class RegisterViewController implements EventHandler<ActionEvent> {
    private RegisterView registerView;

    public RegisterViewController(RegisterView registerView)
    {
        this.registerView = registerView;
    }

    @Override
    public void handle(ActionEvent event) {
        Database database = Database.getInstance();

        String name;
        String email;
        String username;
        String password;

        name = registerView.getNameTextField().getText();
        email = registerView.getEmailTextField().getText();
        username = registerView.getUsernameTextField().getText();
        password = registerView.getPasswordField().getText();

        if (name.isEmpty() || email.isEmpty() || username.isEmpty() || password.isEmpty())
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("One or more fields are empty.");
            alert.show();
        }
        else
        {
            if (database.userExists(username))
            {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Username already exists.");
                alert.show();
            }
            else
            {
                database.getUsers().add(new User(name, email, username, password));
                registerView.getNameTextField().clear();
                registerView.getEmailTextField().clear();
                registerView.getUsernameTextField().clear();
                registerView.getPasswordField().clear();
            }
        }
    }
}
