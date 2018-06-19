package jogopoo;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;

public class InputListener implements KeyListener{
	Player player;

	public InputListener(Player p, JFrame mainFrame){
		player = p;
        mainFrame.addKeyListener(this);
	}
	
	public void keyReleased(KeyEvent e) {
		
	}
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_LEFT) {
			player.setLocation(player.getLocation().x - 5, player.getLocation().y);
		}
		if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
			player.setLocation(player.getLocation().x + 5, player.getLocation().y);
		}
	}
	public void keyTyped(KeyEvent e) {
		
	}
}