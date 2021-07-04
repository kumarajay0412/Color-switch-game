import java.io.Serializable;

public class Collider_state implements Serializable {
    private int option;
    private double layouty;
    private double rotation;


    public int getOption() {
        return option;
    }

    public void setOption(int option) {
        this.option = option;
    }

    public double getLayouty() {
        return layouty;
    }

    public void setLayouty(double layouty) {
        this.layouty = layouty;
    }

    public double getRotation() {
        return rotation;
    }

    public void setRotation(double rotation) {
        this.rotation = rotation;
    }

    public Collider_state(int option , double layouty, double rotation){
        this.option = option;
        this.layouty = layouty;
        this.rotation = rotation;
    }
}
