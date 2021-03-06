package javafxasync;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class JavaFXAsync extends Application {
    
    public static ObservableList<String> items = FXCollections.observableArrayList();

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("GridPane.fxml"));
        Scene scene = new Scene(root);
        
        stage.setTitle("Concurrency in JavaFX");
        stage.setScene(scene);
        stage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}
