package uta.cse3310;

public class Message {
    private static Message head;
    private String[] user;
    private String[] message;
    private Message nextMessage;
  

    public Message(String[] user, String[] message) { // Fix: Change the type of 'user' parameter from String to String[]
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
    public String nextMessage() {

        return null;
    }        
    // getters and setters for user, massage
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

    // Optionally, if needed, a getter for the nextMessage
    public Message getNextMessage() {
        return nextMessage;
    }
    
    // Static getter for the head of the list
    public static Message getHead() {
        return head;
    }
}
