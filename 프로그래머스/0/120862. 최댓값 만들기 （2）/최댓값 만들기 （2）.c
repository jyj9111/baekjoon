#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>

int compare(const int* a, const int* b) {
    return *a - *b;
}

// numbers_len은 배열 numbers의 길이입니다.
int solution(int numbers[], size_t numbers_len) {
    int answer = 0;
    qsort(numbers, numbers_len, sizeof(int), compare);
    int num1 = numbers[0] * numbers[1];
    int num2 = numbers[numbers_len - 2] * numbers[numbers_len - 1];
    
    return (num1 > num2) ? num1 : num2;
}