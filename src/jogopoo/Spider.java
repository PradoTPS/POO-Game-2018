/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogopoo;

import javax.swing.*;

/**
 *
 * @author Lucas
 */
public class Spider extends GameObject{
    //private Vector2 position;
    private final int velocity;
    
    public Spider (String img, JFrame mainFrame, int x, int y, int size, int vel) {
        super(img, mainFrame, x, y, size);
        this.velocity = vel;
    }    
    
    public void behavior() {
        this.setLocation(this.getX(), this.getY() + this.velocity);
        System.out.println("nasceu");
    }
}


