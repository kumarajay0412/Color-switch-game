package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        //Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Color Switch");
        //final Circle circ = new Circle(100, 60, 10);
        Best b1;
        b1 = new Best();
        Group root = new Group(b1.mainMenu());




        primaryStage.setScene(new Scene(root, 400, 575, Color.BLACK));
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

class Best{

    void startGame() {

    }

    VBox mainMenu(){
        Button button1 = new Button("Start Game");
        Button button2 = new Button("Load Game");
        VBox vBox = new VBox(button1, button2);
        vBox.setSpacing(10);
        vBox.setAlignment(Pos.CENTER_RIGHT);
        return vBox;
    }



}

class Ball {
    Circle position() {
        return new Circle(100, 60, 10);
    }

}