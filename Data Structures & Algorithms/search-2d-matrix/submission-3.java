class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int ROWS = matrix.length;
        int COLS = matrix[0].length;

        int top = 0;
        int bot = ROWS - 1;
        while (top <= bot) {
            int row = (bot + top) / 2;
            if (target < matrix[row][0]) {
                bot = row - 1;  // top contains the lowest values
            } else if (target > matrix[row][COLS - 1]) {
                top = row + 1;  // bot contains the highest values
            } else {
                break; // target is in the row
            }
        }

        // top exceed bot: does not exist in all rows
        if (!(top <= bot)) return false;

        int row = (top + bot) / 2;
        int l = 0;
        int r = COLS - 1;
        while (l <= r) {
            int midRow = (l + r) / 2;
            if (target < matrix[row][midRow]) {
                r = midRow - 1;
            } else if (target > matrix[row][midRow]) {
                l = midRow + 1;
            } else {
                return true;
            }
        }
        return false;
    }
}
