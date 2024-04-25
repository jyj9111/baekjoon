#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>

// 파라미터로 주어지는 문자열은 const로 주어집니다. 변경하려면 문자열을 복사해서 사용하세요.
int solution(const char* s) {
    int answer = 0;
    int tmp = 0;
    int old = 0;
    
    char* crr_Num = strtok(s, " ");
    while(crr_Num != NULL) {
        if(strcmp(crr_Num, "Z") == 0) {
            answer -= old;
            crr_Num = strtok(NULL, " ");
            continue;
        }
        tmp = atoi(crr_Num);
        answer += tmp;
        old = tmp;    
        crr_Num = strtok(NULL, " ");
    }
    return answer;
}