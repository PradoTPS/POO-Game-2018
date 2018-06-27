package jogopoo;

import java.util.*;

public class JogoPoo{

    public final static int LOOP_DURATION = 30;

    public static MainFrame mainFrame;
    public static Player player;
    public static Bullet[] bullet = new Bullet[4];
    public static InputListener listener;
    public static List<Spider> spiders;

    public static void main(String[] args) throws InterruptedException {
        createFrame();
        loop();
    }
    
    public static void createFrame(){
        mainFrame = new MainFrame("Crackpots");
        player = new Player("src/images/player.png", mainFrame, 370, 50, 50);
        for(int i = 0; i < bullet.length; i++) bullet[i] = new Bullet("src/images/bulletSpawn.png", mainFrame, 100 + (180 * i), 100, 50);
        listener = new InputListener(player, bullet, mainFrame);
        spiders = new ArrayList<Spider>();
    }

    public static void update(){
        for(int i = 0; i < bullet.length; i++) {
            bullet[i].behaviour();
        }
        
        //Spider spider;
        for(int i=0; i < spiders.size(); i++) {
            spiders.get(i).behavior();
        }
    }

    public static void loop(){
        long expectedtime = System.currentTimeMillis();
        
        //inicializacao da aranha
        Random gerador = new Random();
        long spiderSpawnTime = expectedtime;
        spiders.add(new Spider("src/images/bullet.png", mainFrame, gerador.nextInt(750), 590, 50, 10));

        while (true) {
            
            if (System.currentTimeMillis() - spiderSpawnTime >= 10000) {
                spiderSpawnTime = System.currentTimeMillis();
                spiders.add(new Spider("src/images/bullet.png", mainFrame, gerador.nextInt(750), 590, 50, 10));                
            }
            
            //se o tempo for atual for maior que expectedtime + 30
            if(System.currentTimeMillis() >= expectedtime){
                expectedtime += LOOP_DURATION;
                update();
            }            
        }
    }
}
