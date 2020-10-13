
package EncryptionDecryption;
import javax.swing.*;
import java.awt.event.*;
public class EncryptGraphics implements ActionListener
{
    Encrypt obj=new Encrypt();
    JFrame fr=new JFrame("Encrypt");
    JLabel l1=new JLabel("Enter File name (without extension)");
    JTextField fln=new JTextField(30);
    JLabel l2=new JLabel("Enter message");
    JTextArea msg=new JTextArea(30,30);
    JProgressBar bar=new JProgressBar(0,50);
    JTextField status=new JTextField(30);
    JPanel pan=new JPanel();
    JButton command=new JButton("Encrypt");
    EncryptGraphics()
    {
        bar.setStringPainted(true);
        pan.add(l1);
        pan.add(fln);
        pan.add(l2);
        pan.add(new JScrollPane(msg));
        pan.add(command);
        pan.add(status);
        status.setEditable(false);
        pan.add(bar);
        fr.setSize(400,700);
        fr.add(pan);
        fr.setVisible(true);
        fr.setResizable(false);
        command.addActionListener(this);
        load("Starting up");
        obj.getDatabase();
        load("Initializing Database");
    }

    void load(String s)
    {
        status.setText(s);
        for(int i=0;i<=50;i++)
        {
            bar.setValue(i);
            try
            {
                Thread.sleep(10);
            }
            catch (Exception excep){}
        }
        try
        {
            Thread.sleep(50);
        }
        catch (Exception excep){}
        status.setText("");
        bar.setValue(0);
    }

    

    public void actionPerformed(ActionEvent e)
    {
        status.setText("Encrypting");
        obj.saveToFile(obj.process(msg.getText()),"C:/EncryptedFiles/"+fln.getText().trim()+".invisibleCipher");
        
        status.setText("Done Encrypting.");
        bar.setValue(50);
    }
    
}