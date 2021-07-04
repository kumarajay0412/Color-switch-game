import javafx.animation.AnimationTimer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Point3D;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.AudioClip;
import javafx.scene.transform.Rotate;

import java.net.URL;
import java.util.ResourceBundle;

public class Game_To_Load implements Initializable {
    @FXML
    private Group obs11;
    @FXML
    private Group obs22;

    @FXML
    private TextArea ID;
    @FXML
    private Button button;

    @FXML
    private ListView<String> gamelist;

    private Player myplayer;

    public Player getMyplayer() {
        return myplayer;
    }

    public void setMyplayer(Player myplayer) {
        this.myplayer = myplayer;
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
        }
    };


    public void click(ActionEvent e){
        URL path = getClass().getResource("/soundeffects/button.wav");
        AudioClip ac = new AudioClip(path.toString());
        ac.play();

        Game_State gstate = null;
        if(ID.getText()==null)
            return;
        if(ID.getText().equals(""))
            return;
        for(Game_State gs:myplayer.getGamestates())
        {
            if(gs.getDate().equals(ID.getText()))
                gstate=gs;
        }
        Frame.navigation.load("Game_Screen.fxml");
        if(gstate==null)
            return;
        Game_Screen gsscreen =(Game_Screen)Frame.navigation.getControllers().get(Frame.navigation.getControllers().size()-1);
        gsscreen.setMyPlayer(myplayer);
        gsscreen.recreate_screen(gstate);
    }

    public void onlistclick(MouseEvent mouseEvent) {

        ID.setText(gamelist.getSelectionModel().getSelectedItem());
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        timer.start();
    }
    public void showList()
    {
        for(Game_State gstate:myplayer.getGamestates())
        {
            gamelist.getItems().add(gstate.getDate());
        }
        if(gamelist.getItems().size()==0)
            button.setDisable(true);
    }

    public void goback(ActionEvent actionEvent) {
        URL path = getClass().getResource("/soundeffects/button.wav");
        AudioClip ac = new AudioClip(path.toString());
        ac.play();
        Frame.navigation.GoBack();
    }
}
