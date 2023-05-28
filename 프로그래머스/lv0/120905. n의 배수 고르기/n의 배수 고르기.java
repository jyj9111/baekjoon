class Solution {
    public int[] solution(int n, int[] numlist) {
        int[] temp = new int[101];
        int count = 0;
        
        for(int i = 0; i < numlist.length; i++) {
            if(numlist[i] % n == 0) {
                temp[count++] = numlist[i];
            }
        }
        
        int[] answer = new int[count];
        
        for(int i = 0; i < count; i++) {
            answer[i] = temp[i];
        }
        
        return answer;
    }
}