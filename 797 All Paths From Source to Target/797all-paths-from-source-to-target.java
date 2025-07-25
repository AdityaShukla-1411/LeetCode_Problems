class Solution {
    List<List<Integer>> res = new ArrayList<>();

    public void dfs(int[][] graph, int s, int t, List<Integer> temp){
        temp.add(s);
        if(s==t){
            res.add(new ArrayList<>(temp));
            temp.remove(temp.size()-1);
            return;
        }

        for(int i=0;i<graph[s].length;i++){
            dfs(graph,graph[s][i],t,temp);
        }
        temp.remove(temp.size()-1);
    }

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        int v = graph.length;
        List<Integer> temp = new ArrayList<>();
        dfs(graph,0,v-1,temp);

        return res;
    }
}