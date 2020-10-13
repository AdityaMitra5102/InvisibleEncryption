package EncryptionDecryption;
import java.util.*;
import java.io.*;
class Encrypt extends EncryptionLayers
{
    String database[]=new String [256]; //Using only ASCII (not UNICODE)
    
    Encrypt()
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

    String removeSpaces(String s) //remove spaces from the string
    {
        s=s.toUpperCase();
        String alpha="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String k="";
        for(int i=0;i<s.length();i++)
        {
            if(alpha.indexOf(s.charAt(i))>=0)
            {
                k+=s.charAt(i);

            }
            else
            {
                k+=(char)1;
            }
        }
        return k;
    }

    String makeSquare(String k)//Make the length of string a perfect square
    {
        while(Math.sqrt(k.length())%1!=0)
        {
            k+=" ";
        }
        return k;
    }

    String rotateClearText(String input)//rotate cleartext
    {
        input=makeSquare(input);
        int row=(int)Math.sqrt(input.length());
        int col=row;
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
                catch(Exception excep)
                {
                    arr[j][i]="";
                }
                counter+=1;

            }
        }

        String code="";
        for(int i=0;i<row;i++)
        {
            for(int j=0;j<col;j++)
            {
                code+=arr[i][j];

            }
        }
        //System.out.println(code);
        return code;
    }

    void showDatabase()// only to test
    {
        getDatabase();
        for(int i=0;i<database.length;i++)
        {
            //System.out.println(i+"==>"+database[i]);
            try
            {
                Thread.sleep(10);
            }catch(Exception excep){}
        }
    }

    String makeInvisible(String k)//replace characters by non graphic characters.
    {
        String s="";
        for(int i=0;i<k.length();i++)
        {
            String str;
            str=database[((int)k.charAt(i))];
            //System.out.println((int)str.charAt(0)+" "+(int)str.charAt(1));
            s+=str;
        }
        return s;
    }

    void saveToFile(String s,String fileName)// to save it to *.invisibleCipher file
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

    
    void load()//show animation
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

    String process(String msg)
    {

        for(int i=0;i<encryptionLayers;i++)
        {
            msg=makeInvisible(rotateClearText(msg));
        }
        return msg;
    }

    void work()
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Welcome");
        System.out.println("Initializing Database");
        getDatabase();
        load();
        System.out.println("Enter message");
        String msg=sc.nextLine();

        System.out.println("Enter filename without extension(Spaces not allowed)");
        String flname="C:/EncryptedFiles/"+sc.next()+".invisibleCipher";
        System.out.println("Encrypting. Please wait");
        saveToFile(process(msg),flname);
        load();
        System.out.println("Coded!");
    }   
}