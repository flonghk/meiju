package meiju;

import meiju.Searchtvseries;
import meiju.Finddownloadhref;
import meiju.GetCurrentPath;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UStvseries {
	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		List<String> listTVName = new ArrayList<String>();
		
		//listTVName.add("生活大爆炸第九季");
		listTVName.add("天蝎第二季");
		//listTVName.add("海军罪案调查处第十三季");
		listTVName.add("谍网第一季");
		//listTVName.add("犯罪现场调查：网络第二季");
		//listTVName.add("犯罪现场调查：网络第一季");
		//listTVName.add("灵书妙探第八季");
		//listTVName.add("福尔摩斯：基本演绎法第四季");
		listTVName.add("尖峰时刻第一季");
		
		String chromedriverPath = new GetCurrentPath().getCurrentPath();
		System.setProperty("webdriver.chrome.driver", chromedriverPath + "/\\chromedriver.exe");
		WebDriver webDriver = new ChromeDriver();
		
		Searchtvseries searchtvseries;
		searchtvseries = new Searchtvseries(webDriver);
		List<String> listHref = searchtvseries.listsearch(listTVName);
		
		Finddownloadhref finddownloadhref;
		finddownloadhref = new Finddownloadhref(webDriver); 
		
		finddownloadhref.listdownloadhrefsearch(listHref);
		
		System.out.println("结束");
		
		webDriver.quit();
		
		
	}

}
