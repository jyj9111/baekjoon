import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main { // Boj2075: N번째 큰 수
    public int solution() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            String[] split = reader.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                priorityQueue.offer(Integer.parseInt(split[j]));
                if(priorityQueue.size() > n) priorityQueue.poll();
            }
        }

        return priorityQueue.peek();
    }
    public static void main(String[] args) throws IOException {
        System.out.println(new Main().solution());
    }
}
