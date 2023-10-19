import java.util.*;
class Solution {
    public String[] solution(String my_str, int n) {
        String[] answer = {};
        if (my_str.length() % n == 0) answer = new String[my_str.length() / n];
        else answer = new String[my_str.length() / n + 1];
        int stIdx = 0;
        int edIdx = n;
        
        for(int i = 0; i < answer.length; i++) {
            if(i == answer.length - 1) {
                answer[i] = my_str.substring(stIdx);
                continue;
            }
            answer[i] = my_str.substring(stIdx, edIdx);
            stIdx += n;
            edIdx += n;
        }
        return answer;
    }
}