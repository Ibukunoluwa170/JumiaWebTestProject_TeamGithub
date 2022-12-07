import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class JumiaWebTest {
    //import Jumia webdriver
    private WebDriver driver;
@BeforeTest
public void start() throws InterruptedException {
    //Test1: locate where the chrome driver is
    System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
    //open Chrome browser
    driver = new ChromeDriver();
}
@Test(priority = 0)
public void getUrl() throws InterruptedException {
    //Open your selected app URL (https://www.jumia.com.ng)
    driver.get("https://www.jumia.com.ng/");
    if (driver.getCurrentUrl().contains("https://www.jumia.com.ng/"))
        //pass
        System.out.println("Correct webPage");
    else
        //fail
        System.out.println("Wrong webPage");
    //Add delay command before loading the next page
    Thread.sleep(5000);
}
@Test(priority = 1)
public void getPageTitle() throws InterruptedException {
    //Test2: Confirm the page title
    String expectedTittle = "Jumia Nigeria|Online Shopping";
    String actualTitle = driver.getTitle();
    if (actualTitle.contains(expectedTittle))
        //pass
        System.out.println("correct pageTitle");
    else
        //fail
        System.out.println("wrong pageTitle");
    // Maximize the window
    driver.manage().window().maximize();
    //Added delay command before loading the next page
    Thread.sleep(5000);
}
@Test(priority = 2)
public void signIN()throws InterruptedException {
    // Click on Account to locate the sign-in button
    driver.findElement(By.xpath("/html/body/div[1]/header/section/div[2]/div[1]/label")).click();
    //Click on the sign-in
    driver.findElement(By.xpath("//*[@id=\"dpdw-login-box\"]/div/div/a")).click();
    //Added delay command before loading the next page
    Thread.sleep(2000);
    //Test3: Confirm that user was redirected to the correct signIn page
    driver.getCurrentUrl();
    if (driver.getCurrentUrl().contains("https://my.jumia.com.ng/interaction/0_NwRHRb6rpJYrDmx836O/en-ng/sign-in/email"))
        //pass
        System.out.println("Correct signInPage");
    else
        //fail
        System.out.println("wrong signIn Page");
}
@Test(priority = 3)
public void positiveSignIn()throws InterruptedException {
    //Input your Email
    driver.findElement(By.xpath("/html/body/div/div[4]/form/div[2]/div[2]/label/input")).sendKeys("davidadebanke@gmail.com");
    //Click on continue button
    driver.findElement(By.xpath("/html/body/div/div[4]/form/div[2]/div[3]/div/button/span[3]")).click();
    //Input your Password
    driver.findElement(By.xpath("//*[@id=\"passwordForm\"]/div[2]/div[3]/label/input")).sendKeys("banksdavid");
    //Click on login button
    driver.findElement(By.xpath("//*[@id=\"loginButton\"]/span[3]")).click();
    //Test4: Verify that when user was redirected to the homePage after signIn
    driver.getCurrentUrl();
    if (driver.getCurrentUrl().contains("https://www.jumia.com./"))
        //pass
        System.out.println("Hi,Adebanke");
    else
        //fail
        System.out.println("Invalid signIn");
//Added delay command before loading the next page
    Thread.sleep(2000);
}
    @Test(priority = 4)
 public void LogoutSuccessfully()throws InterruptedException{
    //click on the name header label
    driver.findElement(By.xpath("//*[@id=\"jm\"]/header/section/div[2]/div[1]/label")).click();
    //Click on logout
    driver.findElement(By.xpath("//*[@id=\"dpdw-login-box\"]/div/form/button")).click();
    //Added delay command before loading the next page
    Thread.sleep(2000);
        //Test5: Verify that when user logout, he/she is directed back to the homepage
        String expectedTittle = "Jumia Nigeria|Online Shopping";
        String actualTittle = driver.getTitle();
        if (actualTittle.contains(expectedTittle))
            //pass
            System.out.println("correct pageTitle");
        else
            //fail
            System.out.println("wrong pageTitle");
}
@Test(priority = 5)
public void negativeSignInEmail() throws InterruptedException {
    //Test6: Verify that user can not sigIn with invalid Email Address
    driver.get("https://www.jumia.com.ng/");
    // Click on Account to locate the sign-in button
    driver.findElement(By.xpath("/html/body/div[1]/header/section/div[2]/div[1]/label")).click();
    //Click on the sign-in
    driver.findElement(By.xpath("//*[@id=\"dpdw-login-box\"]/div/div/a")).click();
    Thread.sleep(5000);
    //Input your Email
    driver.findElement(By.xpath("/html/body/div/div[4]/form/div[2]/div[2]/label/input")).sendKeys("1234@gmail.com");
    //click on continue button
    driver.findElement(By.xpath("/html/body/div/div[4]/form/div[2]/div[3]/div/button/span[3]")).click();
    //Input your password
    driver.findElement(By.xpath("//*[@id=\"passwordForm\"]/div[2]/div[3]/label/input")).sendKeys("banksdavid");
    //click on login button
    driver.findElement(By.xpath("//*[@id=\"loginButton\"]/span[3]")).click();
}
@Test(priority = 5)
public void negativeSignInPassword() throws InterruptedException {
    //Test6: Verify that user can not sigIn with invalid Password
    driver.get("https://www.jumia.com.ng/");
    // Click on Account to locate the sign-in button
    driver.findElement(By.xpath("/html/body/div[1]/header/section/div[2]/div[1]/label")).click();
    //Click on the sign-in
    driver.findElement(By.xpath("//*[@id=\"dpdw-login-box\"]/div/div/a")).click();
    Thread.sleep(5000);
    //Input your Email
    driver.findElement(By.xpath("/html/body/div/div[4]/form/div[2]/div[2]/label/input")).sendKeys("davidadebanke@gmail.com");
    //click on continue button
    driver.findElement(By.xpath("/html/body/div/div[4]/form/div[2]/div[3]/div/button/span[3]")).click();
    //Input your password
    driver.findElement(By.xpath("//*[@id=\"passwordForm\"]/div[2]/div[3]/label/input")).sendKeys("banks");
    //click on login button
    driver.findElement(By.xpath("//*[@id=\"loginButton\"]/span[3]")).click();
}

@AfterTest
    public void closeBrowser(){
    //quite the browser
    driver.quit();
}

}






