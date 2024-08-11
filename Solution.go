
package main

import "fmt"

var moves = [4][2]int{{-1, 0}, {1, 0}, {0, -1}, {0, 1}}
var rows int
var columns int

func surfaceArea(matrix [][]int) int {
    rows = len(matrix)
    columns = len(matrix[0])

    var surfaceArea = 0
    for row := 0; row < rows; row++ {
        for column := 0; column < columns; column++ {
            surfaceArea += calculateCellSurfaceArea(row, column, matrix)
        }
    }
    return surfaceArea
}

func calculateCellSurfaceArea(row int, column int, matrix [][]int) int {
    cellSurfaceArea := 0

    if matrix[row][column] == 0 {
        return cellSurfaceArea
    }

    cellSurfaceArea += 2
    for _, move := range moves {
        nextRow := row + move[0]
        nextColumn := column + move[1]

        if !isInMatrix(nextRow, nextColumn) {
            cellSurfaceArea += matrix[row][column]
            continue
        }
        if matrix[row][column] > matrix[nextRow][nextColumn] {
            cellSurfaceArea += matrix[row][column] - matrix[nextRow][nextColumn]
        }
    }
    return cellSurfaceArea
}

func isInMatrix(row int, column int) bool {
    return row >= 0 && row < rows && column >= 0 && column < columns
}
