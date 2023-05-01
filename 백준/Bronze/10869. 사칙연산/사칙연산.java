import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int i,j=0;

        i = sc.nextInt();
        j = sc.nextInt();
        System.out.println(i+j);
        System.out.println(i-j);
        System.out.println(i*j);
        System.out.println(i/j);
        System.out.println(i%j);
    }
}