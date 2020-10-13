package EncryptionDecryption;
import javax.swing.*;
import java.awt.event.*;
class EncryptMenuGraphics implements ActionListener
{
    JFrame fr=new JFrame("Encrypt");
    JLabel lab=new JLabel("What do you want to encrypt?");
    JButton b1=new JButton("Encrypt Message");
    JButton b2=new JButton("Encrypt A Text File");
    JPanel p=new JPanel();
    EncryptMenuGraphics()
    {
        b1.addActionListener(this);
        b2.addActionListener(this);
        p.add(lab);
        p.add(b1);
        p.add(b2);
        fr.setSize(200,200);
        fr.add(p);
        fr.setVisible(true);
        fr.setResizable(false);
    }
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==b1)
        {
            new EncryptGraphics();
        }
        if(e.getSource()==b2)
        {
            new EncryptFileGraphics();
        }
        fr.setVisible(false);
    }
  
}