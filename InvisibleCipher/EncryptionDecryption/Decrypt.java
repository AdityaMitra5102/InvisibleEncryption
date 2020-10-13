package EncryptionDecryption;
import java.io.*;
import java.util.*;
public class Decrypt extends EncryptionLayers
{
    String database[]=new String [256]; //Using only ASCII (not UNICODE)

    Decrypt()
    {
        //getLayers();
        for(int i=0;i<256;i++)
        {
            database[i]="Not assigned";
        }
    }

    void getDatabase() //Add nongraphic characters to database
    {
        int counter=0;
        outer:for(int i=124;i<157;i++)
        {
            for(int j=i;j<157;j++)
            {
                if(counter==256)
                {
                    break outer;
                }
                database[counter]=""+((char)i)+((char)j);
                counter+=1;

            }
        }
    }

    int search(String k)
    {
        for(int i=0;i<256;i++)
        {
            if(k.equals(database[i]))
            {
                return i;
            }
        }
        return -1;
    }

    String makeVisible(String s)
    {
        String k="";
        for(int i=0;i<s.length();i++)
        {
            try
            {
                String part=s.substring(i,i+2);
                //System.out.println((int)part.charAt(0)+" "+(int)part.charAt(1));
                k+=(char)(search(part));
                i+=1;
            }
            catch(Exception excep){}
        }
        // System.out.println(k);
        return k;
    }

    String makeLinear(String input)
    {
        int col=(int)Math.sqrt(input.length());
        int row=col;
        int counter=0;
        String arr[][]=new String[row][col];
        for(int i=0;i<col;i++)
        {
            for(int j=0;j<row;j++)
            {
                try
                {
                    arr[j][i]=""+input.charAt(counter);
                }
                catch(StringIndexOutOfBoundsException excep)
                {
                    arr[j][i]="";
                }
                counter+=1;

            }
        }
        String decr="";
        for(int i=0;i<row;i++)
        {
            for(int j=0;j<col;j++)
            {
                decr+=(arr[i][j]);
            }
        }
        return decr.trim();
    }

    int toDecimal(String bin)
    {
        return Integer.parseInt(bin,2);
    }

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
        }catch(FileNotFoundException excep)
        {
            new FileAbsentGraphics();

            // System.exit(0);
        }
        catch(Exception excep1){}
        return code;
    }

    void load()
    {
        for(int i=0;i<50;i++)
        {
            try 
            {
                System.out.print("=");
                Thread.sleep(10);
            }
            catch(Exception excep){}
        }
        System.out.println();
    } 

    String process(String s)
    {
        for(int i=0;i<encryptionLayers;i++)
        {
            s=makeLinear(makeVisible(s));
        }
        return s;
    }

    String Deprecate(String k)
    {
        return process(readFile(k));
    }

    void work()
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Welcome");
        System.out.println("Initializing Database");
        getDatabase();
        load();

        System.out.println("Enter filename without extension");
        String flname="C:/EncryptedFiles/"+sc.next()+".invisibleCipher";
        System.out.println("Decrypting. Please wait");

        //file=makeVisible(file);
        //System.out.println(file);
        //file=makeLinear(file);
        // System.out.println(len);
        String decoded=Deprecate(flname);
        load();
        System.out.println("Message:");
        System.out.println(decoded);
    }

}