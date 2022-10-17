class Solution
{
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor)
    {
        int[][] ans=image;
        int oldColor=image[sr][sc];
        int delRow[]={-1,0,1,0};
        int delCol[]={0,1,0,-1};
        dfs(sr,sc,image,ans,oldColor,newColor,delRow,delCol);
        return ans;
    }
    public void dfs(int sr,int sc,int[][]image,int[][]ans,int oldColor,int newColor,
                    int[]delRow,int[]delCol)
    {
        ans[sr][sc]=newColor;
        int n=image.length;
        int m=image[0].length;
        for(int i=0;i<4;i++)
        {
            int nrow=sr+delRow[i];
            int ncol=sc+delCol[i];
            if((nrow>=0&&nrow<n) &&(ncol>=0&&ncol<m)&&(image[nrow][ncol]==oldColor)
                &&(ans[nrow][ncol]!=newColor))
                {
                    dfs(nrow,ncol,image,ans,oldColor,newColor,delRow,delCol);
                }
        }
    }
}
