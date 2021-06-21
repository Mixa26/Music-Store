package Controller;

import Main.Main;
import Model.Database;
import Model.GlobalStore;
import Model.User;
import View.LogInView;
import View.MainWindow;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;

import java.util.Optional;

public class LogInViewController implements EventHandler<ActionEvent> {
    private final LogInView logInView;
    public LogInViewController(LogInView logInView)
    {
        this.logInView = logInView;
    }

    @Override
    public void handle(ActionEvent event) {
        Database database = Database.getInstance();

        String username = logInView.getUsernameTextField().getText();
        String password = logInView.getPasswordField().getText();

        if (database.userExists(username))
        {
            Optional<User> optionalUser = database.verifyUser(username, password);
            if (optionalUser.isPresent())
            {
                GlobalStore globalStore = GlobalStore.getInstance();
                globalStore.setCurrentlyLogedIn(optionalUser.get());
                Main.mainStage.setScene(MainWindow.getInstance().makeScene());
                Main.mainStage.show();
            }
            else
            {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Wrong password");
                alert.show();
            }
        }
        else
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("User unknown");
            alert.show();
        }

    }
}
