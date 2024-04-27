#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>
#include <string.h>

// 파라미터로 주어지는 문자열은 const로 주어집니다. 변경하려면 문자열을 복사해서 사용하세요.
char* solution(const char* bin1, const char* bin2) {
    // return 값은 malloc 등 동적 할당을 사용해주세요. 할당 길이는 상황에 맞게 변경해주세요.
    char* answer = (char*)malloc(sizeof(char) * 15);
    
    int len1 = (int)strlen(bin1);
    int num1 = 0;
    for(int i = 0; i < len1; i++) {
        num1 = (num1 << 1) + bin1[i] - '0';
    }
    
    int len2 = (int)strlen(bin2);
    int num2 = 0;
    for(int i = 0; i < len2; i++) {
        num2 = (num2 << 1) + bin2[i] - '0';
    }
    num1 += num2;

    int idx = 0;
    char tmp[15];
    
    if(num1 == 0) return "0";
    while(num1 > 0) {
        if(num1 % 2 == 0) tmp[idx++] = '0';
        else tmp[idx++] = '1';
        num1 >>= 1;
    }
    
    for(int i = 0; i < idx; i++) {
        answer[i] = tmp[idx - i - 1];
    }
    answer[idx] = '\0';
    return answer;
}