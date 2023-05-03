import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        
        for(int i = 0; i < num; i++) {
            String result = "";
            for(int j = 0; j < num - i - 1; j++) {
                result += " ";
            }
            for(int j = 0; j < 2 * i + 1; j++) {
                result += "*";
            }
            System.out.println(result);
        }
    }
}