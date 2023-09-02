import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main { //Boj1504: 특정한 최단 경로
    private class Pair{
        int node;
        long weight;

        public Pair(int node, long weight) {
            this.node = node;
            this.weight = weight;
        }

        public int getNode() {
            return node;
        }

        public void setNode(int node) {
            this.node = node;
        }

        public long getWeight() {
            return weight;
        }

        public void setWeight(long weight) {
            this.weight = weight;
        }
    }

    private final long INF = Integer.MAX_VALUE;
    private List<List<Pair>> adj = new ArrayList<>();

    private void solution() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer info = new StringTokenizer(reader.readLine());

        int nodeCnt = Integer.parseInt(info.nextToken());
        int edgeCnt = Integer.parseInt(info.nextToken());

        for (int i = 0; i < nodeCnt + 1; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < edgeCnt; i++) {
            info = new StringTokenizer(reader.readLine());
            int st = Integer.parseInt(info.nextToken());
            int end = Integer.parseInt(info.nextToken());
            int weight = Integer.parseInt(info.nextToken());
            adj.get(st).add(new Pair(end, weight));
            adj.get(end).add(new Pair(st, weight));
        }

        int[] mustNodes = new int[2];
        info = new StringTokenizer(reader.readLine());
        mustNodes[0] = Integer.parseInt(info.nextToken());
        mustNodes[1] = Integer.parseInt(info.nextToken());

        long[] mustDist =  new long[2];
        mustDist[0] = calculateMinDistance(mustNodes[0], mustNodes[1], new long[nodeCnt + 1]);
        mustDist[1] = calculateMinDistance(mustNodes[1], mustNodes[0], new long[nodeCnt + 1]);
        // 두 경우 모두 경로가 없으면 최종 경로 또한 존재하지 않음
        if ( mustDist[0] == INF && mustDist[1] == INF) {
            System.out.println(-1);
            System.exit(0);
        }

        long answer = INF;
        for (int i = 0; i < 2; i++) {
            long front = calculateMinDistance(1, mustNodes[i], new long[nodeCnt + 1]);
            long back = calculateMinDistance(mustNodes[(i + 1) % 2], nodeCnt, new long[nodeCnt + 1]);
            answer = Math.min(answer, (front + mustDist[i] + back));
        }

        if (answer >= INF) System.out.println(-1);
        else System.out.println(answer);
    }

    private long calculateMinDistance(int stNode, int edNode, long[] dist) {
        Arrays.fill(dist, INF);
        PriorityQueue<Pair> minPq = new PriorityQueue<>(((o1, o2) -> o1.weight >= o2.weight ? 1 : -1));
        dist[stNode] = 0;
        minPq.offer(new Pair(stNode, 0));
        while (!minPq.isEmpty()) {
            Pair crr = minPq.poll();
            if (dist[crr.getNode()] != crr.getWeight()) continue;
            for (Pair next : adj.get(crr.getNode())) {
                if (dist[next.getNode()] <= dist[crr.getNode()] + next.getWeight()) continue;
                dist[next.getNode()] = dist[crr.getNode()] + next.getWeight();
                minPq.offer(new Pair(next.getNode(), dist[next.getNode()]));
            }
        }

        return dist[edNode];
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
