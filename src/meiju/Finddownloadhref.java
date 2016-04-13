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

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

//自定义类
import meiju.DownloadTime;
import meiju.Searchtvseries;
import meiju.Writetofile;
import meiju.Readfromfile;

public class Finddownloadhref {
	private final WebDriver webDriver;
	private final WebDriverWait wait;
	private JavascriptExecutor js;

	Writetofile writeToFile;
	Readfromfile readfromfile;
	// 美剧名
	private WebElement tvName;
	// 下载地址
	private List<WebElement> listElement;
	// = dr.findElements(By.xpath("//*[@id='jishu']/div/ul/li"));
	// 集数
	private List<WebElement> listElement1;
	// =
	// dr.findElements(By.xpath("//*[@id='jishu']/div/ul/li/div[1]/div/span"));
	// 下载链接
	private List<WebElement> listElement2;
	// =
	// dr.findElements(By.xpath("//*[@id='jishu']/div/ul/li/div[1]/div/input"));

	public Finddownloadhref(WebDriver webDriver) {
		this.webDriver = webDriver;
		this.wait = new WebDriverWait(webDriver, 100);
		;
	}

	public List<String> listdownloadhrefsearch(List<String> listTVHref) throws InterruptedException {
		List<String> listHref = new ArrayList<String>();
		/*
		 * webDriver.get(url); WebElement webElementKeyword =
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(
		 * "keyword")));
		 * 
		 * if (webElementKeyword != null) {
		 * System.out.print(webElementKeyword.getText()); }
		 */

		writeToFile = new Writetofile();
		readfromfile = new Readfromfile();
		for (String list : listTVHref) {
			webDriver.get(list);
			// 美剧名
			tvName = webDriver.findElement(By.xpath("//*[@id='redu']/h1"));

			System.out.println(tvName.getText());

			String fileName = tvName.getText() + ".txt";

			listElement = webDriver.findElements(By.xpath("//*[@id='jishu']/div/ul/li"));

			listElement1 = webDriver.findElements(By.xpath("//*[@id='jishu']/div/ul/li/div[1]/div/span"));

			listElement2 = webDriver.findElements(By.xpath("//*[@id='jishu']/div/ul/li/div[1]/div/input"));
			/*
			
			*/

			// 获取txt中最后一行
			String hrefFromTxt = readfromfile.readRocords(fileName);
			System.out.println(hrefFromTxt);
			if (hrefFromTxt.length() > 0 && hrefFromTxt != null) {
				// 下载链接
				List<String> listWriteHref = new ArrayList<String>();
				// 集数
				int Num = 0;
				for (int i = 0; i < listElement.size(); i++) {
					String downloadHref = listElement2.get(i).getAttribute("value").toString();
					if (downloadHref.equals(hrefFromTxt)) {
						Num = i - 1;
						break;
					}
				}
				System.out.println("Num:" + Num);
				for (int i = Num; i < listElement.size(); i++) {
					String downloadHref = listElement2.get(i).getAttribute("value").toString();
					listWriteHref.add(downloadHref);
				}
				if (listWriteHref.size() > 0 && listElement.size() - listWriteHref.size() > 1) {
					//System.out.println("listWriteHref.size() :" + listWriteHref.size());
					// 向文件写本次抓取启动时间
					String time = new DownloadTime().Time();
					writeToFile.appendMethod(fileName, time);

					String beginToEnd = listElement1.get(listElement.size() - listWriteHref.size()).getText().toString() + "-"
							+ listElement1.get(listElement.size() - 1).getText().toString();
					writeToFile.appendMethod(fileName, beginToEnd);

					writeToFile.appendListMethod(fileName, (ArrayList<String>) listWriteHref);
				}
				System.out.println(fileName + "更新结束");
			} else {
				System.out.println("新的美剧");
				// 向文件写本次抓取启动时间
				String time = new DownloadTime().Time();
				writeToFile.appendMethod(fileName, time);

				String beginToEnd = listElement1.get(0).getText().toString() + "-"
						+ listElement1.get(listElement.size() - 1).getText().toString();
				writeToFile.appendMethod(fileName, beginToEnd);
				for (int i = 0; i < listElement.size(); i++) {
					System.out.println(listElement1.get(i).getText());
					System.out.println(listElement2.get(i).getAttribute("value"));

					String downloadHref = listElement2.get(i).getAttribute("value").toString();

					writeToFile.appendMethod(fileName, downloadHref);
				}
			}
		}

		// for(String list : listHref)
		// {
		// System.out.println(list);
		// }
		// webDriver.quit();

		return listHref;
	}

}
