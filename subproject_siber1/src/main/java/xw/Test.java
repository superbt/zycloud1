package xw;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import xw.entity.Page;
import xw.utils.SaveToExcel;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Test {
    public static void main(String arrg[]){
       System.out.println("hello bt -start");
        System.getProperties().setProperty("webdriver.chrome.driver",
                "H:\\mysubPorject\\siber\\chromedriver_win32\\chromedriver.exe");
        ChromeDriver chromeDriver = new ChromeDriver();
        String url = "http://www.baidu.com";
        chromeDriver.get(url);

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebElement kw = chromeDriver.findElement(By.id("kw"));
        kw.sendKeys("123");
        WebElement su = chromeDriver.findElement(By.id("su"));
        su.click();


        chromeDriver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

        WebElement content_left = chromeDriver.findElement(By.id("content_left"));

//        List<WebElement> elements = content_left.findElements(By.cssSelector(".c-container"));
        List<WebElement> elements = content_left.findElements(By.xpath("//div[@class='c-container']"));

        List<Page> list = new ArrayList<>();

        for (WebElement page: elements){
            WebElement h3_a = page.findElement(By.cssSelector("h3 a"));
            String text = h3_a.getText();
            String href = h3_a.getAttribute("href");
            Page page1 = new Page();
            page1.setHref(href);
            page1.setText(text);
            list.add(page1);
            System.out.println(text+"=="+href);
        }

        SaveToExcel<Page> pageSaveToExcel = new SaveToExcel<>();
        try {
            pageSaveToExcel.writeExcel(list ,"H:\\mysubPorject\\siber\\chromedriver_win32\\1.xls");
        } catch (Exception e) {
            e.printStackTrace();
        }


        // chromeDriver.quit();
        System.out.println("hello bt -end");
    }
}
