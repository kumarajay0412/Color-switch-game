package sample;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import java.util.ArrayList;


public class Main extends Application {
    static ArrayList<Shapes> shape = new ArrayList<>();

    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setTitle("Color Switch");
        Best b1;

        b1 = new Best(primaryStage);
        Group root = new Group(b1.mainMenu());
        primaryStage.setScene(new Scene(root, 425, 750, Color.rgb(39,39,39)));
        new Best(primaryStage);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

interface OP {
    void touch();
    void display();
}
