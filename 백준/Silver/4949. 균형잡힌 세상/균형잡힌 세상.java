import java.io.*;
import java.util.Stack;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Stack<Character> stack = new Stack<>();
        boolean isEndInput = false;

        while(!isEndInput) {
            boolean isBalanced = true;
            String str = br.readLine();
            
            if(str.charAt(0) == '.') break;

            int endIdx = str.indexOf(".");

            for (int i = 0; i < endIdx + 1; i++) {

                if(str.charAt(i) == '(' || str.charAt(i) == '[') {
                    stack.add(str.charAt(i));
                } 
                if(stack.isEmpty()) { // 스택이 비어있을 때
                    if(str.charAt(i) == ')' || str.charAt(i) == ']'){
                        isBalanced = false;
                        break;
                    }
                } else { // 스택이 안비어 있을 때
                    if (str.charAt(i) == ')' && stack.peek() == '(')
                        stack.pop();
                    else if (str.charAt(i) == ']' && stack.peek() == '[')
                        stack.pop();
                    else if (str.charAt(i) == ']' && stack.peek() == '(') {
                        isBalanced = false;
                        break;
                    } else if (str.charAt(i) == ')' && stack.peek() == '[') {
                        isBalanced = false;
                        break;
                    }
                }
            }
            if(stack.isEmpty() && isBalanced) bw.write("yes\n");
            else bw.write("no\n");

            stack.clear();
        }
        bw.flush();
        bw.close();
    }
}