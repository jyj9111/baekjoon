#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>

// array_len은 배열 array의 길이입니다.
int solution(int array[], size_t array_len) {
    int answer = 0;
    for(int i = 0; i < array_len; i++) {
        while(array[i] > 0) {
            int tmp = array[i] % 10;
            array[i] /= 10;
            if(tmp == 0) continue;
            if(tmp % 7 == 0) answer++;
        }
    }
    return answer;
}