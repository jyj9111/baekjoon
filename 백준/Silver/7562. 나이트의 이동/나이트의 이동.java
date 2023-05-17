import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

class Pair {
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

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
}

public class Main { //Boj 1012: 유기농 배추

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Queue<Pair> queue = new LinkedList<>();

        int[] dx = {2, 1, -1, -2, -2, -1, 1, 2};
        int[] dy = {1, 2, 2, 1, -1, -2, -2, -1};

        int[][] distance = new int[305][305];

        int caseNum = Integer.parseInt(br.readLine());
        int boardSize = 0;
        int sX = 0;
        int sY = 0;
        int eX = 0;
        int eY = 0;

        while (caseNum > 0) {
            boardSize = Integer.parseInt(br.readLine());
            for (int i = 0; i < boardSize; i++) {
                for (int j = 0; j < boardSize; j++) {
                    distance[i][j] = -1;
                }
            }

            String[] startPointIn = br.readLine().split(" ");
            sX = Integer.parseInt(startPointIn[0]);
            sY = Integer.parseInt(startPointIn[1]);
            distance[sX][sY] = 0;
            queue.add(new Pair(sX, sY));

            String[] endPointIn = br.readLine().split(" ");
            eX = Integer.parseInt(endPointIn[0]);
            eY = Integer.parseInt(endPointIn[1]);

            while (!queue.isEmpty()) {
                Pair crr = queue.remove();

                for (int dir = 0; dir < 8; dir++) {
                    int nx = crr.getX() + dx[dir];
                    int ny = crr.getY() + dy[dir];
                    if (nx < 0 || nx >= boardSize || ny < 0 || ny >= boardSize)
                        continue;
                    if (distance[nx][ny] >= 0)
                        continue;
                    distance[nx][ny] = distance[crr.getX()][crr.getY()] + 1;
                    queue.add(new Pair(nx, ny));
                }
            }
            bw.append(Integer.toString(distance[eX][eY]));
            bw.newLine();

            caseNum--;
        }
        bw.flush();

        br.close();
        bw.close();
    }
}