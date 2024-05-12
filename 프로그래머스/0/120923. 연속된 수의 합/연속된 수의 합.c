#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>
#include <string.h>

int* solution(int num, int total) {
    // return 값은 malloc 등 동적 할당을 사용해주세요. 할당 길이는 상황에 맞게 변경해주세요.
    int* answer = (int*)malloc(sizeof(int) * 150); 
    int middle = 0;
    int st = 0;
    int idx = 0;
    
    if(num % 2 != 0) {
        st = (total / num) - (num / 2); 
    } else {
      st = (total / num) - (num / 2 - 1);  
    }

    for(int i = st; i < st + num; i++) {
            answer[idx++] = i;
        }
    return answer;
}