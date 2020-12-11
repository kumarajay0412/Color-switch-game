package sample;

import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;


public class Best{
    Stage window;


    Best(Stage primaryStage) throws FileNotFoundException {
        window = primaryStage;
    }
    VBox mainMenu() throws FileNotFoundException {
        Image image = new Image(new FileInputStream("/Users/robinkumar/IdeaProjects/FINAL_PROJECT/Code/src/2.gif"));
        ImageView imageView = new ImageView(image);
        imageView.setFitHeight(200);
        imageView.setFitWidth(350);
        Pane colorswitch = new Pane();
        imageView.relocate(40, 0);
        colorswitch.getChildren().addAll(imageView);

            // Load Game started

        Path path = new Path();
        MoveTo moveTo = new MoveTo(-110, 25);
        LineTo linee1 = new LineTo(110, 25);
        LineTo linee2 = new LineTo(95,0);
        LineTo linee3 = new LineTo(110,-25);
        LineTo linee4 = new LineTo(-110, -25);
        LineTo linee5 = new LineTo(-95, 0);
        LineTo linee6 = new LineTo(-110, 25);
        path.getElements().add(moveTo);
        path.getElements().addAll(linee1, linee2,linee3,linee4,linee5,linee6);
        path.setFill(Color.rgb(50, 219, 240));
        path.setStroke(Color.rgb(50, 219, 240));
        Text textq = new Text();
        textq.setText("LOAD GAME");
        textq.setX(-75);
        textq.setY(10);
        textq.setFont(Font.font("verdana", 25));

        Line dash = new Line(20, 40, 210, 40);
        dash.getStrokeDashArray().addAll(25d, 10d);
        dash.setStroke(Color.WHITE);
        dash.setStrokeWidth(3);
        Group lineg = new Group(dash);
        lineg.relocate(-100,18);

        Line dash1 = new Line(20, 40, 210, 40);
        dash1.getStrokeDashArray().addAll(25d, 10d);
        dash1.setStroke(Color.WHITE);
        dash1.setStrokeWidth(3);
        Group lineg1 = new Group(dash1);
        lineg1.relocate(-100,-20);

        Image image10 = new Image(new FileInputStream("/Users/robinkumar/IdeaProjects/FINAL_PROJECT/Code/src/10.png"));
        ImageView imageView10 = new ImageView(image10);
        imageView10.setFitHeight(65);
        imageView10.setFitWidth(80);

        Image image20 = new Image(new FileInputStream("/Users/robinkumar/IdeaProjects/FINAL_PROJECT/Code/src/20.png"));
        ImageView imageView20 = new ImageView(image20);
        imageView20.setFitHeight(65);
        imageView20.setFitWidth(80);

        Group LOADGAME1 = new Group(path,textq,lineg,lineg1);
        Pane LOADGAME = new Pane();
        imageView10.relocate(10, 210);
        LOADGAME1.relocate(100,215);
        imageView20.relocate(335,210);
        LOADGAME.getChildren().addAll(imageView10,imageView20,LOADGAME1);

            //Load Game Ended

//        Bottom started

        Image image40 = new Image(new FileInputStream("/Users/robinkumar/IdeaProjects/FINAL_PROJECT/Code/src/help.png"));
        ImageView imageView40 = new ImageView(image40);
        imageView40.setFitHeight(100);
        imageView40.setFitWidth(100);

        Image image50 = new Image(new FileInputStream("/Users/robinkumar/IdeaProjects/FINAL_PROJECT/Code/src/exit.png"));
        ImageView imageView50 = new ImageView(image50);
        imageView50.setFitHeight(100);
        imageView50.setFitWidth(100);

        Image imagemiddele = new Image(new FileInputStream("/Users/robinkumar/IdeaProjects/FINAL_PROJECT/Code/src/4.png"));
        ImageView imageView3 = new ImageView(imagemiddele);
        imageView3.setX(268.0f);
        imageView3.setY(119.0f);
        imageView3.setFitHeight(67);
        imageView3.setFitWidth(67);

        Pane bottom = new Pane();
        imageView40.relocate(10, 200);
        imageView50.relocate(300,200);
        imageView3.relocate(0, 0);

        bottom.getChildren().addAll(imageView40,imageView50);

        threeCircle threeCircleObstacle = new threeCircle();
        Pane groupcircleobstacle = threeCircleObstacle.makeObstacle();

        Pane playbutton = new Pane();
        groupcircleobstacle.relocate(-70, 130);
        playbutton.getChildren().addAll(groupcircleobstacle);

        VBox vBox = new VBox(30,colorswitch,playbutton,imageView3,LOADGAME,bottom);
        vBox.setAlignment(Pos.CENTER);
        vBox.setPrefWidth(425);
        vBox.setPrefHeight(575);

        imageView50.setOnMouseClicked(event -> {
            Stage stage = (Stage) imageView50.getScene().getWindow();
            stage.close();
        });

        imageView3.setOnMouseClicked(event -> {

            startGame(window);
        });
        return vBox;
    }

    void startGame(Stage window) {
        runGame game = new runGame();
        game.displayScreen(window);
    }
}


