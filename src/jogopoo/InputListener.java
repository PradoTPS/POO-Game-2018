package jogopoo;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;

public class InputListener implements KeyListener{
	Player player;

	public InputListener(Player p, JFrame mainFrame){
		player = p;
        mainFrame.addKeyListener(this);
	}

    public void keyTyped(KeyEvent e) {}
	public void keyReleased(KeyEvent e) {}

	public void keyPressed(KeyEvent e) {
	    switch (e.getKeyCode()){
            case KeyEvent.VK_LEFT:
                player.setLocation(player.getLocation().x - 5, player.getLocation().y);
                break;
            case KeyEvent.VK_RIGHT:
                player.setLocation(player.getLocation().x + 5, player.getLocation().y);
                break;
        }
	}
}