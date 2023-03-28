import org.junit.runners.Parameterized.Parameters;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import pageObjects.MainPage;
import pageObjects.OrderPage;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

@RunWith(Parameterized.class)
public class OrderTestParametrized {

    private WebDriver driver;
    private final String name;
    private final String lastname;
    private final String address;
    private final String numberPhone;
    //private final String comment;


    public OrderTestParametrized(String name, String lastname, String address, String numberPhone) {
        this.name = name;
        this.lastname = lastname;
        this.address = address;
        this.numberPhone = numberPhone;
    }

    @Parameters
    public static Object[][] getData () {
        return new Object[][] {
                {"Петр", "Петров", "Невский проспект 10", "+79111111111"},
                //{"Иван", "Иванов", "Ленина 67", "89117409387"}
        };
    }

    @Before
    public void setUp() {
        Properties prop = new Properties();
        try {
            prop.load(new FileReader("application.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        String webDriver = prop.getProperty("webdriver");
        if (webDriver.equals("firefox")) {
            FirefoxOptions options = new FirefoxOptions();
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver(options);
        } else if (webDriver.equals("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }
        driver.get("https://qa-scooter.praktikum-services.ru/");
    }


    @Test
    public void checkCreateNewOrder_withButtonTop_checkWindowAboutASuccessfulOrder() {

        MainPage mainPage = new MainPage(driver);
        OrderPage orderPage = new OrderPage(driver);
        mainPage.open();
        mainPage.clickCreateOrderButtonInHead();
        orderPage.setName(name);
        orderPage.setLastname(lastname);
        orderPage.setAddress(address);
        orderPage.setNumberPhone(numberPhone);
        orderPage.chooseMetroStation("Сокольники");
        OrderPage.wait(1);
        orderPage.clickNextButton();
        OrderPage.wait(3);
        orderPage.setData("01.04.2023\n");
        orderPage.chooseRentalDay("сутки");
        orderPage.chooseColourBlack();
        orderPage.setComment("Комментарий 1");
        OrderPage.wait(5);
        orderPage.clickMakeOrderButton();
    }

    @Test
    public void checkCreateNewOrder_withButtonSecondary_checkWindowAboutASuccessfulOrder() {

        MainPage mainPage = new MainPage(driver);
        OrderPage orderPage = new OrderPage(driver);
        mainPage.open();
        mainPage.scrollToTheButtonToOrderInPage();
        mainPage.clickCreateOrderButtonInPage();
        orderPage.setName(name);
        orderPage.setLastname(lastname);
        orderPage.setAddress(address);
        orderPage.setNumberPhone(numberPhone);
        orderPage.chooseMetroStation("Красные Ворота");
        OrderPage.wait(5);
        orderPage.clickNextButton();
        orderPage.chooseColourBlack();

    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
