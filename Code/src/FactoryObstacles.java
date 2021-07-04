import java.util.Random;

public class FactoryObstacles {
    public static Obstacle addObstacle(Game_Screen gs)
    {
        Random rand = new Random();
        int x = rand.nextInt(6);
        switch (x){
            case 0:
                return new Obstacle_1square(gs);
            case 1:
                return new Obstacle_1Windmill(gs);
            case 2:
                return new Obstacle_2square(gs);
            case 3:
                return new Obstacle_2Windmill(gs);
            case 4:
                return new Obstacle_circle(gs);
            case 5:
                return new Obstacle_ConcentricCircle(gs);
            default:
                return new Obstacle_circle(gs);
        }
    }
}
