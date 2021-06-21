package View;

import Controller.LogInViewController;
import Main.Main;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class LogInView extends VBox {

    private Label logInLabel;
    private Label usernameLabel;
    private Label passwordLabel;

    private TextField usernameTextField;
    private PasswordField passwordField;

    private Button logInButton;
    private Button registerButton;

    public LogInView()
    {
        init();
        addElements();
        initListeners();
    }

    private void init()
    {
        logInLabel = new Label("Log in");
        usernameLabel = new Label("Username");
        passwordLabel = new Label("Password");

        usernameTextField = new TextField();
        usernameTextField.setPromptText("username");
        usernameTextField.setMaxWidth(200);
        passwordField = new PasswordField();
        passwordField.setPromptText("password");
        passwordField.setMaxWidth(200);

        logInButton = new Button("Log in");
        registerButton = new Button("Register");
    }

    private void addElements()
    {
        HBox hBox = new HBox();

        hBox.setAlignment(Pos.CENTER);
        hBox.setSpacing(10);

        hBox.getChildren().addAll(logInButton, registerButton);

        this.setAlignment(Pos.CENTER);
        this.setPadding(new Insets(10));
        this.setSpacing(10);

        this.getChildren().addAll(logInLabel, usernameLabel, usernameTextField, passwordLabel, passwordField, hBox);
    }

    private void initListeners()
    {
        logInButton.setOnAction(new LogInViewController(this));
        registerButton.setOnAction(e -> Main.mainStage.setScene(new RegisterView().makeScene()));

        Main.mainStage.show();
    }

    public Scene makeScene()
    {
        return new Scene(this, 500, 500);
    }

    public TextField getUsernameTextField() {
        return usernameTextField;
    }

    public PasswordField getPasswordField() {
        return passwordField;
    }
}
