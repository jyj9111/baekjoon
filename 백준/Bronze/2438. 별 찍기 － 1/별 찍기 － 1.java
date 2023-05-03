import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        String result = "";
        
        for(int i = 0; i < num; i++) {
            result += "*";
            System.out.println(result);
        }
    }
}