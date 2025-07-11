class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        // if total available gas is less than total required gas
        if(sum(gas)<sum(cost)) return -1;

        int tank = 0;
        int start = 0;
        for(int i=0;i<gas.length;i++){
            tank+= gas[i]-cost[i];
            if(tank<0){
                tank = 0;
                start = i+1;
            }
        }
        return start;
    }
    public int sum(int[] arr){
        int s=0;
        for(int i=0;i<arr.length;i++){
            s+=arr[i];
        }
        return s;
    }
}