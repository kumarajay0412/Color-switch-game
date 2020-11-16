package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
<<<<<<< Updated upstream
=======
        //Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Color Switch");
        final Circle circ = new Circle(100, 60, 10);
        final Group root = new Group(circ);
        primaryStage.setScene(new Scene(root, 400, 575, Color.BEIGE));
        primaryStage.show();
    }


    public static void main(String[] args) {
        System.out.println("op1");
        launch(args);
        System.out.println("op2");
        Best b = new Best();
        b.startGame();


    }
}

class Best extends Application {

    void startGame() {

    }



    @Override
    public void start(Stage primaryStage) throws Exception {
>>>>>>> Stashed changes
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Color switch");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
