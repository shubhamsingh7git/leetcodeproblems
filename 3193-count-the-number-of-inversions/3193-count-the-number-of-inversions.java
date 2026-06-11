class Solution {
    private static final int MOD=1000000007;
    public int numberOfPermutations(int n, int[][] requirements) {
        int[]req=new int[n];
        Arrays.fill(req,-1);
        for(int[]r:requirements){
            req[r[0]]=r[1];
        }
        int maxInv=400;
        long[][] dp=new long[n+1][maxInv+1];
        dp[0][0]=1;
        for(int len=1;len<=n;len++){
            for(int inv=0;inv<=maxInv;inv++){
                long ways=0;
                for(int add=0;add<=Math.min(inv,len-1);add++){
                    ways+=dp[len-1][inv-add];
                }
                dp[len][inv]=ways%MOD;
            }
            int need=req[len-1];
            if(need!=-1){
                for(int inv=0;inv<=maxInv;inv++){
                    if(inv!=need){
                        dp[len][inv]=0;
                    }
                }
            }
        }
        long ans=0;
        for(int inv=0;inv<=maxInv;inv++){
            ans=(ans+dp[n][inv])%MOD;
        }
        return (int) ans;
    }
}