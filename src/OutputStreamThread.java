import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class OutputStreamThread extends Thread {
    ObjectOutputStream out;
    Scanner sc;
    String senderName;
    public OutputStreamThread(ObjectOutputStream out , String senderName){
        this.out = out;
        this.sc = new Scanner(System.in);
        this.senderName = senderName;
    }
    @Override
    public void run(){
        try {
            while(true) {
                String line = sc.nextLine();
                
                if(line.equals("")){continue;}
                ChatProtocol message = new ChatProtocol();
                message.setMessage(line);
                message.setSender(senderName);
                out.writeObject(message);
                System.out.println(message);
            }
        }
        catch(IOException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}