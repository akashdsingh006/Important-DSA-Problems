class Solution
{
    //Function to return list containing vertices in Topological order. 
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) 
    {
        // add your code here
        int topo[]=new int[V];
        int indegree[]=new int[V];
        for(int i=0;i<V;i++)
        {
            for(int it:adj.get(i))
            {
                indegree[it]++;
            }
        }
        Queue<Integer>qu=new LinkedList<>();
        for(int i=0;i<V;i++)
        {
            if(indegree[i]==0)
            {
                qu.add(i);
            }
        }
        int indx=0;
        while(qu.size()>0)
        {
            int node=qu.poll();
            topo[indx++]=node;
            for(int it:adj.get(node))
            {
                indegree[it]--;
                if(indegree[it]==0)
                {
                    qu.add(it);
                }
            }
        }
        return topo;
    }
   
}
