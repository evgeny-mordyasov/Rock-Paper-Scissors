package game;

import java.io.IOException;


public enum Sign
{
    ROCK(0), PAPER(1), SCISSORS(2);

    private final int value;


    private Sign(int value)
    {
        this.value = value;
    }


    public int getValue() { return value; }


    public static String getNameOfSign(int value)
    {
        String name = "";

        switch (value)
        {
            case 0: name = "Камень"; break;
            case 1: name = "Бумага"; break;
            case 2: name = "Ножницы";
        }

        return name;
    }


    public static int getSign() throws IOException
    {
        int choiceSign = 0;
        boolean isNumber = false;

        do
        {
            printChoice();

            try
            {
                choiceSign = Integer.parseInt(RockPaperScissors.readFromConsole.readLine());
                checkSign(choiceSign);

                isNumber = true;
            } catch (NumberFormatException e) {}
        } while (!isNumber);

        return choiceSign;
    }


    private static void checkSign(int sign) throws NumberFormatException
    {
        switch (sign)
        {
            case 0: break;
            case 1: break;
            case 2: break;

            default: throw new NumberFormatException();
        }
    }


    private static void printChoice()
    {
        System.out.print("Введите выбор: ");
    }
}
