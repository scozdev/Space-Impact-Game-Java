package Logic;

import Gui.ImageModel;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class Character extends ImageModel {

    GameLogic gl;
    Input input;

    public long fire_cooldown = System.currentTimeMillis();
    public long lazer_cooldown = System.currentTimeMillis();//bekleme süresi = cd

    private int gunX = 3;
    ArrayList<Fire> guns = new ArrayList<Fire>();

    ArrayList<Lazer> lazers = new ArrayList<Lazer>();

    public ArrayList<Lazer> getLazers() {
        return lazers;
    }

    public ArrayList<Fire> getGuns() {
        return guns;
    }

    public Character(Input input, GameLogic gl) {
        this.gl = gl;
        this.input = input;
        this.dx = 2;
        this.dy = 2;
        this.y = 200 - (height / 2);
        this.x = (width / 2);
    }

    @Override
    public void update() {

        for (Fire fire : guns) {
            fire.setX(fire.getX() + gunX);
        }

        if (input.keyIs(KeyEvent.VK_UP)) {
            if (y <= (height / 2)) {
                y = height / 2;
            } else {
                y -= dy;
            }
        }

        if (input.keyIs(KeyEvent.VK_DOWN)) {
            if (y >= 430 - height) {
                y = 430 - height;
            } else {
                y += dy;
            }
        }

        if (input.keyIs(KeyEvent.VK_SPACE)) {
            if (System.currentTimeMillis() - fire_cooldown > 250) {
                guns.add(new Fire(this.x + gl.getFg().getPanel().image4.getWidth() / 4, this.y + gl.getFg().getPanel().image4.getHeight() / 8));
                fire_cooldown = System.currentTimeMillis();
            }
        }

        if (input.keyIs(KeyEvent.VK_CONTROL)) {
            if (System.currentTimeMillis() - lazer_cooldown > 4000) {
                lazers.add(new Lazer(this.x + gl.getFg().getPanel().image4.getWidth() / 4, this.y + gl.getFg().getPanel().image4.getHeight() / 8));
                lazer_cooldown = System.currentTimeMillis();//atesimi son olusturdugum sure
            }
        }

        if (input.keyIs(KeyEvent.VK_RIGHT)) {
            if (x >= 200) {
                x = 200;
            } else {
                x += dx;
            }
        }
        if (input.keyIs(KeyEvent.VK_LEFT)) {
            if (x <= 0) {
                x = 0;
            } else {
                x -= dx;
            }
        }

    }

}
