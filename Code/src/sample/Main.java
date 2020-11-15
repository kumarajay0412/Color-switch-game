package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

import java.io.Serializable;
import java.util.ArrayList;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        //Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
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
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }


}

class runGame implements Serializable {
    Ball ball = new Ball();
    public int totalStar;
    public int currentStar;
    ArrayList<OP> gameData = new ArrayList<>();

    void start() {

    }
}

class Ball {

    private float yHieght;



}

interface OP {

}
