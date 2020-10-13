package EncryptionDecryption;
class Main
{
    public static void main(String args[])
    {
        Folder obj=new Folder();
        obj.work("C:/NonEncryptedFiles/");
        obj.work("C:/EncryptedFiles/");
        new Password();
    }
}