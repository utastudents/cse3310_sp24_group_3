package uta.cse3310;

public class Message {
    private static Message head;
    private String user;  
    private String message;  
    private Message nextMessage;

    public Message(String user, String message) {
        this.user = user;
        this.message = message;
        this.nextMessage = null;
    }

    public static void addMessage(String user, String message) {
        Message newMessage = new Message(user, message);
        if (head == null) {
            head = newMessage;
        } else {
            Message temp = head;
            while (temp.nextMessage != null) {
                temp = temp.getNextMessage();
            }
            temp.nextMessage = newMessage;
        }
    }

    public static void removeMessage() {
        if (head != null) {
            head = head.getNextMessage();
        }
    }

    public static void sendMessages() {
        Message current = head;
        while (current != null) {
            System.out.println(current.getUser() + ": " + current.getMessage());
            current = current.getNextMessage();
        }
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
