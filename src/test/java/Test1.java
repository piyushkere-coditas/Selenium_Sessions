import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test1 {

    public static ChromeDriver getChrome() {
        return new ChromeDriver();
    }

    private static void visitUrl(ChromeDriver driver, String url) {
        driver.get(url);
        driver.manage().window().maximize();
    }

    private static void registration(ChromeDriver driver, String fName, String lName, String email, String password) {
        driver.findElement(By.className("ico-register")).click();
        driver.findElement(By.id("gender-male")).click();
        WebElement firstName = driver.findElement(By.id("FirstName"));
        WebElement lastName = driver.findElement(By.id("LastName"));
        WebElement emailID = driver.findElement(By.id("Email"));
        WebElement pass = driver.findElement(By.id("Password"));
        WebElement pass2 = driver.findElement(By.id("ConfirmPassword"));
        firstName.sendKeys(fName);
        lastName.sendKeys(lName);
        emailID.sendKeys(email);
        pass.sendKeys(password);
        pass2.sendKeys(password);
        driver.findElement(By.id("register-button")).click();
    }

    public static void main(String[] args) {
        ChromeDriver driver = getChrome();
        String url = "https://demowebshop.tricentis.com/";
        String fName = "piyush";
        String lName = "kere";
        String email = "kerep@gmail.com";
        String password = "piyush12345";
        visitUrl(driver, url);
        registration(driver, fName, lName, email, password);
    }
}
