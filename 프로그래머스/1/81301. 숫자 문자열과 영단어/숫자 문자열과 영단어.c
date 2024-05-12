#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>
#include <string.h>

// 파라미터로 주어지는 문자열은 const로 주어집니다. 변경하려면 문자열을 복사해서 사용하세요.
int solution(const char* s) {
    char buffer[51];
    int idx = 0;
    int s_len = strlen(s);
    
    for(int i = 0; i < s_len; ) {
        if(s[i] >= '0' && s[i] <= '9') {
            buffer[idx++] = s[i++];
            continue;
        }
        if(s[i] == 'z') {
            buffer[idx++] = '0';
            i += 4;
            continue;
        }
        if(s[i] == 'o') {
            buffer[idx++] = '1';
            i += 3;
            continue;
        }
        if(s[i] == 't' && s[i + 1] == 'w') {
            buffer[idx++] = '2';
            i += 3;
            continue;
        }
        if(s[i] == 't' && s[i + 1] == 'h') {
            buffer[idx++] = '3';
            i += 5;
            continue;
        }
        if(s[i] == 'f' && s[i + 1] == 'o') {
            buffer[idx++] = '4';
            i += 4;
            continue;
        }
        if(s[i] == 'f' && s[i + 1] == 'i') {
            buffer[idx++] = '5';
            i += 4;
            continue;
        }
        if(s[i] == 's' && s[i + 1] == 'i') {
            buffer[idx++] = '6';
            i += 3;
            continue;
        }
        if(s[i] == 's' && s[i + 1] == 'e') {
            buffer[idx++] = '7';
            i += 5;
            continue;
        }
        if(s[i] == 'e') {
            buffer[idx++] = '8';
            i += 5;
            continue;
        }
        if(s[i] == 'n') {
            buffer[idx++] = '9';
            i += 4;
            continue;
        }
    }
    buffer[idx] = '\0';
    
    return atoi(buffer);
}