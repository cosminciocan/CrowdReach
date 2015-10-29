package webdriver;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


public class Driver {

    private static WebDriver driver;
    private static String browser;
    private static String environment;
    private static Properties config;
    private static String tags;

    public static void initWebdriver() {
        try {
            browser = System.getProperty("browser").toLowerCase();
        } catch (NullPointerException e) {
            System.out.println("No browser specified in the command line, using [CHROME] by default");
            browser = "chrome";  // Set the run browser
        }
        switch (browser) {
            case "firefox":
                FirefoxProfile profile = new FirefoxProfile();
                profile.setAcceptUntrustedCertificates(true);
                profile.setPreference("plugin.state.flash", 0);
                driver = new FirefoxDriver(profile);
                break;
            case "chrome":
                System.setProperty("webdriver.chrome.driver", "chromeDriver\\chromedriver.exe");
                driver = new ChromeDriver();
                break;
            case "ie":
                driver = new InternetExplorerDriver();
                break;
            default:
                System.out.println("Unsupported browser specified: " + browser + ". Using Firefox by default.");
                driver = new FirefoxDriver();
                break;
        }
        // driver.manage().window().setSize(new Dimension(1200, 800));
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        System.out.format("Starting browser [%s]\n", browser.toUpperCase());

        Runtime.getRuntime().addShutdownHook(new Thread() {
            public void run() {
                System.out.println("Closing browser");
                driver.quit();
            }
        });
    }

    public static WebDriver getWebdriver() {
        if (driver == null)
            initWebdriver();
        return driver;
    }

    public static void initConfig() {
        config = new Properties();
        InputStream stream;

        try {
            environment = System.getProperty("env").toLowerCase();
        } catch (NullPointerException e) {
            System.out.println("No environment specified in the command line. Using [local] by default.");
            environment = "stage"; // Set the run properties file
        }
        try {
            stream = new FileInputStream("src/main/resources/" + environment + ".properties");
            config.load(stream);
            System.out.println("Using [" + environment + "] environment.");
        } catch (IOException e) {
            Assert.fail("Invalid << env >> parameter");
            e.printStackTrace();
        }
    }

    public static Properties config() {
        if (config == null)
            initConfig();
        return config;
    }
}
