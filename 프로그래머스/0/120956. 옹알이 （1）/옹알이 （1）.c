#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>
#include <string.h>
bool checkWords(char* word) {
    char words[4][4] = {"aya", "ye", "woo", "ma"};
    bool mask[4] = {false};
    
    int w_len = strlen(word);
    
    for(int i = 0; i < 4; i++) 
    {
        if(strstr(word, words[i]) != NULL) 
            mask[i] = true;
    }
    
    int tmp = 0;
    if(mask[0]) tmp += 3;
    if(mask[1]) tmp += 2;
    if(mask[2]) tmp += 3;
    if(mask[3]) tmp += 2;
    
    return (tmp == w_len) ? true : false;
}

// babbling_len은 배열 babbling의 길이입니다.
// 파라미터로 주어지는 문자열은 const로 주어집니다. 변경하려면 문자열을 복사해서 사용하세요.
int solution(const char* babbling[], size_t babbling_len) {
    int answer = 0;
    for(int i = 0; i < babbling_len; i++)
    {
       if(checkWords(babbling[i])) answer++;
    }
    return answer;
}