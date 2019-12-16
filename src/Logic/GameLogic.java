package Logic;

import Gui.FrameGui;
import Gui.PanelGui;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.ImageIcon;

public class GameLogic {

    private Input input = null;
    private Character character = null;
    private Background background = null;
    private ArrayList<Monsters> monsters = new ArrayList<Monsters>();
    private ArrayList<Fire> fires = new ArrayList<Fire>();
    private Actions timer = null;
    private FrameGui fg = null;

    private boolean dead = false;
    private int can = 3;
    private int olen_canavar = 0;

    public GameLogic(FrameGui fg) {
        this.fg = fg;
        monsters.add(new Monsters(this, 900, 100, fg.getPanel().image1));
        timer = new Actions(this);
    }

    public void init() {

    }

    public Actions getTimer() {
        return timer;
    }

    public Input getInput() {
        if (input == null) {
            input = new Input();
        }
        return input;
    }

    public ArrayList<Monsters> getMonsters() {
        return monsters;
    }

    public void setMonsters(ArrayList<Monsters> monsters) {
        this.monsters = monsters;
    }

    public ArrayList<Fire> getFires() {
        return fires;
    }

    public void setFires(ArrayList<Fire> fires) {
        this.fires = fires;
    }

    public boolean isDead() {
        return dead;
    }

    public void setDead(boolean dead) {
        this.dead = dead;
    }

    public int getCan() {
        return can;
    }

    public void setCan(int can) {
        this.can += can;
    }

    public int getOlen_canavar() {
        return olen_canavar;
    }

    public void setOlen_canavar(int olen_canavar) {
        this.olen_canavar += olen_canavar;
    }

    public Character getCharacter() {
        if (character == null) {
            character = new Character(getInput(), this);
        }
        return character;
    }

    public Background getBackground() {
        if (background == null) {
            background = new Background(getInput());
        }
        return background;
    }

    public FrameGui getFg() {
        return fg;
    }

}
