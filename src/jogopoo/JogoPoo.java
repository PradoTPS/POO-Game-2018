package jogopoo;

public class JogoPoo {

    public final static int LOOP_DURATION = 30;

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> createFrame());

        loop();
    }

    private static void createFrame() {
        MainFrame mainFrame = new MainFrame("Crackpots");
        Player player = new Player("sprite.png", mainFrame);
        InputListener listener = new InputListener(player, mainFrame);
    }

    public static void update(){
    	
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
