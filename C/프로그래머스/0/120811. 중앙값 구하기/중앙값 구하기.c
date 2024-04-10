#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>

int compare(const int* num1, const int* num2)
{
    return *num1 - *num2;
}
// array_len은 배열 array의 길이입니다.
int solution(int array[], size_t array_len) {
    qsort(array, array_len, sizeof(array[0]), compare);
    return array[array_len / 2];
}