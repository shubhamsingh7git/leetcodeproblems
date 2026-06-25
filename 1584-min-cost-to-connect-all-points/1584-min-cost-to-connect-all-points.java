class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n=points.length;
        int[] minDist=new int[n];
        boolean[]visited=new boolean[n];
        Arrays.fill(minDist,Integer.MAX_VALUE);
        minDist[0]=0;
        int ans=0;
        for(int i=0;i<n;i++){
            int u=-1;
            for(int j=0;j<n;j++){
                if(!visited[j] && (u==-1 || minDist[j]<minDist[u])){
                    u=j;
                }
            }
            visited[u]=true;
            ans+=minDist[u];
            for(int v=0;v<n;v++){
                if(!visited[v]){
                    int dist=Math.abs(points[u][0]-points[v][0])+Math.abs(points[u][1]-points[v][1]);
                    minDist[v]=Math.min(minDist[v],dist);
                }
            }
        }
        return ans;
    }
}