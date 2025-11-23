public class Board {

    private char[][] board = new char[3][3];   // Internal 3×3 character grid

    public Board() {
        clearBoard();
    }

    // Fills board with empty spaces
    public void clearBoard() {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                board[i][j] = ' ';
    }

    // Places a symbol if the cell is empty
    public boolean placeSymbol(int row, int col, char symbol) {
        if (board[row][col] != ' ')
            return false;

        board[row][col] = symbol;
        return true;
    }

    // Checks all rows, columns, and diagonals for a win
    public boolean checkWin(char symbol) {

        // Check rows and columns
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == symbol && board[i][1] == symbol && board[i][2] == symbol)
                return true;

            if (board[0][i] == symbol && board[1][i] == symbol && board[2][i] == symbol)
                return true;
        }

        // Check main diagonal
        if (board[0][0] == symbol && board[1][1] == symbol && board[2][2] == symbol)
            return true;

        // Check opposite diagonal
        if (board[0][2] == symbol && board[1][1] == symbol && board[2][0] == symbol)
            return true;

        return false;
    }

    // True if no empty cells remain
    public boolean isFull() {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                if (board[i][j] == ' ')
                    return false;
        return true;
    }

    // Used by the AI to scan available spaces
    public char[][] getBoard() {
        return board;
    }
}
