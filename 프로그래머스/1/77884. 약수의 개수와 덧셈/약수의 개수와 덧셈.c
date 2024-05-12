#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>

int calcFactors(int num) {
    int result = 0;
    for(int i = 1; i <= num; i++) {
        if(num % i == 0) result++;
    }
    return result;
}
int solution(int left, int right) {
    int answer = 0;
    for(int i = left; i <= right; i++) {
        int temp = calcFactors(i);
        if(temp % 2 == 0) answer += i;
        else answer -= i;
    }
    return answer;
}