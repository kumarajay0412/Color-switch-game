package sample;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.TranslateTransition;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.ArrayList;

class runGame {
    Ball ball = new Ball();
    int totalStar;
    int currStar;
    ArrayList<OP> gameData;
    int background=0;

    void displayScreen(Stage window) {
        Group root1 = new Group(ball.position());
        Scene op = new Scene(root1, 425, 750, Color.rgb(39, 39, 39));
        window.setScene(op);
        start(window, op);

    }

    void start(Stage window, Scene scene) {
        scene.setOnMouseClicked(event->{
            jump();
        });

    }
    TranslateTransition translate = new TranslateTransition();

    void jump() {
        translate.stop();
        ball.position().setTranslateY(ball.position().getTranslateY()-40);
        ball.position().setFill(Color.WHITE);
        ball.position().smoothProperty();

        translate.play();
        background+=1;
        if(background>=1) {
            translate.setByY(ball.position().getTranslateY());
            translate.setToY(+100);
            System.out.println(0);
            translate.setDuration(Duration.millis(2200));
            translate.setCycleCount(Animation.INDEFINITE);
            translate.setAutoReverse(false);
            translate.setNode(ball.position());
            translate.play();
        }
        if(ball.position().getTranslateY()==+98) {
            translate.stop();
        }
    }

    void pause() {

    }



}


