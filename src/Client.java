import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {
    public void run() {
        Socket requestSocket = null;
        ObjectOutputStream out = null;
        ObjectInputStream in = null;
        try {

            requestSocket = new Socket("172.16.2.62", 4321);
            System.out.println(requestSocket.isConnected());
            out = new ObjectOutputStream(requestSocket.getOutputStream());
            //in = new ObjectInputStream(requestSocket.getInputStream());

            Scanner sc = new Scanner(System.in);
            System.out.println("Before While true");
            while(true) {

                String line = sc.nextLine();
                ChatProtocol message = new ChatProtocol();
                message.setMessage(line);
                message.setSender("Nikolaos");
                System.out.println(message);
                out.writeObject(message);
            }

        } catch (UnknownHostException unknownHost) {
            System.err.println("You are trying to connect to an unknown host!");
        } catch (IOException ioException) {
            ioException.printStackTrace();
            System.out.println("IOEXCEPTION");
        } finally {
            try {
                in.close();	out.close();
                requestSocket.close();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
    }
    public static void main(String[] args){
        new Client().run();
    }

}
