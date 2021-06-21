package View;

import Controller.LogInViewController;
import Controller.RegisterViewController;
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

public class RegisterView extends VBox {

    private Label RegisterLabel;
    private Label nameLabel;
    private Label emailLabel;
    private Label usernameLabel;
    private Label passwordLabel;

    private TextField nameTextField;
    private TextField emailTextField;
    private TextField usernameTextField;
    private PasswordField passwordField;

    private Button logInButton;
    private Button registerButton;

    public RegisterView()
    {
        init();
        addElements();
        initListeners();
    }

    private void init()
    {
        RegisterLabel = new Label("Register");
        nameLabel = new Label("Name");
        emailLabel = new Label("Email");
        usernameLabel = new Label("Username");
        passwordLabel = new Label("Password");

        nameTextField = new TextField();
        nameTextField.setPromptText("name");
        nameTextField.setMaxWidth(200);
        emailTextField = new TextField();
        emailTextField.setPromptText("email");
        emailTextField.setMaxWidth(200);
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

        hBox.getChildren().addAll(registerButton, logInButton);

        this.setAlignment(Pos.CENTER);
        this.setPadding(new Insets(10));
        this.setSpacing(10);

        this.getChildren().addAll(RegisterLabel, nameLabel, nameTextField, emailLabel, emailTextField, usernameLabel, usernameTextField, passwordLabel, passwordField, hBox);
    }

    private void initListeners()
    {
        registerButton.setOnAction(new RegisterViewController(this));

        logInButton.setOnAction(e -> Main.mainStage.setScene(new LogInView().makeScene()));
    }

    public Scene makeScene()
    {
        return new Scene(this, 500, 500);
    }

    public TextField getNameTextField() {
        return nameTextField;
    }

    public TextField getEmailTextField() {
        return emailTextField;
    }

    public TextField getUsernameTextField() {
        return usernameTextField;
    }

    public PasswordField getPasswordField() {
        return passwordField;
    }
}
