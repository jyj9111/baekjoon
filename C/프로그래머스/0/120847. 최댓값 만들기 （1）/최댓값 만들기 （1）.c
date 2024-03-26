#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>

int compare(const int* num1, const int* num2) {
    return (*num1 - *num2);
}
// numbers_len은 배열 numbers의 길이입니다.
int solution(int numbers[], size_t numbers_len) {
    int answer = 0;
    qsort(numbers, numbers_len, sizeof(int), compare);
    
    return numbers[numbers_len - 1] * numbers[numbers_len - 2];
}