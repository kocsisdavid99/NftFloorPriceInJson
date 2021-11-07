import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        while (true){

            //Metabaes
            getDoPush("https://solanart.io/collections/metabaes", "//*[@id=\"root\"]/div[1]/div/div/div/div/div/div[1]/div[5]/div[2]/span/div/button[3]/span[1]/div/span", "metabaes", null, true, 4, false);
            //Eternal Beings
            getDoPush("https://solanart.io/collections/eternalbeings", "//*[@id=\"root\"]/div[1]/div/div/div/div/div/div[1]/div[5]/div[2]/span/div/button[3]/span[1]/div/span", "eternal_beings", null, true, 4, false);
            //Churro
            getDoPush("https://pancakeswap.finance/nfts/collections/0xDf7952B35f24aCF7fC0487D01c8d5690a60DBa07/8", "//*[@id=\"root\"]/div[1]/div[2]/div/div[1]/div[1]/div/div/div/div[1]/div/div[4]/div[1]", "churro", null, false, 0, false);
            //Cakeston Easter '21
            getDoPush("https://pancakeswap.finance/nfts/collections/0xDf7952B35f24aCF7fC0487D01c8d5690a60DBa07/14", "//*[@id=\"root\"]/div[1]/div[2]/div/div[1]/div[1]/div/div/div/div[1]/div/div[4]/div[1]", "cakeston_easter_21", null, false, 0, false);
            //Syrup Soak
            getDoPush("https://pancakeswap.finance/nfts/collections/0xDf7952B35f24aCF7fC0487D01c8d5690a60DBa07/16", "//*[@id=\"root\"]/div[1]/div[2]/div/div[1]/div[1]/div/div/div/div[1]/div/div[4]/div[1]", "syrup_soak", null, false, 0, false);
            //Lottie
            getDoPush("https://pancakeswap.finance/nfts/collections/0xDf7952B35f24aCF7fC0487D01c8d5690a60DBa07/18", "//*[@id=\"root\"]/div[1]/div[2]/div/div[1]/div[1]/div/div/div/div[1]/div/div[4]/div[1]", "lottie", null, false, 0, false);
            //LandPass #1
            getDoPush("https://opensea.io/assets/0xb5f7d50defe738f7c73bf965cd369ac15fa77de9/0", null, "landpass_#1", ".Price--amount", false, 0, true);


            Thread.sleep(300*1000);

        }




    }

    public static void getDoPush(String url, String xpath, String name, String cssSelector, Boolean needCut, int cutFromEnd, Boolean alreadyComma){

        String price = null;
        String date = null;

        try{
            ChromeDriver driver = null;
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            String useragent = "Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/84.0.4147.125 Safari/537.36";
            options.addArguments("--headless", "--disable-gpu", "--window-size=1920,1200", "--ignore-certificate-errors", "--log-level=3", "--no-sandbox", "--disable-dev-shm-usage", "--enable-javascript", "--user-agent=Mozilla/5.0 (Linux; Android 6.0; HTC One M9 Build/MRA58K) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/52.0.2743.98 Mobile Safari/537.36");
            driver = new ChromeDriver(options);
            Waiter.setDriver(driver);
            driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);

            driver.get(url);

            Thread.sleep(5000);

//            File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//            FileUtils.copyFile(scrFile, new File("c:\\tmp\\screenshot.png"));

            if (xpath!=null){
                price = driver.findElement(By.xpath(xpath)).getText();

            }else{
                price = driver.findElement(By.cssSelector(cssSelector)).getText();

            }

            if (needCut){

                price = price.substring(0, cutFromEnd);

            }

            if (!alreadyComma){

                price = price.replace(".", ",");

            }


            System.out.println(name + " " +price);


            driver.quit();

        }catch (Exception e){
            System.out.println(e);
        }

        String pattern = "yyyy-MM-dd HH:mm:ss";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        date = simpleDateFormat.format(new Date());

        try {

            String myDriver = "org.gjt.mm.mysql.Driver";
            String myUrl = "jdbc:mysql://127.0.0.1/nft";
            Class.forName(myDriver);
            Connection conn = DriverManager.getConnection(myUrl, "root", "root");

            Statement st = conn.createStatement();

            st.executeUpdate("UPDATE floor_price SET price='"+price+"' WHERE name='"+name+"'");
            st.executeUpdate("UPDATE floor_price SET date='"+date+"' WHERE name='"+name+"'");

            conn.close();

        }catch (Exception e){
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
        }

    }

}
