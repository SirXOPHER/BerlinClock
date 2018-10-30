import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class ShowTimeOnBerlinClockFeature {

    @Test
    void should_convert_digital_time_into_berlin_clock_time() {
        BerlinClock berlinClock = new BerlinClock();
        String digitalTime = "10:13:00";


        String berlinClockTime = berlinClock.convert(digitalTime);


        String expectedBerlinClockTime =
                        "                 * *\n" +
                        "               *     *\n" +
                        "              *   Y   *\n" +
                        "               *     *\n" +
                        "                 * *\n" +
                        " ╔═══════╗╔═══════╗╔═══════╗╔═══════╗\n" +
                        " ║   R   ║║   R   ║║   O   ║║   O   ║\n" +
                        " ╚═══════╝╚═══════╝╚═══════╝╚═══════╝\n" +
                        " ╔═══════╗╔═══════╗╔═══════╗╔═══════╗\n" +
                        " ║   O   ║║   O   ║║   O   ║║   O   ║\n" +
                        " ╚═══════╝╚═══════╝╚═══════╝╚═══════╝\n" +
                        " ╔═╗╔═╗╔═╗ ╔═╗╔═╗╔═╗ ╔═╗╔═╗╔═╗ ╔═╗╔═╗\n" +
                        " ║Y║║Y║║O║ ║O║║O║║O║ ║O║║O║║O║ ║O║║O║\n" +
                        " ╚═╝╚═╝╚═╝ ╚═╝╚═╝╚═╝ ╚═╝╚═╝╚═╝ ╚═╝╚═╝\n" +
                        " ╔═══════╗╔═══════╗╔═══════╗╔═══════╗\n" +
                        " ║   Y   ║║   Y   ║║   Y   ║║   O   ║\n" +
                        " ╚═══════╝╚═══════╝╚═══════╝╚═══════╝";
        assertThat(berlinClockTime, is(equalTo(expectedBerlinClockTime)));
    }

    @Test
    void should_convert_another_digital_time_into_berlin_clock_time() {
        BerlinClock berlinClock = new BerlinClock();
        String digitalTime = "10:13:23";


        String berlinClockTime = berlinClock.convert(digitalTime);


        String expectedBerlinClockTime =
                        "                 * *\n" +
                        "               *     *\n" +
                        "              *   O   *\n" +
                        "               *     *\n" +
                        "                 * *\n" +
                        " ╔═══════╗╔═══════╗╔═══════╗╔═══════╗\n" +
                        " ║   R   ║║   R   ║║   O   ║║   O   ║\n" +
                        " ╚═══════╝╚═══════╝╚═══════╝╚═══════╝\n" +
                        " ╔═══════╗╔═══════╗╔═══════╗╔═══════╗\n" +
                        " ║   O   ║║   O   ║║   O   ║║   O   ║\n" +
                        " ╚═══════╝╚═══════╝╚═══════╝╚═══════╝\n" +
                        " ╔═╗╔═╗╔═╗ ╔═╗╔═╗╔═╗ ╔═╗╔═╗╔═╗ ╔═╗╔═╗\n" +
                        " ║Y║║Y║║O║ ║O║║O║║O║ ║O║║O║║O║ ║O║║O║\n" +
                        " ╚═╝╚═╝╚═╝ ╚═╝╚═╝╚═╝ ╚═╝╚═╝╚═╝ ╚═╝╚═╝\n" +
                        " ╔═══════╗╔═══════╗╔═══════╗╔═══════╗\n" +
                        " ║   Y   ║║   Y   ║║   Y   ║║   O   ║\n" +
                        " ╚═══════╝╚═══════╝╚═══════╝╚═══════╝";
        assertThat(berlinClockTime, is(equalTo(expectedBerlinClockTime)));
    }
}
