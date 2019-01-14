package GUI.Managent;

import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;

public class app extends Application {
    private double xOffset = 0;
    private double yOffset = 0;
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        //todo: Hiển thị màn hình làm việc chính
        NewWin window = new NewWin();
        window.makeWindow(primaryStage, "ManagementFrame.fxml");
    }
}
