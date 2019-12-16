package Logic;

import Gui.ImageModel;
import java.awt.event.KeyEvent;

public class Background extends ImageModel {

    Input input;
    public int gunes_x = 0, gunes_y = 0;
    public int gunes_x_hareket = 4, gunes_y_hareket = 1;

    public Background(Input input) {
        this.input = input;
        this.x = 0;
        this.dx = 1;
    }

    @Override
    public void update() {
        x -= dx;
        gunes_y += gunes_y_hareket;
        gunes_x += gunes_x_hareket;

        if (x < -900) {
            x = -390;
        }

        if (gunes_y >= 100 || gunes_y <= 0) {
            gunes_y_hareket = -gunes_y_hareket;
        }
        if (gunes_x >= 800 || gunes_x <= 0) {
            gunes_x_hareket = -gunes_x_hareket;
        }

    }

    public int getGunes_x() {
        return gunes_x;
    }

    public void setGunes_x(int gunes_x) {
        this.gunes_x = gunes_x;
    }

    public int getGunes_y() {
        return gunes_y;
    }

    public void setGunes_y(int gunes_y) {
        this.gunes_y = gunes_y;
    }

}
