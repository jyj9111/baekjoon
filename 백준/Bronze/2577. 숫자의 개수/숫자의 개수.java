import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[10];
        int result = 1;
            
        for(int i = 0; i < 3; i++) {
            result *= sc.nextInt();
        }
        while(result > 0) {
            arr[result % 10]++;
            result /= 10;
        }
        for(int i = 0; i < 10; i++) {
            System.out.println(arr[i]);
        }
    }
}