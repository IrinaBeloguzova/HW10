import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Saucedemo {

    @Test
    public void sauceDemo() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
        WebElement username = driver.findElement(By.id("user-name"));
        WebElement password = driver.findElement(By.id("password"));
        WebElement login = driver.findElement(By.id("login-button"));
        //нажимаем Login
        username.sendKeys("standard_user");
        password.sendKeys("secret_sauce");
        login.click();
        //Дожидаемся перехода на страницу products
        WebDriverWait wait = new WebDriverWait(driver, 1);
        wait.until(ExpectedConditions.textToBe(By.xpath("//span[@class='title']"), "PRODUCTS"));
        //проверка перехода на страницу products
        Assert.assertEquals(driver.findElement(By.xpath("//span[@class='title']")).getText(), "PRODUCTS");
        //нажимаем на корзину
        WebElement cart = driver.findElement(By.xpath("//a[@class='shopping_cart_link']"));
        cart.click();
        //Дожидаемся перехода на страницу your cart
        wait.until(ExpectedConditions.textToBe(By.xpath("//span[@class='title']"), "YOUR CART"));
        //проверка перехода на страницу your cart
        Assert.assertEquals(driver.findElement(By.xpath("//span[@class='title']")).getText(), "YOUR CART");
       //нажимаем continue shopping
        WebElement continueShopping = driver.findElement(By.id("continue-shopping"));
        continueShopping.click();
        //Дожидаемся перехода на страницу your cart
        wait.until(ExpectedConditions.textToBe(By.xpath("//span[@class='title']"), "PRODUCTS"));
        //проверка перехода на страницу your cart
        Assert.assertEquals(driver.findElement(By.xpath("//span[@class='title']")).getText(), "PRODUCTS");
        driver.quit();
    }
}





