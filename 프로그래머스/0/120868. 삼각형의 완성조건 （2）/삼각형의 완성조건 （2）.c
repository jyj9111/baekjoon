#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>

int compare(const int* a , const int* b) {
    return *a - *b;
}
bool calc_Tryangle(int data[], int num) {
    int tmp[3] = {data[0], data[1], num};
    qsort(tmp, 3, sizeof(int), compare);
    return (tmp[2] < tmp[0] + tmp[1]) ? true : false;
} 
// sides_len은 배열 sides의 길이입니다.
int solution(int sides[], size_t sides_len) {
    int answer = 0;
    int num1 = sides[0] + sides[1];
    
    for(int i = 1; i < num1; i++) {
        if(calc_Tryangle(sides, i)) answer++;
    }
    return answer;
}