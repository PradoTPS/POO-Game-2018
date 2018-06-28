package jogopoo;

import javax.swing.*;
import java.awt.event.KeyEvent;

public interface GameObject {
    JLabel onCreate(Manager manager, int x, int y);
    void onUpdate(Manager manager);
    void onKeyPressed(Manager manager, KeyEvent e);
    void onKeyReleased(Manager manager, KeyEvent e);
    void onDestroy(Manager manager);
}

