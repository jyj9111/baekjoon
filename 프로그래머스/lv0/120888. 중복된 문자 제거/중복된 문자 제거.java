class Solution {
    public String solution(String my_string) {
        String answer = "";
        
        while(!(my_string.length() == 0)) {
            String temp = String.valueOf(my_string.charAt(0));
            answer += temp;
            my_string = my_string.replace(temp, "");
        }
        return answer;
    }
}