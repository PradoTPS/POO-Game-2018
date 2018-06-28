package jogopoo;

import java.util.Random;

public class Util {
    private static Random random = new Random();

    public static int clamp(int variable, int max, int min){
        return Math.max(max, Math.min(variable, min));
    }

    public static int randomRange(int min, int max){
        return random.nextInt((max - min) + 1) + min;
    }
}
