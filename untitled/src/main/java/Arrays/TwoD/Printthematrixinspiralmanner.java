package Arrays.TwoD;

import java.util.ArrayList;
import java.util.List;

public class Printthematrixinspiralmanner {

    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;

        int n = matrix[0].length;

        List<Integer> list = new ArrayList<>();

        int top = 0, bottom = m - 1;
        int left = 0, right = n - 1;

        while(top <= bottom && left <= right){


            // Traverse from Left to Right
            for(int i=left ; i<= right ;i++){
                list.add(matrix[top][i]);

            }
            top++;

            // Traverse from Top to Bottom
            for(int i=top ;i<=bottom ;i++ ){
                list.add(matrix[i][right]);

            }
            right--;


            // Traverse from Right to Left
            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    list.add(matrix[bottom][i]);
                }
                bottom--;
            }

            // Traverse from Bottom to Top
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    list.add(matrix[i][left]);
                }
                left++;
            }
        }

        return list;

    }

}
