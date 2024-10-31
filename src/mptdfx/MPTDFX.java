
package mptdfx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class MPTDFX extends Application {

   private static Stage primaryStage;

    @Override
    public void start(Stage stage) throws Exception {
        primaryStage = stage;
        showView("Vista1.fxml");
    }

    public static void showView(String fxml) throws Exception {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(MPTDFX.class.getResource("/VISTAS/" + fxml));
        Pane ventana = (Pane) loader.load();
        Scene scene = new Scene(ventana);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
