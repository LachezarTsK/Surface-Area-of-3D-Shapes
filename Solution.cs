
using System;

public class Solution
{
    private static readonly int[][] moves = {
        new int[]{ -1, 0 }, new int[]{ 1, 0 }, new int[]{ 0, -1 }, new int[]{ 0, 1 } };

    private int rows;
    private int columns;

    public int SurfaceArea(int[][] matrix)
    {
        rows = matrix.Length;
        columns = matrix[0].Length;

        int surfaceArea = 0;
        for (int row = 0; row < rows; ++row)
        {
            for (int column = 0; column < columns; ++column)
            {
                surfaceArea += CalculateCellSurfaceArea(row, column, matrix);
            }
        }
        return surfaceArea;
    }

    private int CalculateCellSurfaceArea(int row, int column, int[][] matrix)
    {
        int cellSurfaceArea = 0;

        if (matrix[row][column] == 0)
        {
            return cellSurfaceArea;
        }

        cellSurfaceArea += 2;
        foreach (int[] move in moves)
        {
            int nextRow = row + move[0];
            int nextColumn = column + move[1];

            if (!IsInMatrix(nextRow, nextColumn))
            {
                cellSurfaceArea += matrix[row][column];
                continue;
            }
            if (matrix[row][column] > matrix[nextRow][nextColumn])
            {
                cellSurfaceArea += matrix[row][column] - matrix[nextRow][nextColumn];
            }
        }
        return cellSurfaceArea;
    }

    bool IsInMatrix(int row, int column)
    {
        return row >= 0 && row < rows && column >= 0 && column < columns;
    }
}
