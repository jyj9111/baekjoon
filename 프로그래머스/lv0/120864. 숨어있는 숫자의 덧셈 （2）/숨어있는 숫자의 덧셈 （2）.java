class Solution {
    public int solution(String my_string) {
        int answer = 0;
        my_string = my_string.replaceAll("[a-zA-Z]", "-");
        String[] split = my_string.split("-");
        for (int i = 0; i < split.length; i++) {
            if(split[i].equals(""))continue;
            answer += Integer.parseInt(split[i]);
        }
        return answer;
    }
}