package login;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;


public abstract class TestBase {

    protected final LoginPage loginPage = new LoginPage();
    public WebDriver wait;

    @Before
    public void initWebDriver() {

        iniWebDriver();
    }

    public void iniWebDriver() {
        ChromeOptions options = new ChromeOptions();
        loginPage.driver = new ChromeDriver(options);
        //Запуск браузера в окне размером 500х500
        //options.addArguments("--window-size=500,500");
        //Запуск браузера на весь экран
        loginPage.driver.manage().window().maximize();
        loginPage.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        //Меняем заданный при инициализации размер окна
        //driver.manage().window().setSize(new Dimension(210, 100));
        loginPage.driver.get("https://tt-develop.quality-lab.ru/login");
        WebDriverWait wait = new WebDriverWait(loginPage.driver, 5);
    }

    @After
    public void quitBrowser() {
        if (loginPage.driver !=null)
        loginPage.driver.quit();
        else System.out.println("There is no driver");
    }

    public LoginPage getLoginPage() {
        return loginPage;
    }


}
