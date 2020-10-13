package EncryptionDecryption;
import javax.swing.*;
import java.awt.event.*;
class InitialMenuGraphics implements ActionListener
{
    JFrame fr=new JFrame("Menu");
    JLabel lab=new JLabel("What do you want to do?");
    JButton b1=new JButton("Encrypt Or Decrypt");
    JButton b2=new JButton("Change Password");
    JPanel p=new JPanel();
    InitialMenuGraphics()
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
            new MenuGraphics();
        }
        if(e.getSource()==b2)
        {
            new ChangePasswordGraphics();
        }
        fr.setVisible(false);
    }
  
}