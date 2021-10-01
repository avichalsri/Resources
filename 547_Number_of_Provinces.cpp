class Solution {
public:
    int findCircleNum(vector<vector<int>>& c) {
        int n=c.size(), ans=0;
        vector<bool> v(n, false);
        for(int i=0; i<n; i++) {
            if(!v[i]) {
                dfs(c, v, i);
                ans++;
            }
        }
        return ans;
    }
    
    void dfs(vector<vector<int>>& c, vector<bool>& v, int i) {
        v[i] = true;
        for(int j=0; j<c.size(); j++) {
            if(i != j && c[i][j] && !v[j]) {
                dfs(c, v, j);
            }
        }
    }
};
