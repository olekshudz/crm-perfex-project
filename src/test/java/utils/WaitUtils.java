package utils;

import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitUtils {

    private static WebDriverWait wait;

    static {
        wait = new WebDriverWait(DriverHelper.getDriver(), Duration.ofSeconds(30));
    }

    public static WebDriverWait getWait() {
        return wait;
    }
}
