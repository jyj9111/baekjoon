class Solution {
    public int[] solution(int n) {
        int idx = 0;
        int[] temp = new int[n];
        
        for(int i = 1; i <= n; i++) {
            if(i % 2 != 0) {
                temp[idx++] = i;
            }
        }
        int[] answer = new int[idx];
        for(int i = 0; i < idx; i++) {
            answer[i] = temp[i];
        }
        return answer;
    }
}