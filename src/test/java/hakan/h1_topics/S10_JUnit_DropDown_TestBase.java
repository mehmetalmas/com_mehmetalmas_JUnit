package hakan.h1_topics;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import java.time.Duration;

public class S10_JUnit_DropDown_TestBase extends TestBase {





    @Test
    public void dropDowntTestBase() {
        //kullanici "https://koctas.com.tr/" adresine gider
        driver.get("https://koctas.com.tr/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //kullanici konum butonunu tiklar
        WebElement konum= driver.findElement(By.cssSelector("div[class='ml-5']"));
        konum.click();
        TestBase.wait(2);

        WebElement city= driver.findElement(By.id("locCity"));

        //eger elementin classi select tagli ise select objesi olusturulur
        Select select=new Select(city);

        //select objesi icinden secim yapilir
        select.selectByIndex(1);
        TestBase.wait(2);

        select.selectByValue("35");
        TestBase.wait(2);

        select.selectByVisibleText("ANKARA");
        TestBase.wait(2);

    }
}
