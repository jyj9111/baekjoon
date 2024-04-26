#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>
#include <string.h>

int compare(const int* num1,  const int* num2) {
    return *num1 - *num2;
}
// 파라미터로 주어지는 문자열은 const로 주어집니다. 변경하려면 문자열을 복사해서 사용하세요.
char* solution(const char* my_string) {
    // return 값은 malloc 등 동적 할당을 사용해주세요. 할당 길이는 상황에 맞게 변경해주세요.
    int len = (int)strlen(my_string);
    char* answer = (char*)malloc(len + 2);
    int* tmp = (int*)malloc(sizeof(int) * len);
    
    for(int i = 0; i < len; i++) {
        if(my_string[i] >= 'A' && my_string[i] <= 'Z') {
            tmp[i] = my_string[i] + 32;
        }
        else tmp[i] = my_string[i];
    }
    qsort(tmp, len, sizeof(int), compare);
    for(int i = 0; i < len; i++) {
        answer[i] = tmp[i];
    }
    answer[len] = '\0';
    return answer;
}