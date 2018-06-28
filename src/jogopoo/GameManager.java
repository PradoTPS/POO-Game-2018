package jogopoo;

import javafx.util.Pair;
import javax.swing.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class GameManager {
    private JLayeredPane mainPanel;
    private ArrayList<Pair<GameObject, JLabel>> gameObjects;
    private EnemyManager enemyManager;
    public ArrayList<Bullet> bullets = new ArrayList<Bullet>();
    public ArrayList<Window> windows = new ArrayList<Window>();
    public Player player;

    public GameManager(JLayeredPane p){
        mainPanel = p;

        Awake();
    }

    private void Awake(){
        gameObjects = new ArrayList<>();

        player = new Player();
        instantiate(player);

        for(int i = 0; i < 4; i++) {
            Bullet b = new Bullet();
            bullets.add(b);
            instantiate(b, Util.BOUND + (Util.GAP * i), 100);

            Window w = new Window();
            windows.add(w);
            instantiate(w, Util.BOUND + (Util.GAP * i), 150);
        }

        enemyManager = new EnemyManager();
    }

    public void onUpdate(){
        for(Pair<GameObject, JLabel> Object : gameObjects) {
            Object.getKey().onUpdate(this);
        }

        enemyManager.onUpdate(this);

        if(player.life <= 0){
            restart();
        }
    }

    public void onKeyPressed(KeyEvent e){
        for(Pair<GameObject, JLabel> Object : gameObjects)
            Object.getKey().onKeyPressed(this, e);
    }

    public void onKeyReleased(KeyEvent e){
        for(Pair<GameObject, JLabel> Object : gameObjects)
            Object.getKey().onKeyReleased(this, e);
    }

    public void instantiate(GameObject gameObject, int x, int y){
        JLabel image = gameObject.onCreate(this, x, y);

        gameObjects.add(new Pair<>(gameObject, image));
        mainPanel.add(image, mainPanel.getComponentCount() + 1);
    }

    public void instantiate(GameObject gameObject){
        JLabel image = gameObject.onCreate(this, 0 , 0);

        gameObjects.add(new Pair<>(gameObject, image));
        mainPanel.add(image, mainPanel.getComponentCount() + 1);
    }

    public void destroy(GameObject gameObject){
        for(Pair<GameObject, JLabel> Object : gameObjects)
        {
            if(Object.getKey().equals(gameObject)){
                Object.getKey().onDestroy(this);
                Object.getValue().setVisible(false);
                mainPanel.remove(mainPanel.getIndexOf(Object.getValue()));
                gameObjects.remove(Object);
                break;
            }
        }
    }

    public void restart(){
        for(int i = 0; i < gameObjects.size(); i++) destroy(gameObjects.get(i).getKey());

        Awake();
    }
}
