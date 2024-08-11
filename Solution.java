
public class Solution {

    private static final int[][] moves = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private int rows;
    private int columns;

    public int surfaceArea(int[][] matrix) {
        rows = matrix.length;
        columns = matrix[0].length;

        int surfaceArea = 0;
        for (int row = 0; row < rows; ++row) {
            for (int column = 0; column < columns; ++column) {
                surfaceArea += calculateCellSurfaceArea(row, column, matrix);
            }
        }
        return surfaceArea;
    }

    private int calculateCellSurfaceArea(int row, int column, int[][] matrix) {
        int cellSurfaceArea = 0;

        if (matrix[row][column] == 0) {
            return cellSurfaceArea;
        }

        cellSurfaceArea += 2;
        for (int[] move : moves) {
            int nextRow = row + move[0];
            int nextColumn = column + move[1];

            if (!isInMatrix(nextRow, nextColumn)) {
                cellSurfaceArea += matrix[row][column];
                continue;
            }
            if (matrix[row][column] > matrix[nextRow][nextColumn]) {
                cellSurfaceArea += matrix[row][column] - matrix[nextRow][nextColumn];
            }
        }
        return cellSurfaceArea;
    }

    private boolean isInMatrix(int row, int column) {
        return row >= 0 && row < rows && column >= 0 && column < columns;
    }
}
