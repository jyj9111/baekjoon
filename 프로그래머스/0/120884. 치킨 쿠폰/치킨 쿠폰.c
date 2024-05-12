#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>

int solution(int chicken) {
    int remain_coupon = 0;
    int service = 0;
    
    if(chicken == 0) return 0;
    
    int cnt = 0;
    while(chicken > 0) {
        cnt++;
        service += (chicken / 10);
        remain_coupon += (chicken % 10);
        chicken /= 10;  
    }
    int temp = remain_coupon / 10;
    if(temp != 0) {
        service += temp;
        remain_coupon %= 10;
        remain_coupon += temp;
        service += (remain_coupon / 10);
        return service;
    }
    return service;
}