class Solution {
    public int solution(String my_string) {
        int answer = 0;
        for(int i = 0; i < my_string.length(); i++) {
            int temp = my_string.charAt(i) - '1';
            if(temp < 10) {
                answer += temp + 1;
            }
        }
        return answer;
    }
}