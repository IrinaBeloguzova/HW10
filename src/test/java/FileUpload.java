import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class FileUpload {
    @Test
    public void fileUpload() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://the-internet.herokuapp.com/upload");

        //Загрузить файл
        driver.findElement(By.id("file-upload")).sendKeys(System.getProperty("user.dir") + "/src/test/resources/toUpload.html");
        driver.findElement(By.id("file-submit")).click();

        //Проверить, что имя файла на странице совпадает с именем загруженного файла
        Assert.assertTrue(driver.findElement(By.id("uploaded-files")).getText().contains("toUpload.html"));
        driver.quit();
    }
}
