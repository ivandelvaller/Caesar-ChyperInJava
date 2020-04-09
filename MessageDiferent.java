import javax.swing.JOptionPane;

public class MessageDiferent {
    
    public void errorMessage(){
        JOptionPane.showMessageDialog( null, "Fatal error", "Error", JOptionPane.ERROR_MESSAGE );
    }
    
    public void invalidMessage(){
        JOptionPane.showMessageDialog( null, "Incorrect option", "Error", JOptionPane.ERROR_MESSAGE);
    }
    
    public void dontFoundFile(){
        JOptionPane.showMessageDialog(null, "Don't found file", "Error", JOptionPane.ERROR_MESSAGE);
    }
    
    public void errorToOpenFile(){
        JOptionPane.showMessageDialog(null, "Error to open file", "Error", JOptionPane.ERROR_MESSAGE);
    }
  
    public void erroToCodeMessage(){
         JOptionPane.showMessageDialog(null, "The code just can be short numbers [Until 99]", "Error", JOptionPane.ERROR_MESSAGE);
    }
    
    public void notEncrypted(){
        JOptionPane.showMessageDialog( null, "The message not is encrypted", "Error", JOptionPane.ERROR_MESSAGE);
    }
   
    
    public void alreadyEncrypted(){
        JOptionPane.showMessageDialog(null, "Already encrypted", "Information", JOptionPane.INFORMATION_MESSAGE);
    }
}
