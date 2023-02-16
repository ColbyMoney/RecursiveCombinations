import java.util.Scanner;

public class cam40140a9 {

    static int n = 0;
    static int k = 0;
    static int[][] stored;
    static int calls = 0;
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args)
    {
        System.out.print("Enter two integers as n and k to compute C(n,k): ");
        n = input.nextInt();
        k = input.nextInt();
        stored = new int[n+1][k+1];
        System.out.println("\n(a) Using a loop: C(" + n + "," + k + ")=" + calcA(n, k));
        calls = 0;
        System.out.println("\n(b) Using pure recursion: C(" + n + "," + k + ")=" + calcB(n, k));
        System.out.println("The number of calls is " + (calls - 1) + ".");
        calls = 0;
        System.out.println("\n(b) Using recursion with stored values: C(" + n + "," + k + ")=" + calcC(n, k));
        System.out.println("The number of calls is " + (calls - 1) + ".");
    }

    public static int calcA(int n, int k) //method A
    {
        return (facLoop(n)) / (facLoop(k) * facLoop(n-k));
    }

    public static int calcB(int n, int k) //method B
    {
        calls++;
        if (k == n)
            return 1;
        if (k == 0)
            return 1;
        return (calcB(n - 1, k) + calcB(n - 1, k - 1));
    }

    public static int calcC(int n, int k) //method C
    {
        calls++;
        if (stored[n][k] != 0)
            return stored[n][k];
        stored[n][k] = calcA(n, k);
        if (k == n)
            return 1;
        if (k == 0)
            return 1;
        return (calcC(n - 1, k) + calcC(n - 1, k - 1));
    }

    public static int facLoop(int x) //calculate the factorial of an integer with loop
    {
        int result = 1;
        while (x >= 1)
        {
            result *= x;
            x--;
        }
        return result;
    }

    /*
    public static int facRec(int x) //calculate the factorial of an integer with recursion
    {
        calls++;
        if (x >= 1)
            return ((result *= x) * facRec(x - 1));
        return result;
    }
    */
}
