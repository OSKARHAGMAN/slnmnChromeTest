
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.jupiter.api.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class firstTest {
    public static WebDriver driver;
    public static String URL = "https://maven.apache.org/";
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

    @BeforeAll
    public static void launchBoostAppHomepage() {
        System.out.println("Launch Chrome Browser");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--window-size=1100,1000");
        options.setHeadless(true);
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(options);
        driver.get(URL);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }
    @Test
    void mvnTest(){
        boolean result = wait.until(ExpectedConditions.elementToBeClickable(By.id("breadcrumbs"))).isEnabled();
        System.out.println("Element is clickable");
        String elementText = driver.findElement(By.id("breadcrumbs")).getText();
        System.out.println(elementText);
        assertTrue(result);
    }
    @AfterAll
    static void tearDown() {
        driver.quit();
    }
}

