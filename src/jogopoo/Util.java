package jogopoo;

public class Util {

    public static int clamp(int variable, int max, int min){
        return Math.max(max, Math.min(variable, min));
    }
}
