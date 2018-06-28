package jogopoo;

import javax.swing.*;
import java.awt.event.KeyEvent;

public interface GameObject {
    JLabel onCreate(GameManager gameManager, int x, int y);
    void onUpdate(GameManager gameManager);
    void onKeyPressed(GameManager gameManager, KeyEvent e);
    void onKeyReleased(GameManager gameManager, KeyEvent e);
    void onDestroy(GameManager gameManager);
}

