/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ClientFiles;

import ClientDrawings.BoardDrawer;
import ClientDrawings.ImageService;
import GState.GameState;
import GState.StackColor;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 *
 * @author serhat
 */
public class BoardPanel extends JPanel{
    private ImageService imageService;
    private BoardDrawer boardDrawer;
    private GameState gameState;

    public BoardPanel(GameState gameState) {
        imageService = new ImageService();
        this.gameState = gameState;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D canvas = (Graphics2D) g;
        boardDrawer = new BoardDrawer(canvas, gameState,imageService);
        boardDrawer.drawBoard();
    }

    public void updateGameState(GameState gameState) {
        this.gameState = gameState;
        this.repaint();


        if (gameState.getWinner() == StackColor.WHITE) {
            JOptionPane.showMessageDialog(SwingUtilities.getWindowAncestor(this),
                    "Congratulations! White Wins!",
                     "Game Over!",
                    JOptionPane.PLAIN_MESSAGE);
            System.exit(0);
        }

        if (gameState.getWinner() == StackColor.BLACK) {
            JOptionPane.showMessageDialog(SwingUtilities.getWindowAncestor(this),
                    "Congratulations! Black Wins!",
                     "Game Over!",
                    JOptionPane.PLAIN_MESSAGE);
            System.exit(0);
        }
    }
}
