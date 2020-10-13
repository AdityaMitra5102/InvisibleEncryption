package EncryptionDecryption;
import java.util.*;
import java.io.*;
class DecryptToFile
{
    void saveToFile(String s,String fileName)// to save it to file
    {
        try
        {
            PrintWriter outFile=new PrintWriter(new BufferedWriter(new FileWriter(fileName)));
            outFile.print(s);
            outFile.flush();
            outFile.close();
        }
        catch(Exception excep){}
    }
    void work()
    {
        Decrypt obj=new Decrypt();
        Scanner sc=new Scanner(System.in);
        System.out.println("Welcome");
        System.out.println("Initializing Database");
        obj.getDatabase();
        obj.load();
       
        System.out.println("Enter filename to decrypt without extension");
        String flname="C:/EncryptedFiles/"+sc.next()+".invisibleCipher";
        System.out.println("Reading File");
        String file=obj.readFile(flname);
        obj.load();
        System.out.println("Enter file name (with extension) to save it to");
        String fln="C:/NonEncryptedFiles/"+sc.next();
        System.out.println("Decrypting. Please wait");
        obj.load();
        saveToFile(obj.process(file),fln);
        System.out.println("Saving");
        obj.load();
        System.out.println("Done!");
    }
   
}