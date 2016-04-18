package meiju;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import meiju.IsTargetPage;

public class Searchtvseries {
    private final WebDriver webDriver;
    private final WebDriverWait wait;
    private JavascriptExecutor js;
    //private final String url = "http://www.meijutt.com/";
    private final String url = "http://www.meijutt.com/search.asp";
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
    	/*
        webElementKeyword = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("keyword")));
 
        if (webElementKeyword != null) {
            System.out.print(webElementKeyword.getText());
        }
        */
		for(String list : listTVName)
		{
			IsTargetPage isTargetPage = new IsTargetPage(webDriver);
			webElementKeyword = webDriver.findElement(By.id("keyword"));

			webElementKeyword.clear();
			webElementKeyword.sendKeys(list);
			//System.out.println(list);
			isTargetPage.IsTarget();

			webElementBtn = webDriver.findElement(By.id("keyword_bnt"));
			
			JavascriptExecutor executor = (JavascriptExecutor) webDriver;
			executor.executeScript("arguments[0].click();", webElementBtn);
			//System.out.println("已点击");
			isTargetPage.IsTarget();
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
