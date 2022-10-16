class Pair
{
    int first,second;
    Pair(int f,int s)
    {
        this.first=f;
        this.second=s;
    }
}
class Solution {
    // Function to find the number of islands.
    public int numIslands(char[][] grid) {
        // Code here
        int n=grid.length;
        int m=grid[0].length;
        int vis[][]=new int[n][m];
        int count=0;
        for(int row=0;row<n;row++)
        {
            for(int col=0;col<m;col++)
            {
                if(vis[row][col]==0 && grid[row][col]=='1')
                {
                    bfs(row,col,vis,grid);
                    count++;
                }
            }
        }
        return count;
    }
    public void bfs(int r,int c,int[][]vis,char[][]grid)
    {
        vis[r][c]=1;
        int n=grid.length;
        int m=grid[0].length;
        Queue<Pair>qu=new LinkedList<>();
        qu.add(new Pair(r,c));
        while(qu.size()>0)
        {
            int row=qu.peek().first;
            int col=qu.peek().second;
            qu.poll();
            for(int delrow=-1;delrow<=1;delrow++)
            {
                for(int delcol=-1;delcol<=1;delcol++)
                {
                    int nrow=row+delrow;
                    int ncol=col+delcol;
                    if((nrow>=0 &&nrow<n) &&(ncol>=0&&ncol<m) &&(vis[nrow][ncol]==0)
                            &&(grid[nrow][ncol]=='1'))
                    {
                        vis[nrow][ncol]=1;
                        qu.add(new Pair(nrow,ncol));            
                    }
                }
            }
        }
    }
}
