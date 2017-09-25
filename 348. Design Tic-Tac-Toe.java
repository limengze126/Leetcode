class TicTacToe {

    /** Initialize your data structure here. */
    int[][] grid;
    int[] rowsum;
    int[] colsum;
    int diag;
    int anti_diag;
    int size;
    
    public TicTacToe(int n) {
        grid = new int[n][n];
        diag = 0; //用来记录正对角线的总和
        anti_diag = 0; //用来记录反对角线的总和
        size = n;
        rowsum = new int[size]; //用来记录某一行的总和
        colsum = new int[size]; // 用来记录某一列的总和
    }
    
    /** Player {player} makes a move at ({row}, {col}).
        @param row The row of the board.
        @param col The column of the board.
        @param player The player, can be either 1 or 2.
        @return The current winning condition, can be either:
                0: No one wins.
                1: Player 1 wins.
                2: Player 2 wins. */
    //如果是player1，就加－1；player2，就加1. 这样的话，如果总和是－3和3，就赢了
    public int move(int row, int col, int player) {
        int add = player == 1 ? -1 : 1;
        grid[row][col] = add;
        if (row == col) diag += add; //正对角线＋1或者－1
        if (col + row == size - 1) anti_diag += add;//反对角线＋1或者－1
        rowsum[row] += add;//所在行对角线＋1或者－1
        colsum[col] += add;//所在列对角线＋1或者－1
        //如果某行，某列，某对角线，所有的之和＝size或者－size（eg：1+1+1=3，－1+－1+－1=－3）就说明赢了
        if (Math.abs(rowsum[row]) == size || Math.abs(colsum[col]) == size || Math.abs(diag) == size || Math.abs(anti_diag) == size) {
            return player;
        }else return 0;
        
    }
}