//Problem staement
/*Write a code to find the number of prime numbers from 0 to given input range using sieve method */

#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <math.h>
int countprimes(int);

int main()
{
    int n;
    printf("enter number:");
    scanf("%d", &n);
    printf("number primes less then %d are: %d ", n,countprimes(n));
    return 0;
}

int countprimes(int n) {
    int count = 0;
    int *primes;
    primes = (int *)calloc(n,sizeof(int));
    for (int i = 2; i < n; i++) {
        if (primes[i] == 0) {
            count++;
            for (int j = i; j < n; j += i) {
                primes[j] = 1;
            }
        }
    }
    free(primes);
    return count;
}


//Output
/*
enter number: 100
number primes less than 100 are: 25
*/
