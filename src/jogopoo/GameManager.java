package jogopoo;

import javafx.util.Pair;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class GameManager {
    private JLayeredPane mainPanel;
    private ArrayList<Pair<GameObject, JLabel>> gameObjects;
    private EnemyManager enemyManager;

    public int score;
    private JLabel scoreText;
    private JLabel lifeText;
    private JLabel background;

    public ArrayList<Bullet> bullets = new ArrayList<Bullet>();
    public ArrayList<Window> windows = new ArrayList<Window>();
    public Player player;

    public GameManager(JLayeredPane p){
        mainPanel = p;

        Awake();
    }

    private void Awake(){
        background = new JLabel(new ImageIcon("src/images/background.png"));
        background.setBounds(0,0,800,600);
        background.setLocation(0,0);
        mainPanel.add(background, new Integer(1));

        gameObjects = new ArrayList<>();

        enemyManager = new EnemyManager();
        player = new Player();
        instantiate(player);

        lifeText = new JLabel("Vidas: " + String.valueOf(player.life));
        lifeText.setForeground(Color.BLACK);
        lifeText.setBounds(0,0, 100, 40);
        lifeText.setLocation(50, 10);
        lifeText.setFont(new Font(lifeText.getFont().getFontName(), Font.PLAIN, 20));
        mainPanel.add(lifeText,  new Integer(1000));

        score = 0;
        scoreText = new JLabel("Pontuação: " + String.valueOf(score));
        scoreText.setForeground(Color.BLACK);
        scoreText.setBounds(0,0, 250, 40);
        scoreText.setLocation(180, 10);
        scoreText.setFont(new Font(scoreText.getFont().getFontName(), Font.PLAIN, 20));
        mainPanel.add(scoreText, new Integer (1000));

        for(int i = 0; i < 5; i++) {
            Window w = new Window();
            windows.add(w);
            instantiate(w, Util.BOUND + (Util.GAP * i), 180);

            Bullet b = new Bullet();
            bullets.add(b);
            instantiate(b, Util.BOUND + (Util.GAP * i), 115);
        }
    }

    public void onUpdate(){
        for(Pair<GameObject, JLabel> Object : gameObjects) {
            Object.getKey().onUpdate(this);
        }

        enemyManager.onUpdate(this);
        lifeText.setText("Vidas: " + String.valueOf(player.life));
        scoreText.setText("Pontuação: " + String.valueOf(score));

        if(player.life <= 0){
            restart();
        }
    }

    public void onKeyPressed(KeyEvent e){
        for(Pair<GameObject, JLabel> Object : gameObjects)
            Object.getKey().onKeyPressed(this, e);

        switch(e.getKeyCode()){
            case KeyEvent.VK_RIGHT:
                gameObjects.get(0).getValue().setIcon(new ImageIcon("src/images/playerR.png"));
                break;

            case KeyEvent.VK_LEFT:
                gameObjects.get(0).getValue().setIcon(new ImageIcon("src/images/playerL.png"));
                break;
        }
    }

    public void onKeyReleased(KeyEvent e){
        for(Pair<GameObject, JLabel> Object : gameObjects)
            Object.getKey().onKeyReleased(this, e);
    }

    public void instantiate(GameObject gameObject, int x, int y){
        JLabel image = gameObject.onCreate(this, x, y);

        gameObjects.add(new Pair<>(gameObject, image));
        mainPanel.add(image, new Integer(mainPanel.getComponentCount() + 1));
    }

    public void instantiate(GameObject gameObject){
        JLabel image = gameObject.onCreate(this, 0 , 0);

        gameObjects.add(new Pair<>(gameObject, image));
        mainPanel.add(image, new Integer(mainPanel.getComponentCount() + 1));
    }

    public void destroy(GameObject gameObject){
        for(Pair<GameObject, JLabel> Object : gameObjects)
        {
            if(Object.getKey().equals(gameObject)){
                Object.getValue().setVisible(false);
                mainPanel.remove(mainPanel.getIndexOf(Object.getValue()));
                gameObjects.remove(Object);
                break;
            }
        }
    }

    private void restart(){
        for(int i = 0; i < gameObjects.size(); i++) destroy(gameObjects.get(i).getKey());
        mainPanel.remove(scoreText);
        mainPanel.remove(lifeText);
        mainPanel.remove(background);
        Awake();
    }
}
