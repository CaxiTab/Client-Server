package sample;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class CalculateRunnable implements Runnable {
    protected Socket clientSocket;
    protected String arg1;
    protected String operand1;
    protected String operand2;
    protected String operation;
    private Calculate calculate;


    public CalculateRunnable(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }



    @Override
    public void run() {

        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            if (in.readLine().equals("Client")) {
                
                operand1 = in.readLine();
                operand2 = in.readLine();
                operation = in.readLine();

                double op1 = Double.parseDouble(operand1);
                double op2 = Double.parseDouble(operand2);

                this.calculate = new Calculate(op1,op2, operation);

            }

            out.println(calculate.operate());

//            System.out.println(arg1 + " connected");
//            out.println(calculate.operate());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
