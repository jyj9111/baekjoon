import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int sumOdd = 0;
        int minOdd = 0;
        
        for(int i = 0; i < 7; i++) {
            int num = sc.nextInt();
            
            if( num % 2 != 0) {
                sumOdd += num;
                if( minOdd == 0) {
                    minOdd = num;
                } else if( minOdd > num) {
                    minOdd = num;
                }
            } 
        }
        if(sumOdd == 0) {
            System.out.println(-1);
        } else {
            System.out.println(sumOdd);
            System.out.println(minOdd);
        }
    }
}