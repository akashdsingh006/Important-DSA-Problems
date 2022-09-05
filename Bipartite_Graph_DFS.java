class Solution {
    static boolean dfsCheck(ArrayList < ArrayList < Integer >> graph, int node, int color[]) {
      if(color[node]==-1)
            color[node]=1;
        for (Integer it: graph.get(node)) {
            if (color[it] == -1) {
                //Color of variable neighbor is the inverted color of variable node
                color[it] = 1 - color[node];

                if (!dfsCheck(graph, it, color))
                    return false;
            } else if (color[it] == color[node]) {
                return false;
            }
        }
        return true;
    }

    static boolean checkBipartite(ArrayList < ArrayList < Integer >> graph, int n) {
        int color[] = new int[n];

        for (int i = 0; i < n; i++) {
            color[i] = -1;
        }

        for (int i = 0; i < n; i++) {
            if (color[i] == -1) {
                if (!dfsCheck(graph, i, color)) {
                    return false;
                }
            }
        }
        return true;
    }
