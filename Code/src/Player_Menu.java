import javafx.animation.Animation;
import javafx.animation.AnimationTimer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Point3D;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.media.AudioClip;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.net.URL;
import java.util.ArrayList;

public class Player_Menu implements Serializable {
    @FXML
    private Group obs1;
    @FXML
    private Group obs2;
    @FXML
    private Group obs11;
    @FXML
    private Group obs22;
    @FXML
    private Group obs3;
    @FXML
    private Group obs4;
    @FXML
    private Button newgame;
    @FXML
    private Button backtologin;
    @FXML
    private Button loadgame;

    private Player myPlayer;

    public Player getMyPlayer() {
        return myPlayer;
    }

    public void setMyPlayer(Player myPlayer) {
        this.myPlayer = myPlayer;
    }


    Rotate rotate1 = new Rotate();
    Rotate rotate2 = new Rotate();
    Rotate rotate11 = new Rotate();
    Rotate rotate22 = new Rotate();
    Rotate rotate3 = new Rotate();
    Rotate rotate4 = new Rotate();

    AnimationTimer timer = new AnimationTimer() {
        @Override
        public void handle(long l) {
            //1
            rotate1.setPivotX(0);
            rotate1.setPivotY(0);
            rotate1.setAxis(new Point3D(0,0,1));
            obs1.getTransforms().addAll(rotate1);
            rotate1.setAngle(1);

            //2
            rotate2.setPivotX(0);
            rotate2.setPivotY(0);
            rotate2.setAxis(new Point3D(0,0,1));
            obs2.getTransforms().addAll(rotate2);
            rotate2.setAngle(-1.5);

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

            //3
            rotate3.setPivotX(0);
            rotate3.setPivotY(0);
            rotate3.setAxis(new Point3D(0,0,1));
            obs3.getTransforms().addAll(rotate3);
            rotate3.setAngle(2);

            //4
            rotate4.setPivotX(71);
            rotate4.setPivotY(168);
            rotate4.setAxis(new Point3D(0,0,1));
            obs4.getTransforms().addAll(rotate4);
            rotate4.setAngle(2);
        }
    };

    public Player_Menu(){
        timer.start();
    }

    public void New_Game(ActionEvent e) throws IOException {
        //add also game
        URL path = getClass().getResource("/soundeffects/button.wav");
        AudioClip ac = new AudioClip(path.toString());
        ac.play();
        Frame.navigation.load("Game_Screen.fxml");
        Game_Screen gs=(Game_Screen)Frame.navigation.getControllers().get(Frame.navigation.getControllers().size()-1);
//        myPlayer.setGameScreen(gs);
        gs.setMyPlayer(myPlayer);
    }

    public void backlogin() throws IOException {
        URL path = getClass().getResource("/soundeffects/button.wav");
        AudioClip ac = new AudioClip(path.toString());
        ac.play();
        Frame.navigation.cleanPrevious();
        Frame.navigation.load("Login_Menu.fxml");
    }


    public void loadgame(ActionEvent e){

        URL path = getClass().getResource("/soundeffects/button.wav");
        AudioClip ac = new AudioClip(path.toString());
        ac.play();

        System.out.println(myPlayer.getGamestates().size());
        Frame.navigation.load("Game_To_Load.fxml");
        Game_To_Load gtl =(Game_To_Load) Frame.navigation.getControllers().get(Frame.navigation.getControllers().size()-1);
        gtl.setMyplayer(myPlayer);
        gtl.showList();
    }

}
