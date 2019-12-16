package Logic;

import Gui.ImageModel;
import java.awt.Image;

public class Monsters extends ImageModel {

    private long creating_time = System.currentTimeMillis();
    private long fire_creating_time = System.currentTimeMillis();

    GameLogic gl = null;

    public Monsters(GameLogic gl, int x, int y, Image img) {
        this.gl = gl;
        this.x = x;
        this.y = y;
        width = img.getWidth(null);
        height = img.getHeight(null);
        dx = 1;
    }

    @Override
    public void update() {
        x -= dx;

    }

    public long getCreating_time() {
        return creating_time;
    }

    public long getFire_creating_time() {
        return fire_creating_time;
    }

    public void setFire_creating_time(long fire_creating_time) {
        this.fire_creating_time = fire_creating_time;
    }

}
