# Binary Search is a searching algorithm used in a sorted array by repeatedly dividing the search interval in half.
# The idea of binary search is to use the information that the array is sorted and reduce the time complexity to O(Log n).
# =======================================================================================
# NOTE : INDEX STARTS FROM 0
# Example 1
# Enter elements in list in ascending order:[1,12,34,45,57,63,72,82,93,103,123,145,167,189,256,367]
# Original list is: [1, 12, 34, 45, 57, 63, 72, 82, 93, 103, 123, 145, 167, 189, 256, 367]
# Enter the element to be searched:12
# low = 0 , high = 16
# In first iteration mid will become 8 i.e 93 , which is greater than the element we are searching , so high = mid - 1
# low = 0, high = 7
# In second iteration mid will become 3 i.e 45, which is greater than the element we are searching , so high = mid - 1
# low = 0, high = 2
# In third iteration mid will become 1 i.e 12 , which is equal to the element we are searching
# Element found at position: 1
#
#
# =======================================================================================
# Example 2
# Enter elements in list in ascending order:[1,12,34,45,57,63,72,82,93,103,123,145,167,189,256,367]
# Original list is: [1, 12, 34, 45, 57, 63, 72, 82, 93, 103, 123, 145, 167, 189, 256, 367]
# Enter the element to be searched:14
# low = 0, high = 16
# In first iteration mid will become 8 i.e 93 , which is greater than the element we are searching , so high = mid - 1
# low = 0, high = 7
# In second iteration mid will become 3 i.e 45, which is greater than the element we are searching , so high = mid - 1
# low = 0, high = 2
# In third iteration mid will become 1 i.e 12 , which is less than the element we are searching , so low = mid + 1
# low = 2, high = 2
# In fourth iteration low < high becomes false , ends the while loop
# No such element:


def bsort(list):
    for i in range(0, len(list)-1):
        for j in range(len(list)-1):
            if (list[j] > list[j+1]):
                temp = list[j]
                list[j] = list[j+1]
                list[j+1] = temp
    return list


def binary_search(l, d):
   low = 0
   high = len(l)
   while low <= high:
        mid = (low + high)//2

        if l[mid] == d:
            return mid

        elif l[mid] < d:
            low = mid + 1

        else:
            high = mid - 1

   return -1
   
# main program 
l = eval(input("Enter elements in list in ascending order:"))
print("Original list is:",l) 
l2 = bsort(l)
print("Sorted list is:",l2) 
d = int(input("Enter the element to be searched:"))
s = binary_search(l2,d)
if s != -1:  
   print("Element found at position:",s ) 
else:     
   print("No such element:") 
 


