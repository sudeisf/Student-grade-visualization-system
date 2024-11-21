package chart.chartop;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ChartDisplayApp extends Application {

    @Override
    public  void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(ChartDisplayApp.class.getResource("chart-display.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Chart Page");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}