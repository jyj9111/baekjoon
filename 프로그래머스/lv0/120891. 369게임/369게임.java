class Solution {
    public int solution(int order) {
        int answer = 0;
        while(order > 0) {
            int temp = order % 10;
            if(temp != 0 && temp % 3 == 0) answer++;
            order /= 10;
        }
        return answer;
    }
}