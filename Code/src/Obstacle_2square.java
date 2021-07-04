import javafx.geometry.Point3D;
import javafx.scene.Group;
import javafx.scene.media.AudioClip;
import javafx.scene.shape.Circle;
import javafx.scene.transform.Rotate;

import java.io.Serializable;
import java.net.URL;
import java.util.ArrayList;

public class Obstacle_2square extends Obstacle implements Serializable {

    private Shape_rect rect1;
    private Shape_rect rect2;
    private Shape_rect rect3;
    private Shape_rect rect4;

    private Shape_rect rect5;
    private Shape_rect rect6;
    private Shape_rect rect7;
    private Shape_rect rect8;
    private Star s = new Star(0,0);
    private Group grp1 = new Group(); //bigger square
    private Group grp2 = new Group(); //small square

    private ArrayList<Shapes> allshapes=new ArrayList<>();

    @Override
    public void display() {
        rect1 = new Shape_rect(50,100,colors[0],0,0,261,26);
        rect2 = new Shape_rect(50,100,colors[1],118,-116,261,26);
        rect3 = new Shape_rect(50,100,colors[2],235,0,261,26);
        rect4 = new Shape_rect(50,100,colors[3],118,117,261,26);

        rect2.getRect().setRotate(90);
        rect4.getRect().setRotate(90);

        allshapes.add(rect1);
        allshapes.add(rect2);
        allshapes.add(rect3);
        allshapes.add(rect4);

        grp1.getChildren().addAll(rect1.getRect(),rect2.getRect(),rect3.getRect(),rect4.getRect());

        //group1 properties
        grp1.setLayoutX(119);
        grp1.setScaleX(0.6);
        grp1.setScaleY(0.6);

        rect5 = new Shape_rect(50,100,colors[0],0,0,261,26);
        rect6 = new Shape_rect(50,100,colors[1],118,-116,261,26);
        rect7 = new Shape_rect(50,100,colors[2],235,0,261,26);
        rect8 = new Shape_rect(50,100,colors[3],118,117,261,26);

        rect6.getRect().setRotate(90);
        rect8.getRect().setRotate(90);

        allshapes.add(rect5);
        allshapes.add(rect6);
        allshapes.add(rect7);
        allshapes.add(rect8);

        allshapes.add(s);

        grp2.getChildren().addAll(rect5.getRect(),rect6.getRect(),rect7.getRect(),rect8.getRect());

        //group2 properties
        grp2.setLayoutX(119);
        grp2.setRotate(45);
        grp2.setScaleX(0.4);
        grp2.setScaleY(0.4);


        grp1.getChildren().add(s.getStar());
        s.getStar().setScaleX(0.85);
        s.getStar().setScaleY(0.85);
        s.getStar().setLayoutX(-63);
        s.getStar().setLayoutY(-62);
        group.getChildren().addAll(grp1,grp2);

        //group properties

    }

    @Override
    public Star getS() {
        return s;
    }

    private Rotate rotatesquare1 = new Rotate();
    private Rotate rotatesquare2 = new Rotate();

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
                    grp1.getChildren().remove(s.node());
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
        //rotate big square
        rotatesquare1.setPivotX(130.75);
        rotatesquare1.setPivotY(130.5);
        rotatesquare1.setAxis(new Point3D(0,0,1));
        grp1.getTransforms().addAll(rotatesquare1);
        rotatesquare1.setAngle(1.5);

        //rotate small square
        rotatesquare2.setPivotX(130.75);
        rotatesquare2.setPivotY(130.5);
        rotatesquare2.setAxis(new Point3D(0,0,1));
        grp2.getTransforms().addAll(rotatesquare2);
        rotatesquare2.setAngle(-1);
        s.starsize();
    }


    public Obstacle_2square(Game_Screen g) {
        super(g);
        display();
    }
}
