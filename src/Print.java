import java.io.File;
import java.io.PrintWriter;

public class Print
{
    public static void main(String args[])  throws Exception
    {
    	generate("/users/zheng/downloads/project1-data/a.txt","adsvsad");

}
    public static void generate(String filepath,String content) throws Exception
    { 
    	File fp=new File(filepath);

    	PrintWriter pfp= new PrintWriter(fp);
      
       pfp.print(content);
       pfp.close();
    	
    }

}