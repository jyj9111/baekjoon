#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>
#include <string.h>

bool calc(char* sp, char* dc) {
    int len = (int)strlen(dc);
    for(int i = 0; i < len; i++) {
        if(dc[i] == sp[0]) return true;
    }
    return false;
}
// spell_len은 배열 spell의 길이입니다.
// dic_len은 배열 dic의 길이입니다.
// 파라미터로 주어지는 문자열은 const로 주어집니다. 변경하려면 문자열을 복사해서 사용하세요.
int solution(const char* spell[], size_t spell_len, const char* dic[], size_t dic_len) {
    int answer = 0;
    int cnt[11] = {0};

    for(int i = 0; i < spell_len; i++) {
        for(int j = 0; j < dic_len; j++) {
            if(calc(spell[i], dic[j])) cnt[j]++;
        }
    }
    
    for(int i = 0; i < 11; i++) {
        if(cnt[i] >= spell_len) return 1;
    }
    return 2;
}