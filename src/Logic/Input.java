package Logic;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Input implements KeyListener {

    private static boolean[] keyPressed;

    public Input() {
        keyPressed = new boolean[6];
        for (int i = 0; i < 6; i++) {
            keyPressed[i] = false;
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        key(e, true);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        key(e, false);
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    public boolean keyIs(int keyCode) {
        switch (keyCode) {
            case KeyEvent.VK_UP:
                return keyPressed[0];
            case KeyEvent.VK_DOWN:
                return keyPressed[1];
            case KeyEvent.VK_SPACE:
                return keyPressed[2];
            case KeyEvent.VK_RIGHT:
                return keyPressed[3];
            case KeyEvent.VK_LEFT:
                return keyPressed[4];
            case KeyEvent.VK_CONTROL:
                return keyPressed[5];
            default:
                return false;
        }
    }

    public void key(KeyEvent e, boolean type) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP:
                keyPressed[0] = type;
                break;
            case KeyEvent.VK_DOWN:
                keyPressed[1] = type;
                break;
            case KeyEvent.VK_SPACE:
                keyPressed[2] = type;
                break;
            case KeyEvent.VK_RIGHT:
                keyPressed[3] = type;
                break;
            case KeyEvent.VK_LEFT:
                keyPressed[4] = type;
                break;
            case KeyEvent.VK_CONTROL:
                keyPressed[5] = type;
                break;
        }
    }

}
