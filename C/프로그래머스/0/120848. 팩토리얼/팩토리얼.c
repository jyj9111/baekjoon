#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>

int factorial(int num) {
    int tmp = 1;
    for(int i = 1; i <= num; i++) {
        tmp *= i;
    }
    return tmp;
}
int solution(int n) {
    int answer = 0;
    for(int i = 1; i <= 10; i++) {
        int temp = factorial(i);
        if(temp > n) {
            answer = i - 1;
            break;
        } else if (temp == n) {
            answer = i;
            break;
        }
    }
    return answer;
}