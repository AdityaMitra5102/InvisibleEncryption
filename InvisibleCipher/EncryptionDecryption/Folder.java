package EncryptionDecryption;
import java.io.*;
public class Folder
{
    boolean doesFolderExist(String name)
    {
        File tmpDir=new File(name);
        return tmpDir.exists()&&tmpDir.isDirectory();
    }
    
    void createFolder(String name)
    {
        File tmpDir=new File(name);
        tmpDir.mkdir();
    }
    void work(String name)
    {
        if (!doesFolderExist(name))
        {
            createFolder(name);
        }
    }
}