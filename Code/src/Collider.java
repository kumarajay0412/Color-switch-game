import javafx.scene.Node;

import java.io.Serializable;

public interface Collider extends Serializable {
    void display();
    Node node();
    boolean collide(Ball b);
    String[] colors={"FAE100","900DFF","FF0181","32DBF0"};
}
