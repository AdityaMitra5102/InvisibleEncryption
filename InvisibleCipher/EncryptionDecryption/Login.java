package EncryptionDecryption;
class Login
{
    void work(String psk)
    {
        if(getPsk().equals(psk))
        {
            new InitialMenuGraphics();
        }
        else
        {
            FileAbsentGraphics obj=new FileAbsentGraphics();
            obj.lab.setText("Error! Invalid Password.");
        }
    }
    
    String getPsk()
    {
        Decrypt obj=new Decrypt();
        obj.getDatabase();
        int bkp=EncryptionLayers.encryptionLayers;
        EncryptionLayers.encryptionLayers=2;

        String password=obj.process(obj.readFile("credentials.system"));
        EncryptionLayers.encryptionLayers=bkp;
        
        return password;
    }
}