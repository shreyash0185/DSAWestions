package Arrays.H;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        for (int i = 1; i <= numRows; i++) {
            List<Integer> row = generateRow(i);
            ans.add(row);
        }
        return ans;

    }

    public List<Integer> generateRow(int row) {
        int ans = 1;
        List<Integer> row1 = new ArrayList<>();
        row1.add(ans);
        for (int i = 1; i < row; i++) {
            ans = ans * (row - i);
            ans /= i;
            row1.add(ans);
        }
        return row1;
    }
}
