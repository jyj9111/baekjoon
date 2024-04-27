#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>

int calculation(int num, int cmp) {
    int cnt = 0;
    while(num > 0) {
        if(num % 10 == cmp) cnt++;
        num /= 10;
    }
    return cnt;
}
int solution(int i, int j, int k) {
    int answer = 0;
    for(int st = i; st <= j; st++) {
        answer += calculation(st, k);
    }
    return answer;
}