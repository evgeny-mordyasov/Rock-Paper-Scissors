package game;

import java.io.IOException;


public enum Round
{
    ONE(1), TWO(2), FIVE(5);

    private final int numberOfRounds;


    private Round(int value)
    {
        this.numberOfRounds = value;
    }


    public static int choiceNumberOfRounds() throws IOException
    {
        int numberOfRounds = 1;
        boolean isNumber = false;

        do {
            printInfoAboutNumberOfRounds();

            try
            {
                numberOfRounds = Integer.parseInt(RockPaperScissors.readFromConsole.readLine());

                if (checkNumberOfRounds(numberOfRounds))
                {
                    isNumber = true;
                } else throw new NumberFormatException();

            } catch (NumberFormatException e) {}
        } while (!isNumber);

        return numberOfRounds;
    }


    private static boolean checkNumberOfRounds(int number)
    {
        if (number < 1 || number > 5 || number % 2 == 0) return false;

        return true;
    }


    private static void printInfoAboutNumberOfRounds()
    {
        System.out.print("Выберите количество раундов (1, 3 или 5): ");
    }
}
