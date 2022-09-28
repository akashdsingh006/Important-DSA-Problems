class Solution
{
    //Function to find number of strongly connected components in the graph.
    public int kosaraju(int v, ArrayList<ArrayList<Integer>> adj)
    {
        //code here
        int vis[]=new int[v];
        Stack<Integer>st=new Stack<>();
        for(int i=0;i<v;i++)
        {
            if(vis[i]==0)
            {
                dfs(i,adj,vis,st);
            }
        }
        ArrayList<ArrayList<Integer>>transpose=new ArrayList<>();
        for(int i=0;i<v;i++)
        {
            transpose.add(new ArrayList<>());
        }
        for(int i=0;i<v;i++)
        {
            vis[i]=0;
            for(int it:adj.get(i))
            {
                transpose.get(it).add(i);
            }
        }
        int c=0;
        while(st.size()>0)
        {
            int t=st.pop();
            if(vis[t]==0)
            {
                revDFS(t,vis,transpose);
                c++;
            }
        }
        return c;
    }
    public void dfs(int node,ArrayList<ArrayList<Integer>> adj,int[] vis,
                                                        Stack<Integer>st)
    {
        vis[node]=1;
        for(int it:adj.get(node))
        {
            if(vis[it]==0)
            {
                dfs(it,adj,vis,st);
            }
        }
        st.push(node);
    }
    public void revDFS(int node,int[]vis,ArrayList<ArrayList<Integer>> transpose)
    {
        vis[node]=1;
        for(int it:transpose.get(node))
        {
            if(vis[it]==0)
            {
                revDFS(it,vis,transpose);
            }
        }
    }
}
