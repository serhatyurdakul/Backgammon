/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ClientFiles;

import javax.swing.*;
import java.lang.reflect.InvocationTargetException;

/**
 *
 * @author serhat
 */
public class Main {
    public static void main(String[] args) {
        try {
            SwingUtilities.invokeAndWait(() -> {
                GameWindow gameWindow = new GameWindow();
                gameWindow.setVisible(true);
            });
        } catch (InterruptedException | InvocationTargetException e) {
        }
    }
}
