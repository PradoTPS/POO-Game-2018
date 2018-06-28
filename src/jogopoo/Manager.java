package jogopoo;

import javafx.util.Pair;
import javax.swing.*;
import java.awt.event.KeyEvent;
import java.time.Instant;
import java.util.ArrayList;

public class Manager {
    private JLayeredPane mainPanel;
    private ArrayList<Pair<GameObject, JLabel>> gameObjects;
    public Player player;

    public Manager(JLayeredPane p){
        mainPanel = p;

        gameObjects = new ArrayList<>();

        player = new Player();
        instantiate(player);

        for(int i = 0; i < 4; i++)
            instantiate(new Bullet(), 100 + (180 * i), 100);

        for(int i = 0; i < 4; i++)
            instantiate(new Spider(), 100 + (180 * i), 600);
    }

    public void onUpdate(){
        for(Pair<GameObject, JLabel> Object : gameObjects) {
            Object.getKey().onUpdate(this);
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
}
