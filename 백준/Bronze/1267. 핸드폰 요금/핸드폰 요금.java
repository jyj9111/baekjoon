import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static int calculateFee(int data , boolean mode) {
        int x = 0;
        int result = 0;
        
        if(mode) {
            x = data / 30 + 1;
            result = x * 10;
        } else {
            x = data / 60 + 1;
            result = x * 15;
        }
        return result;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int callNum = sc.nextInt();
        int[] yFee = new int[callNum];
        int[] mFee = new int[callNum];
        int yTotal = 0;
        int mTotal = 0;
        String str = "";
        
        for(int i = 0; i < callNum; i++) {
            int num = sc.nextInt();
            yFee[i] = calculateFee(num, true);
            mFee[i] = calculateFee(num, false);
        }
        for(int i = 0; i < yFee.length; i++) {
            yTotal += yFee[i];
        }
        for(int i = 0; i < mFee.length; i++) {
            mTotal += mFee[i];
        }
        if(yTotal < mTotal) {
            System.out.print("Y " + yTotal);
        } else if(yTotal > mTotal) {
            System.out.print("M " + mTotal);
        } else {
            System.out.print("Y " + "M " + yTotal);
        }
        
    }
}