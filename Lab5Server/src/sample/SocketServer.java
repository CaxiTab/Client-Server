package sample;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
public class SocketServer implements Runnable {
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnStart;

    @FXML
    private AnchorPane serverPane;

    @FXML
    private Label lblMainMenu;

    @FXML
    private TextArea serverOperationsOutput;

    @FXML
    private TextArea connectionsArea;

    @FXML
    private Text connections;

    @FXML
    private Text textPort;

    int port = 8080;
    ServerSocket serverSocket = null;

    @FXML
    void initialize() {

        new Thread(new SocketServer()).start();
        onAction();

    }

    private void onAction() {


    }

    @Override
    public void run() {

        try {
            serverSocket = new ServerSocket(port);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        while(true) {
            try {
                Socket clientSocket = serverSocket.accept();
                new Thread(new CalculateRunnable(clientSocket)).start();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }


        }
    }
}
