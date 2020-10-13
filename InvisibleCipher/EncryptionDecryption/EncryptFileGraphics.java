package EncryptionDecryption;
import java.io.*;
import java.awt.event.*;
import javax.swing.*;
class EncryptFileGraphics implements ActionListener
{
    JFrame fr=new JFrame();
    JTextField fln=new JTextField(30);
    JLabel lab=new JLabel("Enter File Name to encrypt(with Extension)");
    JPanel p=new JPanel();
    JButton con=new JButton("Continue");
    EncryptFileGraphics()
    {
        p.add(lab);
        p.add(fln);
        p.add(con);
        fr.setSize(400,200);
        fr.add(p);
        con.addActionListener(this);
        fr.setVisible(true);
        fr.setResizable(false);
    }

    public void actionPerformed(ActionEvent e)
    {
        String s=new EncryptFile().readFile("C:/NonEncryptedFiles/"+fln.getText());
        EncryptGraphics obj=new EncryptGraphics();
        obj.msg.setText(s);
        fr.setVisible(false);
    }

    
}
