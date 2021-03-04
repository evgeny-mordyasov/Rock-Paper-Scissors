package unimportant;

import java.util.concurrent.ThreadLocalRandom;

/*
 * Analysis of random number generate.
 * It was conducted more 1_000_000 attempts to get maximum the number of inaccuracies.
 * This value is equal to 0,27.
 * The average value is 0,0375.
 * In the worst case, one outcome was 0,27 more likely than the others.
 */

class RandomNumberGenerate
{
    public static void main(String[] args)
    {
        generateNumbers(100);
        print();
    }


    private static void generateNumbers(int numberOfAttempts)
    {
        for(int iterator = 0; iterator < numberOfAttempts; iterator++)
        {
            int currentNumber = ThreadLocalRandom.current().nextInt(1, 4);

            switch (currentNumber)
            {
                case 1:
                    Number.ONE.setCount(Number.ONE.getCount() + 1);
                    break;

                case 2:
                    Number.TWO.setCount(Number.TWO.getCount() + 1);
                    break;

                case 3:
                    Number.THREE.setCount(Number.THREE.getCount() + 1);
                    break;
            }
        }
    }


    /*
    * The result of executing the print() method:
    *
    *
    * Number		Number of dropouts		Probability of falling out		Inaccuracy
    *   1				    31						0,31					   0,02
    *   2					33						0,33					   0,00
    *   3					36						0,36					   0,03
    */

    private static void print()
    {
        System.out.println("Number\t\tNumber of dropouts\t\tProbability of falling out\t\tInaccuracy");
        System.out.println(getStringFormat(Number.ONE.getValue(), Number.ONE.getCount()));
        System.out.println(getStringFormat(Number.TWO.getValue(), Number.TWO.getCount()));
        System.out.println(getStringFormat(Number.THREE.getValue(), Number.THREE.getCount()));
    }


    private static String getStringFormat(int value, int count)
    {
        return String.format(getFormat(), value, count, count / 100d, Math.abs(0.33 - count / 100d));
    }


    private static String getFormat() { return "%d\t\t\t\t\t%d\t\t\t\t\t\t\t%.2f\t\t\t\t\t%.2f"; }
}
