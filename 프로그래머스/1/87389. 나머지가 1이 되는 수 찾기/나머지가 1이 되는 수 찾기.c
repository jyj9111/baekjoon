#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>

int solution(int n) {
    int answer = 2;
    while(1) {
        if(n % answer++ == 1) return answer - 1;  
    }
}