package classes_projet;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainApp extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Bon.fxml"));
        Parent root = loader.load();

        primaryStage.setTitle("Bon Interface");
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.show();
    }
}
