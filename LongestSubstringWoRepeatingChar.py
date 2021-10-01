# https://leetcode.com/problems/longest-substring-without-repeating-characters/ 

class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        #sliding window prblm
        window = set() 
        l, r = 0, 0 
        max_sub = 0
        while r < len(s):
            if s[r] not in window:
                window.add(s[r])
                max_sub = max(max_sub, len(window))
                r+=1
            else:
                window.remove(s[l])
                l+=1 
                
        return max_sub  
