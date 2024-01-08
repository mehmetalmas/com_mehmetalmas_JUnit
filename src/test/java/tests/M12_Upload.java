package tests;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
public class M12_Upload {

    WebDriver driver;
    Actions actions;

    @Before
    public void setUP () {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void upLoad() {

        driver.get("https://demoqa.com/upload-download");
        System.out.println(System.getProperty("user.home"));
        String filePath = System.getProperty("user.home") + "\\Downloads\\WhatsAppImage.jpg";
        System.out.println(filePath);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement selectElement = wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.id("uploadFile")));

        WebElement uploadElement = driver.findElement(By.id("uploadFile"));

        Actions actions = new Actions(driver);
        actions.moveToElement(uploadElement);
        actions.click();
        actions.sendKeys(filePath);
        actions.build().perform();
        //WebElement uploadedFilePath = driver.findElement(By.id("uploadedFilePath"));
        //boolean isElementDisplayed = uploadedFilePath.isDisplayed();
    }

    @Test
    public void upLoad2() throws InterruptedException {

        driver.get("https://demoqa.com/upload-download");

        //WebElement uploadElement = driver.findElement(By.id("uploadFile"));
        WebElement uploadElement = driver.findElement(By.cssSelector("#uploadFile"));

        System.out.println(System.getProperty("user.home"));
        String filePath = System.getProperty("user.home") + "\\Downloads\\WhatsAppImage.jpg";
        System.out.println(filePath);

        uploadElement.click();
        wait(5000);
        uploadElement.sendKeys(filePath);
        wait(5000);

        WebElement uploadedFilePath = driver.findElement(By.id("uploadedFilePath"));
        boolean isElementDisplayed = uploadedFilePath.isDisplayed();
    }
}
