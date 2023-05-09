import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Queue<String> queue = new LinkedList<>();

        int num =  Integer.parseInt(br.readLine());

        for (int i = 0; i < num; i++) {
            String[] mode = br.readLine().split(" ");
            String temp = "";
            switch (mode[0]) {
                case "push":
                    queue.add(mode[1]);
                    break;

                case "pop":
                    temp = queue.poll();
                    if(temp == null) {
                        bw.write("-1" + "\n");
                        break;
                    }
                    bw.write(temp + "\n");
                    break;

                case "size":
                    bw.write(Integer.toString(queue.size()) + "\n");
                    break;

                case "empty":
                    if(queue.isEmpty()){
                        bw.write("1" + "\n");
                        break;
                    } else {
                        bw.write("0" + "\n");
                        break;
                    }

                case "front":
                    temp = queue.peek();
                    if(temp ==  null) {
                        bw.write("-1" + "\n");
                        break;
                    } else {
                        bw.write(temp + "\n");
                        break;
                    }

                case "back":
                    temp = ((LinkedList<String>)queue).peekLast();
                    if(temp == null) {
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