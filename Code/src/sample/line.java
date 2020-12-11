package sample;

import javafx.scene.paint.Color;
import javafx.scene.shape.Line;

class line extends Shapes {
    @Override
    void create() {
        Line line = new Line();
        line.setStroke(Color.RED);
    }
}
