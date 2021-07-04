import javafx.animation.AnimationTimer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Point3D;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.media.AudioClip;
import javafx.scene.text.Text;
import javafx.scene.transform.Rotate;

import java.io.IOException;
import java.io.Serializable;
import java.net.URL;

public class NewPlayerDetails implements Serializable {

    @FXML
    private Group obs11;
    @FXML
    private Group obs22;

    @FXML
    private TextArea NameText;

    @FXML
    private TextArea UNameText;

    Rotate rotate11 = new Rotate();
    Rotate rotate22 = new Rotate();

    @FXML
    Button submit;
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
        }
    };

    public NewPlayerDetails(){ timer.start(); }
    public void dosubmit(ActionEvent e) throws IOException, ClassNotFoundException {
        URL path = getClass().getResource("/soundeffects/button.wav");
        AudioClip ac = new AudioClip(path.toString());
        ac.play();
        Player p=new Player(NameText.getText(),UNameText.getText());
        Frame.navigation.load("Player_Menu.fxml");
        Player_Menu temp=(Player_Menu)Frame.navigation.getControllers().get(Frame.navigation.getControllers().size()-1);
        temp.setMyPlayer(p);
//        p.setPlayer_menu(temp);
//        Login_Menu.addPlayer(p);
    }
}
