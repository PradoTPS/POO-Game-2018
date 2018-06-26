package jogopoo;

public class JogoPoo{

    public final static int LOOP_DURATION = 30;

    public static MainFrame mainFrame;
    public static Player player;
    public static Bullet[] bullet = new Bullet[4];
    public static InputListener listener;

    public static void main(String[] args) throws InterruptedException {
        createFrame();
        loop();
    }
    
    public static void createFrame(){
        mainFrame = new MainFrame("Crackpots");
        player = new Player("src/images/player.png", mainFrame, 370, 50, 50);
        for(int i = 0; i < bullet.length; i++) bullet[i] = new Bullet("src/images/bulletSpawn.png", mainFrame, 100 + (180 * i), 100, 50);
        listener = new InputListener(player, bullet, mainFrame);
    }

    public static void update(){
        for(int i = 0; i < bullet.length; i++){;;;;;
            bullet[i].behaviour();
        }
    }

    public static void loop(){
        long expectedtime = System.currentTimeMillis();

        while (true) {
            if(System.currentTimeMillis() >= expectedtime){
                expectedtime += LOOP_DURATION;
                update();
            }
        }
    }
}
