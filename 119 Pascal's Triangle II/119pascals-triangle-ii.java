class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<>();
        res.add(1);
        long val = 1l;
        int mul = rowIndex;
        for(int i=1;i<=rowIndex;i++){
            val = (val*mul)/i;
            res.add((int)val);
            mul--;
        }
        return res;
    }
}