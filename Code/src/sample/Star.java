package sample;

import javafx.scene.paint.Color;

class Star implements OP {
    Star() {
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
}