package jogopoo;

import java.util.Random;

public class Util {
    public static final int BOUND = 115;
    public static final int GAP = 125;
    private static Random random = new Random();

    public static int clamp(int variable, int min, int max){
        return Math.max(min, Math.min(variable, max));
    }

    public static int randomRange(int min, int max){
        return random.nextInt((max - min) + 1) + min;
    }
}
