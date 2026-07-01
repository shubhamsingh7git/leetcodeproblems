class Solution {

    int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};

    class DSU {
        int[] parent;
        int[] rank;

        DSU(int n) {
            parent = new int[n];
            rank = new int[n];

            for(int i=0;i<n;i++)
                parent[i]=i;
        }

        int find(int x){
            if(parent[x]!=x)
                parent[x]=find(parent[x]);
            return parent[x];
        }

        void union(int a,int b){
            int pa=find(a);
            int pb=find(b);

            if(pa==pb)
                return;

            if(rank[pa]<rank[pb])
                parent[pa]=pb;
            else if(rank[pb]<rank[pa])
                parent[pb]=pa;
            else{
                parent[pb]=pa;
                rank[pa]++;
            }
        }
    }

    public int maximumSafenessFactor(List<List<Integer>> grid) {

        int n=grid.size();

        int[][] dist=new int[n][n];

        for(int[] row:dist)
            Arrays.fill(row,-1);

        Queue<int[]> q=new LinkedList<>();

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(grid.get(i).get(j)==1){
                    dist[i][j]=0;
                    q.offer(new int[]{i,j});
                }
            }
        }

        while(!q.isEmpty()){

            int[] cur=q.poll();

            for(int[] d:dir){

                int x=cur[0]+d[0];
                int y=cur[1]+d[1];

                if(x<0||y<0||x>=n||y>=n)
                    continue;

                if(dist[x][y]!=-1)
                    continue;

                dist[x][y]=dist[cur[0]][cur[1]]+1;
                q.offer(new int[]{x,y});
            }
        }

        List<int[]> cells=new ArrayList<>();

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                cells.add(new int[]{dist[i][j],i,j});
            }
        }

        cells.sort((a,b)->b[0]-a[0]);

        DSU dsu=new DSU(n*n);

        boolean[][] active=new boolean[n][n];

        for(int[] cell:cells){

            int safe=cell[0];
            int r=cell[1];
            int c=cell[2];

            active[r][c]=true;

            int id=r*n+c;

            for(int[] d:dir){

                int nr=r+d[0];
                int nc=c+d[1];

                if(nr<0||nc<0||nr>=n||nc>=n)
                    continue;

                if(!active[nr][nc])
                    continue;

                dsu.union(id,nr*n+nc);
            }

            if(active[0][0] && active[n-1][n-1]
               && dsu.find(0)==dsu.find(n*n-1))
                return safe;
        }

        return 0;
    }
}