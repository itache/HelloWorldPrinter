import org.apache.log4j.Logger;

import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Locale;

/**
 * Application prints on console localized greeting message fitted to current time.
 */
public class Application {
    private static final Logger logger = Logger.getLogger(Application.class);

    public static void main(String[] args) {
        try {
            logger.trace("Application starts");
            Locale locale = Locale.getDefault();
            ZoneId zone = ZoneId.systemDefault();
            LocalTime time = LocalTime.now(zone);
            System.out.println(HelloWorldMessager.getMessage(time, locale));
        } catch (Exception ex) {
            logger.error("Error occurred", ex);
            System.out.println("Internal error. Sorry");
        }
    }
}
