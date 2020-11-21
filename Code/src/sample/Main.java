package sample;

import javafx.animation.Interpolator;
import javafx.animation.RotateTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Translate;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.ImageView;
import javafx.util.Duration;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.io.FileInputStream;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setTitle("Color Switch");
        Best b1;

        b1 = new Best(primaryStage);
        Group root = new Group(b1.mainMenu());
        primaryStage.setScene(new Scene(root, 475, 750, Color.rgb(39,39,39)));
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
    private void movePivot(Node node, double x, double y){
        node.getTransforms().add(new Translate(-x,-y));
        node.setTranslateX(x); node.setTranslateY(y);
    }

    VBox mainMenu() throws FileNotFoundException {
        button1 = new Button("Start Game");
        button1.setOnAction(this);
        button2 = new Button("Load Game ");
        button2.setOnAction(this);
        button3 = new Button("Exit Game ");
        button3.setOnAction(this);
        button1.setStyle("-fx-background-radius: 15px; -fx-background-color: #a2d6a2;  -fx-font-size: 2em;");
        button2.setStyle("-fx-background-radius: 15px; -fx-background-color: #a2d6a2;  -fx-font-size: 2em;");
        button3.setStyle("-fx-background-radius: 15px; -fx-background-color: #a2d6a2;  -fx-font-size: 2em;");
        Image image = new Image(new FileInputStream("/Users/ajay/IdeaProjects/FINAL_PROJECT/Code/src/2.gif"));
        ImageView imageView = new ImageView(image);
        imageView.setX(25);
        imageView.setY(25);
        imageView.setFitHeight(220);
        imageView.setFitWidth(400);

        Image image1 = new Image(new FileInputStream("/Users/ajay/IdeaProjects/FINAL_PROJECT/Code/src/1.gif"));
        ImageView imageView1 = new ImageView(image1);
        imageView1.setX(25);
        imageView1.setY(25);
        imageView1.setFitHeight(200);
        imageView1.setFitWidth(200);

        Line line = new Line();
        line.setStartX(0.0);
        line.setStartY(0.0);
        line.setEndX(500.0);
        line.setEndY(150.0);
        line.setStroke(Color.RED);

        RotateTransition rotate = new RotateTransition();
        rotate.setAxis(Rotate.Z_AXIS);
        rotate.setToAngle(720);
        rotate.setCycleCount(Timeline.INDEFINITE);
        rotate.setDuration(Duration.millis(7000));
        line.setStrokeWidth(5);
        rotate.setAutoReverse(false);
        rotate.setNode(line);

        RotateTransition rotate1 = new RotateTransition();
        rotate1.setAxis(Rotate.Z_AXIS);
        rotate1.setToAngle(-720);
        rotate1.setCycleCount(Timeline.INDEFINITE);
        rotate1.setDuration(Duration.millis(8000));
        rotate1.setAutoReverse(false);
        rotate1.setNode(line);

        RotateTransition rotate2 = new RotateTransition();
        rotate2.setAxis(Rotate.Z_AXIS);
        rotate2.setToAngle(-720);
        rotate2.setCycleCount(Timeline.INDEFINITE);
        rotate2.setDuration(Duration.millis(8000));
        rotate2.setAutoReverse(false);
        rotate2.setNode(line);

        Group group = new Group();
        Group groupcircleobstacle = new Group();
        Group arccircle1 = new Group();
        Group arccircle2 = new Group();

        Line line1 = new Line();
        Line line2 = new Line();
        Line line3 = new Line();
        Line line4 = new Line();

        line1.setStartX(0.0);
        line1.setStartY(0.0);
        line2.setStartX(0.0);
        line2.setStartY(0.0);
        line3.setStartX(0.0);
        line3.setStartY(0.0);
        line4.setStartX(0.0);
        line4.setStartY(0.0);
        line1.setEndX(100.0);
        line1.setEndY(0.0);
        line2.setEndX(0.0);
        line2.setEndY(100.0);
        line3.setEndX(-100.0);
        line3.setEndY(0.0);
        line4.setEndX(0.0);
        line4.setEndY(-100.0);
        line1.setStroke(Color.SKYBLUE);
        line2.setStroke(Color.YELLOW);
        line3.setStroke(Color.INDIANRED);
        line4.setStroke(Color.WHITE);
        line1.setStrokeWidth(15);
        line2.setStrokeWidth(15);
        line3.setStrokeWidth(15);
        line4.setStrokeWidth(15);

        group.getChildren().addAll(line1, line2,line3,line4);


        Arc arc1 = new Arc();
        Arc arc2 = new Arc();
        Arc arc3 = new Arc();
        Arc arc4 = new Arc();

        Arc arc5 = new Arc();
        Arc arc6 = new Arc();
        Arc arc7 = new Arc();
        Arc arc8 = new Arc();

        arc1.setCenterX(300.0f);
        arc1.setCenterY(150.0f);
        arc1.setRadiusX(90.0f);
        arc1.setRadiusY(90.0f);
        arc1.setStartAngle(0.0f);
        arc1.setLength(80.0f);
        arc1.setType(ArcType.OPEN);
        arc1.setFill(null);
        arc1.setStroke(Color.rgb(250, 225, 0));
        arc1.setStrokeWidth(10);

        arc2.setCenterX(300.0f);
        arc2.setCenterY(150.0f);
        arc2.setRadiusX(90.0f);
        arc2.setRadiusY(90.0f);
        arc2.setStartAngle(90.0f);
        arc2.setLength(80.0f);
        arc2.setType(ArcType.OPEN);
        arc2.setFill(null);
        arc2.setStroke(Color.rgb(144, 13, 255));
        arc2.setStrokeWidth(10);

        arc3.setCenterX(300.0f);
        arc3.setCenterY(150.0f);
        arc3.setRadiusX(90.0f);
        arc3.setRadiusY(90.0f);
        arc3.setStartAngle(180.0f);
        arc3.setLength(80.0f);
        arc3.setType(ArcType.OPEN);
        arc3.setFill(null);
        arc3.setStroke(Color.rgb(255, 1, 129));
        arc3.setStrokeWidth(10);

        arc4.setCenterX(300.0f);
        arc4.setCenterY(150.0f);
        arc4.setRadiusX(90.0f);
        arc4.setRadiusY(90.0f);
        arc4.setStartAngle(270.0f);
        arc4.setLength(80.0f);
        arc4.setType(ArcType.OPEN);
        arc4.setFill(null);
        arc4.setStroke(Color.rgb(50, 219, 240));
        arc4.setStrokeWidth(10);

        arc5.setCenterX(300.0f);
        arc5.setCenterY(150.0f);
        arc5.setRadiusX(60.0f);
        arc5.setRadiusY(60.0f);
        arc5.setStartAngle(0.0f);
        arc5.setLength(80.0f);
        arc5.setType(ArcType.OPEN);
        arc5.setFill(null);
        arc5.setStroke(Color.rgb(250, 225, 0));
        arc5.setStrokeWidth(10);

        arc6.setCenterX(300.0f);
        arc6.setCenterY(150.0f);
        arc6.setRadiusX(60.0f);
        arc6.setRadiusY(60.0f);
        arc6.setStartAngle(90.0f);
        arc6.setLength(80.0f);
        arc6.setType(ArcType.OPEN);
        arc6.setFill(null);
        arc6.setStroke(Color.rgb(144, 13, 255));
        arc6.setStrokeWidth(10);

        arc7.setCenterX(300.0f);
        arc7.setCenterY(150.0f);
        arc7.setRadiusX(60.0f);
        arc7.setRadiusY(60.0f);
        arc7.setStartAngle(180.0f);
        arc7.setLength(80.0f);
        arc7.setType(ArcType.OPEN);
        arc7.setFill(null);
        arc7.setStroke(Color.rgb(255, 1, 129));
        arc7.setStrokeWidth(10);

        arc8.setCenterX(300.0f);
        arc8.setCenterY(150.0f);
        arc8.setRadiusX(60.0f);
        arc8.setRadiusY(60.0f);
        arc8.setStartAngle(270.0f);
        arc8.setLength(80.0f);
        arc8.setType(ArcType.OPEN);
        arc8.setFill(null);
        arc8.setStroke(Color.rgb(50, 219, 240));
        arc8.setStrokeWidth(10);

        arccircle2.getChildren().addAll(arc5,arc6,arc7,arc8);
        arccircle1.getChildren().addAll(arc1,arc2,arc3,arc4);
        groupcircleobstacle.getChildren().addAll(arccircle1,arccircle2);

        rotate1.setNode(arccircle2);
        rotate.setNode(arccircle1);
        rotate2.setNode(group);

        rotate.setInterpolator(Interpolator.LINEAR);
        rotate1.setInterpolator(Interpolator.LINEAR);
        rotate2.setInterpolator(Interpolator.LINEAR);

        rotate.play();
        rotate1.play();
        rotate.play();
        rotate2.play();


        VBox vBox = new VBox(10,imageView,button1,button2,button3,groupcircleobstacle,group);
        vBox.setAlignment(Pos.CENTER);
        vBox.setPrefWidth(500);
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