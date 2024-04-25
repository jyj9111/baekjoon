#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>

// 파라미터로 주어지는 문자열은 const로 주어집니다. 변경하려면 문자열을 복사해서 사용하세요.
char* solution(const char* my_string) {
    // return 값은 malloc 등 동적 할당을 사용해주세요. 할당 길이는 상황에 맞게 변경해주세요.
    char vowels[] = {'a', 'e', 'i', 'o', 'u'};
    
    int len = (int)strlen(my_string);
    char* answer = (char*)malloc(sizeof(char) * len);
    
    int idx = 0;
    bool is_Vowel = false;
    
    for(int i = 0; i < len; i++) {
        for(int j = 0; j < 5; j++) {
            if(my_string[i] == vowels[j]) is_Vowel = true;
        }
        
        if(!is_Vowel) {
            answer[idx++] = my_string[i];
        }
        is_Vowel = false;
    }
    answer[idx] = '\0';
    return answer;
}