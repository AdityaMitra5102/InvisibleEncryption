package EncryptionDecryption;
import java.util.*;
import java.io.*;
class EncryptFile
{
    String readFile(String flname)
    {
        String code="";
        try
        {
            //flname+=".invisibleCipher";

            BufferedReader br=new BufferedReader(new FileReader(flname));
            String text;
            while((text=br.readLine())!=null)
            {
                code+=text;
            }
        }catch(FileNotFoundException excep1)
        {
            new FileAbsentGraphics();
        }
        catch(Exception excep){}
        return code;
    }
    
    void work()
    {
        Encrypt obj=new Encrypt();
        Scanner sc=new Scanner(System.in);
        System.out.println("Welcome");
        System.out.println("Initializing Database");
        obj.getDatabase();
        obj.load();
        System.out.println("Enter File name to encrypt(text and binaries only) with extension.");
        String fln="C:/NonEncryptedFiles/"+sc.nextLine();
        System.out.println("Enter Output file name (Without Extension)");
        String flname=sc.next()+".invisibleCipher";
        System.out.println("Encrypting. Please wait");
        obj.saveToFile(obj.process(readFile(fln)),flname);
        obj.load();
        System.out.println("Coded!");
    }
  
}