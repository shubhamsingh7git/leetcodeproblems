class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int left=1;
        int right=0;
        for(int num:nums){
            right=Math.max(right,num);
        }
        while(left<right){
            int mid=left+(right-left)/2;
            if(can(nums,threshold,mid)){
                right=mid;
            }
            else{
                left=mid+1;
            }
        }
        return left;
    }
    private boolean can(int[] nums,int threshold,int d){
        int sum=0;
        for(int num:nums){
            sum+=(num+d-1)/d;
        }
        return sum<=threshold;
    }
}