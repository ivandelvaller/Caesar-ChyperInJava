import java.io.Serializable;

public class Letter implements Serializable {

    //Variables declaration.
    private String subject;
    private String sender;
    private String addresse;
    private String message;
    
    private String messageD;
    
    String space = "                                                                                             ";
    
    //Constructor without parameters.
    public Letter(){
        
    }


    //Constructor with parameters.
    public Letter(String subject, String sender, String addresse, String message ){
        this.subject = subject;
        this.sender = sender;
        this.addresse = addresse;
        this.message = message;
    }

    //get and set methods.	
    public void setSubject ( String subject ){
        this.subject = subject;
    }

    public String getSubject(){
        return subject;
    }    

    public void setSender(String sender){
        this.sender = sender;
    }

    public String getSender(){
        return sender;
    }

    public void setAddresse( String addresse ){
        this.addresse = addresse;
    }

    public String getAddresse(){
        return addresse;
    }

    public void setMessage( String message ){
        this.message = message;
    }

    private String getMessage(){
        return message;
    }
    
    //Method to decode the message.
    public String descodeMessage(){
        char messageDescode[] = getMessage().toCharArray();
        for( int i = 0; i < getMessage().length(); i ++ ){
            messageDescode[i] = (char)(messageDescode[i] + (char)3);
        }
        messageD = String.valueOf(messageDescode);
        return messageD;     
    }
    
    @Override
    public String toString(){
        return String.format( "%s%s\n%s%s\n\n%s\n%s%s\n%s%s", "Subject: ", getSubject() ,"To: ", getAddresse(), descodeMessage(), space, "By: ", space, getSender() );
    }

}
