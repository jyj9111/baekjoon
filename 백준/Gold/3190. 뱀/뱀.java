import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class Main { // Boj3190: 뱀
    static int nNum, kNum, lNum;
    static int[][] map;
    static DirInfo[] directions;
    static Deque<Pair> snake = new LinkedList<>();

    private static class Pair {
        private int x, y;

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
    private static class DirInfo {
        private int sec;
        private String dir;

        public DirInfo(int sec, String dir) {
            this.sec = sec;
            this.dir = dir;
        }

        public int getSec() {
            return sec;
        }

        public String getDir() {
            return dir;
        }
    }

    public static void main(String[] args) throws IOException {
        receiveInput();
        playGame();
    }

    private static void playGame() {
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};

        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(0, 0));
        snake.add(new Pair(0, 0));

        int time = 0;
        int dir = 0; // 0:동, 1:남, 2:서, 3:북
        while (!queue.isEmpty()) {
            time++;

            Pair crr = queue.remove();

            int nextX = crr.getX() + dx[dir];
            int nextY = crr.getY() + dy[dir];
            Pair next = new Pair(nextX, nextY);

            if(nextX < 0 || nextX >= nNum || nextY < 0 || nextY >= nNum) break;
            if(isClashed(next)) break;

            if(map[nextX][nextY] == 2) {
                map[nextX][nextY] = 0;
                snake.addFirst(next);
                queue.add(next);
                dir = checkDirection(time ,dir);
                continue;
            }
            queue.add(next);
            snake.addFirst(next);
            snake.removeLast();
            dir = checkDirection(time ,dir);
        }
        System.out.println(time);
    }

    private static boolean isClashed(Pair pos) {
        for(Pair temp : snake) {
            if(temp.getX() == pos.getX() && temp.getY() == pos.getY())
                return true;
        }
        return false;
    }

    private static int checkDirection(int time, int dir) {
        for(DirInfo temp : directions) {
            if(temp.getSec() == time) {
                if(temp.getDir().equals("L"))
                    dir = (dir + 3) % 4;
                else
                    dir = (dir + 1) % 4;
            }
        }
        return dir;
    }

    private static void receiveInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        nNum = Integer.parseInt(br.readLine());
        map = new int[nNum][nNum];

        kNum = Integer.parseInt(br.readLine());
        for (int i = 0; i < kNum; i++) {
            String[] input = br.readLine().split(" ");
            map[Integer.parseInt(input[0]) - 1][Integer.parseInt(input[1]) - 1] = 2;
        }

        lNum = Integer.parseInt(br.readLine());
        directions = new DirInfo[lNum];
        for (int i = 0; i < lNum; i++) {
            String[] input = br.readLine().split(" ");
            directions[i] = new DirInfo(Integer.parseInt(input[0]), input[1]);
        }
    }
}
