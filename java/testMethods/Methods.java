package testMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.example.Main;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

public class Methods {

    static WebDriver driver = Main.driver;
    static String url = Main.baseUrl;
    static WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    public static void HomePageValidation(){
        driver.get(url);
        String title = driver.getTitle();
        System.out.println("Page Title      :"+title);
        System.out.println("Title Check     :"+(title.equals("Sauce Demo") ? "PASS":"FAIL"));

        String currentUrl = driver.getCurrentUrl();
        System.out.println("Current URL     :"+currentUrl);
        System.out.println("URL check       :"+(currentUrl.equals("https://sauce-demo.myshopify.com/")? "PASS":"FAIL"));

//        here used the cssSelector to target the alt attribute text from logo(id) > <img> tag
        String heading = driver.findElement(By.cssSelector("#logo img")).getAttribute("alt");
        System.out.println("H1 text         :"+heading);

//        here used the cssSelector to target the <a> tags inside the <li> in <nav> tag
        List<WebElement> navmenu = driver.findElements(By.cssSelector("nav li a"));
        System.out.println("Nav link count  :"+navmenu.size());
        System.out.println("=== Task 1 Completed ===");
    }
    public static void NavigateToAboutUs(){
//        here used the linkText to locate the like containing "About Us"
        driver.findElement(By.linkText("About Us")).click();
        boolean currUrl = driver.getCurrentUrl().contains("/pages/about-us");
        System.out.println("URL check       :"+((currUrl)? "PASS":"FAIL)"));

        System.out.println("Title check     :"+((driver.getTitle().equals("About Us – Sauce Demo"))? "PASS":"FAIL"+driver.getTitle()));

//        Here used the cssSelector to get the h1 page title where id = "page-content"
        String pageTitle = driver.findElement(By.cssSelector("div[id = 'page-content'] h1")).getText();
        System.out.println("H1 text         :"+pageTitle);

//        Here used the cssSelector to get the text(paragraph) stored in class = 'wysiwyg'
        String paragraph = driver.findElement(By.cssSelector(("div[class='wysiwyg']"))).getText();
        System.out.println("Verify about page:"+((paragraph.contains("Sauce"))? "PASS":"FAIL"));
        System.out.println("=== Task 2 Completed ===");
    }
    public static void CatalogAndProduct(){
//        here used the linkText to locate the like containing "Catalog"
        driver.findElement(By.linkText("Catalog")).click();
        System.out.println("URL check       :"+(driver.getCurrentUrl().contains("/collections/all")? "PASS": "FAIL"));

        System.out.println("Title check     :"+((driver.getTitle().equals("Products – Sauce Demo"))? "PASS":"FAIL"));

//        here used the cssSelector to get the h1 text stored in page-content
        System.out.println("Verify title    : "+driver.findElement(By.cssSelector("div#page-content h1")).getText());

        List<WebElement> products = driver.findElements(By.cssSelector("section.product-grid a h3"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("product-grid")));
        System.out.println("Product count: "+products.size());
        for(WebElement x: products){
            System.out.println(x.getText());
        }

        System.out.println("Product count   :"+((products.size()==7)? "PASS":"FAIL"));

        int count = driver.findElements(By.xpath("//a[.//div[contains(@class,'sold-out')]]")).size();
        System.out.println("Sold out count  :" + count);

        List<WebElement> soldOutProducts = driver.findElements(By.xpath("//a[.//div[contains(@class,'sold-out')]]//h3"));

        for (WebElement product : soldOutProducts) {
            System.out.println(product.getText());
        }

        System.out.println("Grey Jacket href: "+driver.findElement(By.partialLinkText("Grey")).getAttribute("href"));
        System.out.println("=== Task 3 Completed ===");
    }
    public static void ProductDetailPage(){
        driver.findElement(By.cssSelector("a[href*='grey-jacket']")).click();
        System.out.println("URL check   :"+((driver.getCurrentUrl().contains("grey-jacket"))?"Pass":"Fail"));
        System.out.println("Title check :"+(driver.getTitle().equals("Grey jacket – Sauce Demo")?"Pass":"Fail"));
        String greyJacketPrice = driver.findElement(By.cssSelector("h2 span[class='product-price']")).getText();
        System.out.println(greyJacketPrice);
        System.out.println("Correct Jacket price: "+((greyJacketPrice.equals("£55.00"))?"PASS":"FAIL"));
        List<WebElement> breadcrumb = driver.findElements(By.cssSelector("div[id='breadcrumb'] span a"));
        System.out.println("Breadcrumb:");
        for(WebElement x: breadcrumb){
            System.out.println(x.getText());
        }
        boolean btnDisplayed = driver.findElement(By.xpath("//input[@id='add']")).isDisplayed();
        System.out.println("Button displayed: "+btnDisplayed);

        boolean btnEnable = driver.findElement(By.xpath("//input[@id='add']")).isEnabled();
        System.out.println("Button enabled: "+btnEnable);

        System.out.println("Value attribute: "+driver.findElement(By.xpath("//input[@id='add']")).getAttribute("value"));
        System.out.println("=== Task 4 Completed ===");

    }
    public static void BrowserNavigation(){
        driver.navigate().back();
        System.out.println("on catalog page: "+(driver.getCurrentUrl().contains("/collections/all")));
        driver.navigate().forward();
        System.out.println(("on grey jacket page: "+driver.getCurrentUrl().contains("grey-jacket")));
        driver.navigate().to("https://sauce-demo.myshopify.com/pages/about-us");
        System.out.println("on about us page: "+(driver.getCurrentUrl().contains("/about-us")));
        driver.navigate().refresh();
        System.out.println("Verify title: "+(driver.getTitle().equals("About Us – Sauce Demo")));
        driver.get("https://sauce-demo.myshopify.com");
        System.out.println("=== Task 5 Completed ===");

    }
    public static void Task6(){
        driver.get(Main.baseUrl);
        String cartText = driver.findElement(By.partialLinkText("My Cart")).getText();
        System.out.println(cartText);
        System.out.println((cartText.equals("My Cart (0)"))?"PASS":"FAIL");
        driver.findElement(By.xpath("//a[@class='checkout']")).click();
        System.out.println("on cart page: "+(driver.getCurrentUrl().contains("/cart")));
        driver.findElement(By.xpath("//a[@class='toggle-drawer cart desktop ']")).click();
        String emptyCart = driver.findElement(By.xpath("//p[@class='empty']")).getText();
        System.out.println("Empty cart text: "+emptyCart);
        driver.navigate().back();
        String loginHref = driver.findElement(By.linkText("Log In")).getAttribute("href");
        System.out.println("Log in href: "+loginHref);
        String originalWindow = driver.getWindowHandle();
        driver.switchTo().newWindow(WindowType.WINDOW).get(Main.baseUrl);
        driver.findElement(By.linkText("About Us")).click();
        driver.close();
        driver.switchTo().window(originalWindow);
        System.out.println((driver.getTitle().equals("Your Shopping Cart – Sauce Demo"))?"PASS":"FAIL");
        System.out.println("=== Task 6 Completed ===");


    }
}
