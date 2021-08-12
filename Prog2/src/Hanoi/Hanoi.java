package Hanoi;
public class Hanoi {
    public static void hanoi (int p, int a, int b, int c)
    {
        if (p == 1)
        {
            move(a, c);
        }
        else
        {
            hanoi(p - 1, a, c, b);
            move(a, c);
            hanoi(p - 1, b , a, c);
        }
    }
    public static void move (int orig, int dest)
    {
        orig--;
        dest++;
    }
}
