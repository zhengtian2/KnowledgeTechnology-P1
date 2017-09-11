import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;


public class test {

	public static void main(String[] args) {
		long startTime=System.currentTimeMillis();   //获取开始时间

		

		
		String tempString="";
		int line=0;
		// TODO Auto-generated method stub
		 File file = new File("/users/zheng/downloads/project1-data/ngram10-300-0.65.txt");
		   BufferedReader reader = null;
		   try {
			   reader = new BufferedReader(new FileReader(file));
			   while (( reader.readLine()) != null) {
				   line++;
	            }
		   }
		   catch(Exception e){}
		   
		   finally {
	            if (reader != null) {
	                try {
	                    reader.close();
	                } catch (IOException e1) {
	                }
	            }
		   }
		   
		   System.out.print(line);
		   long endTime=System.currentTimeMillis(); //获取结束时间

			System.out.println("程序运行时间： "+(endTime-startTime)+"ms");
	}

}