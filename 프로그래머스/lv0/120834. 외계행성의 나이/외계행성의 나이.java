class Solution {
    public String solution(int age) {
        String answer = "";
        while (age > 0) {
            int temp = age % 10 + 'a';
            answer += String.valueOf((char) temp);
            age /= 10;
        }
        
        StringBuffer sb = new StringBuffer(answer);
        
        return sb.reverse().toString();
    }
}