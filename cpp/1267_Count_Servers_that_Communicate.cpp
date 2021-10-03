class Solution {
public:
    int countServers(vector<vector<int>>& g) {
        int n=g.size(), m=g[0].size(), ans=0;
        vector<int> r(n), c(m);	
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(g[i][j]) {
                    r[i]++;
                    c[j]++;
                }
            }
        }
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(g[i][j] && (c[j]>1 || r[i]>1)) {
                    ans++;
                }
            }
        }
        return ans;
    }
};
