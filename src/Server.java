import java.io.*;
import java.net.*;

public class Server {

    public static void main(String args[]) {
        new Server().openServer();
    }

    ServerSocket providerSocket;
    Socket connection = null;


    void openServer() {
        ObjectInputStream in = null;
        ChatProtocol e = null;
        ObjectOutputStream out = null;
        try {
            providerSocket = new ServerSocket(4321, 10);

            while (true) {
                connection = providerSocket.accept();
                in = new ObjectInputStream(connection.getInputStream());

                out = new ObjectOutputStream(connection.getOutputStream());

                InputStreamThread input = new InputStreamThread(in);
                OutputStreamThread output = new OutputStreamThread(out,"Xrisa");


                input.start();
                output.start();

                input.join();
                output.join();
            }

        } catch (IOException | InterruptedException ioException) {
            ioException.printStackTrace();
        }finally {
            try {
                providerSocket.close();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
    }


}