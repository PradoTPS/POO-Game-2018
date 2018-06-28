package jogopoo;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
        final MainFrame mainFrame = new MainFrame("Jogo POO");
        final GameManager gameManager = new GameManager(mainFrame.mainPanel);

        mainFrame.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) { gameManager.onKeyPressed(e); }
            @Override
            public void keyReleased(KeyEvent e) { gameManager.onKeyReleased(e); }
        });

        new Timer(1000 / 30, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameManager.onUpdate();
            }
        }).start();
    }
}
