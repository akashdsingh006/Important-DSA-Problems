class Solution
{
    public boolean isBipartite(int V, ArrayList<ArrayList<Integer>>adj)
    {
        // Code here
        int color[]=new int[V];
        for(int i=0;i<color.length;i++)
        {
            color[i]=-1;
        }
        for(int i=0;i<V;i++)
        {
            if(color[i]==-1)
            {
                if(!checkBFS(color,adj,i))
                    return false;
            }
        }
        return true;
    }
    public boolean checkBFS(int[] color,ArrayList<ArrayList<Integer>>adj,int node)
    {
        Queue<Integer> q=new LinkedList<>();
        q.add(node);
        color[node]=1;
        while(!q.isEmpty())
        {
            int nde=q.poll();
            for(Integer it:adj.get(nde))
            {
                if(color[it]==-1)
                {
                    color[it]=1-color[nde];
                    q.add(it);
                }
                if(color[it]==color[nde])
                {
                    return false;
                }
            }
        }
        return true;
    }
}
