package com.twitch.test;

import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

public class Drivers {

    public static RemoteWebDriver DRIVER;


    private static String getDriverName(){
        String browserName = System.getProperty("browser", "chrome");
        return browserName;
    }



    public static void startDriver(){
        switch (getDriverName().toLowerCase()){
            case "chrome":
                System.setProperty("webdriver.chrome.driver", "C:\\Users\\huber\\Desktop\\Testy, programy itp\\Selenium\\drivers\\chromedriver.exe");
                DRIVER = new ChromeDriver();
                break;
            case "firefox":
                System.setProperty("webdriver.gecko.driver", "C:\\Users\\huber\\Desktop\\Testy, programy itp\\Selenium\\drivers\\geckodriver.exe");
                DRIVER = new FirefoxDriver();
                break;
            default:
                throw new IllegalStateException("Unsupported driver - cannot start browser");
        }


        DRIVER.manage().window().maximize();
    }

    public static void destroyDriver(){

        DRIVER.quit();
    }


    private static void embedScreenshot(Scenario scenario){
        byte[] screenshot = DRIVER.getScreenshotAs(OutputType.BYTES);
        scenario.attach(screenshot, "image/png", "screenshot");
    }


    private static void saveScreenshotFile(Scenario scenario) throws IOException {
        File srcFile = ((TakesScreenshot) DRIVER).getScreenshotAs(OutputType.FILE);
        String currentPath = Paths.get(".").toAbsolutePath().normalize().toString();
        FileUtils.copyFile(srcFile, new File(currentPath + "/screenshots/" + scenario.getName() + ".png"));

    }


    public static void processExecutedScenario(Scenario scenario) throws IOException {
        if(scenario.isFailed() && DRIVER != null){
            embedScreenshot(scenario);
            saveScreenshotFile(scenario);
        }
        destroyDriver();
    }


}
