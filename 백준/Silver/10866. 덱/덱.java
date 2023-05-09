import java.io.*;
import java.util.Deque;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Deque<String> deque = new LinkedList<>();

        int num = Integer.parseInt(br.readLine());

        for (int i = 0; i < num; i++) {
            String[] mode = br.readLine().split(" ");
            String temp = "";
            switch (mode[0]) {
                case "push_front":
                    deque.addFirst(mode[1]);
                    break;
                case "push_back":
                    deque.addLast(mode[1]);
                    break;

                case "pop_front":
                    temp = deque.pollFirst();
                    if (temp == null) {
                        bw.write("-1" + "\n");
                        break;
                    }
                    bw.write(temp + "\n");
                    break;
                case "pop_back":
                    temp = deque.pollLast();
                    if (temp == null) {
                        bw.write("-1" + "\n");
                        break;
                    }
                    bw.write(temp + "\n");
                    break;

                case "size":
                    bw.write(Integer.toString(deque.size()) + "\n");
                    break;

                case "empty":
                    if (deque.isEmpty()) {
                        bw.write("1" + "\n");
                        break;
                    } else {
                        bw.write("0" + "\n");
                        break;
                    }

                case "front":
                    temp = deque.peekFirst();
                    if (temp == null) {
                        bw.write("-1" + "\n");
                        break;
                    } else {
                        bw.write(temp + "\n");
                        break;
                    }

                case "back":
                    temp = deque.peekLast();
                    if (temp == null) {
                        bw.write("-1" + "\n");
                        break;
                    } else {
                        bw.write(temp + "\n");
                        break;
                    }
            }
        }
        bw.flush();
        bw.close();
    }
}