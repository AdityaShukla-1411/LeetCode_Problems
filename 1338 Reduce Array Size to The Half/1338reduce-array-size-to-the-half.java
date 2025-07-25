class Solution {
    public int minSetSize(int[] arr) {
        int n = arr.length;
        int[] freq = new int[100001];//10^5
        for(int f: arr){
            freq[f]++;
        }
        //count = [2,4,3,1]
        int index = 0;//3
        int[] count = new int[n];
        for(int f: freq){
            if(f>0){
                count[index++] = f;
            }
        }
        count = Arrays.copyOf(count,index);
        Arrays.sort(count);
        int r=0,c=0;
        for(int i=count.length-1;i>=0;i--){
            r = r+count[i];
            c++;
            if(r>=n/2) return c;
        }
        return -1;//this will never be reached
    }
}