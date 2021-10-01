class Solution {
public:
    void rotate(vector<vector<int>>& matrix) {
        int s = matrix.size();
        int temp;

        for (int  i = 0; i < s; i++){
            for (int j = 0; j < i; j++){
                temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
             }       
        }
        
        for (int i = 0; i < s; i++)
            reverse(matrix[i].begin(), matrix[i].end());
        
    }
};
