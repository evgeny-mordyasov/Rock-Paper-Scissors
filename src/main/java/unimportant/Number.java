package unimportant;

enum Number
{
    ONE(1), TWO(2), THREE(3);

    private int count;
    private final int value;

    private Number(int value)
    {
        this.value = value;
    }

    public int getCount()
    {
        return count;
    }

    public void setCount(int count)
    {
        this.count = count;
    }

    public int getValue()
    {
        return value;
    }
}
