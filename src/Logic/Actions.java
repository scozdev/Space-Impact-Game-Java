package Logic;

import Gui.FrameGui;
import Gui.PanelGui;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.Random;
import javax.swing.Timer;

public class Actions implements ActionListener {

    private Timer timer;
    private Random rand = new Random();

    public Timer getTimer() {
        return timer;
    }

    private Input input;
    private GameLogic gl;

    public Actions(GameLogic gl) {
        this.gl = gl;

        timer = new Timer(10, this);
        timer.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        // update 
        gl.getBackground().update();
        gl.getCharacter().update();

        for (Monsters monster : gl.getMonsters()) {
            monster.update();
        }

        gl.getFg().getFrame().repaint();

        // canavar olusturma
        if (System.currentTimeMillis() - gl.getMonsters().get(gl.getMonsters().size() - 1).getCreating_time() > 3000) {
            gl.getMonsters().add(new Monsters(gl, 1000, gl.getFg().getPanel().image3.getHeight() / 4 + rand.nextInt(500 - 2 * (gl.getFg().getPanel().image3.getHeight() / 4)), gl.getFg().getPanel().image1));
        }

        for (Monsters monster : gl.getMonsters()) {
            // monsters fire  2 sn de bir ates
            if (System.currentTimeMillis() - gl.getMonsters().get(gl.getMonsters().size() - 1).getFire_creating_time() > 2000) {
                gl.getFires().add(new Fire(monster.x + (gl.getFg().getPanel().image3.getWidth() / 8), (monster.y + (gl.getFg().getPanel().image3.getHeight() / 8))));
                monster.setFire_creating_time(System.currentTimeMillis());
            }
        }

        // ates update
        for (Fire ates : gl.getFires()) {
            ates.setX(ates.getX() - 2);
        }

        // canavarla carpisma
        for (Iterator<Monsters> monster_iterator = gl.getMonsters().iterator(); monster_iterator.hasNext();) {
            Monsters monster = monster_iterator.next();

            Rectangle monster_rectangle = new Rectangle(gl.getCharacter().x, gl.getCharacter().y, gl.getFg().getPanel().image4.getWidth() / 4, gl.getFg().getPanel().image4.getHeight() / 4);
            if (monster_rectangle.intersects(new Rectangle(monster.x, monster.y, gl.getFg().getPanel().image4.getWidth() / 4, gl.getFg().getPanel().image4.getHeight() / 4))) {
                monster_iterator.remove();
                gl.setCan(-1);
            }

            // lazer canavar kontrol
//            for (Iterator<Lazer> lazers_iterator = gl.getCharacter().getLazers().iterator(); lazers_iterator.hasNext();) {
//                Lazer lazer = lazers_iterator.next();
//                if (monster_rectangle.intersects(new Rectangle(lazer.getX(), lazer.getY(), 800 - lazer.getX(), 6))) {
//
//                    if (System.currentTimeMillis() - lazer.getLazer_creating_time() > 250) {
//                        lazers_iterator.remove();
//                        monster_iterator.remove();
//
//                    }
//                }
//            }
        }

        for (Iterator<Fire> ates_iterator = gl.getCharacter().guns.iterator(); ates_iterator.hasNext();) {
            Fire fire = ates_iterator.next();

            for (Iterator<Monsters> monster_iterator = gl.getMonsters().iterator(); monster_iterator.hasNext();) {
                Monsters monster = monster_iterator.next();

                Rectangle monster_rectangle = new Rectangle(monster.x, monster.y, gl.getFg().getPanel().image4.getWidth() / 4, gl.getFg().getPanel().image4.getHeight() / 4);

                // karakter atesi ile canavar carpisma kontrolu
                if (monster_rectangle.intersects(new Rectangle(fire.getX(), fire.getY(), 5, 3))) {
                    ates_iterator.remove();
                    monster_iterator.remove();
                    gl.setOlen_canavar(1);
                }
            }

            // ates map i cikinca silelim
            if (fire.getX() > 820) {
                ates_iterator.remove();
            }

        }

        for (Iterator<Fire> canavar_ates_iterator = gl.getFires().iterator(); canavar_ates_iterator.hasNext();) {
            Fire fire = canavar_ates_iterator.next();

            Rectangle karakter_rectangle = new Rectangle(gl.getCharacter().x, gl.getCharacter().y, gl.getFg().getPanel().image4.getWidth() / 4, gl.getFg().getPanel().image4.getHeight() / 4);

            // canavar atesi bize deydimi
            if (karakter_rectangle.intersects(new Rectangle(fire.getX(), fire.getY(), 5, 3))) {

                canavar_ates_iterator.remove();
                gl.setCan(-1);

            }

            // canavarin 0 kordinattindan sonra haritadan sil mermileri
            if (fire.getX() < 0) {
                canavar_ates_iterator.remove();
            }

        }

        for (Iterator<Lazer> lazers_iterator = gl.getCharacter().getLazers().iterator(); lazers_iterator.hasNext();) {

            Lazer lazer = lazers_iterator.next();//iterator bosluktan basladigi icin ekledik

            if (System.currentTimeMillis() - lazer.getLazer_creating_time() > 250) {
                lazers_iterator.remove();
            }

            for (Iterator<Monsters> monster_iterator = gl.getMonsters().iterator(); monster_iterator.hasNext();) {
                Monsters monster = monster_iterator.next();

                Rectangle monster_rectangle = new Rectangle(monster.x, monster.y, gl.getFg().getPanel().image3.getWidth() / 4, gl.getFg().getPanel().image3.getHeight() / 4);

                if (monster_rectangle.intersects(new Rectangle(lazer.getX(), lazer.getY(), 800 - lazer.getX(), 6))) {
                    if (System.currentTimeMillis() - lazer.getLazer_creating_time() > 250) {
                        monster_iterator.remove();

                    }
                }
            }

        }

        if (gl.getCan() < 0) {
            gl.setDead(true);
        }

    }

}
