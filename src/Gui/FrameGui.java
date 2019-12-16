package Gui;

import Logic.GameLogic;
import Logic.Input;
import Logic.Actions;
import javax.swing.JFrame;

public class FrameGui {

    private GameLogic gl = null;

    private JFrame frame = null;
    private PanelGui panel = null;

    public FrameGui() {

    }

    public PanelGui getPanel() {
        if (panel == null) {
            panel = new PanelGui(this);
        }
        return panel;
    }

    public void setPanel(PanelGui panel) {
        this.panel = panel;
    }

    public GameLogic getGl() {
        if (gl == null) {
            gl = new GameLogic(this);
        }
        return gl;
    }

    public void setGl(GameLogic gl) {

        this.gl = gl;
    }

    public JFrame getFrame() {
        if (frame == null) {
            frame = new JFrame("Uzay Oyunu");
            frame.setSize(850, 500);
            frame.setResizable(false);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLocationRelativeTo(null);

            getGl().init();
            frame.addKeyListener(getGl().getInput());

            frame.add(getPanel());

            frame.setVisible(true);
        }
        return frame;
    }

    public void setFrame(JFrame frame) {
        this.frame = frame;
    }

}
