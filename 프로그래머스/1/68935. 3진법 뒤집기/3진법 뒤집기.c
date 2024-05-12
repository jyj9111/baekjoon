#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>

int solution(int n) {
    int* arr = (int*)malloc(sizeof(int) * 3 * 100000000);
    int idx = 0;    
    while(n > 0) {
        arr[idx++] = n % 3;
        n /= 3;   
    }
    
    int answer = 0;
    int temp = 1;
    for(int i = idx - 1; i >= 0; i--) {
        answer += (temp * arr[i]);
        temp *= 3;
    }
    return answer;
}