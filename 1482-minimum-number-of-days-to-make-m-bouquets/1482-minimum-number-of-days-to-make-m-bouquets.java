class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int n=bloomDay.length;
        if((long) k*m>n) return -1;
        int left=Integer.MAX_VALUE;
        int right=0;
        for(int d:bloomDay){
            left=Math.min(left,d);
            right=Math.max(right,d);
        }
        while(left<right){
            int mid=left+(right-left)/2;
            if(canMake(bloomDay,m,k,mid)){
                right=mid;
            }
            else{
                left=mid+1;
            }
        }
        return left;
        
    }
    private boolean canMake(int[] bloomDay, int m, int k, int day){
        int bouquets=0;
        int flowers=0;
        for(int b:bloomDay){
            if(b<=day){
                flowers++;
                if(flowers==k){
                    bouquets++;
                    flowers=0;
                }
            }
            else{
                flowers=0;
            }
        }
        return bouquets>=m;
    }
}