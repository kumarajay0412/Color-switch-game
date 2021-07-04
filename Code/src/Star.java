import javafx.animation.PathTransition;
import javafx.animation.Transition;
import javafx.animation.TranslateTransition;
import javafx.scene.Node;
import javafx.scene.paint.Paint;
import javafx.scene.shape.SVGPath;
import javafx.scene.shape.Shape;

import java.io.Serializable;

public class Star extends Shapes implements Serializable {
    private final SVGPath star=new SVGPath();

    public SVGPath getStar() {
        return star;
    }

    public Star(double layoutx, double layouty) {
        display();
        star.setLayoutY(layouty);
        star.setLayoutX(layoutx);
        star.setFill(Paint.valueOf("WHITE"));
    }

    private boolean less=false;
    private int cnt = 100;
    void starsize()
    {

        double X = star.getScaleX();
        if(cnt >=120)
            less=true;
        if(cnt < 80)
            less=false;
        if(less)
        {
            star.setScaleX(X-0.01);
            star.setScaleY(X-0.01);
            cnt--;
        }
        else
        {
            star.setScaleX(X+0.01);
            star.setScaleY(X+0.01);
            cnt++;
        }
    }

    @Override
    public void display() {
        star.setContent("M 192.000 212.000L 212.000 226.641L" +
                " 209.321 202.000L 232.000 192.000L" +
                " 209.321 182.000L 212.000 157.359L" +
                " 192.000 172.000L 172.000 157.359L" +
                " 174.679 182.000L 152.000 192.000L " +
                "174.679 202.000L 172.000 226.641z");
    }

    @Override
    public Paint getcolor() {
        return star.getFill();
    }

    @Override
    public Node node() {
        return star;
    }

    @Override
    public boolean collide(Ball b) {
        Shape s = Shape.intersect(star,(Shape) b.node());
        if(s.getBoundsInParent().getWidth() != -1){
            return true;
        }
        return false;
    }
}
