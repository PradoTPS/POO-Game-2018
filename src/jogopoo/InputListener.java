package jogopoo;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JLabel;

public class InputListener implements KeyListener{
	JLabel player;
	public InputListener(JLabel p){
		player = p;
	}
	
	public void keyReleased(KeyEvent e) {
		
	}
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_Z) {
			System.out.println("Z");
			player.setLocation(new Point(player.getLocation().x - 5, player.getLocation().y));
		}
		if(e.getKeyCode() == KeyEvent.VK_X) {
			System.out.println("X");
			player.setLocation(new Point(player.getLocation().x + 5, player.getLocation().y));
		}
	}
	public void keyTyped(KeyEvent e) {
		
	}
}