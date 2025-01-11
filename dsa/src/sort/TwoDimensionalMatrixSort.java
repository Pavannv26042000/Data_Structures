package sort;

public class TwoDimensionalMatrixSort {
    
public static void main(String[] args) {

    int[][] matrix = {
        {1},  // First row
        {3}   // Second row
    };

    int target = 3;
    boolean result = binarySearch(0, target, matrix);  // Start at row 0
    System.out.println(result);  // Expected output: true
}
    public boolean searchMatrix(int[][] matrix, int target) {
        return binarySearch(0 , target , matrix);
    }

   public static boolean binarySearch(int i, int target, int[][] matrix) {

        if (i >= matrix.length) {
            return false;  // No more rows to search
        }


        int start = 0;
        int end = matrix[i].length - 1;

        // Binary search in the current row
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (matrix[i][mid] == target) {
                return true;  // Found the target
            } else if (matrix[i][mid] < target) {
                start = mid + 1;  // Move to the right side of the row
            } else {
                end = mid - 1;  // Move to the left side of the row
            }
        }

        // If target not found in current row, move to the next row
        return binarySearch(i + 1, target, matrix);
    }

}

