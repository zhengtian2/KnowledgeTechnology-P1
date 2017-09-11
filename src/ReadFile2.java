import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
 
public class ReadFile2 {

	public static void main (String args[]) throws Exception
	{
		
		readFileByLines("/Users/zheng/Desktop/tianzheng.ningja/KT_p1/queries.10K.txt","/Users/zheng/Desktop/tianzheng.ningja/KT_p1/tweets.30K.txt","/Users/zheng/Desktop/tianzheng.ningja/KT_p1/distance10-30.txt",0.5);
		
	}
    public static void readFileByLines(String fileName,String fileName2,String outputPath,double sv) throws Exception {
    	long startTime=System.currentTimeMillis();   //start time
    	String txt="";
    	n_gram2 gram2=new n_gram2();
    	Print print=new Print();
        File file = new File(fileName);
        File file2 = new File(fileName2);
        BufferedReader reader = null;
        BufferedReader reader2 = null;
        ArrayList <String> query=new ArrayList<String>();
        ArrayList <String> tweets=new ArrayList<String>();
        String[] tweets_string=null;
        String[] query_string=null;
        String output="";

        try {
            
            reader = new BufferedReader(new FileReader(file));
            reader2 = new BufferedReader(new FileReader(file2));

            String tempString = null;
            String tempString2 = null;

            int line = 1;
            int line2=1;
           
           
            // read one line once until we meet null
            while ((tempString2 = reader2.readLine()) != null) {
            try{
            	//tweets.add(tempString2.substring(tempString2.indexOf("\t")));//get rid of user id
            	 tweets.add(tempString2.replace("\t", " ").toLowerCase());//replace the table character to the space so
            	 // I can use split! o hahahaha
            }
            catch(Exception e){}
                line++;
                // print the line number
                // System.out.println("line " + line + ": " + tempString2);
             //  Arraystr2=tempString2.split(" ");
              // Arraystr2[0]=Arraystr2[0].substring(11);//truncate userid       
                
            }
            while ((tempString = reader.readLine()) != null) {
            	query.add(tempString.toLowerCase());
            }
           //double a= distance.sim(Arraystr2[0],Arraystr[0]);
            //System.out.println(Arraystr2[0].substring(11));
            reader.close();
            reader2.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                }
            }

            if (reader2 != null) {
                try {
                    reader2.close();
                } catch (IOException e1) {
                }
            }
            
        }
        double a=0.0;
        //System.out.println(query);
        	for(int i=0;i<tweets.size();i++)
        	{	
        		tweets_string=tweets.get(i).split(" ");//I like this game.
        	 ArrayList <Double> average=new ArrayList<Double>();
        		for(int j=0;j<query.size();j++)
        		{
        			query_string=query.get(j).split(" ");//Acorn Corner
        			a=0.0;
        			output="";
        			if(tweets_string.length>=query_string.length){
        				for (int k=1;k<tweets_string.length-query_string.length+1;k++)
        				{	
        					
        				a=0.0;
        						for(int m=0;m<query_string.length;m++)
        						{
         							//a=0.0;
         							a+=gram2.getDistance(query_string[m],tweets_string[k+m]);
//         							System.out.println(query_string[m]);
//         							System.out.println(tweets_string[k+m]);
//         							System.out.println(a);
         						
										
        						}
     							

        						a=a/query_string.length;
        						//average.add(a);
        						//System.out.println("*****"+a);
        						if (a>sv)
        						{		System.out.println(a+">"+sv+"");
        							for(int m=k;m<k+query_string.length;m++){
//        								/output=output+tweets_string[m]+" ";
        								output=output+tweets_string[m]+" ";
        								//System.out.println("output****"+output);
        						}
        							//output=tweets_string[0]+": "+output;
        							System.out.println(query.get(j)+"===>>>> " +output);
        							txt=txt+"tweets_id: "+tweets_string[0]+"=>>"+output+" \n";
//        							System.out.println("tweets_string is -->"+tweets_string[0]);
        							//System.out.println("txt::"+"===>>>> " +txt);
        						}
        						
        						
        				}
        				
        					}
        		else{i++;}
        				
        				/***for(int mm=0;mm<average.size();mm++)
						{
							if(average.get(mm)>0.8)
								System.out.println("Hey! You are the one!"+"    "+mm);
							 
						}***/

					

        		}
        	}
			print.generate(outputPath,txt);
			 long endTime=System.currentTimeMillis(); 

				System.out.println("exe time:"+(endTime-startTime)+"ms");

        
    }

}




