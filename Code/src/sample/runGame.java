package sample;

import javafx.animation.Animation;
import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.TranslateTransition;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.Line;
import javafx.scene.shape.Shape;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

import javax.swing.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.ResourceBundle;

class runGame implements Initializable {
    Ball ball = new Ball();
    int totalStar;
    Text textpause;
    int currStar;
    ArrayList<Pane> obstacles = new ArrayList<>();
    ArrayList<Pane> gameData1 = new ArrayList<>();
    ArrayList<Pane> onecol = new ArrayList<>();
//    ArrayList<Pane> threeCol = new ArrayList<>();
    ArrayList<Pane> colorSwit = new ArrayList<>();
    ArrayList<Pane> star = new ArrayList<>();
    exitPage exit = new exitPage();
    pauseScreen pa = new pauseScreen();
    int X;
    int Y;
    List<Node> gameData;
//    List<Node> gameData3;
//    List<Node> gameData2;
//    List<Node> gameData4;
    int background = 0;
    Group game = new Group();

    int Score = 0;

    void displayScreen(Stage window) throws FileNotFoundException {
        ball.setColor(Color.rgb(144, 13, 255));
        game.getChildren().add(ball.position());
        Group root1 = new Group(game);
        Scene op = new Scene(root1, 425, 750, Color.rgb(39, 39, 39));
        start(window, op);
        Group root2 = new Group(game);
        op = new Scene(root2, 425, 750, Color.rgb(39, 39, 39));
        window.setScene(op);
        start(window, op);
        game.getChildren().add(score(window));
        //window.setScene();
    }
    float y = 300;

    void circleObstacle(float y) throws FileNotFoundException {
        circle t1 = new circle(210, y);
        Star st = new Star(210, y);
        colorSwitch cs = new colorSwitch(210, y + 200 );
        Pane obj = t1.display();
        Pane str = st.colorChane();
        Pane cs1 = cs.colorChane();
        obj.relocate(0, 130);
        str.relocate(0, 130);
        cs1.relocate(0, 130);
        game.getChildren().addAll(obj, str, cs1);
        obstacles.add(obj);
        star.add(str);
        obstacles.add(str);
        onecol.add(obj);
        obstacles.add(cs1);
        colorSwit.add(cs1);
    }
    void threeCircleObstacle(Float y) throws FileNotFoundException {
        threeCircle t2 = new threeCircle(210, y);
        Star st2 = new Star(210, y);
        colorSwitch cs1 = new colorSwitch(210,y+200);

        Pane obj = t2.display();
        Pane str1 = st2.colorChane();
        Pane cs2 = cs1.colorChane();

        obj.relocate(0, 130);
        str1.relocate(0, 130);
        cs2.relocate(0, 130);

        game.getChildren().addAll(obj, str1, cs2);
        obstacles.add(obj);
        obstacles.add(str1);
        onecol.add(obj);
        star.add(str1);
        obstacles.add(cs2);
        colorSwit.add(cs2);

    }
    void lineObstacle(float y) throws FileNotFoundException {
        line op = new line(0, y, 800, y);
        Star st3 = new Star(210, y+40);
        colorSwitch cs2 = new colorSwitch(210,y+120);
        Pane obj2 = op.display();
        Pane str3 = st3.colorChane();
        Pane cs3 = cs2.colorChane();
        obj2.relocate(0, 130);
        str3.relocate(0, 130);
        cs3.relocate(0, 130);
        game.getChildren().addAll(obj2, str3, cs3);
        obstacles.add(obj2);
        gameData1.add(obj2);
        obstacles.add(str3);
        star.add(str3);
        obstacles.add(cs3);
        colorSwit.add(cs3);


    }

