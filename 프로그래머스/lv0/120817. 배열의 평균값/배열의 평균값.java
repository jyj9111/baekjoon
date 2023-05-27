class Solution {
    public double solution(int[] numbers) {
        double answer = 0;
        for(int i = 0; i < numbers.length; i++) {
            answer += (double) numbers[i];
        }
        return answer / (double)numbers.length;
    }
}