import java.util.Scanner;

public class Main {
    public static int countZero(int[] arr) {
        int count = 0;
        for(int i = 0; i < arr.length; i++) {
            if (arr[i] == 0)  {
                count ++;
            }
        }
        return count;
    }
    public static void print(int data) {
        if(data == 4) {
            System.out.println("D");
        } else if(data == 3) {
            System.out.println("C");
        } else if(data == 2) {
            System.out.println("B");
        } else if(data == 1) {
            System.out.println("A");
        } else {
            System.out.println("E");
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] input = new int[3][4];
        int count = 0;
        
        for(int i = 0; i < input.length; i++) {
            for(int j = 0; j < input[i].length; j++) {
                input[i][j] = sc.nextInt();
            }
        }
        
        for(int i = 0; i < input.length; i++) {
            count = countZero(input[i]);
            print(count);
        }
    }
}