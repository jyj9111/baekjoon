import java.io.*;
import java.util.Stack;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Stack<String> stack = new Stack<>();

        int count = 0;
        int num = Integer.parseInt(br.readLine());

        for (int i = 0; i < num; i++) {
            String[] str = br.readLine().split("");

            for (int j = 0; j < str.length; j++) {
                if(stack.isEmpty()) { // 스택이 비었을 때
                    stack.add(str[j]);
                } else { // 스택이 안 비었을 때
                    if(str[j].equals(stack.peek())) {
                        stack.pop();
                    }
                    else stack.add(str[j]);
                }
            }
            if(stack.isEmpty()) count++;
            stack.clear();
        }
        bw.append(Integer.toString(count));
        bw.flush();
        br.close();
        bw.close();
    }
}