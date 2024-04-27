#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>

// dots_rows는 2차원 배열 dots의 행 길이, dots_cols는 2차원 배열 dots의 열 길이입니다.
int solution(int** dots, size_t dots_rows, size_t dots_cols) {
    int answer = 0;
    int x1 = dots[0][0];
    int y1 = dots[0][1];
    int width = 0;
    int height = 0;
    for(int i = 1; i < dots_rows; i++) {
        // for(int j = 0; j < dots_cols; j++) {
            if(x1 == dots[i][0]) height = dots[i][1] - y1;
            if(y1 == dots[i][1]) width = dots[i][0] - x1;
        // }
    }
    answer = width * height;
    return answer > 0 ? answer : -answer ;
}