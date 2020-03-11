import java.io.*;
import java.net.*;

public class InputStreamThread extends Thread{

    ObjectInputStream in = null;

    InputStreamThread(ObjectInputStream in){
        this.in = in;
    }
    public void run() {
        try{
            ChatProtocol cp = null;
            while(true) {
                cp = (ChatProtocol) in.readObject();
                System.out.println(cp);
            }
        } catch (ClassNotFoundException c) {
            System.out.println("Class not found");
            c.printStackTrace();
            return;
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
}
