# https://leetcode.com/problems/generate-parentheses/ 

class Solution:
    def generateParenthesis(self, n: int) -> List[str]:
        # base cond: add to res when no.of open parantheses = close paren
        # add open paren when it's count is less than n
        # add close paren when count of close paren < open paren
        
        res = []
        stack = []
        
        def backtrack(openN, closeN):
            if openN == closeN == n:
                res.append(''.join(stack))
                return
            
            if openN < n:
                stack.append('(')
                backtrack(openN+1, closeN)
                stack.pop()
                
            if closeN < openN:
                stack.append(')')
                backtrack(openN, closeN+1)
                stack.pop()
                
                
        backtrack(0, 0)
        return res
