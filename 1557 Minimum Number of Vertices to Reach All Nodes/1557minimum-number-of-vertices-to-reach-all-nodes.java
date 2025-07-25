class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        int e = edges.size();
        ArrayList<Integer> res = new ArrayList<>();
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }
        for(int i=0;i<e;i++){
            int s = edges.get(i).get(0);
            int d = edges.get(i).get(1);
            graph.get(d).add(s);
        }

        for(int i=0;i<n;i++){
            if(graph.get(i).size()==0){
                res.add(i);
            }
        }
        return res;
    }
}