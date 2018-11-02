import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class ShowTimeOnBerlinClockFeature {

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
    void should_convert_digital_seconds_into_berlin_clock_time() {
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

    @DisplayName("should convert digital hours with different top hours row in berlin clock time")
    @ParameterizedTest(name = "{0} (for digital time: {1})")
    @MethodSource("digitalTimesWithDifferentTopHoursRowInBerlinClockTime")
    void should_convert_digital_hours_with_different_top_hours_row_in_berlin_clock_time(String description, String digitalTime, String expectedBerlinClockTime) {
        BerlinClock berlinClock = new BerlinClock();

        String berlinClockTime = berlinClock.convert(digitalTime);

        assertThat(berlinClockTime, is(equalTo(expectedBerlinClockTime)));
    }

    private static Stream<Arguments> digitalTimesWithDifferentTopHoursRowInBerlinClockTime() {
        return Stream.of(
                arguments("no top row lamps on for digital hours equal 0", "00:13:23", "" +
                        "                 * *\n" +
                        "               *     *\n" +
                        "              *   O   *\n" +
                        "               *     *\n" +
                        "                 * *\n" +
                        " ╔═══════╗╔═══════╗╔═══════╗╔═══════╗\n" +
                        " ║   O   ║║   O   ║║   O   ║║   O   ║\n" +
                        " ╚═══════╝╚═══════╝╚═══════╝╚═══════╝\n" +
                        " ╔═══════╗╔═══════╗╔═══════╗╔═══════╗\n" +
                        " ║   O   ║║   O   ║║   O   ║║   O   ║\n" +
                        " ╚═══════╝╚═══════╝╚═══════╝╚═══════╝\n" +
                        " ╔═╗╔═╗╔═╗ ╔═╗╔═╗╔═╗ ╔═╗╔═╗╔═╗ ╔═╗╔═╗\n" +
                        " ║Y║║Y║║O║ ║O║║O║║O║ ║O║║O║║O║ ║O║║O║\n" +
                        " ╚═╝╚═╝╚═╝ ╚═╝╚═╝╚═╝ ╚═╝╚═╝╚═╝ ╚═╝╚═╝\n" +
                        " ╔═══════╗╔═══════╗╔═══════╗╔═══════╗\n" +
                        " ║   Y   ║║   Y   ║║   Y   ║║   O   ║\n" +
                        " ╚═══════╝╚═══════╝╚═══════╝╚═══════╝"),
                arguments("first lamp of top hours row on for digital hours equal 5", "05:13:23", "" +
                        "                 * *\n" +
                        "               *     *\n" +
                        "              *   O   *\n" +
                        "               *     *\n" +
                        "                 * *\n" +
                        " ╔═══════╗╔═══════╗╔═══════╗╔═══════╗\n" +
                        " ║   R   ║║   O   ║║   O   ║║   O   ║\n" +
                        " ╚═══════╝╚═══════╝╚═══════╝╚═══════╝\n" +
                        " ╔═══════╗╔═══════╗╔═══════╗╔═══════╗\n" +
                        " ║   O   ║║   O   ║║   O   ║║   O   ║\n" +
                        " ╚═══════╝╚═══════╝╚═══════╝╚═══════╝\n" +
                        " ╔═╗╔═╗╔═╗ ╔═╗╔═╗╔═╗ ╔═╗╔═╗╔═╗ ╔═╗╔═╗\n" +
                        " ║Y║║Y║║O║ ║O║║O║║O║ ║O║║O║║O║ ║O║║O║\n" +
                        " ╚═╝╚═╝╚═╝ ╚═╝╚═╝╚═╝ ╚═╝╚═╝╚═╝ ╚═╝╚═╝\n" +
                        " ╔═══════╗╔═══════╗╔═══════╗╔═══════╗\n" +
                        " ║   Y   ║║   Y   ║║   Y   ║║   O   ║\n" +
                        " ╚═══════╝╚═══════╝╚═══════╝╚═══════╝"),
                arguments("first lamp of top hours row on for digital hours equal 10", "10:13:23", "" +
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
                        " ╚═══════╝╚═══════╝╚═══════╝╚═══════╝"),
                arguments("first lamp of top hours row on for digital hours equal 15","15:13:23", "" +
                        "                 * *\n" +
                        "               *     *\n" +
                        "              *   O   *\n" +
                        "               *     *\n" +
                        "                 * *\n" +
                        " ╔═══════╗╔═══════╗╔═══════╗╔═══════╗\n" +
                        " ║   R   ║║   R   ║║   R   ║║   O   ║\n" +
                        " ╚═══════╝╚═══════╝╚═══════╝╚═══════╝\n" +
                        " ╔═══════╗╔═══════╗╔═══════╗╔═══════╗\n" +
                        " ║   O   ║║   O   ║║   O   ║║   O   ║\n" +
                        " ╚═══════╝╚═══════╝╚═══════╝╚═══════╝\n" +
                        " ╔═╗╔═╗╔═╗ ╔═╗╔═╗╔═╗ ╔═╗╔═╗╔═╗ ╔═╗╔═╗\n" +
                        " ║Y║║Y║║O║ ║O║║O║║O║ ║O║║O║║O║ ║O║║O║\n" +
                        " ╚═╝╚═╝╚═╝ ╚═╝╚═╝╚═╝ ╚═╝╚═╝╚═╝ ╚═╝╚═╝\n" +
                        " ╔═══════╗╔═══════╗╔═══════╗╔═══════╗\n" +
                        " ║   Y   ║║   Y   ║║   Y   ║║   O   ║\n" +
                        " ╚═══════╝╚═══════╝╚═══════╝╚═══════╝"),

                arguments("first lamp of top hours row on for digital hours equal 20", "20:13:23", "" +
                        "                 * *\n" +
                        "               *     *\n" +
                        "              *   O   *\n" +
                        "               *     *\n" +
                        "                 * *\n" +
                        " ╔═══════╗╔═══════╗╔═══════╗╔═══════╗\n" +
                        " ║   R   ║║   R   ║║   R   ║║   R   ║\n" +
                        " ╚═══════╝╚═══════╝╚═══════╝╚═══════╝\n" +
                        " ╔═══════╗╔═══════╗╔═══════╗╔═══════╗\n" +
                        " ║   O   ║║   O   ║║   O   ║║   O   ║\n" +
                        " ╚═══════╝╚═══════╝╚═══════╝╚═══════╝\n" +
                        " ╔═╗╔═╗╔═╗ ╔═╗╔═╗╔═╗ ╔═╗╔═╗╔═╗ ╔═╗╔═╗\n" +
                        " ║Y║║Y║║O║ ║O║║O║║O║ ║O║║O║║O║ ║O║║O║\n" +
                        " ╚═╝╚═╝╚═╝ ╚═╝╚═╝╚═╝ ╚═╝╚═╝╚═╝ ╚═╝╚═╝\n" +
                        " ╔═══════╗╔═══════╗╔═══════╗╔═══════╗\n" +
                        " ║   Y   ║║   Y   ║║   Y   ║║   O   ║\n" +
                        " ╚═══════╝╚═══════╝╚═══════╝╚═══════╝"),

                arguments("first lamp of top hours row on for digital hours bigger than 20", "22:13:23", "" +
                        "                 * *\n" +
                        "               *     *\n" +
                        "              *   O   *\n" +
                        "               *     *\n" +
                        "                 * *\n" +
                        " ╔═══════╗╔═══════╗╔═══════╗╔═══════╗\n" +
                        " ║   R   ║║   R   ║║   R   ║║   R   ║\n" +
                        " ╚═══════╝╚═══════╝╚═══════╝╚═══════╝\n" +
                        " ╔═══════╗╔═══════╗╔═══════╗╔═══════╗\n" +
                        " ║   O   ║║   O   ║║   O   ║║   O   ║\n" +
                        " ╚═══════╝╚═══════╝╚═══════╝╚═══════╝\n" +
                        " ╔═╗╔═╗╔═╗ ╔═╗╔═╗╔═╗ ╔═╗╔═╗╔═╗ ╔═╗╔═╗\n" +
                        " ║Y║║Y║║O║ ║O║║O║║O║ ║O║║O║║O║ ║O║║O║\n" +
                        " ╚═╝╚═╝╚═╝ ╚═╝╚═╝╚═╝ ╚═╝╚═╝╚═╝ ╚═╝╚═╝\n" +
                        " ╔═══════╗╔═══════╗╔═══════╗╔═══════╗\n" +
                        " ║   Y   ║║   Y   ║║   Y   ║║   O   ║\n" +
                        " ╚═══════╝╚═══════╝╚═══════╝╚═══════╝")
        );
    }
}
