package sample;

import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;

class curve extends Shapes {
    Arc arc6 = new Arc();

    Arc create1(float xPosition, float Y, float Rx, float Ry, float angle, Color color) {
        arc6.setCenterX(xPosition);
        arc6.setCenterY(Y);
        arc6.setRadiusX(Rx);
        arc6.setRadiusY(Ry);
        arc6.setStartAngle(angle);
        arc6.setLength(80.0f);
        arc6.setType(ArcType.OPEN);
        arc6.setFill(null);
        arc6.setStroke(color);
        arc6.setStrokeWidth(10);
        return arc6;
    }
    void create() {

    }
}