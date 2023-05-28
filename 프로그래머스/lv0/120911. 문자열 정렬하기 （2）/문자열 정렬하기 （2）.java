import java.util.*;
class Solution {
    public String solution(String my_string) {
        char[] ch = my_string.toLowerCase().toCharArray();
        Arrays.sort(ch);
        return String.valueOf(ch);
    }
}