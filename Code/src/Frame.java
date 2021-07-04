import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.application.Application;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.lang.module.FindException.*;
import java.util.ArrayList;
import java.util.List;


public class Frame extends Application implements Serializable {

    static Navigation navigation;
    static Login_Menu login_menu;

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("COLOR SWITCH (Ramit & Satwik)");
        navigation=new Navigation(stage);

        Frame.navigation.load("Login_Menu.fxml");
//        Frame.navigation.load("Existing_Player_Details.fxml");
    }

}
