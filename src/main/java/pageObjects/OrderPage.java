package pageObjects;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class OrderPage {
    private static final By NAME_INPUT_FIELD = By.xpath(".//input[@placeholder='* Имя']");
    private static final By LASTNAME_INPUT_FIELD = By.xpath(".//input[@placeholder='* Фамилия']");
    private static final By ADDRESS_INPUT_FIELD = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");
    private static final By NUMBER_PHONE_INPUT_FIELD = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");
    private static final By METRO_STATION_SELECT = By.xpath(".//input[@placeholder='* Станция метро']");
    private static final By BUTTON_NEXT = By.xpath(".//button[text()='Далее']");
    private static final By DATA_DATA_PICKER = By.xpath(".//input[@placeholder='* Когда привезти самокат']");
    private static final By RENTAL_DAY_SELECT = By.xpath(".//div[@class='Dropdown-placeholder']");
    private static final By COLOUR_CHECKBOX_BLACK = By.xpath(".//input[@id='black']");
    private static final By COLOUR_CHECKBOX_GREY = By.xpath(".//input[@id='grey']");
    private static final By BUTTON_MAKE_ORDER = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");
    private static final By COMMENT_INPUT_FIELD = By.xpath(".//input[@placeholder='Комментарий для курьера']");
    private static final By BUTTON_CONFIRM_ORDER = By.xpath(".//button[text()='Да']");
    private static final By CREATED_ORDER_MODAL = By.xpath(".//div[@class='Order_Modal__YZ-d3']");



    private final WebDriver driver;
    public OrderPage(WebDriver driver) {

        this.driver = driver;
    }


    public void setName(String name) {

        driver.findElement(NAME_INPUT_FIELD).sendKeys(name);
    }

    public void setLastname(String lastname) {

        driver.findElement(LASTNAME_INPUT_FIELD).sendKeys(lastname);
    }

    public void setAddress(String address) {

        driver.findElement(ADDRESS_INPUT_FIELD).sendKeys(address);
    }

    public void setNumberPhone(String numberPhone) {
        driver.findElement(NUMBER_PHONE_INPUT_FIELD).sendKeys(numberPhone);
    }

    public void clickNextButton() {
        driver.findElement(BUTTON_NEXT).click();
    }

    public void chooseMetroStation(String station) {
        driver.findElement(METRO_STATION_SELECT).click();
        driver.findElement(By.xpath(".//div[@class='select-search__select']//*[text()='"+station+"']")).click();
    }

    public static void wait(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void chooseRentalDay(String day) {
        driver.findElement(RENTAL_DAY_SELECT).click();
        driver.findElement(By.xpath(".//div[@class='Dropdown-menu']//*[text()='"+day+"']")).click();
    }

    public void clickMakeOrderButton() {
        driver.findElement(BUTTON_MAKE_ORDER).click();
    }

    public void chooseColourBlack() {
        driver.findElement(COLOUR_CHECKBOX_BLACK).click();
    }

    public void chooseColourGrey() {
        driver.findElement(COLOUR_CHECKBOX_GREY).click();
    }

    public void setComment(String comment) {
        driver.findElement(COMMENT_INPUT_FIELD).sendKeys(comment);
    }

    public void setData(String data) {
        driver.findElement(DATA_DATA_PICKER).sendKeys(data);
    }




}



