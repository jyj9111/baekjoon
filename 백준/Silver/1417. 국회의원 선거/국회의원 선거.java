import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main { // Boj1417: 국회의원 선거
    public int solution() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int candidates = Integer.parseInt(reader.readLine());
        int myVote = Integer.parseInt(reader.readLine());
        PriorityQueue<Integer> otherVotes = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < candidates - 1; i++) {
            otherVotes.offer(Integer.parseInt(reader.readLine()));
        }

        int answer = 0;

        if (!otherVotes.isEmpty()) {
            while (otherVotes.peek() >= myVote) {
                int votes = otherVotes.poll();
                otherVotes.offer(votes - 1);
                myVote++;
                answer++;
            }
        }

        return answer;
    }
    public static void main(String[] args) throws IOException {
        System.out.println(new Main().solution());
    }
}
