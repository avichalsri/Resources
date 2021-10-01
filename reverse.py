def reverseDisplay(number,k):
    if number >0:
        i=(k)*10+number%10
        j = number//10
        return reverseDisplay(j,i)
    else:
        return k
def rev(n,r=0):
    if n==0:
        #print(n,r)
        return r//10
    else:
        return rev(n//10,(r+(n%10))*10)
        
print(rev(12345))
print(reverseDisplay(1234567,0))
