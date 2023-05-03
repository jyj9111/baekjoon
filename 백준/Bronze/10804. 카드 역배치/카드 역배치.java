import java.util.Scanner;

public class Main {
    public static int[] swapIndex(int[] arr, int st, int lt) {
        int[] result = {};
        int setNum = lt - st +1;
        int[] temp = new int[setNum];
        for(int i = 0; i < setNum; i++) {
             temp[i] = arr[i + st - 1];
        }
        for(int i = 0; i < setNum; i++) {
            arr[i + st - 1] = temp[setNum - i - 1];
        }
        result = arr;
        return result;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[20];
        for(int i = 0; i < 20; i++) {
            arr[i] = i + 1;
        }
        for(int i = 0; i < 10; i++) {
            int num1 = sc.nextInt();
            int num2 = sc.nextInt();
            arr = swapIndex(arr, num1, num2);
        }
        for (int i = 0; i < 20; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}