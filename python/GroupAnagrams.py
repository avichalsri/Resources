# https://leetcode.com/problems/group-anagrams/ 
  
class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:

        hash_map = {}
        for word in strs:
            key = ''.join(sorted(word))
            hash_map[key] = hash_map.get(key, []) + [word]
            
        return hash_map.values()
