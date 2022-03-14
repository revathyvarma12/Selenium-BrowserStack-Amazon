import org.checkerframework.checker.units.qual.Temperature;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;
import org.openqa.selenium.WebDriver;
import com.relevantcodes.extentreports.LogStatus;


public class BrowserStackTestTest extends BrowserStackTestNGTest{

    @Test
    public void amazontest() throws InterruptedException {
      test.log(LogStatus.INFO,"Browser opened");

      //Navigating to amazon

        driver.get("https://www.amazon.com");
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphoneX");
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys(Keys.ENTER);
       // test.log(LogStatus.INFO,"Logged in amazon");
        Thread.sleep(3000);
        //Applying filters

        //driver.findElement(By.xpath("//span[contains(text(),'iOS')]/parent::a/div/label/input")).click();
        //driver.findElement(By.xpath("//label[contains(text(),'Sort by:')]")).click();
        //driver.findElement(By.linkText("Price: High to Low")).click();
        List<WebElement> phones=driver.findElements(By.xpath("//div[starts-with(@class,'s-result-item') and starts-with(@data-cel-widget,'search_result') and @data-asin!='']//span[@class='a-price-whole']"));
        int elements=phones.size();
        System.out.println(elements);
        //Printing the details of all the products

        test.log(LogStatus.INFO,"Product info listed");
        for(int i=1;i<elements;i++) {

            String link = driver.findElement(By.xpath("(//div[starts-with(@class,'s-result-item') and starts-with(@data-cel-widget,'search_result') and @data-asin!='']//span[@class='a-price-whole'])["+i+"]")).getText();
            String productname = driver.findElement(By.xpath("(//div[starts-with(@class,'s-result-item') and starts-with(@data-cel-widget,'search_result') and @data-asin!='']//h2)["+i+"]")).getText();
            String productlink = driver.findElement(By.xpath("(//div[starts-with(@class,'s-result-item') and starts-with(@data-cel-widget,'search_result') and @data-asin!='']//h2/a)["+i+"]")).getAttribute("href");

            System.out.println(productname);
            System.out.println(link);
            System.out.println(productlink);
        }
    }


}