package sample;

import javafx.animation.Interpolator;
import javafx.animation.PathTransition;
import javafx.animation.Transition;
import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.SVGPath;
import javafx.scene.shape.Shape;
import javafx.util.Duration;

import java.io.FileNotFoundException;

class infinity extends obstacle {

    infinity(float Y) {
        setyPosition(Y);
    }

    @Override
    Pane display() throws FileNotFoundException {
        return makeObstacle();
    }

    @Override
    Pane makeObstacle() throws FileNotFoundException {
        double REQUIRED_WIDTH = 350.0;
        double REQUIRED_HEIGHT = 150.0;
        SVGPath svg = new SVGPath();
        svg.setFill(Color.BLACK);
        svg.setStrokeWidth(1.0);
        svg.setStroke(Color.RED);
        svg.setContent("M 787.49,150 C 787.49,203.36 755.56,247.27 712.27,269.5 S 622.17,290.34 582.67,279.16 508.78,246.56 480,223.91 424.93,174.93 400,150 348.85,98.79 320,76.09 256.91,32.03 217.33,20.84 130.62,8.48 87.73,30.5 12.51,96.64 12.51,150 44.44,247.27 87.73,269.5 177.83,290.34 217.33,279.16 291.22,246.56 320,223.91 375.07,174.93 400,150 451.15,98.79 480,76.09 543.09,32.03 582.67,20.84 669.38,8.48 712.27,30.5 787.49,96.64 787.49,150 z");
        resize(svg, REQUIRED_WIDTH, REQUIRED_HEIGHT);

        int NUM_NODES = 40;
        double W = 230;
        double H = 217;
        double NODE_SIZE = H / 13.0;

        Pane content = new Pane();
        for (int count = 0; count < 40; count++) {
            if(count<5) {
                Node node = new Circle(NODE_SIZE / 2, Color.rgb(250, 225, 0));
                content.getChildren().add(node);
                final Transition transition = createPathTransition(svg, node);
                transition.jumpTo(Duration.seconds(10).multiply(count * 1.0 / NUM_NODES));
                transition.play();
            }
            else if(4<count && count<10) {
                Node node = new Circle(NODE_SIZE / 2, Color.rgb(144, 13, 255));
                content.getChildren().add(node);
                final Transition transition = createPathTransition(svg, node);
                transition.jumpTo(Duration.seconds(10).multiply(count * 1.0 / NUM_NODES));
                transition.play();
            }
            else if(9<count && count<15) {
                Node node = new Circle(NODE_SIZE / 2, Color.rgb(255, 1, 129));
                content.getChildren().add(node);
                final Transition transition = createPathTransition(svg, node);
                transition.jumpTo(Duration.seconds(10).multiply(count * 1.0 / NUM_NODES));
                transition.play();
            }
            else if(14<count && count<20) {
                Node node = new Circle(NODE_SIZE / 2, Color.rgb(50, 219, 240));
                content.getChildren().add(node);
                final Transition transition = createPathTransition(svg, node);
                transition.jumpTo(Duration.seconds(10).multiply(count * 1.0 / NUM_NODES));
                transition.play();
            }
            else if(19<count && count<25) {
                Node node = new Circle(NODE_SIZE / 2, Color.rgb(250, 225, 0));
                content.getChildren().add(node);
                final Transition transition = createPathTransition(svg, node);
                transition.jumpTo(Duration.seconds(10).multiply(count * 1.0 / NUM_NODES));
                transition.play();
            }
            else if(24<count && count<30) {
                Node node = new Circle(NODE_SIZE / 2, Color.rgb(144, 13, 255));
                content.getChildren().add(node);
                final Transition transition = createPathTransition(svg, node);
                transition.jumpTo(Duration.seconds(10).multiply(count * 1.0 / NUM_NODES));
                transition.play();
            }
            else if(29<count && count<35) {
                Node node = new Circle(NODE_SIZE / 2, Color.rgb(255, 1, 129));
                content.getChildren().add(node);
                final Transition transition = createPathTransition(svg, node);
                transition.jumpTo(Duration.seconds(10).multiply(count * 1.0 / NUM_NODES));
                transition.play();
            }
            else{
                Node node = new Circle(NODE_SIZE / 2, Color.rgb(50, 219, 240));
                content.getChildren().add(node);
                final Transition transition = createPathTransition(svg, node);
                transition.jumpTo(Duration.seconds(10).multiply(count * 1.0 / NUM_NODES));
                transition.play();
            }
        }

        Pane canvas1212 = new Pane();
        content.relocate(-180, 0);
        canvas1212.relocate(0,getyPosition());
        canvas1212.getChildren().addAll(content);
        return canvas1212;
    }
    private void resize(SVGPath svg, double width, double height) {

        double originalWidth = svg.prefWidth(-1);
        double originalHeight = svg.prefHeight(originalWidth);
        double scaleX = width / originalWidth;
        double scaleY = height / originalHeight;
        svg.setScaleX(scaleX);
        svg.setScaleY(scaleY);
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
