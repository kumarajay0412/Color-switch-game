package sample;

import javafx.animation.Animation;
import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.TranslateTransition;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class runGame {
    Ball ball = new Ball();

    int totalStar;
    int currStar;
    List<Node> gameData;
    List<Node> gameData1;
    ArrayList<Pane> obstacles = new ArrayList<>();
    int background = 0;
//    line op = new line(0,-330,800,-330);
//    threeCircle t = new threeCircle(210, 50);
//    twocircle t2 = new twocircle(210,-200);

    Star s1 = new Star(160,110);
    Star s2 = new Star(160,360);
    Star s3 = new Star(160, -310);
//    Star s1 = new Star();
//    threeCircle ta = new threeCircle(280, -450);
//    threeCircle tb = new threeCircle(280, -950);
//    threeCircle tc = new threeCircle(280, -1450);
//    threeCircle td = new threeCircle(280, -1950);
//    twocircle tw = new twocircle();
    //circle t1 = new circle(210, 300);
//    circle t2 = new circle(280, -200);
//    circle t3 = new circle(280, -700);
//    circle t4 = new circle(280, -1200);
//    circle t5 = new circle(280, -1700);
    Group game = new Group();


    void displayScreen(Stage window) throws FileNotFoundException {
        game.getChildren().add(ball.position());
        Group root1 = new Group(game);
        Scene op = new Scene(root1, 425, 750, Color.rgb(39, 39, 39));
        start(window, op);
        Group root2 = new Group(game);
        op = new Scene(root2, 425, 750, Color.rgb(39, 39, 39));
        window.setScene(op);
        start(window, op);
        //window.setScene();
    }

    void start(Stage window, Scene scene) throws FileNotFoundException {
        scene.setOnMouseClicked(event -> {
            jump();
        });
        int y=300;
        int z=0;

        while (z<10) {
            Random rand = new Random();
            int n = rand.nextInt(4);
//            System.out.println(1);
//            System.out.println(n);

            switch(n) {
                case 0:
                    System.out.println(0);
//                    Star s1 = new Star(110, y);
//                    circle t1 = new circle(210, y);
//                    y = y - 250;
//                    Pane obj = t1.display();
//                    Pane s = s1.display1();
//                    obj.relocate(0, 130);
//                    s.relocate(0, 130);
//                    game.getChildren().addAll(obj, s);
//                    obstacles.add(obj);
//                    obstacles.add(s);
//                    break;
                    infinity in = new infinity(y);
                    y=y-250;
                    Pane obj = in.display();
                    obj.relocate(0, 130);
                    game.getChildren().addAll(obj);
                    obstacles.add(obj);
                    break;
                case 1:
//                    System.out.println(1);
//                    Star s2 = new Star(110, y);
//                    threeCircle t = new threeCircle(210, y);
//                    y = y - 250;
//                    Pane obj1 = t.display();
//                    Pane st = s2.display1();
//                    obj1.relocate(0, 130);
//                    game.getChildren().addAll(obj1, st);
//                    obstacles.add(obj1);
//                    obstacles.add(st);
//                    break;
                case 2:
                    System.out.println(3);
                    line op = new line(0, y, 800, y);
                    y = y - 250;
                    Pane obj2 = op.display();
                    obj2.relocate(0, 130);
                    game.getChildren().add(obj2);
                    obstacles.add(obj2);
                    break;
                case 3:
                    System.out.println(4);

                    rectangle re = new rectangle();
                    Pane obj1 = re.display();
                    obj1.relocate(0, 130);
                    game.getChildren().addAll(obj1);
                    obstacles.add(obj1);
                    break;

                default:
                    break;
            }

            AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long l) {
                ball.position().toFront();
                if (ball.getyHieght() < -300) {
                    for(Pane j : obstacles) {
                        j.setTranslateY(j.getTranslateY() + .1);
                    }
//                    obs1.setTranslateY(obs1.getTranslateY() + 1);
////                        obs1.setTranslateY(obs1.getTranslateY() + 1);
//                    obs2.setTranslateY(obs2.getTranslateY() + 1);
//                    obs3.setTranslateY(obs3.getTranslateY() + 1);
//                    st1.setTranslateY(st1.getTranslateY() + 1);
//                    st2.setTranslateY(st2.getTranslateY() + 1);
//                    st3.setTranslateY(st3.getTranslateY() + 1);
////                    obs4.setTranslateY(obs4.getTranslateY() + 1);
////                    obs5.setTranslateY(obs5.getTranslateY() + 1);
////                    obs6.setTranslateY(obs6.getTranslateY() + 1);
////                    obs7.setTranslateY(obs7.getTranslateY() + 1);
//                    obs8.setTranslateY(obs8.getTranslateY() + 1);
//                   // obs9.setTranslateY(obs9.getTranslateY() + 1);
//                    //obs11.setTranslateY(obs11.getTranslateY() + 1);

                }
            }
        };
        timer.start();


            z++;




        }

