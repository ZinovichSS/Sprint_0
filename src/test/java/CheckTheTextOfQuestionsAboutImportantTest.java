import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
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
import pageObjects.MainPage;
import pageObjects.OrderPage;

import java.time.Duration;

public class CheckTheTextOfQuestionsAboutImportantTest {

    private WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");
    }

    @Test
    public void checkAnswersOnQuestions1() { //считаю, что правильнее было каждую проверку венести одельно (1 тест = 1 проверка)
        MainPage mainPage = new MainPage(driver);
        mainPage.open();
        mainPage.scrollToTheSectionQuestionsAboutImportant();
        mainPage.checkAnswerToQuestion("0", "Сутки — 400 рублей. Оплата курьеру — наличными или картой.");
    }

    @Test
    public void checkAnswersOnQuestions2() {
        MainPage mainPage = new MainPage(driver);
        mainPage.open();
        mainPage.scrollToTheSectionQuestionsAboutImportant();
        mainPage.checkAnswerToQuestion("1", "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.");
    }

    @Test
    public void checkAnswersOnQuestions3() {
        MainPage mainPage = new MainPage(driver);
        mainPage.open();
        mainPage.scrollToTheSectionQuestionsAboutImportant();
        mainPage.checkAnswerToQuestion("2", "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.");
    }

    @Test
    public void checkAnswersOnQuestions4() {
        MainPage mainPage = new MainPage(driver);
        mainPage.open();
        mainPage.scrollToTheSectionQuestionsAboutImportant();
        mainPage.checkAnswerToQuestion("3", "Только начиная с завтрашнего дня. Но скоро станем расторопнее.");
    }

    @Test
    public void checkAnswersOnQuestions5() {
        MainPage mainPage = new MainPage(driver);
        mainPage.open();
        mainPage.scrollToTheSectionQuestionsAboutImportant();
        mainPage.checkAnswerToQuestion("4", "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.");
    }

    @Test
    public void checkAnswersOnQuestions6() {
        MainPage mainPage = new MainPage(driver);
        mainPage.open();
        mainPage.scrollToTheSectionQuestionsAboutImportant();
        mainPage.checkAnswerToQuestion("5", "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.");
    }

    @Test
    public void checkAnswersOnQuestions7() {
        MainPage mainPage = new MainPage(driver);
        mainPage.open();
        mainPage.scrollToTheSectionQuestionsAboutImportant();
        mainPage.checkAnswerToQuestion("6", "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.");
    }

    @Test
    public void checkAnswersOnQuestions8() {
        MainPage mainPage = new MainPage(driver);
        mainPage.open();
        mainPage.scrollToTheSectionQuestionsAboutImportant();
        mainPage.checkAnswerToQuestion("7", "Да, обязательно. Всем самокатов! И Москве, и Московской области.");
    }


    @After
    public void tearDown() {
        driver.quit();
    }
}
