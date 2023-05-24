import java.io.*;

public class Main { //Boj 1182: 부분수열의 합 (백트래킹)
    static int nNum;
    static int sNum;
    static int[] arr;

    static int count = 0;


    static void func(int curr) {

        if(curr == (1 << nNum)) {
            return;
        }
        int result = 0;

        for (int i = 0; i < nNum; i++) {

            if((curr & 1 << i) != 0) {
                result += arr[i];
            }
        }

        if(result == sNum)
            count++;

        func(curr + 1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        nNum = Integer.parseInt(input[0]);
        sNum = Integer.parseInt(input[1]);

        arr = new int[nNum];

        String[] intput2 = br.readLine().split(" ");
        for (int i = 0; i < nNum; i++) {
            arr[i] = Integer.parseInt(intput2[i]);
        }

        func(1);
        bw.append(Integer.toString(count));
        bw.flush();

        br.close();
        bw.close();
    }
}