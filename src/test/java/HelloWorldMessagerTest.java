import org.junit.Assert;
import org.junit.Test;

import java.time.LocalTime;
import java.util.Locale;

public class HelloWorldMessagerTest {

    @Test
    public void shouldResolveMorningPeriod() {
        Assert.assertEquals(
                HelloWorldMessager.Period.MORNING,
                HelloWorldMessager.determinePeriod(LocalTime.of(6, 34))
        );
    }

    @Test
    public void shouldResolveDayPeriod() {
        Assert.assertEquals(
                HelloWorldMessager.Period.DAY,
                HelloWorldMessager.determinePeriod(LocalTime.of(13, 59))
        );
    }

    @Test
    public void shouldResolveEveningPeriod() {
        Assert.assertEquals(
                HelloWorldMessager.Period.EVENING,
                HelloWorldMessager.determinePeriod(LocalTime.of(19, 25))
        );
    }

    @Test
    public void shouldResolveNightPeriod() {
        Assert.assertEquals(
                HelloWorldMessager.Period.NIGHT,
                HelloWorldMessager.determinePeriod(LocalTime.of(0, 56))
        );
    }

    @Test
    public void shouldGetEnMorningGreetingString() {
        Assert.assertEquals(
                "Good morning, World!",
                HelloWorldMessager.getMessage(LocalTime.of(7, 44), Locale.ENGLISH)
        );
    }

    @Test
    public void shouldGetEnDayGreetingString() {
        Assert.assertEquals(
                "Good day, World!",
                HelloWorldMessager.getMessage(LocalTime.of(17, 44), Locale.ENGLISH)
        );
    }

    @Test
    public void shouldGetRusEveningGreetingString() {
        Assert.assertEquals(
                "Добрый вечер, Мир!",
                HelloWorldMessager.getMessage(LocalTime.of(19, 44), Locale.forLanguageTag("ru"))
        );
    }

    @Test
    public void shouldGetRusNightGreetingString() {
        Assert.assertEquals(
                "Доброй ночи, Мир!",
                HelloWorldMessager.getMessage(LocalTime.of(23, 44), Locale.forLanguageTag("ru"))
        );
    }
}
