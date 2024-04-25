#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>

// 파라미터로 주어지는 문자열은 const로 주어집니다. 변경하려면 문자열을 복사해서 사용하세요.
char* solution(const char* my_string) {
    // return 값은 malloc 등 동적 할당을 사용해주세요. 할당 길이는 상황에 맞게 변경해주세요.
    char* answer = (char*)malloc(sizeof(char) * 100);
    int idx = 1;
    int len = (int)strlen(my_string);
    bool is_Equal = false;
    
    answer[0] = my_string[0];
    for(int i = 1; i < len; i++) {
        is_Equal = false;
        for(int j = 0; j < idx; j++) {
            if(my_string[i] == answer[j]) {
                is_Equal = true;                
                break;
            }
        }
        if(!is_Equal) {
            answer[idx++] = my_string[i];
        }
    }
    answer[idx] = '\0';
    return answer;
}