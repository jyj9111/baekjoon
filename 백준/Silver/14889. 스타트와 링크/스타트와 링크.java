import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main { // Boj14889: 스타트와 링크
    static int nNum;
    static int[][] scoreCard;
    static boolean[] isUsed;
    static int min = Integer.MAX_VALUE;
    static int sum;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        nNum = Integer.parseInt(br.readLine());
        scoreCard = new int[nNum][nNum];

        for (int i = 0; i < nNum; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < nNum; j++) {
                scoreCard[i][j] = Integer.parseInt(input[j]);
            }
        }

        isUsed = new boolean[nNum];
        int[] select = new int[nNum / 2];
        List<int[]> teamList = new ArrayList<>();

        Main center = new Main();

        center.backTracking(0, 0, select, teamList);

        isUsed = new boolean[nNum / 2];
        center.divideTeam(teamList);
    }

    private void divideTeam(List<int[]> teamList) {
        int size = teamList.size();
        int[] start, link;
        int dif = 0;

        for (int i = 0; i < size / 2; i++) {
            sum = 0;
            start = teamList.get(i);
            calculate(0, 0, start, new int[2]);
            dif = sum;

            sum = 0;
            link = teamList.get(size - i - 1);
            calculate(0, 0, link, new int[2]);
            dif -= sum;
            min = Math.min(min, Math.abs(dif));
        }

        System.out.println(min);
    }

    private void calculate(int num, int st, int[] arr, int[] answer) {
        if(num == 2) {
            int x = answer[0];
            int y = answer[1];
            sum += (scoreCard[x][y] + scoreCard[y][x]);
            return;
        }

        for (int i = st; i < arr.length; i++) {
            if (!isUsed[i]) {
               answer[num] = arr[i];
               isUsed[i] = true;
               calculate(num + 1, i, arr, answer);
               isUsed[i] = false;
            }
        }
    }

    private void backTracking(int num, int st, int[] select, List<int[]> list) {
        if(num == select.length) {
            int[] temp = deepCopyArray(select);
            list.add(temp);
            return;
        }

        for (int i = st; i < isUsed.length; i++) {
            if(!isUsed[i]) {
                select[num] = i;
                isUsed[i] = true;
                backTracking(num + 1, i, select, list);
                isUsed[i] = false;
            }
        }
    }

    private static int[] deepCopyArray(int[] nums) {
        int[] tmp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            tmp[i] = nums[i];
        }
        return tmp;
    }
}
