package Main;

import Model.Database;
import View.LogInView;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
    public static Stage mainStage;

    @Override
    public void start(Stage primaryStage) throws Exception {
        mainStage = primaryStage;
        mainStage.setTitle("Music store");
        mainStage.setScene(new LogInView().makeScene());
        mainStage.show();
        mainStage.setOnCloseRequest(e -> Database.getInstance().writeDatabasetoDisk());
    }

    public static void main(String[] args) {
        launch(args);
    }
}

