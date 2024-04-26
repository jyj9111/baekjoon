#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>

int compare(const int* num1, const int* num2) {
    return (*num1 - *num2);
}
// sides_len은 배열 sides의 길이입니다.
int solution(int sides[], size_t sides_len) {
    qsort(sides, 3, sizeof(int), compare);
    return (sides[2] < (sides[0] + sides[1])) ? 1 : 2;
}