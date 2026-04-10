class Solution {
    public int minimumDistance(int[] nums) {
        int len=nums.length;
        int[]last=new int[len];
        int res=200;
        for(int i=0;i<len;i++){
            int val=nums[i]-1;
            int pos=i+1;
            int pack=last[val];
            int old=pack&255;
            int cur=pack>>8;
            last[val]=cur|(pos<<8);
            if(old>0){
                res=Math.min(res,(pos-old)<<1);
            }
            
        }
        return res==200?-1:res;
        
    }
}