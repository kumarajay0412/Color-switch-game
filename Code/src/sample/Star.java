package sample;

import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;

class Star implements OP {
    Star(float X, float Y) {
        setxPosition(X);
        setyPosition(Y);
    }
    private float xPosition;
    private float yPosition;
    private Color color;
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
    public Color getColor() {
        return color;
    }
    public void setColor(Color color) {
        this.color = color;
    }
    @Override
    public void touch() {
        destroyStar();
    }
    private void destroyStar() {

    }
    @Override
    public void display() {

    }

    Pane display1() {

        Path path = new Path();
        MoveTo moveTo = new MoveTo(10, 50);
        LineTo linee1 = new LineTo(110, 50);
        LineTo linee2 = new LineTo(20,110);
        LineTo linee3 = new LineTo(60,20);
        LineTo linee4 = new LineTo(100, 110);
        LineTo linee5 = new LineTo(10, 50);
        path.getElements().add(moveTo);
        path.getElements().addAll(linee1, linee2, linee3, linee4, linee5);
        Pane root = new Pane();
        root.getChildren().add(path);
        root.setScaleX(.3);
        root.setScaleY(.3);
        root.relocate(getxPosition(), getyPosition());
        path.setFill(Color.WHITE);
        path.setStroke(Color.WHITE);
        return root;


    }
}