//        Text text4 = new Text("50 ");
//        text4.setFont(Font.font("Verdana", 40));
//        text4.setFill(Color.WHITE);
//        Pane canvasstar = new Pane();
//        text4.relocate(60, 0);
//        canvasstar.getChildren().addAll(text4);
//
//        Pane obs1 = t.display();
//        Pane obs2 = t1.display();
//        Pane obs3 = t2.display();
//        Pane st1 = s1.display1();
//        Pane st2 = s2.display1();
//        Pane st3 = s3.display1();
//
////        Pane obs3 = ta.display();
////        Pane obs4 = t2.display();
////        Pane obs5 = tb.display();
////        Pane obs6 = t3.display();
////        Pane obs7 = tc.display();
//        Pane obs8 = op.display();
//        //Pane obs9 = td.display();
//        //Pane obs11 = l.display();
//
//        obs2.relocate(0, 130);
//        obs3.relocate(0, 130);
//        obs1.relocate(0, 130);
//        s1.display1().relocate(0, 130);
//        s2.display1().relocate(0, 130);
//        s3.display1().relocate(0, 130);
//        //s1.display().relocate(-70, 130);
//        obs1.relocate(0, 130);
//        obs1.relocate(0, 130);
////        obs4.relocate(-70, 130);
////        obs5.relocate(-70, 130);
////        obs6.relocate(-70, 130);
////        obs7.relocate(-70, 130);
//        obs8.relocate(0, 130);
//        //bs9.relocate(-70, 130);
////        obs11.relocate(-70, 130);
//        game.getChildren().add(obs1);
////        game.getChildren().add()
//        game.getChildren().add(obs2);
//        game.getChildren().add(obs3);
////        game.getChildren().add(obs4);
////        game.getChildren().add(obs5);
////        game.getChildren().add(obs6);
////        game.getChildren().add(obs7);
//        game.getChildren().add(obs8);
//        game.getChildren().add(s1.display1());
//        game.getChildren().add(s2.display1());
//        game.getChildren().add(s3.display1());
//        //game.getChildren().add(obs9);
//        //game.getChildren().add(obs11);
//        //game.getChildren().add(obstacles.get(1));
//        AnimationTimer timer = new AnimationTimer() {
//            @Override
//            public void handle(long l) {
//                ball.position().toFront();
//                if (ball.getyHieght() < -300) {
//                    obs1.setTranslateY(obs1.getTranslateY() + 1);
////                        obs1.setTranslateY(obs1.getTranslateY() + 1);
//                    obs2.setTranslateY(obs2.getTranslateY() + 1);
//                    obs3.setTranslateY(obs3.getTranslateY() + 1);
//                    st1.setTranslateY(st1.getTranslateY() + 1);
//                    st2.setTranslateY(st2.getTranslateY() + 1);
//                    st3.setTranslateY(st3.getTranslateY() + 1);
////                    obs4.setTranslateY(obs4.getTranslateY() + 1);
////                    obs5.setTranslateY(obs5.getTranslateY() + 1);
////                    obs6.setTranslateY(obs6.getTranslateY() + 1);
////                    obs7.setTranslateY(obs7.getTranslateY() + 1);
//                    obs8.setTranslateY(obs8.getTranslateY() + 1);
//                   // obs9.setTranslateY(obs9.getTranslateY() + 1);
//                    //obs11.setTranslateY(obs11.getTranslateY() + 1);
//
//                }
//            }
//        };
//        timer.start();
//    }
////
////        obs1.relocate(-70,130);
////        obs2.relocate(-70,130);
////        game.getChildren().
////
////    addAll(obs1, obs2);
////        System.out.println(ball.getyHieght());
////
////
////    gameData =obs1.getChildren();
////    Group op1 = (Group) gameData.get(0);
////    gameData1 =op1.getChildren();
////    Arc v = (Arc) (gameData1.get(1));
////
////        if(obs1.getBoundsInParent.intersects(ball.position().getBoundsInParent))
////
////    {
////
////    }
//
//
    }

    TranslateTransition translate = new TranslateTransition();

    void jump() {
        translate.stop();
        ball.position().setTranslateY(ball.position().getTranslateY()-40);
        ball.setyHieght((float) ball.position().getTranslateY());
        ball.position().smoothProperty();

        translate.play();
        background+=1;
        if(background>=1) {
            translate.setByY(ball.position().getTranslateY());
            translate.setToY(+100);
            translate.setDuration(Duration.millis(2200));
            translate.setCycleCount(Animation.INDEFINITE);
            translate.setAutoReverse(false);
            translate.setNode(ball.position());
            translate.play();
        }
    }




}


