import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int arrSize = sc. nextInt();
        int[] arr = new int[arrSize];
        int[] freq = new int[2000001];
        
        for(int i = 0; i < arrSize; i++)
        {
            arr[i] = sc.nextInt();
            freq[arr[i]]++;
        }
        
        int compareNum = sc.nextInt();
        int count = 0;;
        for(int i = 0; i < arrSize; i++) {
            if(compareNum >= arr[i]) {
                if( freq[compareNum - arr[i]] == 1)
                    count++;
            }
        }
        if(count == 0)
            System.out.print(count);
        else 
            System.out.print(count / 2);
    }
}