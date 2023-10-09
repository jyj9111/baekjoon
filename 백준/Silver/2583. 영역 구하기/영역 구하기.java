import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main { // Boj2583: 영역구하기
    private class Pair{
        private int x;
        private int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
    }
    private void solution() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer info = new StringTokenizer(reader.readLine());
        int row = Integer.parseInt(info.nextToken());
        int col = Integer.parseInt(info.nextToken());
        int rec = Integer.parseInt(info.nextToken());

        int[][] board = new int[row][col];
        boolean[][] visit = new boolean[row][col];

        for (int i = 0; i < rec; i++) {
            String[] split = reader.readLine().split(" ");
            drawRectangle(board, split);
        }

        // BFS
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};

        int num = 0; // 영역 갯수
        Queue<Integer> result = new LinkedList<>();

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == 1 || visit[i][j]) continue;
                num++;
                Queue<Pair> queue = new LinkedList<>();
                visit[i][j] = true;
                queue.offer(new Pair(i, j));
                int area = 0;

                while (!queue.isEmpty()) {
                    area++;
                    Pair crr = queue.poll();
                    for (int dir = 0; dir < 4; dir++) {
                        int nextX = crr.getX() + dx[dir];
                        int nextY = crr.getY() + dy[dir];

                        if (nextX < 0 || nextX >= row || nextY < 0 || nextY >= col) continue;
                        if (visit[nextX][nextY] || board[nextX][nextY] == 1) continue;

                        visit[nextX][nextY] = true;
                        queue.offer(new Pair(nextX, nextY));
                    }
                }
                result.offer(area);
            }
        }
        int[] temp = new int[num];
        int idx = 0;
        for (int i : result) {
            temp[idx++] = i;
        }
        Arrays.sort(temp);
        StringBuilder answer = new StringBuilder();
        answer.append(num).append("\n");
        for (int i = 0; i < num; i++) {
            answer.append(temp[i]).append(" ");
        }
        System.out.println(answer);
    }

    private void drawRectangle(int[][] board, String[] split) {
        int stX = Integer.parseInt(split[0]);
        int stY = Integer.parseInt(split[1]);
        int edX = Integer.parseInt(split[2]);
        int edY = Integer.parseInt(split[3]);

        for (int i = stY; i < edY; i++) {
            for (int j = stX; j < edX; j++) {
                board[i][j] = 1;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
