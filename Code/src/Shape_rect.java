import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.scene.shape.StrokeType;

import java.io.Serializable;

public class Shape_rect extends Shapes implements Serializable {
    private Rectangle rect = new Rectangle();
    private float archeight;
    private float archwidth;
    private String color;
    private float layoutx;
    private float layouty;
    private float height;
    private float width;

    public Shape_rect(float arch,float arcw,String col, float layx,float layy, float heiht,float width){
        this.archeight = arch;
        this.archwidth = arcw;
        this.color = col;
        this.layoutx = layx;
        this.layouty = layy;
        this.height = heiht;
        this.width = width;

        display();
    }

    @Override
    public void display() {
        rect.setArcHeight(this.archeight);
        rect.setArcWidth(this.archwidth);
        rect.setFill(Paint.valueOf(this.color));
        rect.setLayoutX(this.layoutx);
        rect.setLayoutY(this.layouty);
        rect.setHeight(this.height);
        rect.setWidth(this.width);
    }

    @Override
    public Paint getcolor() {
        return rect.getFill();
    }

    @Override
    public Node node() {
        return rect;
    }

    public Rectangle getRect() {
        return rect;
    }

    public void setRect(Rectangle rect) {
        this.rect = rect;
    }

    public float getArcheight() {
        return archeight;
    }

    public void setArcheight(float archeight) {
        this.archeight = archeight;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public float getLayoutx() {
        return layoutx;
    }

    public void setLayoutx(float layoutx) {
        this.layoutx = layoutx;
    }

    public float getLayouty() {
        return layouty;
    }

    public void setLayouty(float layouty) {
        this.layouty = layouty;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public float getWidth() {
        return width;
    }

    public void setWidth(float width) {
        this.width = width;
    }

    public boolean collide(Ball b)
    {
        Shape s=Shape.intersect(rect,(Shape)b.node());
        return (s.getBoundsInParent().getWidth() != -1);
    }
}
