package sample;

import javafx.animation.Interpolator;
import javafx.animation.RotateTransition;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
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
        primaryStage.setScene(new Scene(root, 400, 750, Color.rgb(39,39,39)));
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
        imageView.setFitHeight(200);
        imageView.setFitWidth(350);


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
        rotate.setDuration(Duration.millis(11000));
        rotate.setAutoReverse(false);



        RotateTransition rotate1 = new RotateTransition();
        rotate1.setAxis(Rotate.Z_AXIS);
        rotate1.setToAngle(-720);
        rotate1.setCycleCount(Timeline.INDEFINITE);
        rotate1.setDuration(Duration.millis(11000));
        rotate1.setAutoReverse(false);

        RotateTransition rotate2 = new RotateTransition();
        rotate2.setAxis(Rotate.Z_AXIS);
        rotate2.setToAngle(720);
        rotate2.setCycleCount(Timeline.INDEFINITE);
        rotate2.setDuration(Duration.millis(11000));
        rotate2.setAutoReverse(false);

        RotateTransition rotate3 = new RotateTransition();
        rotate3.setAxis(Rotate.Z_AXIS);
        rotate3.setToAngle(720);
        rotate3.setCycleCount(Timeline.INDEFINITE);
        rotate3.setDuration(Duration.millis(11000));
        rotate3.setAutoReverse(false);

        RotateTransition rotate4 = new RotateTransition();
        rotate4.setAxis(Rotate.Z_AXIS);
        rotate4.setToAngle(-720);
        rotate4.setCycleCount(Timeline.INDEFINITE);
        rotate4.setDuration(Duration.millis(11000));
        rotate4.setAutoReverse(false);


        Group lineobstacle1 = new Group();
        Group groupcircleobstacle = new Group();
        Group arccircle1 = new Group();
        Group arccircle2 = new Group();
        Group arccircle3 = new Group();
        Group lineobstacle = new Group();
        Group rectangleline =new Group();
        Group rectangleline1 =new Group();
        Group rectangleline2 =new Group();
        Group movingline1 =new Group();
        Group movingline2 =new Group();
        Group trianglegroup =new Group();


        Line line1 = new Line();
        Line line2 = new Line();
        Line line3 = new Line();
        Line line4 = new Line();


        line1.setStartX(100);
        line1.setStartY(0);
        line2.setStartX(100);
        line2.setStartY(0);
        line3.setStartX(100);
        line3.setStartY(0);
        line4.setStartX(100);
        line4.setStartY(0);

        line1.setEndX(150);
        line1.setEndY(0);
        line2.setEndX(100);
        line2.setEndY(50);
        line3.setEndX(50);
        line3.setEndY(0);
        line4.setEndX(100);
        line4.setEndY(-50);

        line3.setStroke(Color.rgb(250, 225, 0));
        line2.setStroke(Color.rgb(144, 13, 255));
        line1.setStroke(Color.rgb(255, 1, 129));
        line4.setStroke(Color.rgb(50, 219, 240));
        line1.setStrokeWidth(15);
        line2.setStrokeWidth(15);
        line3.setStrokeWidth(15);
        line4.setStrokeWidth(15);

        lineobstacle1.getChildren().addAll(line1,line2,line3,line4);

        Line line5 = new Line();
        Line line6 = new Line();
        Line line7 = new Line();
        Line line8 = new Line();

        line5.setStartX(0.0);
        line5.setStartY(0.0);
        line6.setStartX(0.0);
        line6.setStartY(0.0);
        line7.setStartX(0.0);
        line7.setStartY(0.0);
        line8.setStartX(0.0);
        line8.setStartY(0.0);
        line5.setEndX(50.0);
        line5.setEndY(0.0);
        line6.setEndX(0.0);
        line6.setEndY(50.0);
        line7.setEndX(-50.0);
        line7.setEndY(0.0);
        line8.setEndX(0.0);
        line8.setEndY(-50.0);
        line5.setStroke(Color.rgb(250, 225, 0));
        line6.setStroke(Color.rgb(144, 13, 255));
        line7.setStroke(Color.rgb(255, 1, 129));
        line8.setStroke(Color.rgb(50, 219, 240));
        line5.setStrokeWidth(15);
        line6.setStrokeWidth(15);
        line7.setStrokeWidth(15);
        line8.setStrokeWidth(15);

        lineobstacle.getChildren().addAll(line5,line6,line7,line8);

        Pane canvas = new Pane();
        lineobstacle.relocate(110, 0);
        lineobstacle1.relocate(220,0);
        canvas.getChildren().addAll(lineobstacle1,lineobstacle);

        Line liner1 = new Line();
        Line liner2 = new Line();
        Line liner3 = new Line();
        Line liner4 = new Line();


        liner1.setStartX(100);
        liner1.setStartY(100);
        liner2.setStartX(100);
        liner2.setStartY(-100);
        liner3.setStartX(-100);
        liner3.setStartY(-100);
        liner4.setStartX(-100);
        liner4.setStartY(100);

        liner1.setEndX(100);
        liner1.setEndY(-100);
        liner2.setEndX(-100);
        liner2.setEndY(-100);
        liner3.setEndX(-100);
        liner3.setEndY(100);
        liner4.setEndX(100);
        liner4.setEndY(100);

        liner1.setStroke(Color.rgb(250, 225, 0));
        liner2.setStroke(Color.rgb(144, 13, 255));
        liner3.setStroke(Color.rgb(255, 1, 129));
        liner4.setStroke(Color.rgb(50, 219, 240));
        liner1.setStrokeWidth(15);
        liner2.setStrokeWidth(15);
        liner3.setStrokeWidth(15);
        liner4.setStrokeWidth(15);

        rectangleline1.getChildren().addAll(liner1,liner2,liner3,liner4);


        Line liner5 = new Line();
        Line liner6 = new Line();
        Line liner7 = new Line();
        Line liner8 = new Line();


        liner5.setStartX(70);
        liner5.setStartY(70);
        liner6.setStartX(70);
        liner6.setStartY(-70);
        liner7.setStartX(-70);
        liner7.setStartY(-70);
        liner8.setStartX(-70);
        liner8.setStartY(70);

        liner5.setEndX(70);
        liner5.setEndY(-70);
        liner6.setEndX(-70);
        liner6.setEndY(-70);
        liner7.setEndX(-70);
        liner7.setEndY(70);
        liner8.setEndX(70);
        liner8.setEndY(70);

        liner5.setStroke(Color.rgb(250, 225, 0));
        liner6.setStroke(Color.rgb(144, 13, 255));
        liner7.setStroke(Color.rgb(255, 1, 129));
        liner8.setStroke(Color.rgb(50, 219, 240));
        liner5.setStrokeWidth(15);
        liner6.setStrokeWidth(15);
        liner7.setStrokeWidth(15);
        liner8.setStrokeWidth(15);

        rectangleline2.getChildren().addAll(liner5,liner6,liner7,liner8);
        Pane canvasrectangleobstacle = new Pane();
        rectangleline1.relocate(140, 0);
        rectangleline2.relocate(170,30);
        canvasrectangleobstacle.getChildren().addAll(rectangleline1,rectangleline2);



        Line linemov1 = new Line();
        Line linemov2  = new Line();
        Line linemov3  = new Line();
        Line linemov4 = new Line();
        Line linemov0  = new Line();
        Line linemov01 = new Line();
        Line linemov02  = new Line();
        Line linemov03 = new Line();

        linemov03.setStartX(-490);
        linemov03.setStartY(50);
        linemov02.setStartX(-380);
        linemov02.setStartY(50);
        linemov0.setStartX(-270);
        linemov0.setStartY(50);
        linemov01.setStartX(-160);
        linemov01.setStartY(50);
        linemov1.setStartX(-50);
        linemov1.setStartY(50);
        linemov2.setStartX(60);
        linemov2.setStartY(50);
        linemov3.setStartX(170);
        linemov3.setStartY(50);
        linemov4.setStartX(280);
        linemov4.setStartY(50);

        linemov03.setEndX(-490);
        linemov03.setEndY(-50);
        linemov02.setEndX(-380);
        linemov02.setEndY(-50);
        linemov0.setEndX(-270);
        linemov0.setEndY(-50);
        linemov01.setEndX(-160);
        linemov01.setEndY(-50);
        linemov1.setEndX(-50);
        linemov1.setEndY(-50);
        linemov2.setEndX(60);
        linemov2.setEndY(-50);
        linemov3.setEndX(170);
        linemov3.setEndY(-50);
        linemov4.setEndX(280);
        linemov4.setEndY(-50);

        linemov3.setStroke(Color.rgb(250, 225, 0));
        linemov02.setStroke(Color.rgb(144, 13, 255));
        linemov0.setStroke(Color.rgb(255, 1, 129));
        linemov01.setStroke(Color.rgb(50, 219, 240));
        linemov1.setStroke(Color.rgb(250, 225, 0));
        linemov2.setStroke(Color.rgb(144, 13, 255));
        linemov3.setStroke(Color.rgb(255, 1, 129));
        linemov4.setStroke(Color.rgb(50, 219, 240));
        linemov1.setStrokeWidth(15);
        linemov2.setStrokeWidth(15);
        linemov3.setStrokeWidth(15);
        linemov4.setStrokeWidth(15);
        linemov0.setStrokeWidth(15);
        linemov01.setStrokeWidth(15);
        linemov02.setStrokeWidth(15);
        linemov03.setStrokeWidth(15);

        Line linemov11 = new Line();
        Line linemov12  = new Line();
        Line linemov13  = new Line();
        Line linemov14 = new Line();
        Line linemov10  = new Line();
        Line linemov101 = new Line();
        Line linemov102  = new Line();
        Line linemov103 = new Line();

        linemov103.setStartX(-490);
        linemov103.setStartY(25);
        linemov102.setStartX(-380);
        linemov102.setStartY(25);
        linemov10.setStartX(-270);
        linemov10.setStartY(25);
        linemov101.setStartX(-160);
        linemov101.setStartY(25);
        linemov11.setStartX(-50);
        linemov11.setStartY(25);
        linemov12.setStartX(60);
        linemov12.setStartY(25);
        linemov13.setStartX(170);
        linemov13.setStartY(25);
        linemov14.setStartX(280);
        linemov14.setStartY(25);

        linemov103.setEndX(-490);
        linemov103.setEndY(-25);
        linemov102.setEndX(-380);
        linemov102.setEndY(-25);
        linemov10.setEndX(-270);
        linemov10.setEndY(-25);
        linemov101.setEndX(-160);
        linemov101.setEndY(-25);
        linemov11.setEndX(-50);
        linemov11.setEndY(-25);
        linemov12.setEndX(60);
        linemov12.setEndY(-25);
        linemov13.setEndX(170);
        linemov13.setEndY(-25);
        linemov14.setEndX(280);
        linemov14.setEndY(-25);

        linemov103.setStroke(Color.rgb(250, 225, 0));
        linemov102.setStroke(Color.rgb(144, 13, 255));
        linemov10.setStroke(Color.rgb(255, 1, 129));
        linemov101.setStroke(Color.rgb(50, 219, 240));
        linemov11.setStroke(Color.rgb(250, 225, 0));
        linemov12.setStroke(Color.rgb(144, 13, 255));
        linemov13.setStroke(Color.rgb(255, 1, 129));
        linemov14.setStroke(Color.rgb(50, 219, 240));
        linemov11.setStrokeWidth(15);
        linemov12.setStrokeWidth(15);
        linemov13.setStrokeWidth(15);
        linemov14.setStrokeWidth(15);
        linemov10.setStrokeWidth(15);
        linemov101.setStrokeWidth(15);
        linemov102.setStrokeWidth(15);
        linemov103.setStrokeWidth(15);

        Pane movinglinescanvas = new Pane();
        linemov03.relocate(-430, 0);
        linemov02.relocate(-320, 0);
        linemov0.relocate(-210, 0);
        linemov01.relocate(-100, 0);
        linemov1.relocate(10, 0);
        linemov2.relocate(120, 0);
        linemov3.relocate(230, 0);
        linemov4.relocate(340, 0);


        linemov11.relocate(65, 25);
        linemov12.relocate(175, 25);
        linemov13.relocate(285, 25);
        linemov14.relocate(395, 25);
        linemov103.relocate(505, 25);
        linemov102.relocate(615, 25);
        linemov10.relocate(725, 25);
        linemov101.relocate(835, 25);

        movinglinescanvas.getChildren().addAll(linemov03,linemov103,linemov02,linemov102,linemov0,linemov10,linemov01,linemov101,linemov1,linemov11,linemov2,linemov12,linemov3,linemov13,linemov4,linemov14);

        TranslateTransition translate02 = new TranslateTransition();
        translate02.setByX(275);
        translate02.setDuration(Duration.millis(7000));
        translate02.setCycleCount(Timeline.INDEFINITE);
        translate02.setNode(linemov03);
        translate02.setAutoReverse(true);
        translate02.setInterpolator(Interpolator.LINEAR);
        translate02.play();

        TranslateTransition translate03 = new TranslateTransition();
        translate03.setByX(275);
        translate03.setDuration(Duration.millis(7000));
        translate03.setCycleCount(Timeline.INDEFINITE);
        translate03.setNode(linemov02);
        translate03.setAutoReverse(true);
        translate03.setInterpolator(Interpolator.LINEAR);
        translate03.play();

        TranslateTransition translate0 = new TranslateTransition();
        translate0.setByX(275);
        translate0.setDuration(Duration.millis(7000));
        translate0.setCycleCount(Timeline.INDEFINITE);
        translate0.setNode(linemov01);
        translate0.setAutoReverse(true);
        translate0.setInterpolator(Interpolator.LINEAR);
        translate0.play();

        TranslateTransition translate01 = new TranslateTransition();
        translate01.setByX(275);
        translate01.setDuration(Duration.millis(7000));
        translate01.setCycleCount(Timeline.INDEFINITE);
        translate01.setNode(linemov0);
        translate01.setAutoReverse(true);
        translate01.setInterpolator(Interpolator.LINEAR);
        translate01.play();

        TranslateTransition translate = new TranslateTransition();
        translate.setByX(275);
        translate.setDuration(Duration.millis(7000));
        translate.setCycleCount(Timeline.INDEFINITE);
        translate.setNode(linemov1);
        translate.setAutoReverse(true);
        translate.setInterpolator(Interpolator.LINEAR);
        translate.play();

        TranslateTransition translate1 = new TranslateTransition();
        translate1.setByX(275);
        translate1.setDuration(Duration.millis(7000));
        translate1.setCycleCount(Timeline.INDEFINITE);
        translate1.setNode(linemov2);
        translate1.setAutoReverse(true);
        translate1.setInterpolator(Interpolator.LINEAR);
        translate1.play();

        TranslateTransition translate3 = new TranslateTransition();
        translate3.setByX(275);
        translate3.setDuration(Duration.millis(7000));
        translate3.setCycleCount(Timeline.INDEFINITE);
        translate3.setNode(linemov3);
        translate3.setAutoReverse(true);
        translate3.setInterpolator(Interpolator.LINEAR);
        translate3.play();

        TranslateTransition translate4 = new TranslateTransition();
        translate4.setByX(275);
        translate4.setDuration(Duration.millis(7000));
        translate4.setCycleCount(Timeline.INDEFINITE);
        translate4.setNode(linemov4);
        translate4.setAutoReverse(true);
        translate4.setInterpolator(Interpolator.LINEAR);
        translate4.play();




       // translate1.play();
