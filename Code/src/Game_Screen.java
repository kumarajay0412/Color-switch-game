import javafx.animation.AnimationTimer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Bounds;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.AudioClip;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.shape.SVGPath;

import java.io.IOException;
import java.io.Serializable;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import java.util.ResourceBundle;

public class Game_Screen implements Initializable, Serializable {
    @FXML
    private Button pause;
    @FXML
    private AnchorPane pane;

    public AnchorPane getPane() {
        return pane;
    }

    @FXML
    private Label score;
    private int scoreval;

    public int getScoreval() {
        return scoreval;
    }

    public Player getMyPlayer() {
        return myPlayer;
    }

    public void setMyPlayer(Player myPlayer) {
        this.myPlayer = myPlayer;
    }

    private Player myPlayer;

    public int getCurscore() {
        return curscore;
    }

    public void setCurscore(int curscore) {
        this.curscore = curscore;
    }

    private int curscore=0;

    private ArrayList<Obstacle> onscreenobstacles = new ArrayList<>();
    private ArrayList<Collider> onscreencolliders=new ArrayList<>();
    private Ball ball;



    private double toadd = 0.05;
    private double add = 5;
    private boolean flag = true;
    private boolean jumphappened=false;
    private int jumpcount=0;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        scoreval = Integer.parseInt(score.getText());
        onscreenobstacles.add(new Obstacle_circle(this));
        onscreenobstacles.add(new Obstacle_2Windmill(this));
        Obstacle tt=new Obstacle_1square(this);
        tt.node().setLayoutY(-350);
        onscreenobstacles.add(tt);


        for (Obstacle o:onscreenobstacles)
            onscreencolliders.add(o);

        onscreencolliders.add(new ColorSwitch());

        for (Collider c:onscreencolliders)
            pane.getChildren().add(c.node());

        timer.start();
        ball=new Ball((colors[new Random().nextInt(4)]));

