#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>

// numbers_len은 배열 numbers의 길이입니다.
double solution(int nums[], size_t nums_len) {
    double answer = 0;
    for(int i = 0; i < nums_len; i++) {
        answer += nums[i];
    }
    return answer / nums_len;
}