import java.io.*;
import java.util.*;

public class Main { //Boj12100: 2048(EASY) (시뮬레이션)
    static int nNum;
    static int[][] board; // 원본 보드
    static Easy[][] eBoard;

    public static class Easy {
        int num;
        boolean isUsed;

        public Easy(int num) {
            this.num = num;
            this.isUsed = false;
        }

        public int getNum() {
            return num;
        }

        public void setNum(int num) {
            this.num = num;
        }

        public boolean isUsed() {
            return isUsed;
        }

        public void setUsed(boolean used) {
            isUsed = used;
        }
    }

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
            eBoard = makeArrIntToEasy(board);
            int brute = tmp;
            for (int i = 0; i < 5; i++) {
                resetEBoardIsUsed();

                int dir = brute % 4;
                brute /= 4;

                if(dir == 0) {        // 위
                    solveUP();
                } else if(dir == 1) { // 오른쪽
                    solveRight();
                } else if(dir == 2) { // 아래
                    solveDown();
                } else {              // 왼쪽
                    solveLeft();
                }

            }
            for (int i = 0; i < nNum; i++) {
                for (int j = 0; j < nNum; j++) {
                    if(eBoard[i][j].getNum() > max) {
                        max = eBoard[i][j].getNum();
                    }
                }
            }
        }
        System.out.println(max);
    }

    private static void solveUP() {

        for (int i = 0; i < nNum; i++) {
            Queue<Easy> que = new LinkedList<>();
            for (int j = 1; j < nNum; j++) {
                if(eBoard[j][i].getNum() == 0) continue;
                que.add(eBoard[j][i]);
                eBoard[j][i] = new Easy(0);
            }
            int size = que.size();
            int idx = 0;
            for (int j = 0; j < size; j++) {
                Easy temp = que.remove();
                if(eBoard[idx][i].getNum() == 0) eBoard[idx][i] = temp;
                else if(!eBoard[idx][i].isUsed() && eBoard[idx][i].getNum() == temp.getNum()) {
                    eBoard[idx][i].setNum(eBoard[idx][i].getNum() + temp.getNum());
                    eBoard[idx][i].setUsed(true);
                }
                else eBoard[++idx][i] = temp;
            }
        }
    }

    private static void solveRight() {
        for (int i = 0; i < nNum; i++) {
            Queue<Easy> que = new LinkedList<>();
            for (int j = nNum - 2; j >= 0; j--) {
                if(eBoard[i][j].getNum() == 0) continue;
                que.add(eBoard[i][j]);
                eBoard[i][j] = new Easy(0);
            }
            int size = que.size();
            int idx = nNum - 1;
            for (int j = 0; j < size; j++) {
                Easy temp = que.remove();
                if(eBoard[i][idx].getNum() == 0) eBoard[i][idx]= temp;
                else if(!eBoard[i][idx].isUsed() && eBoard[i][idx].getNum() == temp.getNum()) {
                    eBoard[i][idx].setNum(eBoard[i][idx].getNum() + temp.getNum());
                    eBoard[i][idx].setUsed(true);
                }
                else eBoard[i][--idx] = temp;
            }
        }
    }

    private static void solveDown() {
        for (int i = 0; i < nNum; i++) {
            Queue<Easy> que = new LinkedList<>();
            for (int j = nNum - 2; j >= 0 ; j--) {
                if(eBoard[j][i].getNum() == 0) continue;
                que.add(eBoard[j][i]);
                eBoard[j][i] = new Easy(0);
            }
            int size = que.size();
            int idx = nNum - 1;
            for (int j = 0; j < size; j++) {
                Easy temp = que.remove();
                if(eBoard[idx][i].getNum() == 0) eBoard[idx][i]= temp;
                else if(!eBoard[idx][i].isUsed() && eBoard[idx][i].getNum() == temp.getNum()) {
                    eBoard[idx][i].setNum(eBoard[idx][i].getNum() + temp.getNum());
                    eBoard[idx][i].setUsed(true);
                }
                else eBoard[--idx][i] = temp;
            }
        }
    }

    private static void solveLeft() {
        for (int i = 0; i < nNum; i++) {
            Queue<Easy> que = new LinkedList<>();
            for (int j = 1; j < nNum ; j++) {
                if(eBoard[i][j].getNum() == 0) continue;
                que.add(eBoard[i][j]);
                eBoard[i][j] = new Easy(0);
            }
            int size = que.size();
            int idx = 0;
            for (int j = 0; j < size; j++) {
                Easy temp = que.remove();
                if(eBoard[i][idx].getNum() == 0) eBoard[i][idx] = temp;
                else if(!eBoard[i][idx].isUsed() && eBoard[i][idx].getNum() == temp.getNum()) {
                    eBoard[i][idx].setNum(eBoard[i][idx].getNum() + temp.getNum());
                    eBoard[i][idx].setUsed(true);
                }
                else eBoard[i][++idx] = temp;
            }
        }
    }
    static private void resetEBoardIsUsed() {
        for (int i = 0; i < eBoard.length; i++) {
            for (int j = 0; j < eBoard[0].length; j++) {
                eBoard[i][j].setUsed(false);
            }
        }
    }
    static private Easy[][] makeArrIntToEasy(int[][] arr) {
        Easy[][] result =  new Easy[arr.length][arr[0].length];

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                result[i][j] = new Easy(arr[i][j]);
            }
        }
        return result;
    }
}
