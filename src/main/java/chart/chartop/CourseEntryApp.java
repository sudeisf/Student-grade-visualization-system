
package chart.chartop;


import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class CourseEntryApp extends Application {


    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(CourseEntryApp.class.getResource("register2.fxml"));

        Scene scene = new Scene(fxmlLoader.load(), 1200, 810);
        stage.setTitle("Course Adding");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}

