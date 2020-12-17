package sample;

import javafx.animation.Interpolator;
import javafx.animation.RotateTransition;
import javafx.animation.Timeline;
import javafx.scene.Group;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;

import java.io.FileNotFoundException;

class circle extends obstacle {

    circle(float X, float Y) {
        setyPosition(Y);
        setxPosition(X);
    }

    Group arccircle1 = new Group();

    @Override
    Pane display() throws FileNotFoundException {
        return makeObstacle();
    }

    @Override
    Pane makeObstacle() throws FileNotFoundException {

        curve c1 = new curve();
        Arc arc1 = c1.create1(getxPosition(), getyPosition(), 50.0f, 50.0f, 0.0f, Color.rgb(250, 225, 0));
        curve c2 = new curve();
        Arc arc2 = c2.create1(getxPosition(), getyPosition(), 50.0f, 50.0f, 90.0f, Color.rgb(144, 13, 255));
        curve c3 = new curve();
        Arc arc3 = c3.create1(getxPosition(), getyPosition(), 50.0f, 50.0f, 180.0f, Color.rgb(255, 1, 129));
        curve c4 = new curve();
        Arc arc4 = c4.create1(getxPosition(), getyPosition(), 50.0f, 50.0f,270.0f,Color.rgb(50, 219, 240));

        arccircle1.getChildren().addAll(arc1, arc2, arc3, arc4);

        RotateTransition rotate1 = new RotateTransition();
        rotate1 = helperFunction(rotate1, -720);


        rotate1.setNode(arccircle1);
        rotate1.play();

        Pane circleobstacle = new Pane();

        circleobstacle.getChildren().addAll(arccircle1);

        return circleobstacle;

    }

    RotateTransition helperFunction(RotateTransition rotate, int angle) throws FileNotFoundException {
        rotate.setAxis(Rotate.Z_AXIS);
        rotate.setToAngle(angle);
        rotate.setCycleCount(Timeline.INDEFINITE);
        rotate.setDuration(Duration.millis(11000));
        rotate.setInterpolator(Interpolator.LINEAR);
        rotate.setAutoReverse(false);
        return rotate;

    }
}
