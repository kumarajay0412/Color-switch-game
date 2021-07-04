import javafx.scene.Node;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.shape.StrokeType;

import java.io.Serializable;

public class Ball implements Serializable {

    private Circle ball=new Circle();

    private int score=0;

    public int getScore() {
        return score;
    }

    public void incrementScore()
    {
        score++;
    }
    private String colour;

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public Ball(String colour)
    {
        this.colour = colour;
        display();
        ball.setFill(Paint.valueOf(colour));
    }

    public Paint getBallColor()
    {
        return ball.getFill();
    }

    public void setBallColor(Paint p){ball.setFill(p);}

    private void display()
    {
        ball.setLayoutX(250);
        ball.setLayoutY(605);
        ball.setRadius(12);
        ball.setStroke(Paint.valueOf("BLACK"));
        ball.setStrokeType(StrokeType.INSIDE);
    }

    Node node()
    {
        return ball;
    }


}
