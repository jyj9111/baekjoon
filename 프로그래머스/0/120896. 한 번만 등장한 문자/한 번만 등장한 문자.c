#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>

// 파라미터로 주어지는 문자열은 const로 주어집니다. 변경하려면 문자열을 복사해서 사용하세요.
char* solution(const char* s) {
    // return 값은 malloc 등 동적 할당을 사용해주세요. 할당 길이는 상황에 맞게 변경해주세요.
    char* answer = (char*)malloc(1001);
    int cnt[26] = {0};
    int idx = 0;
    
    while(s[idx] != NULL) {
        cnt[(s[idx++] - 97)]++;
    }
    
    idx = 0;
    for(int i = 0; i < 26; i++) {
        if(cnt[i] == 1) answer[idx++] = i + 97;
    }
    answer[idx] = '\0';
    return answer;
}