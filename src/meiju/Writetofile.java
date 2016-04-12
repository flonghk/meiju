package meiju;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Writetofile {

    public void appendMethod(String fileName, String content) 
    {  
        try {  
            // 打开一个写文件器，构造函数中的第二个参数true表示以追加形式写文件  
			//FileWriter fw = null;
	        //BufferedWriter writer = null;
	        //fw = new FileWriter(file);
            //writer = new BufferedWriter(fw);
        	isExistFile(fileName);
            FileWriter fw = new FileWriter(fileName, true); 
            BufferedWriter writer = new BufferedWriter(fw);
            writer = new BufferedWriter(fw);
            writer.write(content);  
            writer.newLine();
            writer.close();  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
    }  
    
    public void appendListMethod(String fileName, ArrayList<String> content) 
    {  
        try {  
            // 打开一个写文件器，构造函数中的第二个参数true表示以追加形式写文件  
			//FileWriter fw = null;
	        //BufferedWriter writer = null;
	        //fw = new FileWriter(file);
            //writer = new BufferedWriter(fw);
        	isExistFile(fileName);
            FileWriter fw = new FileWriter(fileName, true); 
            BufferedWriter writer = new BufferedWriter(fw);
            writer = new BufferedWriter(fw);
            for (int i = 0; i < content.size(); i++)
            {
            	writer.write(content.get(i));  
                writer.newLine();
            }
            
            writer.close();  
        } catch (IOException e) {  
            e.printStackTrace();  
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
