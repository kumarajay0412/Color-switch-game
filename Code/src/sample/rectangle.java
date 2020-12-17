package sample;

import javafx.animation.Interpolator;
import javafx.animation.PathTransition;
import javafx.animation.Transition;
import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.util.Duration;

import java.io.FileNotFoundException;

class rectangle extends obstacle {
    @Override
    Pane display() throws FileNotFoundException {
        return makeObstacle();
    }

    @Override
    Pane makeObstacle() throws FileNotFoundException {
        Rectangle rectanglepath =new Rectangle(); //inrntiating Rectangle
        rectanglepath.setX(20); //setting the X coordinate of upper left //corner of rectangle
        rectanglepath.setY(20); //setting the Y coordinate of upper left //corner of rectangle
        rectanglepath.setWidth(200); //setting the width of rectangle
        rectanglepath.setHeight(200); // setting the height of rectangle
        rectanglepath.setArcWidth(120);
        rectanglepath.setArcHeight(120);

        int NUM_NODES1 = 32;
        double W1 = 200;
        double H1 = 200;
        double NODE_SIZE1 = H1 / 10.0;

        Pane content1 = new Pane();
        for (int count = 0; count < 32; count++) {
            if(count<8) {
                Node node = new Circle(NODE_SIZE1 / 2, Color.rgb(250, 225, 0));
                content1.getChildren().add(node);
                final Transition transition = createPathTransition(rectanglepath, node);
                transition.jumpTo(Duration.seconds(10).multiply(count * 1.0 / NUM_NODES1));
                transition.play();
            }
            else if(7<count && count<16) {
                Node node = new Circle(NODE_SIZE1 / 2, Color.rgb(144, 13, 255));
                content1.getChildren().add(node);
                final Transition transition = createPathTransition(rectanglepath, node);
                transition.jumpTo(Duration.seconds(10).multiply(count * 1.0 / NUM_NODES1));
                transition.play();
            }
            else if(15<count && count<24) {
                Node node = new Circle(NODE_SIZE1 / 2, Color.rgb(255, 1, 129));
                content1.getChildren().add(node);
                final Transition transition = createPathTransition(rectanglepath, node);
                transition.jumpTo(Duration.seconds(10).multiply(count * 1.0 / NUM_NODES1));
                transition.play();
            }
            else{
                Node node = new Circle(NODE_SIZE1 / 2, Color.rgb(50, 219, 240));
                content1.getChildren().add(node);
                final Transition transition = createPathTransition(rectanglepath, node);
                transition.jumpTo(Duration.seconds(10).multiply(count * 1.0 / NUM_NODES1));
                transition.play();
            }

        }
        Pane canvascircleapth = new Pane();
        content1.relocate(20, 0);
        canvascircleapth.getChildren().addAll(content1);

        return canvascircleapth;
    }

    private PathTransition createPathTransition(Shape shape, Node node) {
        final PathTransition transition = new PathTransition(
                Duration.seconds(10),
                shape,
                node
        );
        transition.setAutoReverse(false);
        transition.setCycleCount(PathTransition.INDEFINITE);
        transition.setInterpolator(Interpolator.LINEAR);
        return transition;
    };
}
