s=int(input())
def check_valid(n):
    if(n<1):
        return False
    while(n!=1):
        if(n%2!=0):
            return False
        n=n//2
    return True
print(check_valid(s))