    void Obstacle() throws FileNotFoundException {
        Random r = new Random();
        int n = r.nextInt(3);

        switch (n) {
            case 0 -> {
                circleObstacle(y);
                y = y - 300;
            }
            case 1 -> {
                threeCircleObstacle(y);
                y = y - 300;
            }
            case 2 -> {
                lineObstacle(y);
                y = y - 300;
            }
            default -> {
                break;
            }
        }
    }
    void start(Stage window, Scene scene) throws FileNotFoundException {
        scene.setOnMouseClicked(event -> {
            jump();
        });
        Image imagepause = new Image(new FileInputStream("/Users/robinkumar/IdeaProjects/FINAL_PROJECT/Code/src/pause.png"));
        ImageView pause= new ImageView(imagepause);
        pause.setFitHeight(100);
        pause.setFitWidth(100);

        pause.setOnMouseClicked(event -> {
            try {
                System.out.println("3456");
                window.setScene(new Scene(pa.resume(), 425, 750, Color.rgb(39,39,39)));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        });
        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long l) {
                ball.position().toFront();
                try {
                    Obstacle();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                moveDown();
                try {
                    intersect();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
            void moveDown() {
                if (ball.getyHieght() < -300) {
                    for (Pane j : obstacles) {
                        j.setTranslateY(j.getTranslateY() + 10);
                    }
                }
            }
            public void getRandomColorOnBall() {
                ArrayList<Color> allcolors=new ArrayList<>();
                allcolors.add(Color.rgb(144, 13, 255));
                allcolors.add(Color.rgb(250, 225, 0));
                allcolors.add(Color.rgb(255, 1, 129));
                allcolors.add(Color.rgb(50, 219, 240));
                Random rand = new Random();
                int c = rand.nextInt(3);
                ball.setColor(allcolors.get(c));
            }

            void intersect() throws FileNotFoundException {
                for (Pane j1 : gameData1) {
                    gameData = j1.getChildren();
                    Pane obj4 = (Pane) gameData.get(0);
                    gameData = obj4.getChildren();
                    for(Node j :gameData) {
                        Shape l1 = (Shape) j;
                        if(!Shape.intersect(l1, ball.position()).getBoundsInLocal().isEmpty()) {
                            if(!ball.getColor().equals(l1.getStroke())) {
                                window.setScene(new Scene(exit.goodgame(), 425, 750, Color.rgb(39,39,39)));
                                this.stop();
                            }
                        }
                    }
                }

                for(Pane p1 : colorSwit) {
                    gameData = p1.getChildren();
                    for(Node n1 : gameData) {
                        Shape l1 = (Shape) n1;
                        if(!Shape.intersect(l1, ball.position()).getBoundsInLocal().isEmpty()) {
                            getRandomColorOnBall();
                            p1.getChildren().remove(n1);
                        }
                    }
                }
                for(Pane p1 : star) {
                    gameData = p1.getChildren();
                    for(Node n1 : gameData) {
                        Shape l1 = (Shape) n1;
                        if(!Shape.intersect(l1, ball.position()).getBoundsInLocal().isEmpty()) {
                            Score++;
                            textpause.setText(String.valueOf(Score));
                            p1.getChildren().remove(n1);
                        }
                    }
                }

                for(Pane r1: onecol) {
                    gameData = r1.getChildren();
                    Group obj4 = (Group) gameData.get(0);
                    gameData = obj4.getChildren();
                    for(Node j :gameData) {
                        Shape l1 = (Shape) j;
                        if(!Shape.intersect(l1, ball.position()).getBoundsInLocal().isEmpty()) {
                            if(!ball.getColor().equals(l1.getStroke())) {
                                window.setScene(new Scene(exit.goodgame(), 425, 750, Color.rgb(39,39,39)));
                                this.stop();
//                                r1.getChildren().removeAll(l1);
                            }
                        }
                    }
                }

//                for(Pane r1: threeCol) {
//                    gameData = r1.getChildren();
//                    Group obj4 = (Group) gameData.get(0);
//                    gameData4 = obj4.getChildren();
//                    for(Node j :gameData4) {
//                        Shape l1 = (Shape) j;
//                        if(!Shape.intersect(l1, ball.position()).getBoundsInLocal().isEmpty()) {
//                            if(!ball.getColor().equals(l1.getStroke())) {
//                                window.close();
//                                //System.out.println("34567");
//                            }
//                        }
//                    }
//                    Group obj5 = (Group) gameData.get(1);
//                    gameData2 = obj5.getChildren();
//                    for(Node j :gameData2) {
//                        Shape l1 = (Shape) j;
//                        if(!Shape.intersect(l1, ball.position()).getBoundsInLocal().isEmpty()) {
//                            if(!ball.getColor().equals(l1.getStroke())) {
//                                window.close();
//                                //System.out.println("34567");
//                            }
//                        }
//                    }
//                    Group obj6 = (Group) gameData.get(2);
//                    gameData3 = obj6.getChildren();
//                    for(Node j :gameData3) {
//                        Shape l1 = (Shape) j;
//                        if(!Shape.intersect(l1, ball.position()).getBoundsInLocal().isEmpty()) {
//                            if(!ball.getColor().equals(l1.getStroke())) {
//                                window.close();
//                                //System.out.println("34567");
//                            }
//                        }
//                    }
//                }
            }
        };
        timer.start();
    }

    Pane score(Stage window) throws FileNotFoundException {
        String str = String.valueOf(Score);

        textpause = new Text(str);
        textpause.setFont(Font.font ("Verdana", 30));
        textpause.setFill(Color.WHITE);

        Image imagepause = new Image(new FileInputStream("/Users/robinkumar/IdeaProjects/FINAL_PROJECT/Code/src/pause.png"));
        ImageView pause= new ImageView(imagepause);
        pause.setFitHeight(100);
        pause.setFitWidth(100);

        pause.setOnMouseClicked(event -> {
            System.out.println("3456");
            try {
                System.out.println("3456");
                window.setScene(new Scene(pa.resume(), 425, 750, Color.rgb(39,39,39)));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }


        });

        Pane pausecanva = new Pane();
        pause.relocate(300,10);
        textpause.relocate(30, 30);
        pausecanva.getChildren().addAll(textpause,pause);
        pausecanva.relocate(0,360);

        return pausecanva;

    }

        TranslateTransition translate = new TranslateTransition();

        void jump () {
            translate.stop();
            ball.position().setTranslateY(ball.position().getTranslateY() - 40);
            ball.setyHieght((float) ball.position().getTranslateY());
            ball.position().smoothProperty();

            translate.play();
            background += 1;
            if (background >= 1) {
                translate.setByY(ball.position().getTranslateY());
                translate.setToY(+100);
                translate.setDuration(Duration.millis(2200));
                translate.setCycleCount(Animation.INDEFINITE);
                translate.setAutoReverse(false);
                translate.setNode(ball.position());
                translate.play();
            }
        }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            Obstacle();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}







