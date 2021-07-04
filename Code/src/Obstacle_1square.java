import javafx.geometry.Point3D;
import javafx.scene.media.AudioClip;
import javafx.scene.shape.Circle;
import javafx.scene.transform.Rotate;

import java.io.Serializable;
import java.net.URL;
import java.util.ArrayList;

public class Obstacle_1square extends Obstacle implements Serializable {

    private Shape_rect rect1;
    private Shape_rect rect2;
    private Shape_rect rect3;
    private Shape_rect rect4;
    private Star s;

    @Override
    public Star getS() {
        return s;
    }

    private ArrayList<Shapes> allshapes = new ArrayList<>();


    @Override
    public void display() {
        rect1 = new Shape_rect(50,100,"#fae100",0,0,261,26);
        rect2 = new Shape_rect(50,100,"#900dff",118,-116,261,26);
        rect3 = new Shape_rect(50,100,"#32dbf0",235,0,261,26);
        rect4 = new Shape_rect(50,100,"#ff0181",118,117,261,26);
        s=new Star(0,0);
        allshapes.add(rect1);
        allshapes.add(rect2);
        allshapes.add(rect3);
        allshapes.add(rect4);
        allshapes.add(s);

        group.getChildren().addAll(rect1.getRect(),rect2.getRect(),rect3.getRect(),rect4.getRect(),s.node());

        rect2.getRect().setRotate(90);
        rect4.getRect().setRotate(90);

        s.getStar().setScaleX(0.85);
        s.getStar().setScaleY(0.85);
        s.getStar().setLayoutX(-63);
        s.getStar().setLayoutY(-62);

        //gourp properties
        group.setLayoutX(119);
        group.setScaleX(0.6);
        group.setScaleY(0.6);

    }
    private Rotate rotatesquare1 = new Rotate();

    @Override
    public boolean collide(Ball c) {
        for(Shapes temp:allshapes)
        {
            if(temp.collide(c))
            {
                if(temp instanceof Star)
                {
                    URL path = getClass().getResource("/soundeffects/star.wav");
                    AudioClip ac = new AudioClip(path.toString());
                    ac.play();
                    gameScreen.increaseScore();
                    group.getChildren().remove(s.node());
                    return false;
                }
                else if (!c.getBallColor().equals(temp.getcolor()))
                    return true;
            }
        }
        return false;
    }

    @Override
    public void rotate() {
        rotatesquare1.setPivotX(130.75);
        rotatesquare1.setPivotY(130.5);
        group.getTransforms().addAll(rotatesquare1);
        rotatesquare1.setAngle(1.5);
        s.starsize();
    }

    public Obstacle_1square(Game_Screen g){
        super(g);
        display();
    }
}
