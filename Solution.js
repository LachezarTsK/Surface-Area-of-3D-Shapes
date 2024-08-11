
/**
 * @param {number[][]} matrix
 * @return {number}
 */
var surfaceArea = function (matrix) {
    this.moves = [[-1, 0], [1, 0], [0, -1], [0, 1]];
    this.rows = matrix.length;
    this.columns = matrix[0].length;

    let surfaceArea = 0;
    for (let row = 0; row < this.rows; ++row) {
        for (let column = 0; column < this.columns; ++column) {
            surfaceArea += calculateCellSurfaceArea(row, column, matrix);
        }
    }
    return surfaceArea;
};

/**
 * @param {number} row
 * @param {number} column
 * @param {number[][]} matrix
 * @return {number}
 */
function calculateCellSurfaceArea(row, column, matrix) {
    let cellSurfaceArea = 0;

    if (matrix[row][column] === 0) {
        return cellSurfaceArea;
    }

    cellSurfaceArea += 2;
    for (let move of this.moves) {
        const nextRow = row + move[0];
        const nextColumn = column + move[1];

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

/**
 * @param {number} row
 * @param {number} column
 * @return {boolean}
 */
function isInMatrix(row, column) {
    return row >= 0 && row < this.rows && column >= 0 && column < this.columns;
}
