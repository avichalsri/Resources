link to question [https://practice.geeksforgeeks.org/problems/box-stacking/1] (https://practice.geeksforgeeks.org/problems/box-stacking/1)
                  

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            String[] s1 = br.readLine().trim().split(" ");
            int[] height = new int[n];
            for(int i = 0; i < n; i++){
                height[i] = Integer.parseInt(s1[i]);
            }
            String[] s2 = br.readLine().trim().split(" ");
            int[] width = new int[n];
            for(int i = 0; i < n; i++){
                width[i] = Integer.parseInt(s2[i]);
            }
            String[] s3 = br.readLine().trim().split(" ");
            int[] length = new int[n];
            for(int i = 0; i < n; i++){
                length[i] = Integer.parseInt(s3[i]);
            }
            Solution obj = new Solution();
            System.out.println(obj.maxHeight(height, width, length, n));
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution
{
       static class Box {
        int length,width,height;
        
        // Box(int l, int w, int h) {
        //     length=l;
        //     width=w;
        //     height=h;
        // }
    }
    
    public static int maxHeight(int[] height, int[] width, int[] length, int n)
    {
        Box[] boxes = new Box[n*3];
        
        for(int i=0,itr=0;i<n;i++) {
            
            Box box1 = new Box();
            box1.height = length[i];
            box1.length = Math.max(width[i],height[i]);
            box1.width = Math.min(width[i],height[i]);
            boxes[itr++]  = box1;
            
            Box box2 = new Box();
            box2.height = width[i];
            box2.length = Math.max(length[i],height[i]);
            box2.width = Math.min(length[i],height[i]);
            boxes[itr++]  = box2;
            
            Box box3 = new Box();
            box3.height = height[i];
            box3.length = Math.max(length[i],width[i]);
            box3.width = Math.min(length[i],width[i]);
            boxes[itr++]  = box3;
            
        }
        
        
        n *= 3;
        
        Arrays.sort(boxes, (b1,b2) -> Integer.compare(b1.length*b1.width, b2.length*b2.width));
        
        
        int[] lis = new int[n];
        for(int i=0;i<n;i++) {
            lis[i] = boxes[i].height;
            
            for(int j=i-1;j>-1;j--) {
                
                if(boxes[j].length < boxes[i].length && boxes[j].width < boxes[i].width) {
                    lis[i] = Math.max(lis[i], lis[j]+boxes[i].height);
                }
                
            }
            
            
        }
        
        int ans = lis[0];
        for(int i=1;i<n;i++) {
            ans = Math.max(ans,lis[i]);
        }
        
        return ans;
        
    }
}                  
