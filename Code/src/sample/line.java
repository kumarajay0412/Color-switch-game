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

class line extends obstacle {
    Line linepath = new Line();


    line(float Sx, float Sy, float Ex, float Ey) {
        linepath.setStartX(Sx);
        linepath.setStartY(Sy);
        linepath.setEndX(Ex);
        linepath.setEndY(Ey);
    }
    @Override
    Pane display() throws FileNotFoundException {
        return makeObstacle();
    }

    @Override
    Pane makeObstacle() throws FileNotFoundException {
        Pane content1 = new Pane();
        for (int count = 0; count < 8; count++) {
            if(count==0 || count == 4) {
                Line line = new Line(0,0,100,0);
                line.setStroke(Color.rgb(250, 225, 0));
                line.setStrokeWidth(15);
                Node node = line;
                content1.getChildren().add(node);
                final Transition transition = createPathTransition(linepath, node);
                transition.jumpTo(Duration.seconds(10).multiply(count * 1.0 / 8));
                transition.play();
            }else if(count==1 || count == 5) {
                Line line = new Line(0,0,100,0);
                line.setStroke(Color.rgb(144, 13, 255));
                line.setStrokeWidth(15);
                Node node = line;
                content1.getChildren().add(node);
                final Transition transition = createPathTransition(linepath, node);
                transition.jumpTo(Duration.seconds(10).multiply(count * 1.0 / 8));
                transition.play();
            }else if(count==2 || count ==6) {
                Line line = new Line(0,0,100,0);
                line.setStroke(Color.rgb(255, 1, 129));
                Node node = line;
                line.setStrokeWidth(15);
                content1.getChildren().add(node);
                final Transition transition = createPathTransition(linepath, node);
                transition.jumpTo(Duration.seconds(10).multiply(count * 1.0 / 8));
                transition.play();
            }
            else{
                Line line = new Line(0,0,100,0);
                line.setStroke(Color.rgb(50, 219, 240));
                line.setStrokeWidth(15);
                Node node = line;
                content1.getChildren().add(node);
                final Transition transition = createPathTransition(linepath, node);
                transition.jumpTo(Duration.seconds(10).multiply(count * 1.0 / 8));
                transition.play();
            }
        }
        Pane canvascircleapth = new Pane();


        content1.relocate(-100, 0);
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
