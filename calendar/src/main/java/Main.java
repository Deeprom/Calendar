import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader loader = new FXMLLoader();
        Parent root = FXMLLoader.load(getClass().getResource("Calendar.fxml"));

        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 635  , 435));
        primaryStage.show();



    }


    public static void main(String[] args) {
        launch(args);
    }
}
