import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main { // Boj11727 : 2xn 타일링 2
    public void solution() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());

        int[] dp = new int[n + 1];
        dp[1] = 1;
        if (n != 1)
            dp[2] = 3;
        for (int i = 3; i <= n ; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2] * 2) % 10007;
        }

        System.out.println(dp[n]);
    }
    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
