package game;

import java.io.*;


public class RockPaperScissors
{
    public static RockPaperScissors game = new RockPaperScissors();
    public static BufferedReader readFromConsole = new BufferedReader(new InputStreamReader(System.in));
    private static int [] score = new int[]{0, 0};


    public static void main(String[] args) throws IOException
    {
        RockPaperScissors.game.startGame();
    }


    private void startGame() throws IOException
    {
        rulesOfGame();

        int numberOfRounds = Round.choiceNumberOfRounds();

        for (int currentRound = 0; currentRound < numberOfRounds; currentRound++)
        {
            int playerSign = Sign.getSign();
            int robotSign = Robot.getSign();

            determineWinner(playerSign, robotSign);
        }

        printScore();
    }


    private void rulesOfGame()
    {
        System.out.println("Ваш противник - компьютер. Попробуйте одолеть его.");
        System.out.println("Правила игры: ");
        System.out.println("Всего в игре три знака\\жеста: камень, ножница, бумага. Вам необходимо выбрать один из них.");
        System.out.println("Камень бьет ножницы, ножницы режут бумагу, бумага накрывает камень.");
        System.out.println("Вы можете дальше выбрать количество раундов: 1, 3 или 5.");
        System.out.println("В конце подводится итог сыгранных раундов.");
        System.out.println("0 - камень, 1 - бумага, 2 - ножницы.");
        System.out.println("Удачи Вам!\n\n\n");
    }


    private void determineWinner(int playerSign, int robotSign)
    {
        switch (playerSign)
        {
            case 0:
                findWinner(playerSign, robotSign, Sign.ROCK.getValue(), Sign.PAPER.getValue());
                break;

            case 1:
                findWinner(playerSign, robotSign, Sign.PAPER.getValue(), Sign.SCISSORS.getValue());
                break;

            case 2:
                findWinner(playerSign, robotSign, Sign.SCISSORS.getValue(), Sign.ROCK.getValue());
                break;
        }
    }


    private void findWinner(int playerSign, int robotSign, int firstSign, int secondSign)
    {
        printTable(playerSign, robotSign);

        if (robotSign == firstSign)
        {
            System.out.println("Ничья!");
        }
        else if (robotSign == secondSign)
        {
            System.out.println("Робот победил!");

            score[1]++;
        }
        else
        {
            System.out.println("Вы победили!");

            score[0]++;
        }

        System.out.println("-----------------------\n");
    }


    private void printTable(int playerSign, int robotSign)
    {
        System.out.println("\n-----------------------");
        System.out.println("Игрок\tvs\tКомпьютер");
        System.out.println(String.format("%s\t\t%s\n", Sign.getNameOfSign(playerSign), Sign.getNameOfSign(robotSign)));
    }


    private void printScore()
    {
        System.out.println(String.format("Игрок-компьютер: %d-%d", score[0], score[1]));
    }
}
