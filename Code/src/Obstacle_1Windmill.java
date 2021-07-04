import javafx.scene.Group;
import javafx.scene.shape.Circle;
import javafx.scene.transform.Rotate;

import java.io.Serializable;
import java.util.ArrayList;

public class Obstacle_1Windmill extends Obstacle implements Serializable {

    private Shape_rect rect1;
    private Shape_rect rect2;
    private Shape_rect rect3;
    private Shape_rect rect4;

    private Star s;



    private ArrayList<Shape_rect> allshapes = new ArrayList<>();
    public Obstacle_1Windmill(Game_Screen g){
        super(g);
        display();
    }
    @Override
    public void display() {
        rect1 = new Shape_rect(50,150,"ff0181",144,140,164,38);
        rect2 = new Shape_rect(150,50,"#32dbf0",0,121,38,164);
        rect3 = new Shape_rect(50,150,"#900dff",145,-24,164,38);
        rect4 = new Shape_rect(150,50,"#fae100",162,121,38,164);

        allshapes.add(rect1);
        allshapes.add(rect2);
        allshapes.add(rect3);
        allshapes.add(rect4);

        group.getChildren().addAll(rect1.getRect(),rect2.getRect(),rect3.getRect(),rect4.getRect());

        //gourp properties
        group.setLayoutX(5);
        group.setLayoutY(322);
        group.setScaleX(0.6);
        group.setScaleY(0.6);

    }

    private Rotate rotateobj = new Rotate();

    @Override
    public boolean collide(Ball c){
        for(Shape_rect s:allshapes)
        {
            if(s.collide(c) && !s.getRect().getFill().equals(c.getBallColor()))
                return true;

        }
        return false;
    }

    @Override
    public void rotate() {
        rotateobj.setPivotX(163);
        rotateobj.setPivotY(140);
        rotateobj.setAngle(1);
        group.getTransforms().add(rotateobj);
    }

    @Override
    public Star getS() {
        return null;
    }
}
