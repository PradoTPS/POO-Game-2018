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
    private final int deslocamento;
    
    public Spider (String img, JFrame mainFrame, int x, int y, int size, int deltaY) {
        super(img, mainFrame, x, y, size);
        this.deslocamento = deltaY;
    }    
    
    public void behavior() {
        this.setLocation(this.getX(), this.getY() - this.deslocamento);
        System.out.println("nasceu");
    }
}


