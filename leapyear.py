a=int(input("Enter the year\n"))
if (a%400==0 or a%4==0 and a%100!=0):
    print("It is leap year")
else:
    print("It is not leap year")
    
