package sample;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

class Ball {
    private Circle circle;
    Ball() {
        circle = new Circle(100, 60, 10);
        circle.setFill(Color.WHITE);
        circle.setCenterX(210);
        circle.setCenterY(600);
    }

    private float yHieght;

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
