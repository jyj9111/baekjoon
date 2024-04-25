#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>

// num_list_len은 배열 num_list의 길이입니다.
int** solution(int num_list[], size_t num_list_len, int n) {
    // return 값은 malloc 등 동적 할당을 사용해주세요. 할당 길이는 상황에 맞게 변경해주세요.
    int col = n; 
    int row = (int)num_list_len / n;
    int idx = 0;
    
    int** answer = (int**)malloc(sizeof(int*) * row);
    for (int i = 0; i < num_list_len / n; ++i) {
        answer[i] = (int*) malloc(sizeof(int) * col);
    }

    for (int i = 0; i < row; ++i) {
        for (int j = 0; j < col; ++j) {
            answer[i][j] = num_list[idx++];
        }
    }
    return answer;
}