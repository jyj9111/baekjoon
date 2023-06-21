import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main { // Boj14503: 로봇 청소기
    private static class Pair {
        private int x, y, dir;

        public Pair(int x, int y, int dir) {
            this.x = x;
            this.y = y;
            this.dir = dir;
        }

        public int getDir() {
            return dir;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
    }

    static int nNum, mNum;
    static Pair start;
    static int[][] map;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        receiveInput();
        clean();
    }

    private static void clean() {
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        Queue<Pair> queue = new LinkedList<>();
        queue.add(start);

        int count = 0;
        while (!queue.isEmpty()) {
            Pair crr = queue.remove();

            if(map[crr.getX()][crr.getY()] == 0) {
                map[crr.getX()][crr.getY()] = 2;
                count++;
            }

            for (int i = 0; i < 4; i++) {
                int dir = (crr.dir + 3 - i) % 4;
                int nx = crr.getX() + dx[dir];
                int ny = crr.getY() + dy[dir];

                if(nx < 0 || nx >= nNum || ny < 0 || ny >= mNum) continue;
                if(map[nx][ny] != 0) continue;

                queue.add(new Pair(nx, ny, dir));
                break;
            }

            if(queue.isEmpty()) {
                int dir = crr.getDir();
                int nx = crr.getX() + dx[(dir + 2) % 4];
                int ny = crr.getY() + dy[(dir + 2) % 4];

                if(nx < 0 || nx >= nNum || ny < 0 || ny >= mNum) break;
                if(map[nx][ny] == 1) break;

                queue.add(new Pair(nx, ny, dir));
            }
        }
        System.out.println(count);
    }


    private static void receiveInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        nNum = Integer.parseInt(input[0]);
        mNum = Integer.parseInt(input[1]);

        String[] input2 = br.readLine().split(" ");
        start = new Pair(
                Integer.parseInt(input2[0]),
                Integer.parseInt(input2[1]),
                Integer.parseInt(input2[2])
        );

        map = new int[nNum][mNum];
        visited = new boolean[nNum][mNum];
        for (int i = 0; i < nNum; i++) {
            String[] temp = br.readLine().split(" ");
            for (int j = 0; j < mNum; j++) {
                map[i][j] = Integer.parseInt(temp[j]);
            }
        }
    }
}
