#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>

bool calcGradient(int x_1, int y_1, int x_2, int y_2, int x_3, int y_3, int x_4, int y_4) {
    double num1 = (double)(y_2 - y_1) / (x_2 - x_1);
    double num2 = (double)(y_4 - y_3) / (x_4 - x_3);
    
    if(num1 == num2) return true;
    
    return false;
}
// dots_rows는 2차원 배열 dots의 행 길이, dots_cols는 2차원 배열 dots의 열 길이입니다.
int solution(int** dots, size_t dots_rows, size_t dots_cols) {
    int pair_1 [3][2] = {{0, 1}, {0, 2}, {0, 3}};
    int pair_2 [3][2] = {{2, 3}, {1, 3}, {1, 2}};
    
    int num1 = 0;
    int num2 = 0;
    
    for(int i = 0; i < 3; i++) {
        
        if(calcGradient(dots[pair_1[i][0]][0], dots[pair_1[i][0]][1],
                       dots[pair_1[i][1]][0], dots[pair_1[i][1]][1],
                       dots[pair_2[i][0]][0], dots[pair_2[i][0]][1],
                       dots[pair_2[i][1]][0], dots[pair_2[i][1]][1]
                       )) {
            return 1;
        }
    }
    return 0;
}