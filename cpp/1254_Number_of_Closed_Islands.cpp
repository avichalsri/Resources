class Solution {
public:
    bool t= true;
    int closedIsland(vector<vector<int>>& grid) {
        int n=grid.size(), m=grid[0].size();
        int c=0;
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(grid[i][j] == 0) {
                    t = true;
                    dfs(grid, i, j);
                    if(t) {
                        c++;
                    }
                }
            }
        }
        return c;
    }
    
    void dfs(vector<vector<int>>& g, int i, int j) {
        int n=g.size(), m=g[0].size();
        if(i<0 || i==n || j<0 || j ==m) {
            t = false;
            return;
        }
        if(g[i][j] == 1) {
            return;
        }
        g[i][j] = 1;
        dfs(g, i-1, j);
        dfs(g, i+1, j);
        dfs(g, i, j-1);
        dfs(g, i, j+1);
    }
};
