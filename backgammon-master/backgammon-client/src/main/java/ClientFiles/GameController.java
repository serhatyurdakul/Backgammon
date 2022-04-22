package ClientFiles;

import java.io.IOException;

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
