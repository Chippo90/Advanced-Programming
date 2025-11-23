import javax.swing.*;
import java.awt.*;

public class GameGUI extends JFrame {

    private JButton[][] buttons = new JButton[3][3];   // 3×3 button grid
    private char playerSymbol;                         // Player's chosen symbol
    private char computerSymbol;                       // Computer auto picks another symbol
    private Board board;                               // Board logic object

    public GameGUI(char playerSymbol) {
        this.playerSymbol = playerSymbol;
        this.computerSymbol = chooseComputerSymbol(playerSymbol); // Select computer symbol
        this.board = new Board();

        // Window setup
        setTitle("Tic-Tac-Toe");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Grid layout for board
        setLayout(new GridLayout(3, 3));

        // Create UI buttons
        initBoard();

        setVisible(true);
    }

    // Create and place buttons on the board
    private void initBoard() {
        Font font = new Font("Arial", Font.BOLD, 40);  // Large symbol font

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {

                // Create a new button for each cell
                JButton btn = new JButton("");
                btn.setFont(font);

                int row = i, col = j; // Needed for lambda expression

                // Handle player's move when button is clicked
                btn.addActionListener(e -> playerMove(row, col));

                buttons[i][j] = btn;
                add(btn);
            }
        }
    }

    // Selects a computer symbol different from the player
    private char chooseComputerSymbol(char player) {
        char[] symbols = {'X','O','▲','■'};
        for (char c : symbols)
            if (c != player) return c;
        return 'O'; // fallback
    }

    // Called when the player clicks a cell
    private void playerMove(int row, int col) {
        // Place player's symbol if cell is empty
        if (board.placeSymbol(row, col, playerSymbol)) {

            // Update button text
            buttons[row][col].setText(String.valueOf(playerSymbol));
            buttons[row][col].setEnabled(false);

            // Check if player won
            if (checkEnd(playerSymbol, "You win!"))
                return;

            // Computer makes its move
            computerMove();
        }
    }

    // Computer makes a random move
    private void computerMove() {
        int[] move = ComputerAI.chooseRandomMove(board);
        int row = move[0];
        int col = move[1];

        // Update board and button
        board.placeSymbol(row, col, computerSymbol);
        buttons[row][col].setText(String.valueOf(computerSymbol));
        buttons[row][col].setEnabled(false);

        // Check if computer won
        checkEnd(computerSymbol, "Computer wins!");
    }

    // Check if someone won or board is full
    private boolean checkEnd(char symbol, String message) {
        if (board.checkWin(symbol)) {
            JOptionPane.showMessageDialog(this, message);
            System.exit(0);
            return true;
        }

        if (board.isFull()) {
            JOptionPane.showMessageDialog(this, "It's a draw!");
            System.exit(0);
            return true;
        }

        return false;
    }
}
