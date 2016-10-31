import org.junit.Assert;
import org.junit.Test;

import java.time.LocalTime;
import java.util.Locale;

public class HelloWorldMessagerTest {

    @Test
    public void shouldResolveMorningPeriodOnLowerBound() {
        Assert.assertEquals(
                HelloWorldMessager.Period.MORNING,
                HelloWorldMessager.determinePeriod(LocalTime.of(6, 1))
        );
    }

    @Test
    public void shouldResolveDayPeriodOnLowerBound() {
        Assert.assertEquals(
                HelloWorldMessager.Period.DAY,
                HelloWorldMessager.determinePeriod(LocalTime.of(9, 1))
        );
    }

    @Test
    public void shouldResolveEveningPeriodOnLowerBound() {
        Assert.assertEquals(
                HelloWorldMessager.Period.EVENING,
                HelloWorldMessager.determinePeriod(LocalTime.of(19, 1))
        );
    }

    @Test
    public void shouldResolveNightPeriodOnLowerBound() {
        Assert.assertEquals(
                HelloWorldMessager.Period.NIGHT,
                HelloWorldMessager.determinePeriod(LocalTime.of(23, 1))
        );
    }

    @Test
    public void shouldResolveMorningPeriodOnUpperBound() {
        Assert.assertEquals(
                HelloWorldMessager.Period.MORNING,
                HelloWorldMessager.determinePeriod(LocalTime.of(9, 0))
        );
    }

    @Test
    public void shouldResolveDayPeriodOnUpperBound() {
        Assert.assertEquals(
                HelloWorldMessager.Period.DAY,
                HelloWorldMessager.determinePeriod(LocalTime.of(19, 0))
        );
    }

    @Test
    public void shouldResolveEveningPeriodOnUpperBound() {
        Assert.assertEquals(
                HelloWorldMessager.Period.EVENING,
                HelloWorldMessager.determinePeriod(LocalTime.of(23, 0))
        );
    }

    @Test
    public void shouldResolveNightPeriodOnUpperBound() {
        Assert.assertEquals(
                HelloWorldMessager.Period.NIGHT,
                HelloWorldMessager.determinePeriod(LocalTime.of(6, 0))
        );
    }

    @Test
    public void shouldGetEnMorningGreetingString() {
        Assert.assertEquals(
                "Good morning, World!",
                HelloWorldMessager.getMessage(LocalTime.of(7, 0), Locale.ENGLISH)
        );
    }

    @Test
    public void shouldGetEnDayGreetingString() {
        Assert.assertEquals(
                "Good day, World!",
                HelloWorldMessager.getMessage(LocalTime.of(17, 0), Locale.ENGLISH)
        );
    }

    @Test
    public void shouldGetRusEveningGreetingString() {
        Assert.assertEquals(
                "Добрый вечер, Мир!",
                HelloWorldMessager.getMessage(LocalTime.of(21, 0), Locale.forLanguageTag("ru"))
        );
    }

    @Test
    public void shouldGetRusNightGreetingString() {
        Assert.assertEquals(
                "Доброй ночи, Мир!",
                HelloWorldMessager.getMessage(LocalTime.of(2, 0), Locale.forLanguageTag("ru"))
        );
    }
}
