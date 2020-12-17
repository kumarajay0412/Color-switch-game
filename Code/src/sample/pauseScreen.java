package sample;

import javafx.animation.Interpolator;
import javafx.animation.ScaleTransition;
import javafx.animation.Timeline;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.util.Duration;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

class pauseScreen {
    VBox resume() throws FileNotFoundException {
        Image imageplay = new Image(new FileInputStream("/Users/robinkumar/IdeaProjects/FINAL_PROJECT/Code/src/PLAY.png"));
        ImageView play= new ImageView(imageplay);
        play.setFitHeight(150);
        play.setFitWidth(150);

        Image imagestar2 = new Image(new FileInputStream("/Users/robinkumar/IdeaProjects/FINAL_PROJECT/Code/src/home.png"));
        ImageView home= new ImageView(imagestar2);
        home.setFitHeight(100);
        home.setFitWidth(100);



        Pane homecanva = new Pane();
        home.relocate(10,10);
        homecanva.getChildren().addAll(home);

        Text textpause1 = new Text("PAUSE");
        textpause1.setFont(Font.font ("Verdana", 60));
        textpause1.setFill(Color.WHITE);


        Pane textpause1canva = new Pane();
        textpause1.relocate(130,0);
        textpause1canva.getChildren().addAll(textpause1);

        Image imagesave = new Image(new FileInputStream("/Users/ajay/IdeaProjects/FINAL_PROJECT/Code/src/save.png"));
        ImageView save= new ImageView(imagesave);
        save.setFitHeight(150);
        save.setFitWidth(150);

        ScaleTransition scaleTransitionsave = new ScaleTransition();
        scaleTransitionsave.setDuration(Duration.millis(1000));
        scaleTransitionsave.setNode(save);
        scaleTransitionsave.setByY(.07);
        scaleTransitionsave.setByX(.07);
        scaleTransitionsave.setCycleCount(Timeline.INDEFINITE);
        scaleTransitionsave.setAutoReverse(true);
        scaleTransitionsave.setInterpolator(Interpolator.LINEAR);
        scaleTransitionsave.play();

        ScaleTransition scaleTransitionplay = new ScaleTransition();
        scaleTransitionplay.setDuration(Duration.millis(1000));
        scaleTransitionplay.setNode(play);
        scaleTransitionplay.setByY(.07);
        scaleTransitionplay.setByX(.07);
        scaleTransitionplay.setCycleCount(Timeline.INDEFINITE);
        scaleTransitionplay.setAutoReverse(true);
        scaleTransitionplay.setInterpolator(Interpolator.LINEAR);
        scaleTransitionplay.play();

        ScaleTransition scaleTransitionhome = new ScaleTransition();
        scaleTransitionhome.setDuration(Duration.millis(1000));
        scaleTransitionhome.setNode(home);
        scaleTransitionhome.setByY(.06);
        scaleTransitionhome.setByX(.06);
        scaleTransitionhome.setCycleCount(Timeline.INDEFINITE);
        scaleTransitionhome.setAutoReverse(true);
        scaleTransitionhome.setInterpolator(Interpolator.LINEAR);
        scaleTransitionhome.play();

        Pane playcanva = new Pane();
        play.relocate(140,0);
        playcanva.getChildren().addAll(play);



        Pane savecanva = new Pane();
        save.relocate(140,0);
        savecanva.getChildren().addAll(save);

        VBox vBox = new VBox(50,homecanva,textpause1canva,playcanva,savecanva);
        vBox.setPrefWidth(425);
        vBox.setPrefHeight(575);
        return vBox;
    }
}