        pane.getChildren().add(ball.node());
        score.setText("0");
    }


    AnimationTimer timer = new AnimationTimer() {
        @Override
        public void handle(long l) {
            if(checkpause())
            {
                try {
                    if(checkcollide(ball))
                    {
                        System.out.println("Collided");
//                        timer.stop();
                        System.out.println("DONE ========================" +
                                "\n \n \n \n \n \n \n \n \n \n \n \n \n" +
                                "DONE ===================" );
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                rotate();
                fall();
                updatescreen();
                if (jumphappened)
                {
                    jump();
                    jumphappened = !(jumpcount > 10);
                    if (!jumphappened)
                        jumpcount = 0;
                }
            }
        }
    };

    public void increaseScore()
    {
        curscore++;
        myPlayer.setPlayerscore(myPlayer.getPlayerscore()+1);
        if(myPlayer.getBestscore()<curscore)
            myPlayer.setBestscore(curscore);
        score.setText(Integer.toString(curscore));
    }




    private void updatescreen()
    {
        for (int i=0;i<onscreenobstacles.size();i++)
        {
            Obstacle c=onscreenobstacles.get(i);
            if(c.node().getBoundsInParent().getMinY()>700)
            {
                Obstacle o=FactoryObstacles.addObstacle(this);
                ColorSwitch newcolorswitch=addColorSwitch();

                onscreencolliders.add(o);
                onscreencolliders.add(newcolorswitch);
                onscreenobstacles.add(o);

                pane.getChildren().add(o.group);
                pane.getChildren().add(newcolorswitch.node());

                onscreencolliders.remove(c);
                onscreenobstacles.remove(c);
                pane.getChildren().removeAll(c.node());

                double lower = o.group.getBoundsInParent().getCenterY();
                o.group.setLayoutY(o.group.getLayoutY() -250 - lower);
                newcolorswitch.node().setLayoutY(o.group.getBoundsInParent().getMinY()-80);
            }
        }
    }


    private Star addStar()
    {
        return new Star(0,0);
    }



    private ColorSwitch addColorSwitch()
    {
        return new ColorSwitch();
    }


    private boolean checkcollide(Ball b) throws IOException {
        Collider temp = null;
        for(Collider c:onscreencolliders)
        {
            if(c.collide(b))
            {
                if (c instanceof Obstacle) {
                    URL path = getClass().getResource("/soundeffects/dead.wav");
                    AudioClip ac = new AudioClip(path.toString());
                    ac.play();
                    Frame.navigation.load("Score_Menu.fxml");
                    ScoreMenu sc = (ScoreMenu) Frame.navigation.getControllers().get(Frame.navigation.getControllers().size()-1);
                    sc.setScoreval(Integer.parseInt(score.getText()));
                    sc.setBestscoreval(myPlayer.getBestscore());
                    sc.setTotalscoreval(myPlayer.getPlayerscore());
                    sc.setMyplayer(myPlayer);
                    sc.setMyGameScreen(this);
                    return true;
                }
                if(c instanceof ColorSwitch) {
                    temp = c;
                    URL path = getClass().getResource("/soundeffects/colorswitch.wav");
                    AudioClip ac = new AudioClip(path.toString());
                    ac.play();
                }
                if(c instanceof Star) {
                    temp = c;
                }
            }
        }
        if(temp!=null)
        {
            onscreencolliders.remove(temp);
            pane.getChildren().remove(temp.node());
        }
        return false;
    }


    boolean checkpause()
    {
        return pane.getScene()!=null;
    }



    void movedown()
    {
        if(ball.node().getBoundsInParent().getMinY()<400)
        {
            for (Collider c:onscreencolliders)
                c.node().setLayoutY(c.node().getLayoutY()+3.5);
        }
    }

    void rotate()
    {
        for(Obstacle o: onscreenobstacles)
            o.rotate();
    }

    public void pauseclick(ActionEvent e) throws IOException {

        Frame.navigation.load("Pause.fxml");
        Pause  p =(Pause) Frame.navigation.getControllers().get(Frame.navigation.getControllers().size()-1);
        p.setMyplayer(myPlayer);
        p.setMygamescreen(this);
    }

    public void jumpwanted(MouseEvent e){
        jumphappened=true;
        URL path = getClass().getResource("/soundeffects/bulle.wav");
        AudioClip ac = new AudioClip(path.toString());
        ac.play();
    }

    private void jump()
    {
        flag = false;
        add = 1;
        ball.node().setTranslateY(ball.node().getTranslateY()-5);
        jumpcount+=1;
        movedown();
    }

    public void fall(){
        if(!flag) {ball.node().setTranslateY(ball.node().getTranslateY()+add+toadd);add+=toadd;}
    }


    public void recreate_screen(Game_State g){
        while (onscreencolliders.size()!=0){
            Collider temp = onscreencolliders.get(0);
            pane.getChildren().removeAll(temp.node());
            onscreencolliders.remove(0);
        }
        onscreenobstacles = new ArrayList<>();
        System.out.println(g.getAllcolliders().size());

        for(Collider_state col:g.getAllcolliders()){
            Collider temp = null;
            switch (col.getOption()){
                case 1:
                    //colorswitch
                    temp = new ColorSwitch();
                    temp.node().setLayoutY(col.getLayouty());
                    break;
                case 2:
                    //obs1square
                    temp = new Obstacle_1square(this);
                    temp.node().setLayoutY(col.getLayouty());
                    temp.node().setRotate(col.getRotation());
                    break;
                case 3:
                    //obs2square
                    temp = new Obstacle_2square(this);
                    temp.node().setLayoutY(col.getLayouty());
                    temp.node().setRotate(col.getRotation());
                    break;
                case 4:
                    //1windmill
                    temp = new Obstacle_1Windmill(this);
                    temp.node().setLayoutY(col.getLayouty());
                    temp.node().setRotate(col.getRotation());
                    break;
                case 5:
                    //2windmill
                    temp = new Obstacle_2Windmill(this);
                    temp.node().setLayoutY(col.getLayouty());
                    temp.node().setRotate(col.getRotation());
                    break;
                case 6:
                    //circle
                    temp = new Obstacle_circle(this);
                    temp.node().setLayoutY(col.getLayouty());
                    temp.node().setRotate(col.getRotation());
                    break;
                case 7:
                    //concircle
                    temp = new Obstacle_ConcentricCircle(this);
                    temp.node().setLayoutY(col.getLayouty());
                    temp.node().setRotate(col.getRotation());
                    break;
            }
            onscreencolliders.add(temp);
            if(temp instanceof Obstacle){
                onscreenobstacles.add((Obstacle) temp);
            }
        }
        for(Collider coli : onscreencolliders){
            pane.getChildren().add(coli.node());
        }
        pane.getChildren().removeAll(ball.node());
        ball = new Ball(g.getColor());
        ball.node().setLayoutY(g.getBall_y());
        pane.getChildren().addAll(ball.node());
        score.setText(Integer.toString(g.getScore()));
    }

    public Game_State Save_game(){
        Game_State gs = new Game_State();
        for(Collider o: onscreencolliders){
            int op;
            if(o instanceof ColorSwitch) op = 1;
            else if(o instanceof Obstacle_1square) op = 2;
            else if (o instanceof Obstacle_2square) op = 3;
            else if(o instanceof Obstacle_1Windmill) op = 4;
            else if (o instanceof Obstacle_2Windmill) op = 5;
            else if (o instanceof Obstacle_circle) op =6;
            else op= 7;
            Collider_state curr = new Collider_state(op,o.node().getLayoutY(),o.node().getRotate());
            gs.addcollider(curr);
        }
        System.out.println(gs.getAllcolliders().size());
        gs.setScore(Integer.parseInt(score.getText()));
        gs.setBall_y(ball.node().getBoundsInParent().getCenterY());
        gs.setColor(ball.getColour());
        return gs;
    }

    private String[] colors={"FAE100","900DFF","FF0181","32DBF0"};
}
