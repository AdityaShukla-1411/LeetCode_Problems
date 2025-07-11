class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int[] rmax = new int[n];
        int[] lmax = new int[n];
        int sum = 0,r=0,l=0;
        for(int i=0;i<n;i++){
            if(l<height[i]){
                l = height[i];
            }
            if(r<height[n-i-1]){
                r = height[n-i-1];
            }
            lmax[i] = l;
            rmax[n-i-1] = r;
        }

        for(int i=0;i<n;i++){
            sum+= Math.min(rmax[i],lmax[i])-height[i];
        }
        return sum;
    }
}