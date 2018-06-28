package jogopoo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class JogoPoo{

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable(){
            @Override
            public void run(){
                build();
            }
        });
    }

    private static void build(){
        MainFrame mainFrame = new MainFrame("Jogo POO");
        final Manager manager = new Manager(mainFrame.mainPanel);

        mainFrame.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {}
            @Override
            public void keyPressed(KeyEvent e) { manager.onKeyPressed(e); }
            @Override
            public void keyReleased(KeyEvent e) { manager.onKeyReleased(e); }
        });

        new Timer( 1000/30, a -> manager.onUpdate()).start();
    }
}
