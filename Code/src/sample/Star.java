package sample;

import javafx.scene.Group;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;

class Star {
    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    private float x;
    private float y;

    Star(float x, float y){
        setX(x);
        setY(y);
    }

    Pane colorChane() {
        Arc colorchange1 = new Arc(getX(), getY(), 10.0f, 10.0f, 0.0f, 90.0f);
        Arc colorchange2 = new Arc(getX(), getY(), 10.0f, 10.0f, 90.0f, 90.0f);
        Arc colorchange3 = new Arc(getX(), getY(), 10.0f, 10.0f, 180.0f, 90.0f);
        Arc colorchange4 = new Arc(getX(), getY(), 10.0f, 10.0f, 270.0f, 90.0f);
        colorchange1.setType(ArcType.ROUND);
        colorchange2.setType(ArcType.ROUND);
        colorchange3.setType(ArcType.ROUND);
        colorchange4.setType(ArcType.ROUND);
        colorchange1.setStroke(Color.WHITE);
        colorchange2.setStroke(Color.WHITE);
        colorchange3.setStroke(Color.WHITE);
        colorchange4.setStroke(Color.WHITE);
        colorchange1.setFill(Color.WHITE);
        colorchange2.setFill(Color.WHITE);
        colorchange3.setFill(Color.WHITE);
        colorchange4.setFill(Color.WHITE);

        Pane colorchange = new Pane();
        colorchange.getChildren().addAll(colorchange1, colorchange2, colorchange3, colorchange4);

        return colorchange;

    }

}
