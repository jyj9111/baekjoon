#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>
#include <string.h>

bool check_X(char* poly, int len) {
    return (poly[len - 1] == 'x') ? true : false;
}
// 파라미터로 주어지는 문자열은 const로 주어집니다. 변경하려면 문자열을 복사해서 사용하세요.
char* solution(const char* polynomial) {
    int value = 0;
    int cons = 0;
    char* crr = strtok(polynomial, " ");
    while(crr != NULL) {
        int len = (int)strlen(crr);
        char temp[3];
        
        if(check_X(crr, len)) {
            if(len == 1) {
                value++;
            } else {
                for(int i = 0; i < len - 1; i++) {
                    temp[i] = crr[i];
                }
                temp[len - 1] = '\0';
                value += atoi(temp);
            }
        } else {
            cons += atoi(crr);
        }
        
         crr = strtok(NULL, " ");
    }
    
    // return 값은 malloc 등 동적 할당을 사용해주세요. 할당 길이는 상황에 맞게 변경해주세요.
    char* answer = (char*)malloc(sizeof(char) * 12);
    
    int idx = 0;
    
    if(value != 0) {
        if(value != 1) {
            char tmp[5];
            sprintf(tmp, "%d", value);
            while(tmp[idx] != NULL) {
                answer[idx] = tmp[idx];
                idx++;
            }
        }
        answer[idx++] = 'x'; 
    }
    
    if(value != 0 && cons != 0) {
        answer[idx++] = ' ';
        answer[idx++] = '+';
        answer[idx++] = ' ';
    }
    
    if(cons != 0) {
        char tmp1[5];
        sprintf(tmp1, "%d", cons);
        int cnt = 0;
        while(tmp1[cnt] != NULL) {
            answer[idx++] = tmp1[cnt++];
        }
    }
    
    answer[idx] = '\0';
    return answer;
}