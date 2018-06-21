package jogopoo;

public class JogoPoo{

    public final static int LOOP_DURATION = 30;

    public static MainFrame mainFrame;
    public static Player player;
    public static BulletSpawn[] bulletSpawns = new BulletSpawn[4];
    public static InputListener listener;

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> createFrame());

        loop();
    }
    
    public static void createFrame(){
        mainFrame = new MainFrame("Crackpots");
        player = new Player("src/images/player.png", mainFrame, 370, 50, 50);
        for(int i = 0; i < bulletSpawns.length; i++) bulletSpawns[i] = new BulletSpawn("src/images/bulletSpawn.png", mainFrame, 100 + (180 * i), 100, 50);
        listener = new InputListener(player, mainFrame);
    }

    public static void update(){}

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
