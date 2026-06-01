class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        char[][] arr = new char[n][n];

        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                arr[i][j] = '.';
            }
        }
        int row = 0;
        nQueenSolver(arr, row, n, result);

        return result;

    }

    public void nQueenSolver(char[][] arr, int row, int n, List<List<String>> result) {
        if(row == n) {
            List<String> ans = new ArrayList<>();
            for(int i=0;i<n;i++) {
                ans.add(new String(arr[i]));
            }

            result.add(ans);
            return;
        }

        for(int i=0;i<n;i++) {
            if(isSafe(arr, row, i, n)) {
                arr[row][i] = 'Q';
                nQueenSolver(arr, row+1, n, result);
                arr[row][i] = '.';
            }
        }
    }

    public boolean isSafe(char[][] arr, int row, int col, int n) {
        for(int i=0;i<n;i++) {
            if(arr[row][i] == 'Q') {
                return false;
            }
        }

        for(int i=0;i<n;i++) {
            if(arr[i][col] == 'Q') {
                return false;
            }
        }

        for(int i=row, j=col; i>=0 && j>=0; i--, j--) {
            if(arr[i][j]=='Q') {
                return false;
            }
        }

        for(int i=row, j=col; i>=0 && j<n; i--, j++) {
            if(arr[i][j] == 'Q') {
                return false;
            }
        }

        return true;
    }
}
