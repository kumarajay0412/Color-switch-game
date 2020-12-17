package sample;

import javafx.animation.RotateTransition;
import javafx.animation.Timeline;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.text.*;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

class exitPage {
    ArrayList<Integer> op = new ArrayList<>();

    VBox goodgame(String score) throws FileNotFoundException {
        Line textArea = new Line();
        textArea.setStartX(0.0);
        textArea.setStartY(0.0);
        textArea.setEndX(500.0);
        textArea.setEndY(0);
        textArea.setStroke(Color.rgb(221, 136, 39));
        textArea.setStrokeWidth(80);

        Text text = new Text("             SCORE    ");
        text.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 40));
        text.setTextAlignment(TextAlignment.CENTER);
        Group stack =new Group();
        stack.getChildren().addAll(textArea, text);


        Image image = new Image(new FileInputStream("/Users/robinkumar/IdeaProjects/FINAL_PROJECT/Code/src/2.gif"));
        ImageView imageView = new ImageView(image);
        imageView.setFitHeight(200);
        imageView.setFitWidth(350);
        Pane colorswitch = new Pane();
        imageView.relocate(40, 0);
        colorswitch.getChildren().addAll(imageView);

        Line textArea1 = new Line();
        textArea1.setStartX(0.0);
        textArea1.setStartY(0.0);
        textArea1.setEndX(500.0);
        textArea1.setEndY(0);
        textArea1.setStroke(Color.rgb(221, 136, 39));
        textArea1.setStrokeWidth(80);

        Text text1 = new Text(score);
        text1.setFont(Font.font ("Verdana", 40));
        text1.setFill(Color.WHITE);

        Pane canvas122 = new Pane();
        text1.relocate(180, 0);
        canvas122.getChildren().addAll(text1);
        int i=Integer.parseInt(score);
        op.add(i);
        int max;
        max=op.get(0);
        for(int h: op) {
            if(h>max) {
                max=h;
            }
        }


        Text text2 = new Text("        BEST SCORE   ");
        text2.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 40));
        text2.setTextAlignment(TextAlignment.JUSTIFY);


        Group stack2 =new Group();
        stack2.getChildren().addAll(textArea1, text2);
        stack2.setTranslateY(20);

        Text text3 = new Text(String.valueOf(max));
        text3.setFont(Font.font ("Verdana", 40));
        text3.setFill(Color.WHITE);

        Pane canvas121 = new Pane();
        text3.relocate(180, 0);
        canvas121.getChildren().addAll(text3);
        canvas121.setTranslateY(0);

        Image imagestar1 = new Image(new FileInputStream("/Users/robinkumar/IdeaProjects/FINAL_PROJECT/Code/src/stars.png"));
        ImageView imagestar= new ImageView(imagestar1);
        imagestar.setFitHeight(70);
        imagestar.setFitWidth(140);

        Image imagestar21 = new Image(new FileInputStream("/Users/robinkumar/IdeaProjects/FINAL_PROJECT/Code/src/home.png"));
        ImageView home1= new ImageView(imagestar21);
        home1.setFitHeight(100);
        home1.setFitWidth(100);

        Image image111 = new Image(new FileInputStream("/Users/robinkumar/IdeaProjects/FINAL_PROJECT/Code/src/repeat.png"));
        ImageView imagerepeat= new ImageView(image111);
        imagerepeat.setFitHeight(100);
        imagerepeat.setFitWidth(100);

        Text text4 = new Text("50 ");
        text4.setFont(Font.font ("Verdana", 40));
        text4.setFill(Color.WHITE);

        Pane canvasstar = new Pane();
        text4.relocate(60, 0);
        canvasstar.getChildren().addAll(text4);

        Text text5 = new Text("REVIVE ");
        text5.setFont(Font.font ("Verdana", 40));
        text5.setFill(Color.WHITE);

        Pane canvasstar1 = new Pane();
        text5.relocate(30, 0);
        canvasstar1.getChildren().addAll(text5);



        Pane bottomend = new Pane();
        imagestar.relocate(10, 0);
        imagerepeat.relocate(170, -40);
        home1.relocate(310, 0);

        bottomend.getChildren().addAll(imagestar,imagerepeat,home1);
        bottomend.setTranslateY(35);

        canvas122.setTranslateY(-10);
        canvas121.setTranslateY(0);
        canvasstar1.setTranslateY(-30);
        canvasstar1.setTranslateX(-5);
        canvasstar.setTranslateY(-25);
        RotateTransition rotaterepeat = new RotateTransition();
        rotaterepeat.setAxis(Rotate.Z_AXIS);
        rotaterepeat.setToAngle(-720);
        rotaterepeat.setCycleCount(Timeline.INDEFINITE);
        rotaterepeat.setDuration(Duration.millis(11000));
        rotaterepeat.setAutoReverse(false);
        rotaterepeat.setNode(imagerepeat);
        rotaterepeat.play();

        VBox vBox = new VBox(20,colorswitch,stack,canvas122,stack2,canvas121,bottomend ,canvasstar,canvasstar1);
        vBox.setAlignment(Pos.CENTER);
        vBox.setPrefWidth(425);
        vBox.setPrefHeight(575);

        return vBox;
    }
}
