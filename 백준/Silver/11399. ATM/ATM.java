import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main { // Boj11399: ATM
    public void solution() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());

        StringTokenizer info = new StringTokenizer(reader.readLine());
        int[] time = new int[n];
        for (int i = 0; i < n; i++) {
            time[i] = Integer.parseInt(info.nextToken());
        }

        Arrays.sort(time);
        int[] answer = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                answer[i] += time[j];
            }
            if (i != 0)
                answer[i] += answer[i - 1];
        }

        System.out.println(answer[n - 1]);
    }
    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
