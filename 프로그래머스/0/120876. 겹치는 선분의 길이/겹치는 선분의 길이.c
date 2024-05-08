#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>

// lines_rows는 2차원 배열 lines의 행 길이, lines_cols는 2차원 배열 lines의 열 길이입니다.
int solution(int** lines, size_t lines_rows, size_t lines_cols) {
    int count[202] = {0};
    int idx = 0;
    for(int i = 0; i < lines_rows; i++) {
        for(int j = lines[i][0]; j < lines[i][1]; j++) {
            count[j + 100]++;
        }
    }
    
    int answer = 0;
    for(int i = 0; i < 202; i++) {
        if(count[i] > 1) answer++;
    }
    
    return answer;
}