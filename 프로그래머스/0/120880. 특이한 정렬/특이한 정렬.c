#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>

int compare(const int* a, const int* b) {
    return *b - *a;
}
// numlist_len은 배열 numlist의 길이입니다.
int* solution(int numlist[], size_t numlist_len, int n) {
    // return 값은 malloc 등 동적 할당을 사용해주세요. 할당 길이는 상황에 맞게 변경해주세요.
    int* answer = (int*)malloc(sizeof(int) * numlist_len);
    int idx_answer = 0;
    
    int arr_tmp[12000][12000] = {{0,0}};
    int idx[12000] = {0};
    
    for(int i = 0; i < numlist_len; i++) {
        int num1 = abs(numlist[i] - n);
        arr_tmp[num1][idx[num1]++] = numlist[i];
    }
    
    for(int i = 0; i < 12000; i++) {
        if(idx[i] == 0) continue;
        qsort(arr_tmp[i], 12000, sizeof(int), compare);
        for(int j = 0; j < idx[i]; j++) {
            answer[idx_answer++] = arr_tmp[i][j];
        }
    }

    return answer;
}