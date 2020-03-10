import java.io.Serializable;

public class ChatProtocol implements Serializable {
    private String message;
    private String sender;

    public ChatProtocol(String message, String sender) {
        this.message = message;
        this.sender = sender;
    }
    public ChatProtocol() {
    }

    @Override
    public String toString() {
        return getSender() + " : " + getMessage() ;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }
}
