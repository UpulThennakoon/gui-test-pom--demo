package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;
import java.time.Duration;

public class TestApp {
    private WebDriver driver;
    private static TestApp myobt;
    PropertyFileReader propertyFileReader=new PropertyFileReader();
    public static TestApp getInstance()
    {
        if(myobt==null)
        {
            myobt=new TestApp();
            return myobt;
        }
        else {
            return myobt;

        }
    }
    public WebDriver getDriver()
    {
        return driver;
    }
    public void setDriver(WebDriver driver)
    {
        this.driver=driver;
    }
    public static void setMyobt(TestApp myobt)
    {
        TestApp.myobt=myobt;
    }
    public void openBrowser()
    {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver=new ChromeDriver(options);
        driver.manage().window().maximize();

    }
    public void navigateToURL()
    {
        String url= propertyFileReader.getProperty("config","url");
        driver.get(url);
    }
    public  void closeBrowser()
    {
        driver.quit();
    }
    public  WebElement waitNextElementAppears(By locator,int timeOut)
    {
        WebElement element=new WebDriverWait(TestApp.getInstance().getDriver(), Duration.ofSeconds(timeOut)).until(ExpectedConditions.presenceOfElementLocated(locator));
        return element;
    }
    public  void setText(By locator ,String text)
    {
        driver.findElement(locator).sendKeys(text);
    }
    private String getChromeDriverFilePath()
    {
        URL res=getClass().getClassLoader().getResource("chromedriver.exe");
        File file=null;
        try {
            {
                file= Paths.get(res.toURI()).toFile();
            }
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return  file.getAbsolutePath();
    }
}

