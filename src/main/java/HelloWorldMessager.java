import org.apache.log4j.Logger;

import java.time.LocalTime;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;


public class HelloWorldMessager {
    private static final Logger logger = Logger.getLogger(HelloWorldMessager.class);
    private static final String SOURCE = "messages";

    /**
     * Utility class has no constructors
     */
    private HelloWorldMessager() {
    }

    /**
     * Returns localized greeting fitted to input time.
     *
     * @throws NullPointerException if time or locale is null
     * @throws MissingResourceException if no resource bundle with messages can be found
     * @return greeting message
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
        if( hours >= 6 && hours < 10) {
            return Period.MORNING;
        } else if(hours >= 10 && hours < 19) {
            return Period.DAY;
        } else if(hours >= 19 && hours < 22) {
            return Period.EVENING;
        }else {
            return Period.NIGHT;
        }

    }

    /**
     * Contains periods of the day
     */
    enum Period {
        MORNING, DAY, EVENING, NIGHT;
    }
}
