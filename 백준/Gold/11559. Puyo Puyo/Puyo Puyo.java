import java.io.*;
import java.util.*;

public class Main { //Boj11559: Puyo Puyo (시뮬레이션)
    static String[][] board = new String[12][6];
    static int count = 0;

    private static class Pair {
        int x, y;

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

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int i = 0; i < 12; i++) {
            String[] input = br.readLine().split("");
            for (int j = 0; j < 6; j++) {
                board[i][j] = input[j];
            }
        }

        while(true) {
            if(!checkBubble()) {
                break;
            }
            count++;
            putDown();
        }

        bw.append(count + "");
        bw.flush();
        br.close();
        bw.close();
    }

    private static boolean checkBubble() {
        int resutl = 0;

        resutl += bfs("R");
        resutl += bfs("G");
        resutl += bfs("B");
        resutl += bfs("P");
        resutl += bfs("Y");

        if(resutl == 0) return false;
        else return true;
    }

    private static void putDown() {
        for (int i = 0; i < 6; i++) {
            Queue<String> que = new LinkedList<>();
            for (int j = 11; j >= 0 ; j--) {
                if(board[j][i].equals(".")) continue;
                que.add(board[j][i]);
                board[j][i] = ".";
            }
            int size = que.size();
            int idx = 11;
            for (int j = 0; j < size; j++) {
                String temp = que.remove();
                if(board[idx][i].equals(".")) board[idx][i] = temp;
                else board[--idx][i] = temp;
            }
        }
    }

    private static int bfs(String target) {
        boolean[][] vis = new boolean[12][6];
        boolean isPop = false;

        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};

        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 6; j++) {
                if(!board[i][j].equals(target) || vis[i][j])
                    continue;
                Queue<Pair> que = new LinkedList<>();
                ArrayList<Pair> arr = new ArrayList<>();

                vis[i][j] = true;
                que.add(new Pair(i, j));
                arr.add(new Pair(i, j));

                while(!que.isEmpty()) {
                    Pair crr = que.remove();
                    for (int dir = 0; dir < 4; dir++) {
                        int nx = crr.getX() + dx[dir];
                        int ny = crr.getY() + dy[dir];
                        if(nx < 0 || nx >= 12 || ny < 0 || ny >= 6)
                            continue;
                        if(vis[nx][ny] || !board[nx][ny].equals(target))
                            continue;
                        vis[nx][ny] = true;
                        que.add(new Pair(nx, ny));
                        arr.add(new Pair(nx, ny));
                    }
                }
                if(arr.size() >= 4) {
                    popBubble(arr);
                    isPop = true;
                }
            }
        }

        if(isPop) return 1;
        else return 0;
    }

    private static void popBubble(ArrayList<Pair> arr) {
        for (int i = 0; i < arr.size(); i++) {
            int x = arr.get(i).getX();
            int y = arr.get(i).getY();
            board[x][y] = ".";
        }
    }
}
