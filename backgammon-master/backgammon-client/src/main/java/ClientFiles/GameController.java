/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ClientFiles;

import java.io.IOException;

/**
 *
 * @author serhat
 */
public class GameController {
    private ServerConnector serverConnector;

    public GameController() {
        serverConnector = new ServerConnector();
        serverConnector.connect("127.0.0.1", 1342);
    }

    public ServerConnector getServerConnector() {
        return serverConnector;
    }
}