//        rotate2.setAxis(Rotate.Z_AXIS);
//        rotate2.setToAngle(720);
//        rotate2.setCycleCount(Timeline.INDEFINITE);
//        rotate2.setDuration(Duration.millis(11000));
//        rotate2.setAutoReverse(false);

        TranslateTransition translate102 = new TranslateTransition();
        translate102.setByX(-275);
        translate102.setDuration(Duration.millis(7000));
        translate102.setCycleCount(Timeline.INDEFINITE);
        translate102.setNode(linemov101);
        translate102.setAutoReverse(true);
        translate102.setInterpolator(Interpolator.LINEAR);
        translate102.play();

        TranslateTransition translate103 = new TranslateTransition();
        translate103.setByX(-275);
        translate103.setDuration(Duration.millis(7000));
        translate103.setCycleCount(Timeline.INDEFINITE);
        translate103.setNode(linemov102);
        translate103.setAutoReverse(true);
        translate103.setInterpolator(Interpolator.LINEAR);
        translate103.play();

        TranslateTransition translate10 = new TranslateTransition();
        translate10.setByX(-275);
        translate10.setDuration(Duration.millis(7000));
        translate10.setCycleCount(Timeline.INDEFINITE);
        translate10.setNode(linemov103);
        translate10.setAutoReverse(true);
        translate10.setInterpolator(Interpolator.LINEAR);
        translate10.play();

        TranslateTransition translate101 = new TranslateTransition();
        translate101.setByX(-275);
        translate101.setDuration(Duration.millis(7000));
        translate101.setCycleCount(Timeline.INDEFINITE);
        translate101.setNode(linemov10);
        translate101.setAutoReverse(true);
        translate101.setInterpolator(Interpolator.LINEAR);
        translate101.play();

        TranslateTransition translate12 = new TranslateTransition();
        translate12.setByX(-275);
        translate12.setDuration(Duration.millis(7000));
        translate12.setCycleCount(Timeline.INDEFINITE);
        translate12.setNode(linemov11);
        translate12.setAutoReverse(true);
        translate12.setInterpolator(Interpolator.LINEAR);
        translate12.play();

        TranslateTransition translate11 = new TranslateTransition();
        translate11.setByX(-275);
        translate11.setDuration(Duration.millis(7000));
        translate11.setCycleCount(Timeline.INDEFINITE);
        translate11.setNode(linemov12);
        translate11.setAutoReverse(true);
        translate11.setInterpolator(Interpolator.LINEAR);
        translate11.play();

        TranslateTransition translate13 = new TranslateTransition();
        translate13.setByX(-275);
        translate13.setDuration(Duration.millis(7000));
        translate13.setCycleCount(Timeline.INDEFINITE);
        translate13.setNode(linemov13);
        translate13.setAutoReverse(true);
        translate13.setInterpolator(Interpolator.LINEAR);
        translate13.play();

        TranslateTransition translate14 = new TranslateTransition();
        translate14.setByX(-275);
        translate14.setDuration(Duration.millis(7000));
        translate14.setCycleCount(Timeline.INDEFINITE);
        translate14.setNode(linemov14);
        translate14.setAutoReverse(true);
        translate14.setInterpolator(Interpolator.LINEAR);
        translate14.play();



        Line Triangleline1 = new Line();
        Line Triangleline2  = new Line();
        Line Triangleline3  = new Line();


        Triangleline1.setStartX(0);
        Triangleline1.setStartY(117.27);
        Triangleline2.setStartX(111);
        Triangleline2.setStartY(-75);
        Triangleline3.setStartX(-111);
        Triangleline3.setStartY(-75);

        Triangleline1.setEndX(111);
        Triangleline1.setEndY(-75);
        Triangleline2.setEndX(-111);
        Triangleline2.setEndY(-75);
        Triangleline3.setEndX(0);
        Triangleline3.setEndY(117.27);


        Triangleline1.setStroke(Color.rgb(144, 13, 255));
        Triangleline2.setStroke(Color.rgb(255, 1, 129));
        Triangleline3.setStroke(Color.rgb(50, 219, 240));

        Triangleline1.setStrokeWidth(15);
        Triangleline1.setStrokeLineCap(StrokeLineCap.ROUND);
        Triangleline2.setStrokeWidth(15);
        Triangleline2.setStrokeLineCap(StrokeLineCap.ROUND);
        Triangleline3.setStrokeWidth(15);
        Triangleline3.setStrokeLineCap(StrokeLineCap.ROUND);

        trianglegroup.getChildren().addAll(Triangleline1,Triangleline2,Triangleline3);

        RotateTransition rotatetriangle = new RotateTransition(Duration.seconds(11),trianglegroup);
        rotatetriangle.setAxis(Rotate.Z_AXIS);
        rotatetriangle.setToAngle(720);
        rotatetriangle.setCycleCount(Timeline.INDEFINITE);
        rotatetriangle.setDuration(Duration.millis(11000));
        rotatetriangle.setAutoReverse(false);
        rotatetriangle.setInterpolator(Interpolator.LINEAR);
        rotatetriangle.play();


        Line verticleline1 = new Line();
        Line verticleline2 = new Line();
        Line verticleline3  = new Line();
        Line verticleline4 = new Line();
        Line verticleline5 = new Line();
        Line verticleline6 = new Line();
        Line verticleline7  = new Line();
        Line verticleline8 = new Line();



        verticleline1.setStartX(0);
        verticleline1.setStartY(0);
        verticleline2.setStartX(100);
        verticleline2.setStartY(0);
        verticleline3.setStartX(200);
        verticleline3.setStartY(0);
        verticleline4.setStartX(300);
        verticleline4.setStartY(0);
        verticleline5.setStartX(0);
        verticleline5.setStartY(0);
        verticleline6.setStartX(-100);
        verticleline6.setStartY(0);
        verticleline7.setStartX(-200);
        verticleline7.setStartY(0);
        verticleline8.setStartX(-300);
        verticleline8.setStartY(0);

        verticleline1.setEndX(100);
        verticleline1.setEndY(0);
        verticleline2.setEndX(200);
        verticleline2.setEndY(0);
        verticleline3.setEndX(300);
        verticleline3.setEndY(0);
        verticleline4.setEndX(400);
        verticleline4.setEndY(0);
        verticleline5.setEndX(-100);
        verticleline5.setEndY(0);
        verticleline6.setEndX(-200);
        verticleline6.setEndY(0);
        verticleline7.setEndX(-300);
        verticleline7.setEndY(0);
        verticleline8.setEndX(-400);
        verticleline8.setEndY(0);

        verticleline1.setStroke(Color.rgb(250, 225, 0));
        verticleline2.setStroke(Color.rgb(144, 13, 255));
        verticleline3.setStroke(Color.rgb(255, 1, 129));
        verticleline4.setStroke(Color.rgb(50, 219, 240));
        verticleline8.setStroke(Color.rgb(250, 225, 0));
        verticleline7.setStroke(Color.rgb(144, 13, 255));
        verticleline6.setStroke(Color.rgb(255, 1, 129));
        verticleline5.setStroke(Color.rgb(50, 219, 240));

        verticleline1.setStrokeWidth(15);
        verticleline2.setStrokeWidth(15);
        verticleline3.setStrokeWidth(15);
        verticleline4.setStrokeWidth(15);
        verticleline5.setStrokeWidth(15);
        verticleline6.setStrokeWidth(15);
        verticleline7.setStrokeWidth(15);
        verticleline8.setStrokeWidth(15);

        Group  verticlelinegroup =new Group();
        Group  verticlelinegroup1 =new Group();

        verticlelinegroup.getChildren().addAll(verticleline1,verticleline2,verticleline3,verticleline4);
        verticlelinegroup1.getChildren().addAll(verticleline8,verticleline5,verticleline6,verticleline7);
        Pane verticlelinegroupcanvas = new Pane();
        verticlelinegroup.relocate(-300,0);
        verticlelinegroup1.relocate(100,0);

        verticlelinegroupcanvas.getChildren().addAll(verticlelinegroup,verticlelinegroup1);


        TranslateTransition verticlelinegrouptrans = new TranslateTransition();
        verticlelinegrouptrans.setByX(275);
        verticlelinegrouptrans.setDuration(Duration.millis(7000));
        verticlelinegrouptrans.setCycleCount(Timeline.INDEFINITE);
        verticlelinegrouptrans.setNode(verticlelinegroupcanvas);
        verticlelinegrouptrans.setAutoReverse(false);
        verticlelinegrouptrans.setInterpolator(Interpolator.LINEAR);
        verticlelinegrouptrans.play();



        Arc arc1 = new Arc();
        Arc arc2 = new Arc();
        Arc arc3 = new Arc();
        Arc arc4 = new Arc();

        Arc arc5 = new Arc();
        Arc arc6 = new Arc();
        Arc arc7 = new Arc();
        Arc arc8 = new Arc();

        Arc arc9 = new Arc();
        Arc arc10 = new Arc();
        Arc arc11 = new Arc();
        Arc arc12 = new Arc();

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
        arc5.setRadiusX(70.0f);
        arc5.setRadiusY(70.0f);
        arc5.setStartAngle(0.0f);
        arc5.setLength(80.0f);
        arc5.setType(ArcType.OPEN);
        arc5.setFill(null);
        arc5.setStroke(Color.rgb(250, 225, 0));
        arc5.setStrokeWidth(10);

        arc6.setCenterX(300.0f);
        arc6.setCenterY(150.0f);
        arc6.setRadiusX(70.0f);
        arc6.setRadiusY(70.0f);
        arc6.setStartAngle(90.0f);
        arc6.setLength(80.0f);
        arc6.setType(ArcType.OPEN);
        arc6.setFill(null);
        arc6.setStroke(Color.rgb(144, 13, 255));
        arc6.setStrokeWidth(10);

        arc7.setCenterX(300.0f);
        arc7.setCenterY(150.0f);
        arc7.setRadiusX(70.0f);
        arc7.setRadiusY(70.0f);
        arc7.setStartAngle(180.0f);
        arc7.setLength(80.0f);
        arc7.setType(ArcType.OPEN);
        arc7.setFill(null);
        arc7.setStroke(Color.rgb(255, 1, 129));
        arc7.setStrokeWidth(10);

        arc8.setCenterX(300.0f);
        arc8.setCenterY(150.0f);
        arc8.setRadiusX(70.0f);
        arc8.setRadiusY(70.0f);
        arc8.setStartAngle(270.0f);
        arc8.setLength(80.0f);
        arc8.setType(ArcType.OPEN);
        arc8.setFill(null);
        arc8.setStroke(Color.rgb(50, 219, 240));
        arc8.setStrokeWidth(10);

        arc9.setCenterX(300.0f);
        arc9.setCenterY(150.0f);
        arc9.setRadiusX(50.0f);
        arc9.setRadiusY(50.0f);
        arc9.setStartAngle(0.0f);
        arc9.setLength(80.0f);
        arc9.setType(ArcType.OPEN);
        arc9.setFill(null);
        arc9.setStroke(Color.rgb(250, 225, 0));
        arc9.setStrokeWidth(10);

        arc10.setCenterX(300.0f);
        arc10.setCenterY(150.0f);
        arc10.setRadiusX(50.0f);
        arc10.setRadiusY(50.0f);
        arc10.setStartAngle(90.0f);
        arc10.setLength(80.0f);
        arc10.setType(ArcType.OPEN);
        arc10.setFill(null);
        arc10.setStroke(Color.rgb(144, 13, 255));
        arc10.setStrokeWidth(10);

        arc11.setCenterX(300.0f);
        arc11.setCenterY(150.0f);
        arc11.setRadiusX(50.0f);
        arc11.setRadiusY(50.0f);
        arc11.setStartAngle(180.0f);
        arc11.setLength(80.0f);
        arc11.setType(ArcType.OPEN);
        arc11.setFill(null);
        arc11.setStroke(Color.rgb(255, 1, 129));
        arc11.setStrokeWidth(10);

        arc12.setCenterX(300.0f);
        arc12.setCenterY(150.0f);
        arc12.setRadiusX(50.0f);
        arc12.setRadiusY(50.0f);
        arc12.setStartAngle(270.0f);
        arc12.setLength(80.0f);
        arc12.setType(ArcType.OPEN);
        arc12.setFill(null);
        arc12.setStroke(Color.rgb(50, 219, 240));
        arc12.setStrokeWidth(10);

        Image imagemiddele = new Image(new FileInputStream("/Users/ajay/IdeaProjects/FINAL_PROJECT/Code/src/4.png"));
        ImageView imageView3 = new ImageView(imagemiddele);
        imageView3.setX(268.0f);
        imageView3.setY(119.0f);
        imageView3.setFitHeight(67);
        imageView3.setFitWidth(67);

        arccircle2.getChildren().addAll(arc5,arc6,arc7,arc8);
        arccircle1.getChildren().addAll(arc1,arc2,arc3,arc4);
        arccircle3.getChildren().addAll(arc9,arc10,arc11,arc12);
        groupcircleobstacle.getChildren().addAll(arccircle1,arccircle2,arccircle3,imageView3);


        rotate1.setNode(arccircle2);
        rotate.setNode(arccircle1);
        rotate2.setNode(lineobstacle1);
        rotate3.setNode(arccircle3);
        rotate4.setNode(lineobstacle);
        rotate1.setNode(rectangleline1);
        rotate.setNode(rectangleline2);
       rotatetriangle.setNode(trianglegroup);

    //    rotate4.setP

        rotate.setInterpolator(Interpolator.LINEAR);
        rotate1.setInterpolator(Interpolator.LINEAR);
        rotate2.setInterpolator(Interpolator.LINEAR);
        rotate3.setInterpolator(Interpolator.LINEAR);
        rotate4.setInterpolator(Interpolator.LINEAR);
        rotatetriangle.setInterpolator(Interpolator.LINEAR);

        rotate.play();
        rotate1.play();
        rotate2.play();
        rotate3.play();
        rotate4.play();
        rotatetriangle.play();
        //rotatetriangle.playFromStart();
        VBox vBox = new VBox(20,imageView,verticlelinegroupcanvas,trianglegroup);
        vBox.setAlignment(Pos.CENTER);
        vBox.setPrefWidth(450);
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