
class Solution {

    private companion object {
        val moves = arrayOf<IntArray>(intArrayOf(-1, 0), intArrayOf(1, 0), intArrayOf(0, -1), intArrayOf(0, 1))
    }

    private var rows: Int = 0
    private var columns: Int = 0

    fun surfaceArea(matrix: Array<IntArray>): Int {
        rows = matrix.size
        columns = matrix[0].size

        var surfaceArea = 0
        for (row in 0..<rows) {
            for (column in 0..<columns) {
                surfaceArea += calculateCellSurfaceArea(row, column, matrix)
            }
        }
        return surfaceArea
    }

    private fun calculateCellSurfaceArea(row: Int, column: Int, matrix: Array<IntArray>): Int {
        var cellSurfaceArea = 0

        if (matrix[row][column] == 0) {
            return cellSurfaceArea
        }

        cellSurfaceArea += 2
        for (move in moves) {
            val nextRow = row + move[0]
            val nextColumn = column + move[1]

            if (!isInMatrix(nextRow, nextColumn)) {
                cellSurfaceArea += matrix[row][column]
                continue
            }
            if (matrix[row][column] > matrix[nextRow][nextColumn]) {
                cellSurfaceArea += matrix[row][column] - matrix[nextRow][nextColumn]
            }
        }
        return cellSurfaceArea
    }

    private fun isInMatrix(row: Int, column: Int): Boolean {
        return row in 0..<rows && column in 0..<columns
    }
}
