import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[10];
        int result = sc. nextInt();
        
        while(result > 0) {
            int temp = result % 10;
            if(temp == 9) temp = 6;
            arr[temp]++;
            result /= 10;
        }
        
        if(arr[6] % 2 != 0) 
            arr[6] = arr[6] / 2 + 1;
        else 
            arr[6] /= 2;
        
        int maxValue = 0;
        for(int i = 0; i < 10; i++) {
            if(arr[i] > maxValue) maxValue = arr[i];
        }
        
        System.out.print(maxValue);
    }
}