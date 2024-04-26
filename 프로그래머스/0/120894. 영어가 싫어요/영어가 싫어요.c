#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>
#include <string.h>

// 파라미터로 주어지는 문자열은 const로 주어집니다. 변경하려면 문자열을 복사해서 사용하세요.
long long solution(const char* numbers) {
    long long answer = 0;
    int idx = 0;
    int len = (int)strlen(numbers);
    char* tmp = (char*)malloc(sizeof(char) * 51);
    
    for(int i = 0; i < len; i++) {
        switch(numbers[i]) {
            case 'o':
                tmp[idx++] = '1';
                i += 2;
                break;
            case 'e':
                tmp[idx++] = '8';
                i += 4;
                break;
            case 'n':
                tmp[idx++] = '9';
                i += 3;
                break;
            case 'z':
                tmp[idx++] = '0';
                i += 3;
                break;
            case 't':
                if(numbers[i + 1] == 'w') {
                    tmp[idx++] = '2';
                    i += 2;
                    break;
                } else {
                    tmp[idx++] = '3';
                    i += 4;
                    break;
                }
            case 'f' :
                if(numbers[i + 1] == 'o') {
                    tmp[idx++] = '4';
                    i += 3;
                    break;
                } else {
                    tmp[idx++] = '5';
                    i += 3;
                    break;
                }
            case 's' :
                if(numbers[i + 1] == 'i') {
                    tmp[idx++] = '6';
                    i += 2;
                    break;
                } else {
                    tmp[idx++] = '7';
                    i += 4;
                    break;
                }
        }
    }
    tmp[idx] = '\0';
    answer = atoll(tmp);
    return answer;
}