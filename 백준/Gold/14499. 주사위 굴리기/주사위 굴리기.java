import java.io.*;

public class Main { // Boj14499: 주사위 굴리기
    static int nNum, mNum, kNum, stX, stY;
    static int[][] map;
    static int[] command;
    static int[] diceRow = new int[4];
    static int[] diceCol = new int[4];

    public static void main(String[] args) throws IOException {
        receiveInput();

        for (int i = 0; i < kNum; i++) {
            int cmd = command[i];
            if(cmd < 3) rollingDice(diceRow, cmd);
            else rollingDice(diceCol, cmd);
        }
    }

    private static void rollingDice(int[] dice, int cmd ) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] dx = {0, 0, 0, -1, 1};
        int[] dy = {0, 1, -1, 0, 0};

        int crrX = stX + dx[cmd];
        int crrY = stY + dy[cmd];

        if(crrX < 0 || crrX >= nNum || crrY < 0 || crrY >= mNum) return;

        shiftDice(dice, cmd);

        if(map[crrX][crrY] == 0) {
            map[crrX][crrY] = dice[3];
        }
        else {
            dice[3] = map[crrX][crrY];
            map[crrX][crrY] = 0;
        }

        stX = crrX;
        stY = crrY;
        diceCol[1] = dice[1];
        diceRow[1] = dice[1];
        diceCol[3] = dice[3];
        diceRow[3] = dice[3];

        bw.append(dice[1] + "\n");
        bw.flush();
    }

    private static void shiftDice(int[] arr, int cmd) {
        if(cmd % 3 == 1) { // cmd가 1,4(동,남)이면 오른쪽으로 쉬프트
            int temp = arr[arr.length - 1];
            for (int i = arr.length - 2; i >= 0; i--) {
                arr[i + 1] = arr[i];
            }
            arr[0] = temp;
        } else {            // cmd가 2,3(서,북)이면 왼쪽으로 쉬프트
            int temp = arr[0];
            for (int i = 0; i < arr.length - 1; i++) {
                arr[i] = arr[i + 1];
            }
            arr[arr.length - 1] = temp;
        }
    }

    private static void receiveInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        nNum = Integer.parseInt(input[0]);
        mNum = Integer.parseInt(input[1]);
        stX = Integer.parseInt(input[2]);
        stY = Integer.parseInt(input[3]);
        kNum = Integer.parseInt(input[4]);
        map = new int[nNum][mNum];
        command = new int[kNum];

        for (int i = 0; i < nNum; i++) {
            String[] input2 = br.readLine().split(" ");
            for (int j = 0; j < mNum; j++) {
                map[i][j] = Integer.parseInt(input2[j]);
            }
        }

        String[] input3 = br.readLine().split(" ");
        for (int i = 0; i < kNum; i++) {
            command[i] = Integer.parseInt(input3[i]);
        }

        br.close();
    }
}
