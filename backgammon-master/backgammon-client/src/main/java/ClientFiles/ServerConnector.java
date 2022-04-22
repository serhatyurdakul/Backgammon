/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ClientFiles;

import GState.GameState;
import javax.swing.*;
import java.io.*;
import java.net.Socket;
import java.util.Observable;

/**
 *
 * @author serhat
 */
public class ServerConnector extends Observable {
    private Socket socket;
    private Writer serverWriter;
    private ObjectInputStream ois;

    @Override
    public void notifyObservers(Object arg) {
        super.setChanged();
        super.notifyObservers(arg);
    }

    public void connect(String host, int port) {
        try {
            socket = new Socket(host, port);
            serverWriter = createServerWriter(socket);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Thread receivingThread = new Thread() {
            @Override
            public void run() {
                while (true) {
                    try {
                        ois = new ObjectInputStream(socket.getInputStream());
                        notifyObservers(ois.readObject());
                    } catch (IOException ex) {
                        notifyObservers(ex);
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        receivingThread.start();
    }

    public Socket getSocket() {
        return socket;
    }

    public void sendCommand(String command) {
        try {
            serverWriter.write(command);
            serverWriter.flush();
        } catch (IOException e) {

            throw new RuntimeException(e);
        }
    }

    public GameState receiveGameState() throws IOException, ClassNotFoundException {
        ois = new ObjectInputStream(socket.getInputStream());
        return (GameState) ois.readObject();
    }

    private OutputStreamWriter createServerWriter(Socket socket) {
        try {
            return new OutputStreamWriter(socket.getOutputStream());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
