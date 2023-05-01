import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] num = new int[3];
        boolean sameAll, sameTwo, allDif;
        int answer = 0;
        
        for(int i = 0; i < num.length; i++) {
            num[i] = sc.nextInt();
        }
        
        
        if((num[0] == num[1]) && (num[1] == num[2])) {
            answer = 10000 + num[0] * 1000;
        } else if((num[0] == num[1]) && (num[0] != num[2])) {
            answer = 1000 + num[0] * 100;
        } else if((num[0] == num[2]) && (num[0] != num[1])) {
            answer = 1000 + num[0] * 100;
        } else if((num[1] == num[2]) && (num[0] != num[2])) {
            answer = 1000 + num[1] * 100;
        } 
        else {
            Arrays.sort(num);
            answer = num[2] * 100;
        }
        
        System.out.println(answer);
        
    }
}