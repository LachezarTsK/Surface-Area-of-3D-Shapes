
#include <span>
#include <array>
#include <vector>
using namespace std;

class Solution {

    static constexpr array<array<int, 2>, 4> moves{ { {-1, 0}, {1, 0}, {0, -1}, {0, 1} } };
    size_t rows{};
    size_t columns{};

public:
    int surfaceArea(const vector<vector<int>>& matrix) {
        rows = matrix.size();
        columns = matrix[0].size();

        int surfaceArea = 0;
        for (int row = 0; row < rows; ++row) {
            for (int column = 0; column < columns; ++column) {
                surfaceArea += calculateCellSurfaceArea(row, column, matrix);
            }
        }
        return surfaceArea;
    }

private:
    int calculateCellSurfaceArea(size_t row, size_t column, span<const vector<int>> matrix) const {
        int cellSurfaceArea = 0;

        if (matrix[row][column] == 0) {
            return cellSurfaceArea;
        }

        cellSurfaceArea += 2;
        for (const auto& move : moves) {
            size_t nextRow = row + move[0];
            size_t nextColumn = column + move[1];

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

    bool isInMatrix(size_t row, size_t column) const {
        return row < rows && column < columns;
    }
};
