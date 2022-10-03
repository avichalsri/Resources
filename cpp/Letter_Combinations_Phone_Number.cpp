// Letter Combinations of a Phone Number

// Given a string containing digits from 2-9 inclusive, return all possible letter 
// combinations that the number could represent. Return the answer in any order.

// A mapping of digits to letters (just like on the telephone buttons) is given below. 
// Note that 1 does not map to any letters.

// Example 1:

// Input: digits = "23"
// Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]

// Example 2:

// Input: digits = ""
// Output: []

// Example 3:

// Input: digits = "2"
// Output: ["a","b","c"]

// Constraints:

// 0 <= digits.length <= 4
// digits[i] is a digit in the range ['2', '9'].




class Solution {
    private:
    void solve(string output, string mapping[],int index,vector<string>& ans, string digits ){
        
        //base case
        if(index>= digits.length()){
            ans.push_back(output);
            return;
        }
        
        int number = digits[index]- '0';
        string value = mapping[number];
        
        for(int i=0; i<value.length(); i++){
            output.push_back(value[i]);
            solve(output,mapping,index+1,ans,digits);
            output.pop_back();
        }
        
        
    }
    
public:
    vector<string> letterCombinations(string digits) {
        vector<string> ans;
        if(digits.length()==0){
            return ans;
        }
        int index=0;
        string mapping[10]= {"","", "abc", "def", "ghi","jkl","mno","pqrs","tuv","wxyz"};
        string output= "";
        solve(output,mapping,index,ans,digits);
        return ans;
        
        
    }
};