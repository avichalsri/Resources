# Example 1
# Enter elements in list in ascending order:[1,12,34,45,57,63,72,82,93,103,123,145,167,189,256,367]
# Original list is: [1, 12, 34, 45, 57, 63, 72, 82, 93, 103, 123, 145, 167, 189, 256, 367]
# Enter the element to be searched:12
# Element found at position: 2

# Example 2
# Enter elements in list in ascending order:[1,12,34,45,57,63,72,82,93,103,123,145,167,189,256,367]
# Original list is: [1, 12, 34, 45, 57, 63, 72, 82, 93, 103, 123, 145, 167, 189, 256, 367]
# Enter the element to be searched:14
# No such element:


def binary_search(l, d):
  low = 0
  high = len(l)
  while low < high:
     mid = (low+high)//2
     if d == l[mid]:
        return mid
     elif d < l[mid]:
       high = mid - 1
     else:
        low = mid + 1
        return -1
 
# main program 
l = eval(input("Enter elements in list in ascending order:"))
print("Original list is:",l) 
d = int(input("Enter the element to be searched:"))
s = binary_search(l,d)
if s>=0:  
   print("Element found at position:",s+1) 
else:     
 print("No such element:") 
 
