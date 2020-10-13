package EncryptionDecryption;
import javax.swing.*;
import java.awt.event.*;
class MenuGraphics extends EncryptionLayers implements ActionListener
{
    JFrame fr=new JFrame("Menu");
    JLabel laylab=new JLabel("Current number of encryption layers ");
    JTextField la=new JTextField(3);
    
    JLabel lab=new JLabel("What do you want to do?");
    JButton b1=new JButton("Encrypt");
    JButton b2=new JButton("Decrypt");
    JButton b3=new JButton("Change Layers of Encryption");
    JLabel l1=new JLabel("Encrypted files will be saved to C:/EncryptedFiles/");
    JLabel l2=new JLabel("Encrypted files will be decrypted from C:/EncryptedFiles/");
    JLabel l3=new JLabel("Files will be encrypted from C:/NonEncryptedFiles/");
    JLabel l4=new JLabel("Files will be decrypted to C:/NonEncryptedFiles/");
    JPanel p=new JPanel();
    MenuGraphics()
    {
        getLayers();
        la.setEditable(false);
        la.setText(Integer.toString(encryptionLayers));
        p.add(laylab);
        p.add(la);
      
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        p.add(lab);
        p.add(b1);
        p.add(b2);
        p.add(b3);
        p.add(l1);
        p.add(l2);
        p.add(l3);
        p.add(l4);
        fr.setSize(400,240);
        fr.add(p);
        fr.setVisible(true);
        fr.setResizable(false);
    }
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==b1)
        {
            new EncryptMenuGraphics();
        }
        if(e.getSource()==b2)
        {
            new DecryptGraphics();
        }
        if(e.getSource()==b3)
        {
            new ChangeLayersGraphics();
        }
        fr.setVisible(false);
    }
  
}