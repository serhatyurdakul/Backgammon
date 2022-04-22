package ClientFiles;

import javax.swing.*;
import java.lang.reflect.InvocationTargetException;

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
