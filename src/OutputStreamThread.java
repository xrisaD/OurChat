import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class OutputStreamThread extends Thread {
    ObjectOutputStream out;
    Scanner sc;
    public OutputStreamThread(ObjectOutputStream out){
        this.out = out;
        this.sc = new Scanner(System.in);
    }
    @Override
    public void run(){
        try {
            while(true) {
                String line = sc.nextLine();
                ChatProtocol message = new ChatProtocol();
                message.setMessage(line);
                message.setSender("Nikolaos");
                System.out.println(message);
                out.writeObject(message);
            }
        }
        catch(IOException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
