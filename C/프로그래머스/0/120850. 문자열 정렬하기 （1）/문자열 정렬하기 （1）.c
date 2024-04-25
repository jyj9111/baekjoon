#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>

int compare(const int* a, const int* b) {
    return (*a - *b);
}
// 파라미터로 주어지는 문자열은 const로 주어집니다. 변경하려면 문자열을 복사해서 사용하세요.
int* solution(const char* my_string) {
    // return 값은 malloc 등 동적 할당을 사용해주세요. 할당 길이는 상황에 맞게 변경해주세요.
    int cnt = 0;
    int idx = 0;
    int len = (int)strlen(my_string);
    int nums[100] = {0};
    
    for(int i = 0; i < len; i++) {
        int tmp = my_string[i] - 48;
        if(tmp >= 0 && tmp <= 9) {
            nums[idx++] = tmp;
        }
    }
    int* answer = (int*)malloc(sizeof(int) * idx);
    memset(answer, 0, idx);
    
    qsort(nums, 100, sizeof(int), compare);
    for(int i = 0; i < idx; i++) {
        answer[i] = nums[100 - idx + i];
    }
    return answer;
}