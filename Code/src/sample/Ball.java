package sample;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

class Ball {
    private Circle circle;
    Ball() {
        circle = new Circle(10, 60, 10);
        circle.setFill(Color.YELLOW);
        circle.setCenterX(210);
        circle.setCenterY(600);
    }

    private float yHieght;

    public float getyHieght() {
        return yHieght;
    }

    public void setyHieght(float yHieght) {
        this.yHieght = yHieght;
    }

    private final float gravity=10;

    public float getYSpeed() {
        return YSpeed;
    }

    private float YSpeed = 5;

    public void setYSpeed(float YSpeed) {
        this.YSpeed = YSpeed;
    }

    public float getGravity() {
        return gravity;
    }

    Circle position() {
        return circle;
    }
}
