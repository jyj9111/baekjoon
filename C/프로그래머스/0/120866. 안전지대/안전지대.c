#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>

int** buffer;
void findMines (int** board, int rows, int cols) {
    int n_x = 0;
    int n_y = 0;
    
    int dx[] = {-1, -1, -1, 0, 0, 1, 1, 1};
    int dy[] = {1, 0, -1, 1, -1, 1, 0, -1};
    
    for(int i = 0; i < rows; i++) {
        for(int j = 0; j < cols; j++) {
            if(board[i][j] == 1) {
                buffer[i][j] = 2;
                for(int k = 0; k < 8; k++) {
                    n_x = i + dy[k];
                    n_y = j + dx[k];
                    if(n_x < 0 || n_x >= cols || n_y < 0 || n_y >= rows)
                        continue;
                    buffer[n_x][n_y] = 2;
                }             
            }
        }   
    }
}

int countSafeZone(int** board, int rows, int cols) {
    int result = 0;
    for(int i = 0; i < rows; i++) {
        for(int j = 0; j < cols; j++) {
            if(buffer[i][j] == 0) {
                result++;
            }
        }   
    }
    return result;
}

// void printBoard(int** board, int rows, int cols) {
//     for(int i = 0; i < rows; i++) {
//         printf("[ ");
//         for(int j = 0; j < cols; j++) {
//             printf("%d ", board[i][j]);
//         }
//         printf("]\n");
//     }
// }
// board_rows는 2차원 배열 board의 행 길이, board_cols는 2차원 배열 board의 열 길이입니다.
int solution(int** board, size_t board_rows, size_t board_cols) {
    buffer = (int**)malloc(sizeof(int*) * board_rows);
    for(int i = 0; i < board_rows; i++) {
        buffer[i] = (int*)malloc(sizeof(int) * board_cols);
        memset(buffer[i], 0, sizeof(int) * board_cols);
    }
    
    findMines(board, board_rows, board_cols);
    // printBoard(board, board_rows, board_cols);
    // printf("\n");
    // printBoard(buffer, board_rows, board_cols);
    return countSafeZone(board, board_rows, board_cols);
}