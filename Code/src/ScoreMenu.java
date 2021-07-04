import javafx.animation.AnimationTimer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Point3D;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.AudioClip;
import javafx.scene.shape.SVGPath;
import javafx.scene.transform.Rotate;

import java.io.IOException;
import java.io.Serializable;
import java.net.URL;

public class ScoreMenu implements Serializable {
    @FXML
    private Group obs11;
    @FXML
    private Group obs22;
    @FXML
    private Button reload;
    @FXML
    private Button returnmain;
    @FXML
    private SVGPath star1;
    @FXML
    private SVGPath star2;
    @FXML
    private SVGPath star3;
    @FXML
    private ImageView heart;
    @FXML
    private Label score;
    @FXML
    private Label bestscore;
    @FXML
    private Label totalscore;

    public Player myplayer;

    public Player getMyplayer() {
        return myplayer;
    }

    public void setMyplayer(Player myplayer) {
        this.myplayer = myplayer;
    }

    private int scoreval;
    private int bestscoreval; // it is total score btw
    private int totalscoreval;

    private Game_Screen myGameScreen;

    public Game_Screen getMyGameScreen() {
        return myGameScreen;
    }

    public void setMyGameScreen(Game_Screen myGameScreen) {
        this.myGameScreen = myGameScreen;
    }

    public int getTotalscoreval() {
        return totalscoreval;
    }

    public void setTotalscoreval(int totalscoreval) {
        this.totalscoreval = totalscoreval;
    }

    public int getScoreval() {
        return scoreval;
    }

    public void setScoreval(int scoreval) {
        this.scoreval = scoreval;
    }

    public int getBestscoreval() {
        return bestscoreval;
    }

    public void setBestscoreval(int bestscoreval) {
        this.bestscoreval = bestscoreval;
    }

    Rotate rotate11 = new Rotate();
    Rotate rotate22 = new Rotate();

    AnimationTimer timer = new AnimationTimer() {
        @Override
        public void handle(long l) {
            //11
            rotate11.setPivotX(0);
            rotate11.setPivotY(0);
            rotate11.setAxis(new Point3D(0,0,1));
            obs11.getTransforms().addAll(rotate11);
            rotate11.setAngle(1.5);

            //22
            rotate22.setPivotX(0);
            rotate22.setPivotY(0);
            rotate22.setAxis(new Point3D(0,0,1));
            obs22.getTransforms().addAll(rotate22);
            rotate22.setAngle(1.5);

            animatereload();animatestars();
            score.setText(Integer.toString(scoreval));
            bestscore.setText(Integer.toString(bestscoreval));
            totalscore.setText(Integer.toString(totalscoreval));
        }
    };

    public void reloadgame(ActionEvent e){
        URL path = getClass().getResource("/soundeffects/button.wav");
        AudioClip ac = new AudioClip(path.toString());
        ac.play();
        Frame.navigation.GoBack();
        Frame.navigation.GoBack();
        Frame.navigation.GoBack();
        Frame.navigation.load("Game_Screen.fxml");
        Game_Screen gs=(Game_Screen)Frame.navigation.getControllers().get(Frame.navigation.getControllers().size()-1);
        gs.setMyPlayer(myplayer);
    }

    public void returntomain(ActionEvent e) throws IOException {
        URL path = getClass().getResource("/soundeffects/button.wav");
        AudioClip ac = new AudioClip(path.toString());
        ac.play();
        Frame.navigation.cleanPrevious();
        Frame.navigation.load("Player_menu.fxml");
        Player_Menu pm = (Player_Menu) Frame.navigation.getControllers().get(Frame.navigation.getControllers().size()-1);
        Login_Menu.addPlayer(myplayer);
        pm.setMyPlayer(myplayer);
    }

    private boolean less1 = false;
    public void animatereload(){
        double X=reload.getScaleX();
        if(X>=0.6)
            less1=true;
        if(X<=0.5)
            less1=false;
        if(less1)
        {
            reload.setScaleX(X-0.002);
            reload.setScaleY(X-0.002);
        }
        else
        {
            reload.setScaleX(X+0.002);
            reload.setScaleY(X+0.002);
        }
    }

    private boolean less = false;
    public void animatestars(){
        double X=reload.getScaleX()*4;
        if(X>=3)
            less=true;
        if(X<=2)
            less=false;
        if(less)
        {
            star1.setScaleX(X-0.002);
            star1.setScaleY(X-0.002);
            star2.setScaleX(X-0.002);
            star2.setScaleY(X-0.002);
            star3.setScaleX(X-0.002);
            star3.setScaleY(X-0.002);
        }
        else
        {
            star1.setScaleX(X+0.002);
            star1.setScaleY(X+0.002);
            star2.setScaleX(X+0.002);
            star2.setScaleY(X+0.002);
            star3.setScaleX(X+0.002);
            star3.setScaleY(X+0.002);
        }
    }

    public ScoreMenu(){ timer.start();}

    public void heartClicked(MouseEvent mouseEvent) {
        if(myplayer.getPlayerscore()>=10) {
            Game_State gstate=myGameScreen.Save_game();
            gstate.setBall_y(gstate.getBall_y()+50);
            myGameScreen.recreate_screen(gstate);
            myplayer.setPlayerscore(myplayer.getPlayerscore()-10);
            Frame.navigation.GoBack();
        }
    }
}
