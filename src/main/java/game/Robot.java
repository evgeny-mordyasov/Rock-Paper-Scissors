package game;

import java.util.concurrent.ThreadLocalRandom;

public class Robot
{
    public static int getSign()
    {
        return makeChoice();
    }


    private static int makeChoice()
    {
        return ThreadLocalRandom.current().nextInt(0, 3);
    }
}
