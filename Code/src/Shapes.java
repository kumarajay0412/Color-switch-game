import javafx.scene.paint.Paint;

import java.io.Serializable;

public abstract class Shapes implements Collider, Serializable {
    protected float layoutx;
    protected float layouty;
    protected String color;

    public abstract void display();

    public abstract Paint getcolor();
}
