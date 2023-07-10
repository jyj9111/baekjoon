import java.io.*;
import java.util.*;

public class Main { // Boj13305: 주유소
    public long solution() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        long cityCount = Integer.parseInt(reader.readLine());
        StringTokenizer cityDistToken = new StringTokenizer(reader.readLine());

        long[] cityDistance = new long[(int) cityCount - 1];
        for (int i = 0; i < cityCount - 1; i++) {
            cityDistance[i] = Integer.parseInt(cityDistToken.nextToken());
        }

        StringTokenizer cityFuelToken = new StringTokenizer(reader.readLine());
        long[] cityFuel = new long[(int) cityCount];
        for (int i = 0; i < cityCount; i++) {
            cityFuel[i] = Integer.parseInt(cityFuelToken.nextToken());
        }

        long currentMin = Integer.MAX_VALUE;
        long needToGo = 0;
        long totalPrice = 0;

        for (int i = 0; i < cityCount - 1; i++) {
            if (cityFuel[i] < currentMin) {
                totalPrice += currentMin * needToGo;
                currentMin = cityFuel[i];
                needToGo = cityDistance[i];
            } else {
                needToGo += cityDistance[i];
            }
        }
        return totalPrice + needToGo * currentMin;
    }

    public static void main(String[] args) throws IOException {
        System.out.println(new Main().solution());
    }
}
