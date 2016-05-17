package meiju;

import java.util.Date;
import java.util.Calendar; 
import java.text.SimpleDateFormat;

public class DownloadTime {
	
	public String Time()
	{
		Calendar calendar = Calendar.getInstance();//可以对每个时间域单独修改

		int year = calendar.get(Calendar.YEAR); 
		int month = calendar.get(Calendar.MONTH)+1; 
		int date = calendar.get(Calendar.DATE); 
		int hour = calendar.get(Calendar.HOUR_OF_DAY); 
		int minute = calendar.get(Calendar.MINUTE); 
		int second = calendar.get(Calendar.SECOND); 
	
		String time = "启动时间：" + year + "年" + month + "月" + date + "日" + hour + "时" + minute + "分" + second + "秒";
		return time;
	}	
}
