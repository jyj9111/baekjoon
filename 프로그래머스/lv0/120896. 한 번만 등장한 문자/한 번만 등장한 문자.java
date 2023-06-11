import java.util.*;
class Solution {
    public String solution(String s) {
        String answer = "";
        String result = "";
        char [] ch = s.toCharArray();
        Arrays.sort(ch);
        answer = String.valueOf(ch);
        for (int i = 0; i < answer.length(); i++) {
            char temp = answer.charAt(i);
            int len = answer.length() - answer.replace(String.valueOf(temp), "").length();
            if(len == 1) result += temp;
        }
        return result;
    }
}