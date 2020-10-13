package EncryptionDecryption;
import java.awt.event.*;
import javax.swing.*;
class Password implements ActionListener
{
    JFrame fr=new JFrame("LOGIN");
    JLabel l1=new JLabel("LOGIN:");
    JLabel lab=new JLabel("Enter Password To Login");
    JPasswordField psk=new JPasswordField(30);
    JPanel p=new JPanel();
    JButton b=new JButton("Login");
    Password()
    {
        psk.addActionListener(this);
        fr.setSize(400,200);
        p.add(l1);
        p.add(lab);
        p.add(psk);
        p.add(b);
        fr.add(p);
        fr.setVisible(true);
        fr.setResizable(false);
        b.addActionListener(this);
    }
    public void actionPerformed(ActionEvent e)
    {
        fr.setVisible(false);
        new Login().work(psk.getText());
    }
}