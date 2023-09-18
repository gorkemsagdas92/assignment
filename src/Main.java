import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.List;


    public class Main {

        public static void main(String[] args) {

        // web driver setted
        System.setProperty("webdriver.gecko.driver","C:\\geckodriver.exe");
        WebDriver driver = new ChromeDriver();
        System.setProperty("webdriver.chrome.driver","G:\\chromedriver.exe");
        driver.manage().window().maximize();

        // techcrunch.com site is setted as a default web site
        String baseUrl = "https://techcrunch.com";
        driver.get(baseUrl);

        //@Test

            // Latest News are checked
        List<WebElement> tagElements1 = driver.findElements(By.xpath("//a[text()='The Latest - Home']"));

        for (WebElement tagElement1 : tagElements1) {

            // authors of "latest news" are checked
            WebElement authorsElement = tagElement1.findElement(By.xpath("../..//div[@class='river-byline__authors']"));

            // finding of emptu authors News
            String authorsText = authorsElement.getText().trim();


            //displaying test results for authors' data
            if (authorsText.isEmpty())
                System.out.println("Fail: Author is empty for");

            else
                System.out.println("Pass: Authors");
        }
            //@Test

            // Latest News are checked
            List<WebElement> tagElements2 = driver.findElements(By.xpath("//a[text()='The Latest - Home']"));

            for (WebElement tagElement2 : tagElements2) {

                // images of "latest news" are checked
                WebElement imageElement = tagElement2.findElement(By.xpath("../..//div[@class='post-block__media']"));

                // finding of empty image News
                String imageText = imageElement.getText().trim();

                //displaying test results for images data
                if (imageText.isEmpty())
                    System.out.println("Fail: Image is empty for");

                else
                    System.out.println("Pass: Image");

        }
        //@Test

            //clicking the latest News
        WebElement element = driver.findElement(By.cssSelector("[cmp-ltrk-idx='0']"));
        element.click();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        // checking the website title is the same with article
        String pageTitle = driver.getTitle();
        WebElement articleTitleElement = driver.findElement(By.className("article__title"));
        String elementText = articleTitleElement.getText();

        //displaying the test result for title check
        if (pageTitle.equals(elementText)) {
            System.out.println("Pass: Title is the same");
        } else {
            System.out.println("Fail: Wrong Title");
        }

       // @Test

            //checking the Links on the page is OK
        List<WebElement> links = driver.findElements(By.tagName("a"));


        // clicking the the links which is located on the screen
        for (WebElement link : links) {
            link.click();
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // getting the current URL for the current Page
            String currentUrl = driver.getCurrentUrl();


            //Verifying the current link is directed to another page
            if (!currentUrl.equals("https://techcrunch.com/techcrunchplus/?tpcc=ecleftnav")) {
                System.out.println("Pass: " + currentUrl);
            } else {
                System.out.println("Fail: " + link.getAttribute("href"));
            }

            //get back to main screen
            driver.navigate().back();
        }

        //closing the driver.
        driver.close();
}}