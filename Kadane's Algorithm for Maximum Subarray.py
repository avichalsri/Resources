#  https://www.hackerrank.com/challenges/maxsubarray/problem

def maxSubarray(arr):
    max_so_far = max_ending_here = max_neg = -2**31
    c_sum = 0
   

    for i in range(len(arr)):
        max_ending_here = max(arr[i], max_ending_here + arr[i])        
        max_so_far = max(max_so_far, max_ending_here)

        if arr[i] > 0:
            c_sum += arr[i] 
        else:
            if arr[i] > max_neg:
                max_neg = arr[i]
    if c_sum == 0: 
        c_sum = max_neg
    return map(str, (max_so_far, c_sum))

test_cases = int(input())
for i in range(test_cases):
        n = int(input())
        array = [int(i) for i in input().split()]

        print (' '.join(maxSubarray(array)))
        
