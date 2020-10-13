package EncryptionDecryption;
import java.awt.event.*;
import javax.swing.*;
class FileAbsentGraphics extends EncryptionLayers implements ActionListener
{
    JFrame fr=new JFrame("Error");
    JLabel ln=new JLabel(new ImageIcon("Err.png"));
    JLabel lab=new JLabel ("Error 404: File not Found");
     JLabel lab2=new JLabel ("Program terminated");
    JButton n=new JButton("OK");
    JPanel p=new JPanel();
    FileAbsentGraphics()
    {
        n.addActionListener(this);
        p.add(ln);
        p.add(lab);
        p.add(lab2);
        p.add(n);
        fr.add(p);
        fr.setSize(400,180);
        fr.setVisible(true);
        fr.setResizable(false);
    }
    public void actionPerformed(ActionEvent e)
    {
        fr.setVisible(false);
        System.exit(0);
    }
} 