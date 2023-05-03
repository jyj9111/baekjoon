import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        
        for(int i = 1; i <= num; i++) {
            String result = "";
            for(int j = 1; j <= num - i; j++) {
                result += " ";
            }
            for(int j = 1; j <= i; j++) {
                result += "*";
            }
            System.out.println(result);
        }
    }
}