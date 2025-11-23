import javax.swing.*;
import java.awt.*;

public class StartMenu extends JFrame {

    public StartMenu() {
        // Set window title and size
        setTitle("Choose Your Symbol");
        setSize(300, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Layout with 4 rows (one button per row)
        setLayout(new GridLayout(4, 1));

        // Buttons for the four symbol choices
        JButton xBtn = new JButton("X");
        JButton oBtn = new JButton("O");
        JButton triBtn = new JButton("▲");
        JButton sqBtn = new JButton("■");

        // Assign actions to buttons and start game with chosen symbol
        xBtn.addActionListener(e -> startGame('X'));
        oBtn.addActionListener(e -> startGame('O'));
        triBtn.addActionListener(e -> startGame('▲'));
        sqBtn.addActionListener(e -> startGame('■'));

        // Add buttons to window
        add(xBtn);
        add(oBtn);
        add(triBtn);
        add(sqBtn);

        // Make window visible
        setVisible(true);
    }

    // Starts the game with the chosen symbol and closes this menu
    private void startGame(char playerSymbol) {
        new GameGUI(playerSymbol);
        this.dispose();
    }
}
