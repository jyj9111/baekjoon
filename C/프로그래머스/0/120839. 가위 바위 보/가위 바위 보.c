#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>

// 파라미터로 주어지는 문자열은 const로 주어집니다. 변경하려면 문자열을 복사해서 사용하세요.
char* solution(const char* rsp) {
 // return 값은 malloc 등 동적 할당을 사용해주세요. 할당 길이는 상황에 맞게 변경해주세요.
    
    int len = (int )strlen(rsp);
    char* answer = (char*)malloc(len);
    
    int idx = 0;
    for (int i = 0; i < len; i++) {
        switch (rsp[i]) {
            case '0':
                answer[idx++] = '5';
                break;
            case '2':
                answer[idx++] = '0';
                break;
            case '5':
                answer[idx++] = '2';
                break;
        }
    }
    answer[idx] = '\0';
    return answer;
}