package sample;

import javafx.animation.Interpolator;
import javafx.animation.PathTransition;
import javafx.animation.Transition;
import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Shape;
import javafx.util.Duration;

import java.io.FileNotFoundException;

class horizontal extends obstacle {
    @Override
    Pane display() throws FileNotFoundException {
        return makeObstacle();
    }

    @Override
    Pane makeObstacle() throws FileNotFoundException {
        Line linepath = new Line();
        linepath.setStartX(0);
        linepath.setStartY(0.0);
        linepath.setEndX(500.0);
        linepath.setEndY(0.0);
        int NUM_NODES1 = 4;

        Pane content1 = new Pane();
        for (int count = 0; count < 4; count++) {
            if (count == 0) {
                Line line = new Line(0, 50, 0, -50);
                line.setStroke(Color.rgb(250, 225, 0));
                line.setStrokeWidth(18);
                Node node = line;
                content1.getChildren().add(node);
                final Transition transition = createPathTransition(linepath, node);
                transition.jumpTo(Duration.seconds(10).multiply(count * 1.0 / NUM_NODES1));
                transition.play();
            } else if (count == 1) {
                Line line = new Line(0, 50, 0, -50);
                line.setStroke(Color.rgb(144, 13, 255));
                line.setStrokeWidth(18);
                Node node = line;
                content1.getChildren().add(node);
                final Transition transition = createPathTransition(linepath, node);
                transition.jumpTo(Duration.seconds(10).multiply(count * 1.0 / NUM_NODES1));
                transition.play();
            } else if (count == 2) {
                Line line = new Line(0, 50, 0, -50);
                line.setStroke(Color.rgb(255, 1, 129));
                Node node = line;
                line.setStrokeWidth(18);
                content1.getChildren().add(node);
                final Transition transition = createPathTransition(linepath, node);
                transition.jumpTo(Duration.seconds(10).multiply(count * 1.0 / NUM_NODES1));
                transition.play();
            } else {
                Line line = new Line(0, 50, 0, -50);
                line.setStroke(Color.rgb(50, 219, 240));
                line.setStrokeWidth(18);
                Node node = line;
                content1.getChildren().add(node);
                final Transition transition = createPathTransition(linepath, node);
                transition.jumpTo(Duration.seconds(10).multiply(count * 1.0 / NUM_NODES1));
                transition.play();
            }

        }


        Line linepath1 = new Line();

        linepath1.setEndX(0);
        linepath1.setEndY(0.0);
        linepath1.setStartX(500.0);
        linepath1.setStartY(0.0);

        int NUM_NODES2 = 4;

        Pane content2 = new Pane();
        for (int count = 0; count < 4; count++) {
            if (count == 3) {
                Line line = new Line(0, 25, 0, -25);
                line.setStroke(Color.rgb(250, 225, 0));
                line.setStrokeWidth(18);
                Node node = line;
                content2.getChildren().add(node);
                final Transition transition = createPathTransition(linepath1, node);
                transition.jumpTo(Duration.seconds(10).multiply(count * 1.0 / NUM_NODES2));
                transition.play();
            } else if (count == 2) {
                Line line = new Line(0, 25, 0, -25);
                line.setStroke(Color.rgb(144, 13, 255));
                line.setStrokeWidth(18);
                Node node = line;
                content2.getChildren().add(node);
                final Transition transition = createPathTransition(linepath1, node);
                transition.jumpTo(Duration.seconds(10).multiply(count * 1.0 / NUM_NODES2));
                transition.play();
            } else if (count == 1) {
                Line line = new Line(0, 25, 0, -25);
                line.setStroke(Color.rgb(255, 1, 129));
                Node node = line;
                line.setStrokeWidth(18);
                content2.getChildren().add(node);
                final Transition transition = createPathTransition(linepath1, node);
                transition.jumpTo(Duration.seconds(10).multiply(count * 1.0 / NUM_NODES2));
                transition.play();
            } else {
                Line line = new Line(0, 25, 0, -25);
                line.setStroke(Color.rgb(50, 219, 240));
                line.setStrokeWidth(18);
                Node node = line;
                content2.getChildren().add(node);
                final Transition transition = createPathTransition(linepath1, node);
                transition.jumpTo(Duration.seconds(10).multiply(count * 1.0 / NUM_NODES2));
                transition.play();
            }

        }
        Pane canvascircleapth = new Pane();
        content1.relocate(0, 0);
        content2.relocate(0, 0);
        canvascircleapth.getChildren().addAll(content1, content2);
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
    }
}
