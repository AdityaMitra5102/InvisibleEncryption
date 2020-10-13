package EncryptionDecryption;
class EncryptionLayers
{
    public static int encryptionLayers=0;
    void getLayers()
    {
        Decrypt obj=new Decrypt();
        obj.getDatabase();
        
        EncryptionLayers.encryptionLayers=2;

        encryptionLayers=Integer.parseInt(obj.process(obj.readFile("layers.system")));
        
        
            }
}  