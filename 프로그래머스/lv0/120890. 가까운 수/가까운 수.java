import java.util.*;

class Solution {
    public int solution(int[] array, int n) {
        Stack<Integer> stack = new Stack<>();
        int minDif = 100;
        Arrays.sort(array);

        for (int i = 0; i < array.length; i++) {
            int temp = Math.abs(n - array[i]);
            if(minDif > temp) {
                minDif = temp;
                stack.push(array[i]);
            }
        }
        return stack.pop();
    }
}