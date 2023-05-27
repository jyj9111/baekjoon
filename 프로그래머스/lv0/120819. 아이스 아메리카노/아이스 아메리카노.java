class Solution {
    public int[] solution(int money) {
        
        int coffee = money / 5500;
        int change = money % 5500;
        
        
        int[] answer = {coffee, change};
        return answer;
    }
}