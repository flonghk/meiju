package meiju;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import meiju.IsTargetPage;

public class Searchtvseries {
    private final WebDriver webDriver;
    private final WebDriverWait wait;
    private JavascriptExecutor js;
    private final String url = "http://www.meijutt.com/";
    
    private WebElement webElementKeyword;
    private WebElement webElementBtn;
    //private WebElement webElementInput;

    public Searchtvseries(WebDriver webDriver) {
        this.webDriver = webDriver;
        this.wait = new WebDriverWait(webDriver, 1000);
        this.js = (JavascriptExecutor) webDriver;
    }
    


	public List<String> listsearch(List<String> listTVName) throws InterruptedException {
    	List<String> listHref = new ArrayList<String>();
    	
    	webDriver.get(url);
        WebElement webElementKeyword = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("keyword")));
 
        if (webElementKeyword != null) {
            System.out.print(webElementKeyword.getText());
        }
        
		for(String list : listTVName)
		{
			webElementKeyword = webDriver.findElement(By.id("keyword"));
			webElementKeyword.sendKeys(list);
			IsTargetPage isTargetPage = new IsTargetPage(webDriver);
			isTargetPage.IsTarget();
			webElementBtn = webDriver.findElement(By.id("keyword_bnt"));
			webElementBtn.click();
			Thread.sleep(1000);
        
			listHref.add( webDriver.findElement(By.partialLinkText(list)).getAttribute("href"));
		}
		
		for(String list : listHref)
		{
			System.out.println(list);
		}
		
		//webDriver.close();;
		
		return listHref;
    }
}
