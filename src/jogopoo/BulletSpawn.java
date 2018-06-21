package jogopoo;

import javax.swing.*;

public class BulletSpawn extends GameObject{
    
    public BulletSpawn(String img, JFrame mainFrame, int x, int y, int size) {
        super(img, mainFrame, x, y, size);
    }
    
    public void instantiateBullet(){
        System.out.println("Instanciei");
    }
}
