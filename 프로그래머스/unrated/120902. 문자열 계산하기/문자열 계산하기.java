import java.util.*;
class Solution {
    public int solution(String my_string) {
        int answer = 0;
        
        Stack<Integer> stack = new Stack<>();
        Stack<String> operator = new Stack<>();

        for(String temp : my_string.split(" ")) {
            if(temp.equals("+") || temp.equals("-")) {
                operator.push(temp);
                continue;
            }
            if(!operator.isEmpty()) {
                if (operator.pop().equals("+")) {
                    int i = stack.pop() + Integer.parseInt(temp);
                    stack.push(i);
                } else {
                    int i = stack.pop() - Integer.parseInt(temp);
                    stack.push(i);
                }
            } else {
                stack.push(Integer.parseInt(temp));
            }
        }
        answer = stack.pop();
        return answer;
    }
}