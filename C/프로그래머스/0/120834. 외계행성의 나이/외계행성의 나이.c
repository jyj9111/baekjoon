#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>

char* solution(int age) {
    // return 값은 malloc 등 동적 할당을 사용해주세요. 할당 길이는 상황에 맞게 변경해주세요.
    char buffer[4];
    int count = 0;
    
    while(age > 0){
        buffer[count++] = age % 10 + 'a';
        age /= 10;
    }
    char temp[count];
    char* answer = (char*)malloc(sizeof(char) * (count + 1));
    for(int i = 0; i < count; i++) {
        answer[i] = buffer[count - 1 - i];
    }
    answer[count] = '\0';
    return answer;
}