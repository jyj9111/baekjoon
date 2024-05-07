#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>

bool checkThree(int num)
{
    char buff[5];
    sprintf(buff, "%d", num);
    for(int i = 0; i < 5; i++)
    {
        if(buff[i] == '3') return true;
    }
    return false;
}

int solution(int n) {
    int answer = 0;
    int num = 0;

    while(answer < n)
    {   
        num++;
        if(num % 3 == 0 || checkThree(num))
        {
            continue;  
        }
        answer++;
    }
    return num;
}