package meiju;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class IsTargetPage {
    private final WebDriver webDriver;
    //private final WebDriverWait wait;
    //private JavascriptExecutor js;
    //美剧名
    //private WebElement tvName;
    //下载地址
    //private List<WebElement> listElement;
	//= dr.findElements(By.xpath("//*[@id='jishu']/div/ul/li"));
	//集数
    //private List<WebElement> listElement1; 
	//= dr.findElements(By.xpath("//*[@id='jishu']/div/ul/li/div[1]/div/span"));
    //下载链接
    //private List<WebElement> listElement2;
	//= dr.findElements(By.xpath("//*[@id='jishu']/div/ul/li/div[1]/div/input"));
	
    public IsTargetPage(WebDriver webDriver){
    	this.webDriver = webDriver;
    	//this.wait = new WebDriverWait(webDriver, 100);;
    }
    
    public void IsTarget()
    {
    	String parentWindowId = webDriver.getWindowHandle();
    	Set<String> allWindowsId = webDriver.getWindowHandles();
    	for(String windowId : allWindowsId)
    	{
    		if(webDriver.switchTo().window(windowId).getTitle().contains("<目标查找窗口Tilte的某段字符串>"))
    		{
    			webDriver.switchTo().window(windowId).getTitle().contains("<目标查找窗口Tilte的某段字符串>");
    		break;
    		}

    	}
    }
}
