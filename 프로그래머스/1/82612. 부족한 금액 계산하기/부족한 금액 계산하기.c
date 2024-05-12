#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>

long long solution(int price, int money, int count) {
    long long result = 0;
    for(int i = 1; i <= count; i++) {
        result += (i * price);
    }
    return (money >= result) ? 0 : (result - money);
}