class Solution {
    public int countCompleteComponents(int n, int[][] edges) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }

        int e = edges.length;
        for(int i=0;i<e;i++){
            int s = edges[i][0];
            int d = edges[i][1];
            graph.get(s).add(d);
            graph.get(d).add(s);
        }
        int count = 0;
        boolean[] vis = new boolean[n];
        for(int i=0;i<n;i++){
            if(!vis[i]){
                dfs(graph,vis,i);
                if(check(graph)){
                    count++;
                }
                vertex.clear();
            }
        }
        return count;
    }
    ArrayList<Integer> vertex = new ArrayList<>();
    public void dfs(ArrayList<ArrayList<Integer>> graph, boolean[] vis, int s){
        vis[s] = true;
        vertex.add(s);
        for(int i=0;i<graph.get(s).size();i++){
            if(!vis[graph.get(s).get(i)]){
                dfs(graph, vis, graph.get(s).get(i));
            }
        }
    }
    public boolean check(ArrayList<ArrayList<Integer>> graph){
        int n = vertex.size()-1;
        for(int i=0;i<vertex.size();i++){
            if(graph.get(vertex.get(i)).size()!=n) return false;
        }
        return true;
    }
}