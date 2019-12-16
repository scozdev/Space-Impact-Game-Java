package Gui;

import Logic.Fire;
import Logic.GameLogic;
import Logic.Lazer;
import Logic.Monsters;
import Logic.Actions;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.imageio.stream.FileImageInputStream;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class PanelGui extends JPanel {

    private FrameGui fg;
    public BufferedImage image1, image2, image3, image4, image5, image6, image7, image8;

    public PanelGui(FrameGui fg) {

        this.fg = fg;

        try {
            image1 = ImageIO.read(new FileImageInputStream(new File("resim/a1.png")));
            image2 = ImageIO.read(new FileImageInputStream(new File("resim/a2.png")));
            image3 = ImageIO.read(new FileImageInputStream(new File("resim/a3.png")));
            image4 = ImageIO.read(new FileImageInputStream(new File("resim/a4.png")));
            image5 = ImageIO.read(new FileImageInputStream(new File("resim/a5.png")));
            image6 = ImageIO.read(new FileImageInputStream(new File("resim/a6.png")));
            image7 = ImageIO.read(new FileImageInputStream(new File("resim/a7.png")));
            image8 = ImageIO.read(new FileImageInputStream(new File("resim/a8.png")));

        } catch (IOException ex) {
            Logger.getLogger(PanelGui.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void repaint() {
        super.repaint();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        // background 
        g.drawImage(image2, fg.getGl().getBackground().x, 380, image2.getWidth() / 2, image2.getHeight() / 2, this);
        // Monsters
        for (Monsters monster : fg.getGl().getMonsters()) {
            g.drawImage(image3, monster.x, monster.y, image3.getWidth() / 4, image3.getHeight() / 4, this);

        }

        // Monsters fire
        for (Fire ates : fg.getGl().getFires()) {
            g.fillRect(ates.getX(), ates.getY(), 5, 3);
        }

        g.drawImage(image4, fg.getGl().getCharacter().x, fg.getGl().getCharacter().y, image4.getWidth() / 4, image4.getHeight() / 4, this);
        g.setColor(Color.RED);
//        for (Fire fire : fg.getGl().character.getGuns()) {
//            if (fire.getX() >= 850) {
//                fg.getGl().character.getGuns().remove(fire);
//            }
//        }
        for (Fire ates : fg.getGl().getCharacter().getGuns()) {
            g.fillRect(ates.getX(), ates.getY(), 5, 3);
        }

        for (int i = 0; i < fg.getGl().getCan(); i++) {
            g.drawImage(image1, 15 * i + 15, 15, 20, 20, this);
        }

        // enissss   
        for (Lazer lazer : fg.getGl().getCharacter().getLazers()) {
            g.fillRect(lazer.getX(), lazer.getY(), 850 - lazer.getX(), 6);
        }
        g.drawImage(image8, fg.getGl().getBackground().gunes_x, fg.getGl().getBackground().gunes_y, image8.getWidth() / 4, image8.getHeight() / 4, this);

        // Score
        g.setColor(Color.BLACK);
        Font stringFont = new Font("SansSerif", Font.PLAIN, 20);
        g.setFont(stringFont);
        g.drawString("Score : " + fg.getGl().getOlen_canavar(), 750, 20);

        //  oldumu
        if (fg.getGl().isDead()) {
            fg.getGl().getTimer().getTimer().stop();

            String message = "      Kaybettiniz \n"
                    + "     Score : " + fg.getGl().getOlen_canavar();

            JOptionPane.showMessageDialog(this, message);

            System.exit(0);

        }
    }

}
