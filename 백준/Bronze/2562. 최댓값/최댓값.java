import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int maxNum = 0;
        int count = 0;
        int[] arr = new int[9];
        for(int i = 0; i < 9; i++) {
            arr[i] = sc.nextInt();
        }
        int[] temp = arr.clone();
        Arrays.sort(temp);
        maxNum = temp[8];
        
        for(int i = 0; i < 9; i++){
            if(arr[i] == maxNum) break;
            count++;
        }
        
        System.out.println(maxNum);
        System.out.println(count + 1);
    }
}