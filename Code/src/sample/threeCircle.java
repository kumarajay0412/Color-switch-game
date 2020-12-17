package sample;

import javafx.animation.Interpolator;
import javafx.animation.RotateTransition;
import javafx.animation.Timeline;
import javafx.scene.Group;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.Shape;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;

import java.io.FileNotFoundException;
import java.util.ArrayList;

class threeCircle extends obstacle {

    threeCircle(float X, float Y) {
        setyPosition(Y);
        setxPosition(X);
    }

    Group arccircle1 = new Group();
    Group arccircle2 = new Group();
    Group arccircle3 = new Group();

    @Override
    Pane makeObstacle() throws FileNotFoundException {

        curve c1 = new curve();
        Arc arc1 = c1.create1(getxPosition(), getyPosition(), 80.0f, 80.0f, 0.0f, Color.rgb(250, 225, 0));
        curve c2 = new curve();
        Arc arc2 = c2.create1(getxPosition(), getyPosition(), 80.0f, 80.0f, 90.0f, Color.rgb(144, 13, 255));
        curve c3 = new curve();
        Arc arc3 = c3.create1(getxPosition(), getyPosition(), 80.0f, 80.0f, 180.0f, Color.rgb(255, 1, 129));
        curve c4 = new curve();
        Arc arc4 = c4.create1(getxPosition(), getyPosition(), 80.0f, 80.0f,270.0f,Color.rgb(50, 219, 240));
        curve c5 = new curve();
        Arc arc5 = c5.create1(getxPosition(), getyPosition(), 70.0f, 70.0f,0.0f, Color.rgb(250, 225, 0));
        curve c6 = new curve();
        Arc arc6 = c6.create1(getxPosition(), getyPosition(), 70.0f, 70.0f,90.0f, Color.rgb(144, 13, 255));
        curve c7 = new curve();
        Arc arc7 = c7.create1(getxPosition(), getyPosition(), 70.0f, 70.0f, 180.0f,Color.rgb(255, 1, 129));
        curve c8 = new curve();
        Arc arc8 = c8.create1(getxPosition(), getyPosition(), 70.0f, 70.0f,270.0f, Color.rgb(50, 219, 240));
        curve c9 = new curve();
        Arc arc9 = c9.create1(getxPosition(), getyPosition(), 60.0f, 60.0f,0.0f, Color.rgb(250, 225, 0));
        curve c10 = new curve();
        Arc arc10 = c10.create1(getxPosition(), getyPosition(), 60.0f, 60.0f,90.0f, Color.rgb(144, 13, 255));
        curve c11 = new curve();
        Arc arc11 = c11.create1(getxPosition(), getyPosition(), 60.0f, 60.0f,180.0f, Color.rgb(255, 1, 129));
        curve c12 = new curve();
        Arc arc12 = c12.create1(getxPosition(), getyPosition(), 60.0f, 60.0f,270.0f, Color.rgb(50, 219, 240));

        arccircle2.getChildren().addAll(arc5, arc6, arc7, arc8);
        arccircle1.getChildren().addAll(arc3, arc2,arc1, arc4);
        arccircle3.getChildren().addAll(arc9, arc10, arc11, arc12);

        RotateTransition rotate = new RotateTransition(); 
        rotate = helperFunction(rotate, 720, 11000);

        RotateTransition rotate1 = new RotateTransition();
        rotate1 = helperFunction(rotate1, 720, 11000);

        RotateTransition rotate3 = new RotateTransition();
        rotate3 = helperFunction(rotate3, 720, 11000);

        rotate.setNode(arccircle1);
        rotate1.setNode(arccircle2);
        rotate3.setNode(arccircle3);

        rotate.play();
        rotate1.play();
        rotate3.play();
        Pane groupcircleobstacle = new Pane();

        groupcircleobstacle.getChildren().addAll(arccircle1, arccircle2, arccircle3);

        return groupcircleobstacle;

    }

    RotateTransition helperFunction(RotateTransition rotate, int angle, int op) throws FileNotFoundException {
        rotate.setAxis(Rotate.Z_AXIS);
        rotate.setToAngle(angle);
        rotate.setCycleCount(Timeline.INDEFINITE);
        rotate.setDuration(Duration.millis(op));
        rotate.setInterpolator(Interpolator.LINEAR);
        rotate.setAutoReverse(false);
        return rotate;

    }

    @Override
    Pane display() throws FileNotFoundException {
        return makeObstacle();
    }

}