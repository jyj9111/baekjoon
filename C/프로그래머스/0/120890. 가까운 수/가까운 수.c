#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>

int compare(const int* num1, const int* num2) {
    return *num1 - *num2;
}

// array_len은 배열 array의 길이입니다.
int solution(int array[], size_t array_len, int n) {
    int idx = 0;
    
    qsort(array, array_len, sizeof(int), compare);
    
    for(int i = 0; i < array_len; i++) {
        if(n < array[i]) {
            idx = i;
            break;
        } else if( n == array[i]) {
            return array[i];
        }
    }
    
    if(idx == 0)
        return array[array_len - 1];
    if((n - array[idx - 1]) <= (array[idx] - n))
        return array[idx - 1];
    else
        return array[idx];
}