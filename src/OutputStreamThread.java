import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class OutputStreamThread extends Thread {
    ObjectOutputStream out;
    Scanner sc;
    public OutputStreamThread(ObjectOutputStream out){
        System.out.print("xrisaki");
        this.out = out;
        this.sc = new Scanner(System.in);
    }
    @Override
    public void run(){
        System.out.println("xrisa");
        try {
            while(true) {

                String line = sc.nextLine();
                System.out.println(line);
                ChatProtocol message = new ChatProtocol();
                message.setMessage(line);
                System.out.println(line);
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
