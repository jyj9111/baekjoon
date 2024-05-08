#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>

int solution(int a, int b) {
    int num = 2;
    while(num <= a) {
        if(a % num == 0 && b % num == 0) {
            a /= num;
            b /= num;
            continue;
        }
        num++;
    }
    while(1){
        if(b % 2 != 0) break;
        b /= 2;
    }
    while(1){
        if(b % 5 != 0) break;
        b /= 5;
    }
    return b == 1 ? 1 : 2;
}