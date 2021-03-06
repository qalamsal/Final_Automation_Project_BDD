package Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.util.Properties;


    public class BasePage {
        public static WebDriver wd;
        public static Properties prop;

        //CONSTRUCTOR
        public BasePage() {
            try{
                prop=new Properties();
                FileInputStream ip=new FileInputStream("src/test/java/config/config.properties");
                prop.load(ip);
            }
            catch (Exception e){
                System.out.println(e.getMessage());
            }
        }

        //page initiatlization method
        public void initialization(){
            String browsername=prop.getProperty("browser"); //reading from
            if(browsername.equals("chrome")){
                System.setProperty("webdriver.chrome.driver","chromedriver.exe");
                wd=new ChromeDriver();
            }
            wd.manage().window().maximize();
            wd.get("http://automationpractice.itsutra.com/");
        }
    }
