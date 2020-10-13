package EncryptionDecryption;
import java.awt.event.*;
import javax.swing.*;
class ChangePasswordGraphics implements ActionListener
{
    JFrame fr=new JFrame("Change Password");
    JLabel l1=new JLabel("Change Password");
    JLabel lab1=new JLabel("Enter current password");
    JPasswordField psk1=new JPasswordField(30);
    JLabel lab2=new JLabel("Enter new password");
    JPasswordField psk2=new JPasswordField(30);
    JLabel lab3=new JLabel("Re-enter new password");
    JPasswordField psk3=new JPasswordField(30);

    JPanel p=new JPanel();
    JButton b=new JButton("Proceed");
    ChangePasswordGraphics()
    {
        fr.setSize(400,300);
        p.add(l1);
        p.add(lab1);
        p.add(psk1);
        p.add(lab2);
        p.add(psk2);
        p.add(lab3);
        p.add(psk3);

        p.add(b);
        fr.add(p);
        fr.setVisible(true);
        fr.setResizable(false);
        b.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e)
    {
        fr.setVisible(false);
        new ChangePassword().change(psk1.getText(),psk2.getText(),psk3.getText());
    }
}