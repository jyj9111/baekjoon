import java.util.*;
class Solution {
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
    public int solution(int[][] maps) {
        int row = maps.length;
        int col = maps[0].length;
        int[][] distance = new int[row][col];
        for(int[] temp : distance) {
            Arrays.fill(temp, -2);
        }

        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};

        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(0, 0));
        distance[0][0] = 0;

        while(!queue.isEmpty()) {
            Pair crr = queue.poll();

            for (int dir = 0; dir < 4; dir++) {
                int nx = crr.getX() + dx[dir];
                int ny = crr.getY() + dy[dir];

                if(nx < 0 || nx >= row || ny < 0 || ny >= col) continue;
                if(distance[nx][ny] >= 0 || maps[nx][ny] == 0) continue;

                queue.add(new Pair(nx, ny));
                distance[nx][ny] = distance[crr.getX()][crr.getY()] + 1;
            }
        }

        return distance[row - 1][col - 1] + 1;
    }
}