from math import sqrt
def prime(n):
    for i in range(2,int(sqrt(n))+1):
        if n%i==0:
            return False
    return True
number=int(input())
print(prime(number))









        
