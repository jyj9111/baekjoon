#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>
#include <string.h>

// 파라미터로 주어지는 문자열은 const로 주어집니다. 변경하려면 문자열을 복사해서 사용하세요.
int solution(const char* my_string) {
    int answer = 0;
    bool op = false;

    char* crr = strtok(my_string, " ");
    while(crr != NULL) {
        if(strcmp(crr, "-") == 0) {
            op = true;
        } else if(strcmp(crr, "+") == 0) {
            op = false;
        } else {
            if(!op) answer += atoi(crr);
            else    answer -= atoi(crr);
        }
        crr = strtok(NULL, " ");
    }
    return answer;
}