package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;


public class Client implements Runnable {
    private String host = "127.0.0.1";
    private int port = 8080;
    private double firstOp;
    private double secondOp;
    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;
    private InputStreamReader ir;
    private BufferedReader stdIn;

    @FXML
    private AnchorPane clientPane;

    @FXML
    private Label lblMainMenu;

    @FXML
    private TextArea clientConsole;

    @FXML
    private Button btnConnect;

    @FXML
    private Button btnDisconnect;


    @FXML
    private TextField op1Field ;

    @FXML
    private TextField op2Field;

    @FXML
    private TextField operationField;


    @FXML
    private Text textOp1;

    @FXML
    private Text TextOp2;

    @FXML
    private Button btnSubmit;

    @FXML
    private Button btnEnter;



    @FXML
    void initialize() {
       // onAction();
        new Thread(new Client()).start();

    }

    private void onAction() {
        btnConnect.setOnAction((ActionEvent event) -> {
            clientConsole.appendText(
                    "Connected \n" +
                            "Port: " + port + "\n"+
                            "Host: " + host + "\n"
            );
        });
        btnDisconnect.setOnAction((ActionEvent event) -> {

        });
        btnEnter.setOnAction((ActionEvent a) -> {
            op1Field = new TextField();
            op2Field = new TextField();
            operationField = new TextField();
            firstOp = Double.parseDouble(op1Field.getText());
            secondOp = Double.parseDouble(op2Field.getText());
            out.println((op1Field.getText()));
            out.println((op2Field.getText()));
            out.println();
        });

        btnSubmit.setOnAction((ActionEvent event) -> {
            double[] op = {firstOp, secondOp};
        });
    }

    @Override
    public void run() {
        while (true) {
            try {
                System.out.println("Client program");
                clientSocket = new Socket(host, port);
                out = new PrintWriter(clientSocket.getOutputStream(), true);
                ir = new InputStreamReader(clientSocket.getInputStream());
                in = new BufferedReader(ir);

                stdIn = new BufferedReader(new InputStreamReader(System.in));

                out.println("Client");

                System.out.println("Enter operand 1");
                out.println(stdIn.readLine());

                System.out.println("Enter operand 2");
                out.println(stdIn.readLine());

                System.out.println("Enter operation");
                out.println(stdIn.readLine());

                System.out.println("Server says result is: " + in.readLine());

            } catch (UnknownHostException e) {
                System.exit(1);
            } catch (IOException e) {
                System.exit(1);
            }
        }
    }
}
