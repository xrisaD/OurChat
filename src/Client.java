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

            requestSocket = new Socket("192.168.1.13", 4321);
            System.out.println("Getting socket output stream");
            out = new ObjectOutputStream(requestSocket.getOutputStream());
            System.out.println("Getting socket input stream");
            in = new ObjectInputStream(requestSocket.getInputStream());
            System.out.println("Finished getting streams");
            System.out.println(requestSocket.isConnected());


            Thread output = new OutputStreamThread(out , "NickSm");
            Thread input = new InputStreamThread(in);
            //Starting threads
            output.start();
            input.start();

            output.join();
            input.join();

        } catch (UnknownHostException unknownHost) {
            System.err.println("You are trying to connect to an unknown host!");
        } catch (IOException ioException) {
            ioException.printStackTrace();
            System.out.println("IOEXCEPTION");
        }
        catch(InterruptedException e){
            System.out.println("Client Interrupted");

        }finally {
            try {
                in.close();//	out.close();
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
