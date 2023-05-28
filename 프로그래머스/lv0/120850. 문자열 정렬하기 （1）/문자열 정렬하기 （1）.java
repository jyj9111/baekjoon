import java.util.*;
class Solution {
    public int[] solution(String my_string) {
        int[] arr = new int[100];
        int idx = 0;
        for(int i = 0; i < my_string.length(); i++) {
            int temp = my_string.charAt(i) - '0';
            if(temp >= 0 && temp < 10) 
                arr[idx++] = temp;
        }
        int[] answer = new int[idx];
        for(int i = 0; i < idx; i++) {
            answer[i] = arr[i];
        }
        Arrays.sort(answer);
        return answer;
    }
}