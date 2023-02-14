package utils;

import org.openqa.selenium.remote.DesiredCapabilities;


import java.io.FileInputStream;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class TestProperties {

    private static Properties props = new Properties();
    private static String propsPath = "src/main/resources/config.properties";
    private static DesiredCapabilities desiredCapabilities = new DesiredCapabilities();


    private static void loadProperties() {
        try ( InputStream input = new FileInputStream(propsPath)){
            props.load(input);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static DesiredCapabilities setDesiredCapabilities() {
        loadProperties();
        desiredCapabilities.setCapability("platformName", props.getProperty("platformName"));
        desiredCapabilities.setCapability("appium:automationName", props.getProperty("automationName"));
        desiredCapabilities.setCapability("appium:appPackage", props.getProperty("appPackage"));
        desiredCapabilities.setCapability("appium:appActivity", props.getProperty("appActivity"));
        desiredCapabilities.setCapability("appium:noReset", props.getProperty("noReset"));
        return desiredCapabilities;
    }


    public static String getProperty(String name){return props.getProperty(name);}
}

