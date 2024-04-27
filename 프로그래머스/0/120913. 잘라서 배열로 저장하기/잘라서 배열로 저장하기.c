#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>
#include <string.h>

// 파라미터로 주어지는 문자열은 const로 주어집니다. 변경하려면 문자열을 복사해서 사용하세요.
char** solution(const char* my_str, int n) {
    // return 값은 malloc 등 동적 할당을 사용해주세요. 할당 길이는 상황에 맞게 변경해주세요.
    int len = (int)strlen(my_str);
    int num1 = 0;
    int idx = 0;
    bool is_Remain = false;
    int remain = 0;
    
    if(len % n == 0) {
        num1 = len / n;
        is_Remain = false;
    }
    else {
        num1 = len / n + 1;
        is_Remain = true;
        remain = len % n;
    }

    char** answer = (char**)malloc(sizeof(char*) * num1);
    for(int i = 0; i < num1; i++) {
        answer[i] = (char*)malloc(sizeof(char) * n + 1);
    }

    for(int i = 0; i < num1; i++) {
        if(is_Remain && i == (num1 - 1)) {
            for(int j = 0; j < remain; j++) {
                answer[i][j] = my_str[idx++];
            }
            answer[i][remain] = '\0';
            continue;
        }
        for(int j = 0; j < n; j++) {
            answer[i][j] = my_str[idx++];
        }
        answer[i][n] = '\0';
    }
    return answer;
}