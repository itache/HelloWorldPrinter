import org.apache.log4j.Logger;

import java.time.LocalTime;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;


public class HelloWorldMessager {
    private static final Logger logger = Logger.getLogger(HelloWorldMessager.class);
    private static final String SOURCE = "messages";

    private static final int MORNING_START_HOUR = 6;
    private static final int DAY_START_HOUR = 9;
    private static final int EVENING_START_HOUR = 19;
    private static final int NIGHT_START_HOUR = 23;

    /**
     * Utility class has no constructors
     */
    private HelloWorldMessager() {
    }

    /**
     * Returns localized greeting fitted to input time.
     *
     * @return greeting message
     * @throws NullPointerException     if time or locale is null
     * @throws MissingResourceException if no resource bundle with messages can be found
     */
    public static String getMessage(LocalTime time, Locale locale) {
        logger.trace(String.format("Input parameters: time = %tR, locale = %s", time, locale));
        Period period = determinePeriod(time);
        logger.trace("Period resolved: " + period);
        ResourceBundle bundle = ResourceBundle.getBundle(SOURCE, locale);
        String message = bundle.getString(period.toString().toLowerCase());
        logger.trace("Message received: " + message);
        return message;
    }

    /**
     * Determines the period of the day by time.
     *
     * @param time time to determine
     * @return determined period
     */
    static Period determinePeriod(LocalTime time) {
        int hours = time.getHour();
        if (hours >= NIGHT_START_HOUR || hours < MORNING_START_HOUR) {
            return Period.NIGHT;
        }
        if (hours >= EVENING_START_HOUR) {
            return Period.EVENING;
        }
        if (hours >= DAY_START_HOUR) {
            return Period.DAY;
        }
        return Period.MORNING;
    }

    /**
     * Contains periods of the day
     */
    enum Period {
        MORNING, DAY, EVENING, NIGHT;
    }
}
