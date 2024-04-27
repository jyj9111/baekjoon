#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>
#include <string.h>

int compare_c(const char* a, const char* b) {
    return *a - *b;
}

// 파라미터로 주어지는 문자열은 const로 주어집니다. 변경하려면 문자열을 복사해서 사용하세요.
int solution(const char* before, const char* after) {
    int len = (int)strlen(before);
    
    char c_b[1000];
    char c_a[1000];
    strcpy(c_b, before);
    strcpy(c_a, after);

    qsort(c_b, len, sizeof(char), compare_c);
    qsort(c_a, len, sizeof(char), compare_c);
    
    return (strcmp(c_b, c_a) == 0) ? 1 : 0;
}