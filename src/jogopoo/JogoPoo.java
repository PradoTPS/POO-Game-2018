package jogopoo;

import javax.swing.*;

public class JogoPoo {

    public final static int ONE_SECOND = 1000;
    
    public static void main(String[] args) {
       loop();
    }
  
    public static void update(){
        System.out.println("oi");
    }
    
    public static void loop(){
        long expectedtime = System.currentTimeMillis();
        while (true) {
           if(System.currentTimeMillis() >= expectedtime){
            expectedtime += ONE_SECOND;
            update();
           }
        }
    }
}
