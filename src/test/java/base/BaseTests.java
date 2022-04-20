package base;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class BaseTests {
    public WebDriver driver;
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/login");
//        driver.manage().window().maximize();
        WebElement usernameElement = driver.findElement(By.id("username"));
        usernameElement.sendKeys("tomsmith");
        WebElement passwordElement = driver.findElement(By.id("password"));
        passwordElement.sendKeys("SuperSecretPassword!");

        System.out.println("Name attribute of userName button:" + usernameElement.getAttribute("Name"));
        driver.findElement(By.xpath("//i[contains(text(), 'Login')]")).click();
        driver.navigate().back();
        List<WebElement> inputList = driver.findElements(By.tagName("input"));
        System.out.println(inputList.size());

        for (WebElement element:inputList){
            System.out.println("Element:" + element.getAttribute("name"));
        }
        for (int i =0; i< inputList.size(); i++){
            System.out.println("Element:" + inputList.get(i).getAttribute("name"));
        }

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.quit();
//        System.out.println(driver.getTitle());

    }

    public static void main(String[] args){
        BaseTests test = new BaseTests();
        test.setUp();
    }
}
