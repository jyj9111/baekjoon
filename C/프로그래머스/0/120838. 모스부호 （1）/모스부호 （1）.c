#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>
#include <string.h>

// 파라미터로 주어지는 문자열은 const로 주어집니다. 변경하려면 문자열을 복사해서 사용하세요.
char* solution(const char* letter) {
    // return 값은 malloc 등 동적 할당을 사용해주세요. 할당 길이는 상황에 맞게 변경해주세요.
    char* morse[] = {
            ".-","-...","-.-.","-..",".","..-.",
            "--.","....","..",".---","-.-",".-..",
            "--","-.","---",".--.","--.-",".-.",
            "...","-","..-","...-",".--","-..-",
            "-.--","--.."
    };
    char* cmp_Morse[1000];

    char* answer = (char*)malloc(1000);
    bool is_Code = false;
    int t_idx = 0;
    int idx = 0;
    int l_len = strlen(letter);
    char tmp[5];

    for(int i = 0; i <= l_len; i++) {
        if(letter[i] == ' ' || letter[i] == '\0') {
            tmp[t_idx] = '\0';
            t_idx = 0;
            is_Code = true;
        } else {
            tmp[t_idx++] = letter[i];
        }

        if(is_Code) {
            is_Code = false;
            for (int j = 0; j < 26; j++) {
                if(strcmp(tmp, morse[j]) == 0) {
                    answer[idx++] = (char)(j + 97);
                }
            }
        }
    }
    answer[idx] = '\0';
    return answer;
}