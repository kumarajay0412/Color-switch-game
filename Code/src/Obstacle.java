import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.shape.Circle;

import java.io.Serializable;

public abstract class Obstacle implements Collider, Serializable {

    protected Game_Screen gameScreen;

    protected String[] colors={"FAE100","900DFF","FF0181","32DBF0"};
    protected Group group = new Group();

    public Obstacle(Game_Screen g)
    {
        this.gameScreen=g;
    }


    public abstract boolean collide(Ball c);

    public abstract void rotate();

    public abstract Star getS();

    @Override
    public Node node() {
        return group;
    }
}

