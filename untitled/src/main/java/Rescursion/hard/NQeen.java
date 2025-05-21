package Rescursion.hard;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class NQeen {

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        char[][] board= new char[n][n];

        // Initialize the board with '.'
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }

        backtrack( 0 , result , n , board);
        return result;
    }

    public void backtrack(int currRow , List<List<String>> result , int n , char[][] board ){

        //Base case
        if(currRow == n){
            result.add(constructBoard(board));
            return ;
        }

        for(int col = 0 ; col<n;col++ ){

            if(isSafe(currRow , col , board , n)){
                board[currRow][col] = 'Q';              // Place queen
                backtrack(currRow + 1, result, n,board); // Go to next row
                board[currRow][col] = '.';              // Backtrack
            }
        }


    }

    public boolean isSafe(int currRow , int col , char[][] board , int n ){

        int r = currRow ;
        int c = col;

        //top
        while(r>=0){
            if(board[r][c] == 'Q'){
                return false;
            }
            r--;
        }

        //right
        r = currRow;
        c = col;
        while(r >= 0 && c < n){
            //    while (r >= 0 && c < n) {
            if(board[r][c] == 'Q'){
                return false;
            }
            r--;
            c++;
        }

        //left
        r = currRow;
        c = col;
        while(r >= 0 && c >=0){
            if(board[r][c] == 'Q'){
                return false;
            }
            r--;
            c--;
        }


        return true;
    }

    private List<String> constructBoard(char[][] board) {
        List<String> layout = new ArrayList<>();
        for (char[] row : board) {
            layout.add(new String(row));
        }
        return layout;
    }
}
