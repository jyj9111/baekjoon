import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());
        for (int i = 0; i < num; i++) {
           String[] data = br.readLine().split(" ");
           int result = Integer.parseInt(data[0]) + Integer.parseInt(data[1]);
           bw.write(Integer.toString(result) + "\n");
        }
        bw.flush();
    }
}