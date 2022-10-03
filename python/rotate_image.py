#https://leetcode.com/problems/rotate-image/
#90deg rotate of an 2d array
def rotate(matrix): #takes 2d array as argument 
    for i in range(len(matrix)):   #first -> transpose the whole array
        for j in range(i,len(matrix)):
            matrix[i][j],matrix[j][i] = matrix[j][i],matrix[i][j]



    for i in range(len(matrix)): #second -> reverse each row inplace
        left = 0
        right = len(matrix) - 1
        while left < right:
            matrix[i][left],matrix[i][right] = matrix[i][right],matrix[i][left]
            left += 1
            right -= 1


mat = [
        [1,2,3],
        [4,5,6],
        [7,8,9]
      ]
rotate(mat)

print(mat)

# output: 
# [
#   [7,4,1],
#   [8,5,2],
#   [9,6,3]
# ]

#complexity 
#time complexity sure its o(n^2) 
#auxilary space is O(1) since its inplace operation
