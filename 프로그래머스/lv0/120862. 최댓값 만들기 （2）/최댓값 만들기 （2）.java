import java.util.*;

class Solution {
    public int solution(int[] numbers) {
        int answer = 0;
        Arrays.sort(numbers);
        int max1 = numbers[0] * numbers[1];
        int max2 = numbers[numbers.length - 1] * numbers[numbers.length - 2];
        return max1 > max2 ? max1 : max2;
    }
}