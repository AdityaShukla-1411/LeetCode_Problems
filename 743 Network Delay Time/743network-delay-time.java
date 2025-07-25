class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        int v = n;
        int e = times.length;

        ArrayList<ArrayList<Edge>> graph = new ArrayList<>();
        for(int i=0;i<v+1;i++){
            graph.add(new ArrayList<>());
        }

        for(int i=0;i<e;i++){
            int s = times[i][0];
            int d = times[i][1];
            int w = times[i][2];
             graph.get(s).add(new Edge(s,d,w));
        }
        int res = dijkstras(graph,v,e,k);
        return res;
    }

    public static int dijkstras(ArrayList<ArrayList<Edge>> graph, int v, int e, int k){
        int sum = 0;
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        int[] path = new int[v+1];
        boolean[] vis = new boolean[v+1];
        for(int i=1;i<v+1;i++){
            path[i] = Integer.MAX_VALUE;
        }
        path[k] = 0;
        pq.add(new Edge(k,k,0));
        while(!pq.isEmpty()){
            Edge E = pq.poll();
            if(vis[E.d]) continue;
            vis[E.d] = true;
            for(int i=0;i<graph.get(E.d).size();i++){
                int weight = E.w;
                Edge des = graph.get(E.d).get(i);
                if((weight+des.w)<path[des.d]){
                    path[des.d] = weight+des.w;
                    pq.add(new Edge(E.d, des.d, path[des.d]));;
                }

            }
        }
        for(int i=1;i<v+1;i++){
            //System.out.print(path[i]+" ");
            if(path[i]>sum)sum = path[i];
        }
        //System.out.println();
        if(sum==Integer.MAX_VALUE) return -1;
        return sum;
    }
}

class Edge implements Comparable<Edge>{
    int s,d,w;
    Edge(int s, int d, int w){
        this.s = s;
        this.d = d;
        this.w = w;
    }
    public int compareTo(Edge that){
        return this.w-that.w;
    }
}