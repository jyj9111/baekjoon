import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Queue<Integer> queue = new LinkedList<>();

        int answer = 0;
        int num =  Integer.parseInt(br.readLine());

        for (int i = 1; i <= num; i++) {
            queue.add(i);
        }

        while(!queue.isEmpty()) {
            answer = queue.poll();
            if(!queue.isEmpty())
                queue.add(queue.poll());
        }

        bw.write(Integer.toString(answer));
        bw.flush();
        bw.close();
    }
}