package uta.cse3310;

public class Message {
    private static Message head;
    private String user;  
    private String message;  
    private Message nextMessage;

    public Message(String user, String message) { // Fix: Changed parameter types
        this.user = user;
        this.message = message;
        this.nextMessage = null;
    }

    public static void addMessage() {

    }

    public static void removeMessage() {

    }

    public static void sendMessages() {
    }

    public Message getNextMessage() {
        return nextMessage;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static Message getHead() {
        return head;
    }
}
