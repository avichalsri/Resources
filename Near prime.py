import math
def isPrime(num): 
    if(num==2 or num==3 or num==5 or num==7):	 
        prime=True 
    elif(num%2==0 or num%3==0 or num%5==0 or num%7==0): 
    	prime=False	 
    elif(math.ceil(math.sqrt(num))-math.floor(math.sqrt(num))==0): 
        prime=False 
    else:	 
        prime=True 
    return(prime)
n=int(input("Enter the number:")) 
for i in range(n,1,-1):
    #print(i)
    if(isPrime(i)): 
        pnear=i  
        break 
#snear=pnear+1  
for i in range(n,n+pnear): 
    if(isPrime(i)): 
        snear=i 
        break 
if((n-pnear)>(snear-n)): 
    print(snear) 
else: 
    print(pnear) 
