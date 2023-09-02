import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.*;

public class Main { // Boj1238: 파티
    private final int INF = Integer.MAX_VALUE;
    private class Pair{
        int node;
        int weight;

        public Pair(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }

        public int getNode() {
            return node;
        }

        public void setNode(int node) {
            this.node = node;
        }

        public int getWeight() {
            return weight;
        }

        public void setWeight(int weight) {
            this.weight = weight;
        }
    }
    private void solution() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer info = new StringTokenizer(reader.readLine());

        int town = Integer.parseInt(info.nextToken());
        int road = Integer.parseInt(info.nextToken());
        int partyHome = Integer.parseInt(info.nextToken());

        // 마을 + 도로 정보 담을 리스트
        List<List<Pair>> adj = new ArrayList<>();
        // 리스트 초기화
        for (int i = 0; i < town + 1; i++) {
            adj.add(new ArrayList<>());
        }

        // 마을 + 도로 정보 입력
        for (int i = 0; i < road; i++) {
            info = new StringTokenizer(reader.readLine());
            int st = Integer.parseInt(info.nextToken());
            int end = Integer.parseInt(info.nextToken());
            int weight = Integer.parseInt(info.nextToken());

            adj.get(st).add(new Pair(end, weight));
        }

        // 최단거리 기록 배열, 초기화
        int[] dist = new int[town + 1];
        // 정답 산출용 배열
        int[] answer = new int[town + 1];

        for (int i = 1; i < town + 1; i++) {
            Arrays.fill(dist, INF);
            int stTown = i;
            // 최소우선순위큐
            PriorityQueue<Pair> minPq = new PriorityQueue<>((o1, o2) -> o1.weight >= o2.weight ? 1 : -1);
            dist[stTown] = 0;
            minPq.offer(new Pair(stTown, 0));
            while (!minPq.isEmpty()) {
                Pair crr = minPq.poll();
                if (dist[crr.getNode()] != crr.getWeight()) continue;
                for (Pair next : adj.get(crr.getNode())) {
                    if (dist[next.getNode()] <= dist[crr.getNode()] + next.getWeight()) continue;

                    dist[next.getNode()] = dist[crr.getNode()] + next.getWeight();
                    minPq.offer(new Pair(next.getNode(), dist[next.getNode()]));
                }
            }
            
            if (i != partyHome) {
                answer[i] += dist[partyHome];
                continue;
            }

            for (int j = 1; j < town + 1; j++) {
                answer[j] += dist[j];
            }
        }
        // 최대값 산출
        int max = -1;
        for (int temp : answer) {
            max = Math.max(max, temp);
        }
        System.out.println(max);
    }
    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
