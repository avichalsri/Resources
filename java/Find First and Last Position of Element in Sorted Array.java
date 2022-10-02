//Example 1
//Input: nums = [5,7,7,8,8,10], target = 8
//Output: [3,4]


//Example 2
// Input: nums = [5,7,7,8,8,10], target = 6
//Output: [-1,-1]

class Solution {
    public int leftocc(int[] nums,int target){
        int l=0;
        int r=nums.length-1;
        int ans=-1;
        while(l<=r){
            int mid=(l+r)/2;
            if(nums[mid]==target){
                ans=mid;
            r=mid-1;
            }
            else if(target>nums[mid])
                l=mid+1;
            else
                r=mid-1;
            
        }
        return ans;
    }
      public int rightocc(int[] nums,int target){
        int l=0;
        int r=nums.length-1;
        int ans=-1;
        while(l<=r){
            int mid=(l+r)/2;
            if(nums[mid]==target){
                ans=mid;
            l=mid+1;
            }
           else  if(target>nums[mid])
                l=mid+1;
            else
                r=mid-1;
            
        }
        return ans;
    }
    
    public int[] searchRange(int[] nums, int target) {
      
        int p=leftocc(nums,target);
        int q=rightocc(nums,target);
        int a[]={p,q};
        return a;
        
    }
}
