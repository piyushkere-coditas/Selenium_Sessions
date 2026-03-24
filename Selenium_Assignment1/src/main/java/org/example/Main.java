package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import testMethods.Methods;

import java.time.Duration;


public class Main{

    public static WebDriver driver;
    public static String baseUrl = "https://sauce-demo.myshopify.com";

    public static void main(String[] args) {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        Methods.HomePageValidation();
        Methods.NavigateToAboutUs();
        Methods.CatalogAndProduct();
        Methods.ProductDetailPage();
        Methods.BrowserNavigation();
        Methods.Task6();
    }
}