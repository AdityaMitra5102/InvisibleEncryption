package EncryptionDecryption;
import javax.swing.*;
import java.awt.event.*;
public class DecryptGraphics implements ActionListener
{
    Decrypt obj=new Decrypt();
    JFrame fr=new JFrame("Decrypt");
    JLabel l1=new JLabel("Enter File name (without extension)");
    JTextField fln=new JTextField(30);
    JLabel l2=new JLabel("Message");
    JTextArea msg=new JTextArea(30,30);
    JProgressBar bar=new JProgressBar(0,50);
    JTextField status=new JTextField(30);
    JPanel pan=new JPanel();
    JButton command=new JButton("Decrypt");
    JButton svf=new JButton("Save To File");
    DecryptGraphics()
    {
        status.setEditable(false);	
        svf.setEnabled(false);
        svf.addActionListener(this);
        msg.setEditable(false);
        bar.setStringPainted(true);
        pan.add(l1);
        pan.add(fln);
        pan.add(l2);
        pan.add(new JScrollPane(msg));
        pan.add(command);
        pan.add(status);
        pan.add(bar);
        pan.add(svf);
        fr.setSize(350,700);
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
        if(e.getSource()==command)
        {
            status.setText("Decrypting");
            String file=obj.readFile("C:/EncryptedFiles/"+fln.getText().trim()+".invisibleCipher");
            String decoded=obj.process(file);
            msg.setText(decoded);
            status.setText("Done Decrypting.");
            bar.setValue(50);
            svf.setEnabled(true);
        }
        if(e.getSource()==svf)
        {
            new DecryptToFileGraphics(msg.getText());
        }
    }

}