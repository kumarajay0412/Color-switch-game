import java.io.Serializable;
import java.util.ArrayList;

public class Player implements Serializable
{
    private static int UID=0;
    private int ID=0;
    private String name;
    private String username;



//    private Player_Menu player_menu;
    private Game_State gamestate;

    private ArrayList<Game_State> gamestates=new ArrayList<>();

    private int playerscore=0;

    private int bestscore=0;

    public int getBestscore() {
        return bestscore;
    }

    public void setBestscore(int bestscore) {
        this.bestscore = bestscore;
    }

    public Game_State getGamestate() {
        return gamestate;
    }

    public void setGamestate(Game_State gamestatse) {
        this.gamestate = gamestatse;
        gamestates.add(gamestatse);
    }

    public ArrayList<Game_State> getGamestates() {
        return gamestates;
    }

    public void setGamestates(ArrayList<Game_State> gamestates) {
        this.gamestates = gamestates;
    }

    Player()
    {
        UID=this.ID;
    }

    public void start(){
        System.out.println(this.name + "i am here ");
        Frame.navigation.load("Player_Menu.fxml");
        Player_Menu pm = (Player_Menu) Frame.navigation.getControllers().get(Frame.navigation.getControllers().size()-1);
        pm.setMyPlayer(this);
    }

    Player(String name, String username)
    {
        this.name = name;
        this.username = username;
        UID++;
        UID=this.ID;
    }


    public String getName() {
        return name;
    }

    public String getUsername() {
        return username;
    }



    public int getPlayerscore() {
        return playerscore;
    }

    public void setPlayerscore(int playerscore) {
        this.playerscore = playerscore;

    }


}
