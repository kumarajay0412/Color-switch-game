import javafx.animation.AnimationTimer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.media.AudioClip;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.Serializable;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.ResourceBundle;

public class Pause implements Initializable, Serializable {
    @FXML
    private Button play;
    @FXML
    private Button home;
    @FXML
    private Button save;

    private boolean less1 = false;
    private boolean less2 = false;

    AnimationTimer timer = new AnimationTimer() {
        @Override
        public void handle(long l) {
            animateplay();animatesave();
        }
    };
    public void animateplay(){
        double X=play.getScaleX();
        if(X>=0.7)
            less1=true;
        if(X<=0.6)
            less1=false;
        if(less1)
        {
            play.setScaleX(X-0.002);
            play.setScaleY(X-0.002);
        }
        else
        {
            play.setScaleX(X+0.002);
            play.setScaleY(X+0.002);
        }
    }

    public void animatesave(){
        double X=save.getScaleX();
        if(X>=0.7)
            less2=true;
        if(X<=0.6)
            less2=false;
        if(less2)
        {
            save.setScaleX(X-0.002);
            save.setScaleY(X-0.002);
        }
        else
        {
            save.setScaleX(X+0.002);
            save.setScaleY(X+0.002);
        }
    }

    private Player myplayer;

    public Player getMyplayer() {
        return myplayer;
    }

    public void setMyplayer(Player myplayer) {
        this.myplayer = myplayer;
    }

    private  Game_Screen mygamescreen;

    public Game_Screen getMygamescreen() {
        return mygamescreen;
    }

    public void setMygamescreen(Game_Screen mygamescreen) {
        this.mygamescreen = mygamescreen;
    }

    public void saveanddisplscore(ActionEvent e) throws IOException {
        Game_State gstate = mygamescreen.Save_game();
        myplayer.setGamestate(gstate);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now=LocalDateTime.now();
        gstate.setDate(dtf.format(now));

        Frame.navigation.cleanPrevious();
        Frame.navigation.load("Player_menu.fxml");
        Player_Menu pm = (Player_Menu) Frame.navigation.getControllers().get(Frame.navigation.getControllers().size()-1);
        pm.setMyPlayer(myplayer);
        Login_Menu.addPlayer(myplayer);
    }

    public void gotohome(ActionEvent e) throws IOException {
        URL path = getClass().getResource("/soundeffects/button.wav");
        AudioClip ac = new AudioClip(path.toString());
        ac.play();
        Game_State gstate = mygamescreen.Save_game();
        myplayer.setGamestate(gstate);

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now=LocalDateTime.now();
        gstate.setDate(dtf.format(now));
        Login_Menu.addPlayer(myplayer);

        Frame.navigation.cleanPrevious();
        Frame.navigation.load("Player_menu.fxml");
        Player_Menu pm = (Player_Menu) Frame.navigation.getControllers().get(Frame.navigation.getControllers().size()-1);
        pm.setMyPlayer(myplayer);
    }

    public void back(ActionEvent e) throws IOException{
        URL path = getClass().getResource("/soundeffects/button.wav");
        AudioClip ac = new AudioClip(path.toString());
        ac.play();
        Frame.navigation.GoBack();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        timer.start();
    }
}
