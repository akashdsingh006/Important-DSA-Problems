class Solution{
    static void dfs(int row,int col,int[][]vis,char[][]mat,int[]delRow,int[]delCol)
    {
        vis[row][col]=1;
        int n=mat.length;
        int m=mat[0].length;
        for(int i=0;i<4;i++)
        {
            int nrow=row+delRow[i];
            int ncol=col+delCol[i];
            if(nrow>=0&&nrow<n && ncol>=0&&ncol<m && vis[nrow][ncol]==0 && 
                                                    mat[nrow][ncol]=='O')
            {
                dfs(nrow,ncol,vis,mat,delRow,delCol);
            }
        }
    }
    static char[][] fill(int n, int m, char mat[][])
    {
        // code here
        int delRow[]={-1,0,1,0};
        int delCol[]={0,1,0,-1};
        int vis[][]=new int[n][m];
        for(int i=0;i<m;i++)
        {
            if(vis[0][i]==0 && mat[0][i]=='O')
            {
                dfs(0,i,vis,mat,delRow,delCol);
            }
             if(vis[n-1][i]==0 && mat[n-1][i]=='O')
            {
                dfs(n-1,i,vis,mat,delRow,delCol);
            }
        }
        for(int i=0;i<n;i++)
        {
             if(vis[i][0]==0 && mat[i][0]=='O')
            {
                dfs(i,0,vis,mat,delRow,delCol);
            }
             if(vis[i][m-1]==0 && mat[i][m-1]=='O')
            {
                dfs(i,m-1,vis,mat,delRow,delCol);
            }
        }
        
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(vis[i][j]==0 && mat[i][j]=='O')
                {
                    mat[i][j]='X';
                }
            }
        }
        return mat;
    }
}
