package EncryptionDecryption;
import java.awt.*;
import javax.swing.*;
class ChangePassword
{
    void change(String p1,String p2,String p3)
    {
        String pass=new Login().getPsk();
        if(!p1.equals(pass))
        {
            FileAbsentGraphics obj= new FileAbsentGraphics();
            obj.lab.setText("The Initial Password is Incorrect");
            return;
        }
        if(!p2.equals(p3))
        {
            FileAbsentGraphics obj= new FileAbsentGraphics();
            obj.lab.setText("Passwords do not match");
            return;
        }
        Encrypt obj=new Encrypt();
        obj.getDatabase();
        int bkp=EncryptionLayers.encryptionLayers;
        EncryptionLayers.encryptionLayers=2;
        obj.saveToFile(obj.process(p2),"credentials.system");
        FileAbsentGraphics ob=new FileAbsentGraphics();
        ob.ln.setIcon(new ImageIcon("success.png"));
        ob.lab.setText("Password changed successfully.");
        ob.lab2.setText("Restart this program for changes to take place");
    }
}