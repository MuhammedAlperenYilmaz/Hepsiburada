package Hepsiburada;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.time.Duration;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class Hepsiburada {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver();
        WebDriver driver= new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Actions actions = new Actions(driver);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.hepsiburada.com/");
        driver.manage().window().maximize();
        WebElement popup=driver.findElement(By.xpath("//button[@id='onetrust-accept-btn-handler']"));
        popup.click();

         List<WebElement> menuElements = driver.findElements(By.xpath("//li[@class='sf-MenuItems-WulWXvlfIAwNiOUGY7FP']"));
        int indexToClick = 5;
        menuElements.get(indexToClick - 1).click();
        WebElement thermomethers=driver.findElement(By.className("item-1169"));
        actions.moveToElement(thermomethers).build().perform();
        thermomethers.click();
        WebElement sortBy=driver.findElement(By.xpath("//label[@class='horizontalSortingBar-Ce404X9mUYVCRa5bjV4D']"));
        sortBy.click();
        List<WebElement> sortElements = driver.findElements(By.xpath("//a[@class='horizontalSortingBar-wxPx75gvwcKxOM8rMngA']"));
        int indexToClick2 = 7;
        sortElements.get(indexToClick2 - 1).click();

        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.id("i12")));
        element.click(); 
        
        

        String mainWindow = driver.getWindowHandle();
        Set<String> allWindows = driver.getWindowHandles();
        for (String window : allWindows) {
            if (!window.equalsIgnoreCase(mainWindow)) {
                // Yeni sekmenin referansını saklayın ve o sekmeye geçiş yapın
                driver.switchTo().window(window);
                break;
            }
        }
        WebElement addToBasket=driver.findElement(By.xpath("//button[@id='addToCart']"));
        addToBasket.click();

        
        WebElement goingOnShopping=driver.findElement(By.xpath("//button[@kind='secondary']"));
        goingOnShopping.click();
        WebElement Basket=driver.findElement(By.id("shoppingCart"));
        Basket.click();

        WebElement amount=driver.findElement(By.xpath("//input[@type='number']"));
         amount.sendKeys(Keys.CONTROL+"a");
        amount.sendKeys(Keys.DELETE);     
        amount.sendKeys("100");
        amount.click();

        WebElement sendToTrash=driver.findElement(By.className("trash_button_3KWju"));
        sendToTrash.click();
        driver.close();
        driver.manage().window().minimize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().getCookies();
        driver.navigate().back();
        driver.manage().addCookie();


//

        
     
    
}
    }
