package sample;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setTitle("Color Switch");
        Best b1;

        b1 = new Best(primaryStage);
        Group root = new Group(b1.mainMenu());
        primaryStage.setScene(new Scene(root, 400, 575, Color.RED));
        new Best(primaryStage);
        primaryStage.show();

    }


    public static void main(String[] args) {
        launch(args);
        //Best b = new Best(primaryStage);
        //b.startGame();


    }
}

class Best implements EventHandler<ActionEvent> {
    Stage window;

    Best(Stage primaryStage) {
        window = primaryStage;
    }
    Button button1;
    Button button2;
    Button button3;

    void startGame() {

        runGame game = new runGame();
        game.displayScreen();

    }

    VBox mainMenu(){
        button1 = new Button("Start Game");
        button1.setOnAction(this);
        button2 = new Button("Load Game");
        button2.setOnAction(this);
        button3 = new Button("Exit Game");
        button3.setOnAction(this);
        VBox vBox = new VBox(10,button1,button2,button3);
        vBox.setAlignment(Pos.CENTER);
        vBox.setPrefWidth(400);
        vBox.setPrefHeight(575);
        return vBox;

        };


    @Override
    public void handle(ActionEvent actionEvent) {
        if (actionEvent.getSource() == button1) {
            startGame();
        }


        if (actionEvent.getSource() == button2) System.out.println("Game Loaded");
        if (actionEvent.getSource() == button3) {
            Platform.exit();
            System.exit(0);
        }



    }

}

class runGame {
    Ball ball;
    int totalStar;
    int currStar;
    ArrayList<OP> gameData;

    void displayScreen() {
        ball.position();
    }

}

interface OP {
    void touch();
    void display();
}

class Ball {
    Circle position() {
        return new Circle(100, 60, 10);
    }

}

class Star implements OP {

    Star() {

    }
    private float xPosition;
    private float yPosition;
    private Color color;

    public float getxPosition() {
        return xPosition;
    }

    public void setxPosition(float xPosition) {
        this.xPosition = xPosition;
    }

    public float getyPosition() {
        return yPosition;
    }

    public void setyPosition(float yPosition) {
        this.yPosition = yPosition;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public void touch() {
        destroyStar();
    }

    private void destroyStar() {

    }

    @Override
    public void display() {

    }
}

abstract class Shapes {
    float xPosition;
    float yPosition;
    Color color;
    float speed;
    float angle;

    abstract void create();
}

class line extends Shapes {

    @Override
    void create() {
        Line line = new Line();
        line.setStroke(Color.RED);



    }
}

class curve extends Shapes {

    @Override
    void create() {

    }
}

abstract class obstacle {
    private float xPosition;
    private float yPosition;
    ArrayList<Shapes> shapes;

    public float getxPosition() {
        return xPosition;
    }

    public void setxPosition(float xPosition) {
        this.xPosition = xPosition;
    }

    public float getyPosition() {
        return yPosition;
    }

    public void setyPosition(float yPosition) {
        this.yPosition = yPosition;
    }
    abstract void display();
    abstract void makeObstacle();

}

class lineObstacle extends obstacle {



    @Override
    void display() {

    }

    @Override
    void makeObstacle() {
        line l1 = new line();


    }
}