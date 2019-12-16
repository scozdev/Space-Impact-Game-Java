package Gui;

import java.awt.Image;

public abstract class ImageModel {

    public Image img = null;
    public int x = 0;
    public int y = 0;
    public double dx = 0;
    public double dy = 0;
    public int width = 0;
    public int height = 0;

    public abstract void update();

}
