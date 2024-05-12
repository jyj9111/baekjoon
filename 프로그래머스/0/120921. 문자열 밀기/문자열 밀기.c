#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>
#include <string.h>

void shiftSpell(char* word, int length) {
    char temp = word[length - 1];
    for(int i = length - 1; i > 0; i--) {
        word[i] = word[i - 1];
    }
    word[0] = temp;
}
// 파라미터로 주어지는 문자열은 const로 주어집니다. 변경하려면 문자열을 복사해서 사용하세요.
int solution(const char* A, const char* B) {
    int answer = 0;
    char* buffer[100];
    bool is_same = false;
    
    strcpy(buffer, A);
    int len = strlen(buffer);

    for(int i = 0; i < len; i++) {
        if(strcmp(buffer, B) == 0) {
            is_same = true;        
            break;  
        } 
        shiftSpell(buffer, len);
        answer++;
    }

    return is_same ? answer : -1;
}