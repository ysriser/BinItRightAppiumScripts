package utils;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;

import java.time.Duration;
import java.util.Collections;

public class ScrollUtil {

    public static void scrollDown(AndroidDriver driver) {

        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence swipe = new Sequence(finger, 1);

        swipe.addAction(finger.createPointerMove(
                Duration.ZERO,
                PointerInput.Origin.viewport(),
                500, 1600));

        swipe.addAction(finger.createPointerDown(0));

        swipe.addAction(finger.createPointerMove(
                Duration.ofMillis(700),
                PointerInput.Origin.viewport(),
                500, 600));

        swipe.addAction(finger.createPointerUp(0));

        driver.perform(Collections.singletonList(swipe));
    }
}

