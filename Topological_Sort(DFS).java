class Solution
{
    //Function to return list containing vertices in Topological order. 
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) 
    {
        // add your code here
        Stack<Integer> st=new Stack<>();
        int vis[]=new int[V];
        for(int i=0;i<V;i++)
        {
            if(vis[i]==0)
            {
                topoDFS(i,adj,vis,st);
            }
        }
        int arr[]=new int[V];
        int idx=0;
        while(st.size()>0)
        {
            arr[idx++]=st.pop();
        }
        return arr;
    }
    static void topoDFS(int node,ArrayList<ArrayList<Integer>> adj,int[]vis,Stack<Integer> st)

    {
        vis[node]=1;
        for(int it:adj.get(node))
        {
            if(vis[it]==0)
            {
                topoDFS(it,adj,vis,st);
            }
        }
        st.push(node);
        return;
    }
}
