class Solution {
    int open = 0;
    public void dfs(List<List<Integer>> rooms, int v, int s, boolean[] vis){
        vis[s] = true;
        open--; // 1 more door opened successfully
        for(int i=0;i<rooms.get(s).size();i++){
            if(!vis[rooms.get(s).get(i)]){
                dfs(rooms,v,rooms.get(s).get(i),vis);
            }
        }
    }
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        open = n;//need to open n number of doors
        boolean[] vis = new boolean[n];
        dfs(rooms,n,0,vis);

        if(open==0) return true;
        else return false;
    }
}