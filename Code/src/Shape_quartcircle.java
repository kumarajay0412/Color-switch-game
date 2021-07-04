import javafx.scene.Node;
import javafx.scene.paint.Paint;
import javafx.scene.shape.SVGPath;
import javafx.scene.shape.Shape;

import java.io.Serializable;

public class Shape_quartcircle extends Shapes implements Serializable {

    private SVGPath quat = new SVGPath(); //quarter
    private int rotate;
    public Shape_quartcircle(float layoutx, float layouty, int rotate, String color) {
        this.layoutx = layoutx;
        this.layouty = layouty;
        this.rotate = rotate;
        this.color = color;
        display();
    }

    @Override
    public void display() {
        quat.setContent("M 150 300 Q 150 50 400 50 L 400 100 Q 200 100 200 300 L 150 300");
        quat.setFill(Paint.valueOf(color));
        quat.setLayoutX(layoutx);
        quat.setLayoutY(layouty);
        quat.setRotate(rotate);
    }

    @Override
    public Paint getcolor() {
        return quat.getFill();
    }

    @Override
    public Node node() {
        return quat;
    }

    public SVGPath getQuat() {
        return quat;
    }

    public void setQuat(SVGPath quat) {
        this.quat = quat;
    }

    @Override
    public boolean collide(Ball c){
        Shape s=Shape.intersect(quat,(Shape)c.node());
        return (s.getBoundsInParent().getWidth() != -1);
    }
}
