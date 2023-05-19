import java.util.Scanner;

public class Main { //Boj 1629: 곱셈 (재귀)
    public long Pow (int num1, int num2, int mod) {
        if(num2 == 1)
            return num1 % mod;
        long value = Pow(num1, num2 / 2, mod);
        value = value * value % mod;
        if(num2 % 2 == 0)
            return value;
        return value * num1 % mod;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num1 = sc.nextInt();
        int num2 = sc.nextInt();
        int mod = sc.nextInt();
        Main sd = new Main();
        System.out.print(sd.Pow(num1, num2, mod));
    }
}