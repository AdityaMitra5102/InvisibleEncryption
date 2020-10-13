package EncryptionDecryption;
import java.awt.*;
import javax.swing.*;
class ChangeLayers
{
    void change(int n)
    {
        Encrypt obj=new Encrypt();
        obj.getDatabase();
        EncryptionLayers.encryptionLayers=2;
        obj.saveToFile(obj.process(Integer.toString(n)),"layers.system");
        FileAbsentGraphics ob=new FileAbsentGraphics();
        ob.ln.setIcon(new ImageIcon("success.png"));
        ob.lab.setText("Encryption layers changed successfully.");
        ob.lab2.setText("Restart this program for changes to take place");
    }
}