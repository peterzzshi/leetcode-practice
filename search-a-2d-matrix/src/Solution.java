class Solution {
    public boolean searchMatrix(final int[][] matrix, final int target) {

        final int m = matrix.length;
        final int n = matrix[0].length;

        int top = 0;
        int bottom = m - 1;
        while (top <= bottom) {
            final int mid = (top + bottom) / 2;
            if (matrix[mid][0] < target && matrix[mid][n - 1] > target) {
                break;
            } else if (matrix[mid][0] > target) {
                bottom = mid - 1;
            } else {
                top = mid + 1;
            }
        }

        int left = 0;
        int right = n - 1;

        final int row = (top + bottom) / 2;

        while (left <= right) {
            final int mid = (left + right) / 2;
            if (matrix[row][mid] > target) {
                right = mid - 1;
            } else if (matrix[row][mid] < target) {
                left = mid + 1;
            } else {
                return true;
            }
        }

        return false;
    }
}