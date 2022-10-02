link to question: [https://practice.geeksforgeeks.org/problems/dice-throw5349/1](https://practice.geeksforgeeks.org/problems/dice-throw5349/1)
                   
                   
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S[] = read.readLine().split(" ");
            
            int M = Integer.parseInt(S[0]);
            int N = Integer.parseInt(S[1]);
            int X = Integer.parseInt(S[2]);

            Solution ob = new Solution();
            System.out.println(ob.noOfWays(M,N,X));
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution {
    static long noOfWays(int M , int N , int X) {
        // code here
        long[][] dp = new long[N+1][X+1];
        for(int i=0;i<dp.length;i++)
            Arrays.fill(dp[i],-1);
        return func(M,N,X,dp);
    }
    static long func(int M , int N , int X,long[][] dp) {
        if(X<=0)
            return 0;
        if(N==1){
            if(X>M)
                return 0;
            return 1;
        }
        if(dp[N][X]!=-1)
            return dp[N][X];
        long sum=0;
        for(int i=1;i<=M;i++){
            sum+=func(M,N-1,X-i,dp);
        }
        dp[N][X]=sum;
        return sum;
    }
    
};                   
