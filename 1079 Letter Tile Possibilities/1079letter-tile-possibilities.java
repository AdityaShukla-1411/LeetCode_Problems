class Solution {
    
    public int numTilePossibilities(String tiles) {
        boolean[] used = new boolean[tiles.length()];
        StringBuilder curr = new StringBuilder();
        Set<String> res = new HashSet<>();
        seq(tiles,used,curr,res);
        return res.size()-1;
    }
    public void seq(String tiles, boolean[] used, StringBuilder curr, Set<String> res){
        //Goal state
        res.add(curr.toString());

        //Exploration state
        for(int i=0;i<tiles.length();i++){
            if(used[i]==false){
                //Action State
                curr.append(tiles.charAt(i));
                used[i] = true;
                //Recursive call
                seq(tiles, used, curr, res);
                //Backtracking or undo
                curr.deleteCharAt(curr.length()-1);
                used[i] = false;
            }
        }
    }
}