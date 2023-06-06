import java.io.*;
import java.util.*;

public class Main { //Boj12100: 2048(EASY) (시뮬레이션)
    static int nNum;
    static int[][] board;
    static int[][] pBoard;
    static boolean[][] isUsed;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        nNum = Integer.parseInt(br.readLine());
        board = new int[nNum][nNum];

        for (int i = 0; i < nNum; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < nNum; j++) {
                board[i][j] = Integer.parseInt(input[j]);
            }
        }

        int max = 0;
        for (int tmp = 0; tmp < (1 << 10); tmp++) {
            pBoard = makeDeepCopyArr(board);

            int brute = tmp;
            for (int i = 0; i < 5; i++) {
                isUsed = new boolean[nNum][nNum];
                int dir = brute % 4;
                brute /= 4;

                if(dir == 0) { // 위
                    solveUP();
                } else if(dir == 1) { // 오른쪽
                    solveRight();
                } else if(dir == 2) { // 아래
                    solveDown();
                } else { // 왼쪽
                    solveLeft();
                }

            }
            for (int i = 0; i < nNum; i++) {
                for (int j = 0; j < nNum; j++) {
                    if(pBoard[i][j] > max) max = pBoard[i][j];
                }
            }
        }
        System.out.println(max);
    }

    private static void solveUP() {

        for (int i = 0; i < nNum; i++) {
            Queue<Integer> que = new LinkedList<>();
            for (int j = 1; j < nNum; j++) {
                if(pBoard[j][i] == 0) continue;
                que.add(pBoard[j][i]);
                pBoard[j][i] = 0;
            }
            int size = que.size();
            int idx = 0;
            for (int j = 0; j < size; j++) {
                int temp = que.remove();
                if(pBoard[idx][i] == 0) pBoard[idx][i] = temp;
                else if(!isUsed[idx][i] && pBoard[idx][i] == temp) {
                    pBoard[idx][i] += temp;
                    isUsed[idx][i] = true;
                }
                else pBoard[++idx][i] = temp;
            }
        }
    }

    private static void solveRight() {
        for (int i = 0; i < nNum; i++) {
            Queue<Integer> que = new LinkedList<>();
            for (int j = nNum - 2; j >= 0; j--) {
                if(pBoard[i][j] == 0) continue;
                que.add(pBoard[i][j]);
                pBoard[i][j] = 0;
            }
            int size = que.size();
            int idx = nNum - 1;
            for (int j = 0; j < size; j++) {
                int temp = que.remove();
                if(pBoard[i][idx] == 0) pBoard[i][idx] = temp;
                else if(!isUsed[i][idx] && pBoard[i][idx] == temp) {
                    pBoard[i][idx] += temp;
                    isUsed[i][idx] = true;
                }
                else pBoard[i][--idx] = temp;
            }
        }
    }

    private static void solveDown() {
        for (int i = 0; i < nNum; i++) {
            Queue<Integer> que = new LinkedList<>();
            for (int j = nNum - 2; j >= 0 ; j--) {
                if(pBoard[j][i] == 0) continue;
                que.add(pBoard[j][i]);
                pBoard[j][i] = 0;
            }
            int size = que.size();
            int idx = nNum - 1;
            for (int j = 0; j < size; j++) {
                int temp = que.remove();
                if(pBoard[idx][i] == 0) pBoard[idx][i] = temp;
                else if(!isUsed[idx][i] && pBoard[idx][i] == temp) {
                    pBoard[idx][i] += temp;
                    isUsed[idx][i] = true;
                }
                else pBoard[--idx][i] = temp;
            }
        }
    }

    private static void solveLeft() {
        for (int i = 0; i < nNum; i++) {
            Queue<Integer> que = new LinkedList<>();
            for (int j = 1; j < nNum ; j++) {
                if(pBoard[i][j] == 0) continue;
                que.add(pBoard[i][j]);
                pBoard[i][j] = 0;
            }
            int size = que.size();
            int idx = 0;
            for (int j = 0; j < size; j++) {
                int temp = que.remove();
                if(pBoard[i][idx] == 0) pBoard[i][idx] = temp;
                else if(!isUsed[i][idx] && pBoard[i][idx] == temp) {
                    pBoard[i][idx] += temp;
                    isUsed[i][idx] = true;
                }
                else pBoard[i][++idx] = temp;
            }
        }
    }

    static private int[][] makeDeepCopyArr(int[][] arr) {
        int[][] result =  new int[arr.length][arr[0].length];

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                result[i][j] = arr[i][j];
            }
        }
        return result;
    }
}