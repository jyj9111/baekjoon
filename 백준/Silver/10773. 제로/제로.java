import java.io.*;
import java.util.Stack;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Stack<Integer> stack = new Stack<>();

        int num = Integer.parseInt(br.readLine());

        while (num > 0) {
            int temp = Integer.parseInt(br.readLine());
            if(temp == 0) {
                stack.pop();
            } else {
                stack.push(temp);
            }
            num--;
        }
        int sum = 0;
        while (!stack.isEmpty()) {
            sum += stack.pop();
        }
        bw.write(Integer.toString(sum));
        bw.flush();
        bw.close();
    }
}