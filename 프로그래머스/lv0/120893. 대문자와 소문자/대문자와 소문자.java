class Solution {
    public String solution(String my_string) {
        String answer = "";
        for(int i = 0; i < my_string.length(); i++) {
            if(my_string.charAt(i) - 'a' >= 0) {
                String temp = my_string.substring(i, i + 1);
                answer += temp.toUpperCase();
            } else {
                String temp = my_string.substring(i, i + 1);
                answer += temp.toLowerCase();
            }
        }
        return answer;
    }
}