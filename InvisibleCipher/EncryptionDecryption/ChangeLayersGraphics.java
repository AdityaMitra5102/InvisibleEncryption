package EncryptionDecryption;
import java.awt.event.*;
import javax.swing.*;
class ChangeLayersGraphics implements ActionListener
{
    JFrame fr=new JFrame("Change Layers");
    JLabel l1=new JLabel("Change Layers");
    JLabel lab=new JLabel("Enter number of layers of encryption");
    JTextField lay=new JTextField(3);

    JPanel p=new JPanel();
    JButton b=new JButton("Proceed");
    ChangeLayersGraphics()
    {
        fr.setSize(400,200);
        p.add(l1);
        p.add(lab);
        p.add(lay);

        p.add(b);
        fr.add(p);
        fr.setVisible(true);
        fr.setResizable(false);
        b.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e)
    {
        fr.setVisible(false);
        new ChangeLayers().change(Integer.parseInt(lay.getText().trim()));
    }
}