package Rescursion.hard;

public class WordSearch {

    public boolean exits(char[][] board, String word){
        int n = board.length;
        int m = board[0].length;
        boolean[][] visited = new boolean[n][m];
        for(int i=0;i<board.length;i++){
           for(int j=0;j<board[0].length;j++){
               if (findPath(board, i, j, visited, word, 0)) {
                   return true;
               }
           }
        }
        return false;
    }

    public boolean findPath(char[][] board, int row, int col, boolean[][] visited, String word, int index){
        //base case

        if(index == word.length()){
            return true;
        }

        if(!isSafe( board, row, col,  visited, word,  index)){
            return false;
        }

        visited[row][col] = true;

        boolean found = findPath(board, row+1,col,visited,word,index+1) ||
                findPath(board, row-1,col,visited,word,index+1) ||
                findPath(board, row,col+1,visited,word,index+1) ||
                findPath(board, row,col-1,visited,word,index+1);

        visited[row][col] = false; // Backtrack
        return found;
    }

    public boolean isSafe(char[][] board, int row, int col, boolean[][] visited, String word, int index){
        return (row >= 0 && row < board.length && col >= 0 && col < board[0].length &&
                !visited[row][col] && board[row][col] == word.charAt(index));
    }
}
