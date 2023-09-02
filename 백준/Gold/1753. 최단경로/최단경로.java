import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main { // Boj1753: 최단경로
    private final int INF = Integer.MAX_VALUE;
    
    private static class Pair {
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

    public void solution() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer info = new StringTokenizer(reader.readLine());
        int node = Integer.parseInt(info.nextToken());
        int edge = Integer.parseInt(info.nextToken());
        int stNode = Integer.parseInt(new StringTokenizer(reader.readLine()).nextToken());

        // 정점 정보 초기화
        List<List<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < node + 1; i++) {
            adj.add(new ArrayList<>());
        }
        // 최단거리 기록용 배열 초기화
        int[] dist = new int[node + 1];
        Arrays.fill(dist, INF);

        for (int i = 0; i < edge; i++) {
            info = new StringTokenizer(reader.readLine());
            int st = Integer.parseInt(info.nextToken());
            int end = Integer.parseInt(info.nextToken());
            int weight = Integer.parseInt(info.nextToken());
            // 시작 정점을 index로 가지는 List에 연결된 정점 정보를 추가
            adj.get(st).add(new Pair(end, weight));
        }

        // 알고리즘 시작
        PriorityQueue<Pair> minPq = new PriorityQueue<>((Pair o1, Pair o2) -> o1.weight >= o2.weight ? 1 : -1);
        dist[stNode] = 0;
        minPq.offer(new Pair(stNode, dist[stNode]));
        while (!minPq.isEmpty()) {
            Pair crr = minPq.poll();
            // 현재 정점에서 기록된 최단거리 값과 가중치가 다르면 패스
            if (dist[crr.getNode()] != crr.getWeight()) continue;
            // 현재 정점에서 갈 수있는 정점들 탐색
            for (Pair next : adj.get(crr.getNode())) {
                // 다음 정점 후보지의 이미 기록되어있는 최단거리 값이 (현재 정점의 최단거리값 + 다음 정점으로 가는 가중치)
                // 보다 작으면 패스
                if (dist[next.getNode()] <= dist[crr.getNode()] + next.getWeight()) continue;

                dist[next.getNode()] = dist[crr.getNode()] + next.getWeight();
                minPq.offer(new Pair(next.getNode(), dist[next.getNode()]));
            }
        }
        StringBuilder answer = new StringBuilder();
        for (int i = 1; i < node + 1; i++) {
            if (dist[i] == INF) answer.append("INF\n");
            else answer.append(dist[i]).append("\n");
        }

        System.out.println(answer);
    }
    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
