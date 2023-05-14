import java.io.*;
import java.util.LinkedList;

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

public class Main { //Boj 7562: 나이트의 이동

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] dx = {1, 0, -1, 0};                           // 방문좌표에서 4방향 좌표 확인을 위한 x의 변화량 배열
        int[] dy = {0, 1, 0, -1};                           // 방문좌표에서 4방향 좌표 확인을 위한 y의 변화량 배열

        int testCase = Integer.parseInt(br.readLine());
        int n, m, k = 0;
        
        while (testCase > 0) {
            int[][] board = new int[52][52];
            boolean[][] vis = new boolean[52][52];

            String[] input = br.readLine().split(" ");
            m = Integer.parseInt(input[0]); // 가로 
            n = Integer.parseInt(input[1]); // 세로
            k = Integer.parseInt(input[2]); // 심어져있는 배추 갯수

            for (int i = 0; i < k; i++) {
                String[] inputK = br.readLine().split(" ");
                int x = Integer.parseInt(inputK[1]);
                int y = Integer.parseInt(inputK[0]);

                board[x][y] = 1;
            }

            int num = 0;

            for (int i = 0; i < n; i++) {                       // n x m의 board를 돌면서 그림의 시작지점을 찾고
                for (int j = 0; j < m; j++) {                   // 시작지점으로부터 그림의 면적을 파악
                    if(board[i][j] == 0 || vis[i][j])           // 그림이 아닌 곳 or 이미 방문한 곳 이면 다음 반복! -> j++
                        continue;
                    // 그림이면서 처음 방문한 곳.
                    num++;                                      // 일단 그림의 개수 +1
                    LinkedList<Pair> queue = new LinkedList<>();// 큐를 생성.
                    vis[i][j] = true;                           // 우선 방문표시.
                    queue.add(new Pair(i,j));                   // 큐에 방문 좌표 삽입.
                    int area = 0;                               // 현재 좌표에서 이어진 그림의 면적을 카운트 하기위한 변수;

                    // 아래 반복문을 통해 현재 좌표에서 이어진 그림을 확인
                    while (!queue.isEmpty()) {                  // 큐가 빌때까지 반복.
                        area++;                                 // 그림면적 카운트 +1
                        Pair crr = queue.peekFirst();           // 큐에 들어있는 시작 좌표를 crr 변수에 저장 후
                        queue.pop();                            // 큐에서 삭제!
                        for (int dir = 0; dir < 4; dir++) {     // 방문지점에서 상,하,좌,우 방향 확인하기 위한 for문
                            int nx = crr.getX() + dx[dir];      // 시작좌표 (x,y)에 순서대로 (x+1, y) -> (x, y+1) ->
                            int ny = crr.getY() + dy[dir];      // (x-1, y) -> (x,y-1) 좌표를 확인
                            if (nx < 0 || nx >= n || ny < 0 || ny >= m)
                                continue;                       // 인덱스범위를 넘어가지 않는지 체크.
                            if (vis[nx][ny] || board[nx][ny] != 1)
                                continue;                       // 4방향 중 방문한 곳 이거나 그림이 아니라면 Pass!
                            vis[nx][ny] = true;                 // 그렇지 않다면 방문표시 남기고
                            queue.push(new Pair(nx, ny));       // 큐에 담아준다.
                        }
                    }
                }
            }
            bw.append(Integer.toString(num));
            bw.newLine();

            testCase--;
        }

        bw.flush();

        br.close();
        bw.close();
    }
}