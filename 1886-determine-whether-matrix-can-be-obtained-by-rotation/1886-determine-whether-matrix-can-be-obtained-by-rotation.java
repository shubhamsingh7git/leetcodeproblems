class Solution {
    public boolean findRotation(int[][] mat, int[][] target) {
        for(int k = 0; k < 4; k++){
            if(equal(mat, target)) return true;
            rotate(mat);
        }
        return false;
    }

    private boolean equal(int[][] a, int[][] b){
        int n = a.length;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(a[i][j] != b[i][j]) return false;
            }
        }
        return true;
    }

    private void rotate(int[][] mat){
        int n = mat.length;
        for(int i = 0; i < n / 2; i++){
            for(int j = i; j < n - i - 1; j++){
                int temp = mat[i][j];
                mat[i][j] = mat[n - j - 1][i];
                mat[n - j - 1][i] = mat[n - i - 1][n - j - 1];
                mat[n - i - 1][n - j - 1] = mat[j][n - i - 1];
                mat[j][n - i - 1] = temp;
            }
        }
    }
}