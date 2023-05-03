import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num1 = sc.nextInt();
        int num2 = sc.nextInt();
        int cntNum = 0;
        if(num1 < num2)
            cntNum = num2 - num1 - 1;
        else if (num1 > num2)
            cntNum = num1 - num2 - 1;
        else {
            System.out.println("0");
            return;
        }

        System.out.println(cntNum);

        if(num1 < num2) {
            for (int i = 1; i <= cntNum; i++) {
                System.out.print(i + num1 + " ");
            }
        } else {
            for (int i = 1; i <= cntNum; i++) {
                System.out.print(i + num2);
                if (i < cntNum) {
                    System.out.print(" ");
                }
            }
        }
    }
}