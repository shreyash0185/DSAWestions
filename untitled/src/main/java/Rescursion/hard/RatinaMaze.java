package Rescursion.hard;

public class RatinaMaze {

    public static void main(String[] args) {
        int[][] maze = {
            {1, 0, 0, 0},
            {1, 1, 0, 1},
            {0, 1, 0, 0},
            {1, 1, 1, 1}
        };
        int n = maze.length;
        int m = maze[0].length;
        boolean[][] visited = new boolean[n][m];
        String path = "";
        findPath(maze, 0, 0, visited, path);
    }

    public static void findPath(int[][] maze, int row, int col, boolean[][] visited, String path) {
        if (row == maze.length - 1 && col == maze[0].length - 1) {
            System.out.println(path);
            return;
        }

        if (isSafe(maze, row, col)) {
            visited[row][col] = true;

            // Move Down
            findPath(maze, row + 1, col, visited, path + "D");
            // Move Left
            findPath(maze, row, col - 1, visited, path + "L");
            // Move Right
            findPath(maze, row, col + 1, visited, path + "R");
            // Move Up
            findPath(maze, row - 1, col, visited, path + "U");

            visited[row][col] = false; // Backtrack
        }
    }

    public static boolean isSafe(int[][] maze, int row, int col) {
        return (row >= 0 && row < maze.length && col >= 0 && col < maze[0].length && maze[row][col] == 1);
    }
}
