package jogopoo;

import javax.swing.*;

public class GameObject extends JLabel{
    private final ImageIcon image;
    private Vector2 bound = new Vector2();
    
    public GameObject(String img, JFrame mainFrame, int x, int y, int size){
        super();

        this.image = new ImageIcon(img);
        this.setIcon(image);
        this.setBounds(x, y, size, size);
        
        mainFrame.getContentPane().add(this);
    }
    
    public int clamp(int location, Vector2 boundary){
        return Math.max(boundary.x, Math.min(location, boundary.y));
    }
    
    public void setBound(int min, int max){
        bound.x = min;
        bound.y = max;
    }
    
    public Vector2 getBound(){
        return bound;
    }
}
