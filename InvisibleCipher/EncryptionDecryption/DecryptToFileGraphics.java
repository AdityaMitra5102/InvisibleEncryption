package EncryptionDecryption;
import java.io.*;
import java.awt.event.*;
import javax.swing.*;
class DecryptToFileGraphics implements ActionListener
{
    JFrame fr=new JFrame();
    JTextField fln=new JTextField(30);
    JLabel lab=new JLabel("Enter File Name to save to(with Extension)");
    JPanel p=new JPanel();
    JButton con=new JButton("Save");
    String msg="";
    DecryptToFileGraphics(String s)
    {
        fr.setResizable(false);
        msg=s;
        p.add(lab);
        p.add(fln);
        p.add(con);
        fr.setSize(400,200);
        fr.add(p);
        con.addActionListener(this);
        fr.setVisible(true);
    }

    public void actionPerformed(ActionEvent e)
    {
        new DecryptToFile().saveToFile(msg,"C:/NonEncryptedFiles/"+fln.getText().trim());
        fr.setVisible(false);
    }

}
