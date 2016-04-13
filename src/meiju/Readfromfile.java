package meiju;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class Readfromfile {
	
	public String readRocords(String filename) {
		isExistFile(filename);
        List<String> transaction = null;
        if (filename.length() > 0) 
        {
            transaction = new LinkedList<String>();
            //for (String filename : filenames) 
            //{
                try 
                {
                    FileReader fr = new FileReader(filename);
                    BufferedReader br = new BufferedReader(fr);
                    try 
                    {
                        String line;
                        while ((line = br.readLine()) != null) 
                        {
                            if(line.trim().length()>0)
                            {
                                transaction.add(line);
                            }
                        }
                    } finally {
                        br.close();
                    }
                } catch (IOException ex) {
                    System.out.println("Read transaction records failed."
                            + ex.getMessage());
                    System.exit(1);
                }
            //}
        }
        if(transaction.size() > 0)
        {
        	return transaction.get(transaction.size()-1);
        }
        else
        {
        	System.out.println("未更新");
        	return null;
        }
    }
	
	public void isExistFile(String fileName)
    {
		File file = new File(fileName);
		
	    if(!file.exists())   
	    {   
	        try {   
	            file.createNewFile();   
	        } catch (IOException e) {   
	            // TODO Auto-generated catch block   
	            e.printStackTrace();   
	        }   
	    } 
    }
 
}
