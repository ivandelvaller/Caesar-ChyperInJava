import java.awt.event.*;
import java.io.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JPanel;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class ButtonLetter implements ActionListener {

    WindowLetter windowLetter;
    MessageDiferent messageDiferent;
    Letter letter = new Letter();
    
    boolean encryptIs = false;
    boolean descodeIs = false;
    
    public ButtonLetter( WindowLetter windowLetter ){
        this.windowLetter = windowLetter;
    }

    @Override
    public void actionPerformed( ActionEvent event ){

    if( event.getSource() == windowLetter.btnSaveMessage){          
        
        if( encryptIs == true ){
            int option = JOptionPane.showConfirmDialog(null, "Do you confirm that message is encrypted once?" );
            if( option == JOptionPane.YES_OPTION){
                JFileChooser fileChooser = new JFileChooser();
                FileNameExtensionFilter fileNameExtensionFilter = new FileNameExtensionFilter("Text File", "Txt");
                fileChooser.setFileFilter(fileNameExtensionFilter);   
                
                int answer = fileChooser.showSaveDialog(new JPanel());  
            
                    if (answer == JFileChooser.APPROVE_OPTION) {
                       try{
                           letter.setSubject(windowLetter.txtFileSubject.getText());
                           letter.setSender(windowLetter.txtSenderName.getText());
                           letter.setAddresse(windowLetter.txtAddresseName.getText());
                           letter.setMessage(windowLetter.txtMessageArea.getText());
                           
                            FileOutputStream fileOutputStream;
                            fileOutputStream = new FileOutputStream( fileChooser.getSelectedFile() );
                            ObjectOutputStream objectOutputStream;
                            objectOutputStream = new ObjectOutputStream( fileOutputStream );
                            objectOutputStream.writeObject( letter ); 
                        
                        }catch (Exception exception) {
                        }
                    }    
            }
        }else{        
            messageDiferent.notEncrypted();
        }    
            
    }
        
        if( event.getSource() == windowLetter.btnReadMessage ){
            JFileChooser fc = new JFileChooser();
            FileNameExtensionFilter filter = new FileNameExtensionFilter("Text File", "Txt");
            fc.setFileFilter(filter);
            File file = fc.getSelectedFile();
        
                int answer = fc.showOpenDialog(new JPanel());
                    if (answer == JFileChooser.APPROVE_OPTION) {
                        FileReader fr = null;
                        try {                   
                            FileInputStream fileInputStream = new FileInputStream( fc.getSelectedFile() );
                            ObjectInputStream objectInputStream; 
                            objectInputStream = new ObjectInputStream( fileInputStream );
                            Letter l = (Letter) objectInputStream.readObject();
                            windowLetter.txtMessageArea.setText( l.toString() ); 
                            objectInputStream.close();        
                            
                        }catch ( IOException | ClassNotFoundException exception) {
                            messageDiferent.errorMessage();
                        }                  
                    }               
        }

       if( event.getSource() == windowLetter.btnClearMessage ){
           int confirmClear = JOptionPane.showConfirmDialog(null, "All will be clean, do you want continue?", "Information", JOptionPane.INFORMATION_MESSAGE);
           
           if( confirmClear == JOptionPane.YES_OPTION){
                try{
                windowLetter.txtAddresseName.setText( "" );
                windowLetter.txtFileSubject.setText( "" );
                windowLetter.txtSenderName.setText( "" );
                windowLetter.txtMessageArea.setText( "" );
                encryptIs = false;
                }catch( Exception exception ){
                    messageDiferent.errorMessage();
                }
            }    
        }
        
        if( event.getSource() == windowLetter.btnEncrypt ){
            
            if(encryptIs == true ){
                messageDiferent.alreadyEncrypted();
            }else{    
                try{                           
                String messageE;
                char message[] = windowLetter.txtMessageArea.getText().toCharArray();
                    for( int i = 0; i < windowLetter.txtMessageArea.getText().length(); i++ ){
                        message[i] = (char)(message[i] - (char)3);
                    }                       
                messageE = String.valueOf(message);
                windowLetter.txtMessageArea.setText( messageE );      
                encryptIs = true;           
                }catch( Exception exception ){
                    messageDiferent.erroToCodeMessage();
                }
            }           
        }

        if( event.getSource() == windowLetter.btnExit ){
            int optionExit = JOptionPane.showConfirmDialog(null, "Do you want to close the application?", "Question", JOptionPane.INFORMATION_MESSAGE);
                if( optionExit == JOptionPane.YES_OPTION){
                    System.exit(0); 
                }
        }
        

    }
}

