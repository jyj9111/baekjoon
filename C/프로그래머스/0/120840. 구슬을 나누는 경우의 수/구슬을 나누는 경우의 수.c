#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>

int solution(int balls, int share) {
    long long tmp = 1;
    int answer = 0;
    for(int i = 0 ; i < share; i++)
    {
        tmp = tmp * (balls-i) / (i+1);
    }
    answer = (int)tmp;
    return answer;
}