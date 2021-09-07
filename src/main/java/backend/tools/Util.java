package backend.tools;

import java.util.Random;

public class Util {

    public static int randomNumber(int downBound, int upperBound) {

        Random generate = new Random();
        return generate.nextInt(upperBound-downBound) + downBound;
    }

}