#https://leetcode.com/problems/unique-paths/

def unique_paths(r:int,c:int) ->  int:
    dp = [ [0] * c ] * r  #short form creating 2d array

    for i in range(r):
        dp[i][0] = 1 #intializing first row elements to 1's

    for i in range(c):
        dp[0][i] = 1 #intializing first column elements to 1's

    for i in range(1,r):
        for j in range(1,c):
            dp[i][j] = dp[i-1][j] + dp[i][j-1] #number of paths at any position assuming it is the last position (a sub problem) is addition of top ways and left ways
            
    return dp[r-1][c-1]

print(unique_paths(r=3,c=7))
