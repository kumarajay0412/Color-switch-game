import javafx.animation.FadeTransition;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class Navigation {

    private final Stage stage;
    private final Scene scene;

    private List<Parent> Roots = new ArrayList<>();

    private List<Object> Controllers=new ArrayList<>();

    public List<Parent> getRoots() {
        return Roots;
    }

    public void setRoots(List<Parent> roots) {
        Roots = roots;
    }

    public List<Object> getControllers() {
        return Controllers;
    }

    public void setControllers(List<Object> controllers) {
        Controllers = controllers;
    }

    public Navigation(Stage stage)
    {
        this.stage = stage;
        scene = new Scene(new Pane(),480,700);
        stage.setScene(scene);
    }

    public void load(String sUrl)
    {
        try {
            //loads the fxml file
            FXMLLoader f=new FXMLLoader();
            Parent root = f.load(getClass().getResource(sUrl).openStream());
            Roots.add(root);
            Object o=f.getController();
            Controllers.add(o);
            System.out.println();
            scene.setRoot(root);
            stage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }

    }

    public void setroot(Parent root,Object whichclass)
    {
        Controllers.add(whichclass);
        Roots.add(root);
        scene.setRoot(root);
        stage.show();
    }

    public void GoBack()
    {
        if (Roots.size() > 1)
        {
            Roots.remove((Roots.size() - 1));
            Controllers.remove(Controllers.size()-1);
            scene.setRoot(Roots.get(Roots.size() - 1));
        }
    }

    public void cleanPrevious()
    {
        while(Roots.size()>1) {
            Roots.remove(0);
            Controllers.remove(0);
        }
    }
}
