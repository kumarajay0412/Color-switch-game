import javafx.animation.AnimationTimer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Point3D;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.media.AudioClip;
import javafx.scene.transform.Rotate;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Login_Menu implements Initializable,Serializable {

    @FXML
    private Group obs1;
    @FXML
    private Group obs2;
    @FXML
    private Group obs11;
    @FXML
    private Group obs22;
    @FXML
    private Button newplayer;
    @FXML
    private Group t1;
    @FXML
    private Group t2;

    static ObjectInputStream in;
    static ObjectOutputStream out;


    Rotate rotate1 = new Rotate();
    Rotate rotate2 = new Rotate();
    Rotate rotate11 = new Rotate();
    Rotate rotate22 = new Rotate();
    Rotate rotatet1 = new Rotate();
    Rotate rotatet2 = new Rotate();

    AnimationTimer timer = new AnimationTimer() {
        @Override
        public void handle(long l) {
            rotate();
        }
    };

    void rotate()
    {
        rotate1.setPivotX(0);
        rotate1.setPivotY(0);
        rotate1.setAxis(new Point3D(0,0,1));
        rotate2.setPivotX(163);
        rotate2.setPivotY(140);
        rotate2.setAxis(new Point3D(0,0,1));
        obs1.getTransforms().addAll(rotate1);
        obs2.getTransforms().addAll(rotate2);
        rotate1.setAngle(1.5);
        rotate2.setAngle(3);

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

        //t1
        rotatet1.setPivotX(74);
        rotatet1.setPivotY(159);
        rotatet1.setAxis(new Point3D(0,0,1));
        t1.getTransforms().addAll(rotatet1);
        rotatet1.setAngle(2);

        //t2
        rotatet2.setPivotX(74);
        rotatet2.setPivotY(159);
        rotatet2.setAxis(new Point3D(0,0,1));
        t2.getTransforms().addAll(rotatet2);
        rotatet2.setAngle(-2);

    }


    public void exit(ActionEvent e){
        URL path = getClass().getResource("/soundeffects/button.wav");
        AudioClip ac = new AudioClip(path.toString());
        ac.play();
        // for delay in threading
        for(int i=0;i<1000000000;i++){;}
        System.exit(0);
    }

    public void Exiting_Player(ActionEvent e) throws IOException, ClassNotFoundException {
        URL path = getClass().getResource("/soundeffects/button.wav");
        AudioClip ac = new AudioClip(path.toString());
        ac.play();
        Frame.navigation.load("Existing_Player_Details.fxml");
    }

    public static void addPlayer(Player p) throws IOException {

        System.out.println("game is saving" + p.getName());
        File f = new File("Players.txt");
        if(f.isFile()){
            out=new MyObjectOutputStream(new FileOutputStream("Players.txt",true));
        }
        else {
            out = new ObjectOutputStream(new FileOutputStream("Players.txt", true));
        }
        out.writeObject(p);

    }


    public void New_Player(ActionEvent e){
        URL path = getClass().getResource("/soundeffects/button.wav");
        AudioClip ac = new AudioClip(path.toString());
        ac.play();
        Frame.navigation.load("New_Player_Details.fxml");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        timer.start();
    }




}
