package sample;

import javafx.scene.layout.Pane;

import java.io.FileNotFoundException;
import java.util.ArrayList;

abstract class obstacle {
    private float xPosition;
    private float yPosition;
    ArrayList<Shapes> shapes;

    public float getxPosition() {
        return xPosition;
    }

    public void setxPosition(float xPosition) {
        this.xPosition = xPosition;
    }

    public float getyPosition() {
        return yPosition;
    }

    public void setyPosition(float yPosition) {
        this.yPosition = yPosition;
    }
    abstract Pane display() throws FileNotFoundException;
    abstract Pane makeObstacle() throws FileNotFoundException;
}
