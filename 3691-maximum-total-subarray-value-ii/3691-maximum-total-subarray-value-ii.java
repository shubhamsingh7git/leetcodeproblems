class Solution {
        private int[][] mx;
        private int[][] mn;
        private int[] lg;
        public long maxTotalValue(int[] nums, int k) {
            int n=nums.length;
            int LOG=1;
            while((1<<LOG)<=n) LOG++;
            mx=new int[LOG][n];
            mn=new int[LOG][n];
            for(int i=0;i<n;i++){
                mx[0][i]=nums[i];
                mn[0][i]=nums[i];
            }
            for(int j=1;j<LOG;j++){
                for(int i=0;i+(1<<j)<=n;i++){
                    mx[j][i]=Math.max(mx[j-1][i],mx[j-1][i+(1<<(j-1))]);
                    mn[j][i]=Math.min(mn[j-1][i],mn[j-1][i+(1<<(j-1))]);
                }
            }
            lg=new int[n+1];
            for(int i=2;i<=n;i++){
                lg[i]=lg[i/2]+1;
            }
            PriorityQueue<long[]>pq=new PriorityQueue<>((a,b)->Long.compare(b[0],a[0]));
            for(int i=0;i<n;i++){
                pq.offer(new long[]{value(i,n-1),i,n-1});
            }
            long ans=0;
            while(k-->0){
                long[]cur=pq.poll();
                long val=cur[0];
                int l=(int)cur[1];
                int r=(int)cur[2];
                ans+=val;
                if(r>l){
                    pq.offer(new long[]{value(l,r-1),l,r-1});
                }
            }
            return ans;

                
            
        }
        private long value(int l,int r){
            int len=r-l+1;
            int p=lg[len];
            int maxVal=Math.max(mx[p][l],mx[p][r-(1<<p)+1]);
            int minVal=Math.min(mn[p][l],mn[p][r-(1<<p)+1]);
            return (long)maxVal-minVal;
        }
    }