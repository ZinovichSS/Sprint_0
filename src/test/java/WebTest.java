import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class WebTest {

    private WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");
    }

    @Test
    public void checkAnswersOnQuestions() {

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOfElementLocated(By.className("header__user")));
        WebElement element = driver.findElement(By.xpath(".//div[text()='Вопросы о важном']"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
        driver.findElement(By.id("accordion__heading-0")).click();


        }
        @After
        public void tearDown() {
            driver.quit();
        }
    }
