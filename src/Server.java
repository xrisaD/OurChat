import java.io.*;
import java.net.*;

public class Server {

    public static void main(String args[]) {
        new Server().openServer();
    }

    ServerSocket providerSocket;
    Socket connection = null;

    //ObjectOutputStream out = null;

    void openServer() {
        ObjectInputStream in = null;
        ChatProtocol e = null;
        try {

            providerSocket = new ServerSocket(4321, 10);

            while (true) {
                connection = providerSocket.accept();
                in = new ObjectInputStream(connection.getInputStream());

                //out = new ObjectOutputStream(connection.getOutputStream());
                while(true) {
                    e = (ChatProtocol) in.readObject();
                    System.out.println(e);
                }
                //out.writeObject();
               // out.close();
            }

        } catch (IOException ioException) {
            ioException.printStackTrace();
        } catch (ClassNotFoundException c) {
            System.out.println("Employee class not found");
            c.printStackTrace();
            return;
        }finally {
            try {
                providerSocket.close();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
    }


}