class NeighborSum {
    private int[][]grid;
    private Map<Integer,int[]>pos;

    public NeighborSum(int[][] grid) {
        this.grid=grid;
        pos=new HashMap<>();
        int n=grid.length;
        for(int r=0;r<n;r++){
            for(int c=0;c<n;c++){
                pos.put(grid[r][c],new int[]{r,c});
            }
        }
    }
    
    public int adjacentSum(int value) {
       int[]p=pos.get(value);
       int r=p[0];
       int c=p[1];
       int n=grid.length;
       int sum=0;
       int[][]dir={{-1,0},{1,0},{0,-1},{0,1}};
       for(int[]d:dir){
        int nr=r+d[0];
        int nc=c+d[1];
        if(nr>=0 && nr<n && nc>=0 && nc<n){
            sum+=grid[nr][nc];
        }
       }
       return sum;
    }
    
    public int diagonalSum(int value) {
        int[]p=pos.get(value);
        int r=p[0];
        int c=p[1];
        int n=grid.length;
        int sum=0;
        int[][]dir={{-1,-1},{-1,1},{1,-1},{1,1}};
        for(int[]d:dir){
            int nr=r+d[0];
            int nc=c+d[1];
            if(nr>=0 && nr<n && nc>=0 && nc<n){
                sum+=grid[nr][nc];
            } 
        }
        return sum;
    }
}

/**
 * Your NeighborSum object will be instantiated and called as such:
 * NeighborSum obj = new NeighborSum(grid);
 * int param_1 = obj.adjacentSum(value);
 * int param_2 = obj.diagonalSum(value);
 */