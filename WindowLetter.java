import javax.swing.*;

public class WindowLetter extends JFrame {

    //Buttons
    JButton btnSaveMessage;
    JButton btnReadMessage;
    JButton btnClearMessage;
    JButton btnEncrypt;
    //JButton btnDescode;
    JButton btnExit;

    //TxtFields.
    JTextField txtFileSubject;
    JTextField txtSenderName;
    JTextField txtAddresseName;
    //JTextField txtCodeMessage;

    //Labels
    JLabel lbl1;
    JLabel lbl2;
    JLabel lbl3;
    JLabel lbl4;

    //MessageArea
    JTextArea txtMessageArea;
    JScrollPane scrollPane;

    public WindowLetter( String title, int x, int y, int width, int height){

        super(title);
        this.setBounds(x, y, width, height);
        this.getContentPane().setLayout(null);
        
        lbl2 = new JLabel("Subject: ");
        lbl2.setBounds(35, 10, 100, 25);
        
        lbl3 = new JLabel("Sender: ");
        lbl3.setBounds(35, 40, 100, 25);
        
        lbl4 = new JLabel("Addressee: ");
        lbl4.setBounds(35, 70, 100, 25);

        txtAddresseName = new JTextField();
        txtAddresseName.setBounds(120, 75, 200, 20);

        txtMessageArea = new JTextArea();
        scrollPane = new JScrollPane( txtMessageArea );
        scrollPane.setBounds(10, 100, 370, 200);

        txtSenderName = new JTextField();
        txtSenderName.setBounds(120, 40, 200, 20);

        txtFileSubject = new JTextField();
        txtFileSubject.setBounds(120, 10, 200, 20);  
        
        //Buttons.
        btnSaveMessage = new JButton("Save");
        btnSaveMessage.setBounds(50, 300, 80, 30);
        
        btnReadMessage = new JButton("Open");
        btnReadMessage.setBounds(150, 300, 80, 30);
        
        btnClearMessage = new JButton("Clear");
        btnClearMessage.setBounds(250, 300, 80, 30);
        
        btnEncrypt = new JButton("Encrypt");
        btnEncrypt.setBounds(50, 350, 80, 30);
        
        //btnDescode = new JButton("Descode");
        //btnDescode.setBounds( 150, 350, 80, 30);
        
        btnExit = new JButton("Exit");
        btnExit.setBounds(150, 350, 80, 30);

        ButtonLetter buttonLetter = new ButtonLetter(this);
        btnSaveMessage.addActionListener(buttonLetter);
        btnReadMessage.addActionListener(buttonLetter);
        btnClearMessage.addActionListener(buttonLetter);
        btnExit.addActionListener(buttonLetter);
        btnEncrypt.addActionListener(buttonLetter);
        //btnDescode.addActionListener(buttonLetter);

        this.getContentPane().add( btnSaveMessage );
        this.getContentPane().add( btnReadMessage);
        this.getContentPane().add( btnClearMessage );
        this.getContentPane().add( btnEncrypt );
        //this.getContentPane().add( btnDescode );
        this.getContentPane().add( btnExit );
        this.getContentPane().add( lbl2 );
        this.getContentPane().add( lbl3 );
        this.getContentPane().add( lbl4 );
        this.getContentPane().add( txtFileSubject );
        this.getContentPane().add( txtSenderName );
        this.getContentPane().add( txtAddresseName );
        this.getContentPane().add( scrollPane );
        this.setVisible(true);

    }


}
