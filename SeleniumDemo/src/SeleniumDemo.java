import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SeleniumDemo {
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		try {
            driver.get("https://seleniumbase.io/demo_page");
            //Step 1 - Fill the text input and check
            WebElement element = driver.findElement(By.id("myTextInput"));
            element.sendKeys("MAPS is boring");
            System.out.println("Step 1 result: " + element.getAttribute("value"));
            //Step 2 - Get color attribute
            String rgb = driver.findElement(By.id("svgRect")).getAttribute("fill");
            System.out.println("Step 2 result: " + rgb);
            //Step 3 - Checkbox
            driver.switchTo().frame("myFrame3");
            element = driver.findElement(By.id("checkBox6"));
            element.click();
            System.out.println("Step 3 result: " + element.isSelected());
            driver.switchTo().parentFrame();
            //Step 4 - Change bar value
            Select drop = new Select(driver.findElement(By.id("mySelect")));
            drop.selectByVisibleText("Set to 50%");
            double result4 = Double.parseDouble(driver.findElement(By.id("meterBar")).getAttribute("value"));
            System.out.println("Step 4 result: " + (result4 == 0.5));
            //Step 5 - List of hyperlinks
            List<WebElement> urls = driver.findElements(By.xpath("//a"));
            System.out.println("Step 5 result:");
            for (int i = 0; i < urls.size(); i++) {
            	//Filter for blank elements
            	if (urls.get(i).getText().length() > 0) {
            		System.out.println(urls.get(i).getText());
            	}
            }
        } finally {
        	driver.quit();
        }
	}
}
