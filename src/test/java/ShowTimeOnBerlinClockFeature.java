import org.junit.jupiter.api.BeforeEach;
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

    private BerlinClock berlinClock;

    @BeforeEach
    void setUp() {
        berlinClock = new BerlinClock();
    }

    @DisplayName("0: first naive test - should convert digital time in berlin clock time")
    @Test
    void should_convert_digital_time_in_berlin_clock_time() {
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

    @DisplayName("1: seconds - should convert digital seconds in berlin clock time")
    @Test
    void should_convert_digital_seconds_in_berlin_clock_time() {
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

    @DisplayName("2: five hours blocks - should convert digital hours with different five hours block row in berlin clock time")
    @ParameterizedTest(name = "{0} (for digital time: {1})")
    @MethodSource("digitalTimesWithDifferentFiveHoursBlockRowInBerlinClockTime")
    void should_convert_digital_hours_with_different_five_hours_block_row_in_berlin_clock_time(String description, String digitalTime, String expectedBerlinClockTime) {

        String berlinClockTime = berlinClock.convert(digitalTime);

        assertThat(berlinClockTime, is(equalTo(expectedBerlinClockTime)));
    }

    private static Stream<Arguments> digitalTimesWithDifferentFiveHoursBlockRowInBerlinClockTime() {
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
                arguments("first and second lamp of top hours row on for digital hours equal 10", "10:13:23", "" +
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
                arguments("first, second and third lamp of top hours row on for digital hours equal 15","15:13:23", "" +
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
                arguments("all lamps of top hours row on for digital hours equal 20", "20:13:23", "" +
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
                arguments("all lamps of top hours row on for digital hours bigger than 20", "22:13:23", "" +
                        "                 * *\n" +
                        "               *     *\n" +
                        "              *   O   *\n" +
                        "               *     *\n" +
                        "                 * *\n" +
                        " ╔═══════╗╔═══════╗╔═══════╗╔═══════╗\n" +
                        " ║   R   ║║   R   ║║   R   ║║   R   ║\n" +
                        " ╚═══════╝╚═══════╝╚═══════╝╚═══════╝\n" +
                        " ╔═══════╗╔═══════╗╔═══════╗╔═══════╗\n" +
                        " ║   R   ║║   R   ║║   O   ║║   O   ║\n" +
                        " ╚═══════╝╚═══════╝╚═══════╝╚═══════╝\n" +
                        " ╔═╗╔═╗╔═╗ ╔═╗╔═╗╔═╗ ╔═╗╔═╗╔═╗ ╔═╗╔═╗\n" +
                        " ║Y║║Y║║O║ ║O║║O║║O║ ║O║║O║║O║ ║O║║O║\n" +
                        " ╚═╝╚═╝╚═╝ ╚═╝╚═╝╚═╝ ╚═╝╚═╝╚═╝ ╚═╝╚═╝\n" +
                        " ╔═══════╗╔═══════╗╔═══════╗╔═══════╗\n" +
                        " ║   Y   ║║   Y   ║║   Y   ║║   O   ║\n" +
                        " ╚═══════╝╚═══════╝╚═══════╝╚═══════╝")
        );
    }

    @DisplayName("3: single hour blocks - should convert digital hours with different single hours row in berlin clock time")
    @ParameterizedTest(name = "{0} (for digital time: {1})")
    @MethodSource("digitalTimesWithDifferentSingleHoursRowInBerlinClockTime")
    void should_convert_digital_hours_with_different_single_hours_row_in_berlin_clock_time(String description, String digitalTime, String expectedBerlinClockTime) {

        String berlinClockTime = berlinClock.convert(digitalTime);

        assertThat(berlinClockTime, is(equalTo(expectedBerlinClockTime)));
    }

    private static Stream<Arguments> digitalTimesWithDifferentSingleHoursRowInBerlinClockTime() {
        return Stream.of(
                arguments("no single hours row lamps on for digital hours equal 0", "00:13:23", "" +
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
                arguments("first lamp of single hours row on for digital hours equal 1", "01:13:23", "" +
                        "                 * *\n" +
                        "               *     *\n" +
                        "              *   O   *\n" +
                        "               *     *\n" +
                        "                 * *\n" +
                        " ╔═══════╗╔═══════╗╔═══════╗╔═══════╗\n" +
                        " ║   O   ║║   O   ║║   O   ║║   O   ║\n" +
                        " ╚═══════╝╚═══════╝╚═══════╝╚═══════╝\n" +
                        " ╔═══════╗╔═══════╗╔═══════╗╔═══════╗\n" +
                        " ║   R   ║║   O   ║║   O   ║║   O   ║\n" +
                        " ╚═══════╝╚═══════╝╚═══════╝╚═══════╝\n" +
                        " ╔═╗╔═╗╔═╗ ╔═╗╔═╗╔═╗ ╔═╗╔═╗╔═╗ ╔═╗╔═╗\n" +
                        " ║Y║║Y║║O║ ║O║║O║║O║ ║O║║O║║O║ ║O║║O║\n" +
                        " ╚═╝╚═╝╚═╝ ╚═╝╚═╝╚═╝ ╚═╝╚═╝╚═╝ ╚═╝╚═╝\n" +
                        " ╔═══════╗╔═══════╗╔═══════╗╔═══════╗\n" +
                        " ║   Y   ║║   Y   ║║   Y   ║║   O   ║\n" +
                        " ╚═══════╝╚═══════╝╚═══════╝╚═══════╝"),
                arguments("first and lamp of single hours row on for digital hours equal 2", "02:13:23", "" +
                        "                 * *\n" +
                        "               *     *\n" +
                        "              *   O   *\n" +
                        "               *     *\n" +
                        "                 * *\n" +
                        " ╔═══════╗╔═══════╗╔═══════╗╔═══════╗\n" +
                        " ║   O   ║║   O   ║║   O   ║║   O   ║\n" +
                        " ╚═══════╝╚═══════╝╚═══════╝╚═══════╝\n" +
                        " ╔═══════╗╔═══════╗╔═══════╗╔═══════╗\n" +
                        " ║   R   ║║   R   ║║   O   ║║   O   ║\n" +
                        " ╚═══════╝╚═══════╝╚═══════╝╚═══════╝\n" +
                        " ╔═╗╔═╗╔═╗ ╔═╗╔═╗╔═╗ ╔═╗╔═╗╔═╗ ╔═╗╔═╗\n" +
                        " ║Y║║Y║║O║ ║O║║O║║O║ ║O║║O║║O║ ║O║║O║\n" +
                        " ╚═╝╚═╝╚═╝ ╚═╝╚═╝╚═╝ ╚═╝╚═╝╚═╝ ╚═╝╚═╝\n" +
                        " ╔═══════╗╔═══════╗╔═══════╗╔═══════╗\n" +
                        " ║   Y   ║║   Y   ║║   Y   ║║   O   ║\n" +
                        " ╚═══════╝╚═══════╝╚═══════╝╚═══════╝"),
                arguments("first, second and third lamp of single hours row on for digital hours equal 3", "03:13:23", "" +
                        "                 * *\n" +
                        "               *     *\n" +
                        "              *   O   *\n" +
                        "               *     *\n" +
                        "                 * *\n" +
                        " ╔═══════╗╔═══════╗╔═══════╗╔═══════╗\n" +
                        " ║   O   ║║   O   ║║   O   ║║   O   ║\n" +
                        " ╚═══════╝╚═══════╝╚═══════╝╚═══════╝\n" +
                        " ╔═══════╗╔═══════╗╔═══════╗╔═══════╗\n" +
                        " ║   R   ║║   R   ║║   R   ║║   O   ║\n" +
                        " ╚═══════╝╚═══════╝╚═══════╝╚═══════╝\n" +
                        " ╔═╗╔═╗╔═╗ ╔═╗╔═╗╔═╗ ╔═╗╔═╗╔═╗ ╔═╗╔═╗\n" +
                        " ║Y║║Y║║O║ ║O║║O║║O║ ║O║║O║║O║ ║O║║O║\n" +
                        " ╚═╝╚═╝╚═╝ ╚═╝╚═╝╚═╝ ╚═╝╚═╝╚═╝ ╚═╝╚═╝\n" +
                        " ╔═══════╗╔═══════╗╔═══════╗╔═══════╗\n" +
                        " ║   Y   ║║   Y   ║║   Y   ║║   O   ║\n" +
                        " ╚═══════╝╚═══════╝╚═══════╝╚═══════╝"),
                arguments("all lamps of single hours row on for digital hours equal 4", "04:13:23", "" +
                        "                 * *\n" +
                        "               *     *\n" +
                        "              *   O   *\n" +
                        "               *     *\n" +
                        "                 * *\n" +
                        " ╔═══════╗╔═══════╗╔═══════╗╔═══════╗\n" +
                        " ║   O   ║║   O   ║║   O   ║║   O   ║\n" +
                        " ╚═══════╝╚═══════╝╚═══════╝╚═══════╝\n" +
                        " ╔═══════╗╔═══════╗╔═══════╗╔═══════╗\n" +
                        " ║   R   ║║   R   ║║   R   ║║   R   ║\n" +
                        " ╚═══════╝╚═══════╝╚═══════╝╚═══════╝\n" +
                        " ╔═╗╔═╗╔═╗ ╔═╗╔═╗╔═╗ ╔═╗╔═╗╔═╗ ╔═╗╔═╗\n" +
                        " ║Y║║Y║║O║ ║O║║O║║O║ ║O║║O║║O║ ║O║║O║\n" +
                        " ╚═╝╚═╝╚═╝ ╚═╝╚═╝╚═╝ ╚═╝╚═╝╚═╝ ╚═╝╚═╝\n" +
                        " ╔═══════╗╔═══════╗╔═══════╗╔═══════╗\n" +
                        " ║   Y   ║║   Y   ║║   Y   ║║   O   ║\n" +
                        " ╚═══════╝╚═══════╝╚═══════╝╚═══════╝"),
                arguments("all lamp of single hours row on for digital hours equal 19", "19:13:23", "" +
                        "                 * *\n" +
                        "               *     *\n" +
                        "              *   O   *\n" +
                        "               *     *\n" +
                        "                 * *\n" +
                        " ╔═══════╗╔═══════╗╔═══════╗╔═══════╗\n" +
                        " ║   R   ║║   R   ║║   R   ║║   O   ║\n" +
                        " ╚═══════╝╚═══════╝╚═══════╝╚═══════╝\n" +
                        " ╔═══════╗╔═══════╗╔═══════╗╔═══════╗\n" +
                        " ║   R   ║║   R   ║║   R   ║║   R   ║\n" +
                        " ╚═══════╝╚═══════╝╚═══════╝╚═══════╝\n" +
                        " ╔═╗╔═╗╔═╗ ╔═╗╔═╗╔═╗ ╔═╗╔═╗╔═╗ ╔═╗╔═╗\n" +
                        " ║Y║║Y║║O║ ║O║║O║║O║ ║O║║O║║O║ ║O║║O║\n" +
                        " ╚═╝╚═╝╚═╝ ╚═╝╚═╝╚═╝ ╚═╝╚═╝╚═╝ ╚═╝╚═╝\n" +
                        " ╔═══════╗╔═══════╗╔═══════╗╔═══════╗\n" +
                        " ║   Y   ║║   Y   ║║   Y   ║║   O   ║\n" +
                        " ╚═══════╝╚═══════╝╚═══════╝╚═══════╝")
        );
    }

    @DisplayName("4: five minutes blocks - should convert digital minutes with different five minutes block row in berlin clock time")
    @ParameterizedTest(name = "{0} (for digital time: {1})")
    @MethodSource("digitalTimesWithDifferentFiveMinutesBlockRowInBerlinClockTime")
    void should_convert_digital_minutes_with_different_five_minutes_block_row_in_berlin_clock_time(String description, String digitalTime, String expectedBerlinClockTime) {

        String berlinClockTime = berlinClock.convert(digitalTime);

        assertThat(berlinClockTime, is(equalTo(expectedBerlinClockTime)));
    }

    private static Stream<Arguments> digitalTimesWithDifferentFiveMinutesBlockRowInBerlinClockTime() {
        return Stream.of(
                arguments("no five minutes row lamps on for digital minutes equal 0", "00:00:23", "" +
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
                        " ║O║║O║║O║ ║O║║O║║O║ ║O║║O║║O║ ║O║║O║\n" +
                        " ╚═╝╚═╝╚═╝ ╚═╝╚═╝╚═╝ ╚═╝╚═╝╚═╝ ╚═╝╚═╝\n" +
                        " ╔═══════╗╔═══════╗╔═══════╗╔═══════╗\n" +
                        " ║   O   ║║   O   ║║   O   ║║   O   ║\n" +
                        " ╚═══════╝╚═══════╝╚═══════╝╚═══════╝"),
                arguments("first lamp of five minutes row on for digital minutes equal 5", "00:05:23", "" +
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
                        " ║Y║║O║║O║ ║O║║O║║O║ ║O║║O║║O║ ║O║║O║\n" +
                        " ╚═╝╚═╝╚═╝ ╚═╝╚═╝╚═╝ ╚═╝╚═╝╚═╝ ╚═╝╚═╝\n" +
                        " ╔═══════╗╔═══════╗╔═══════╗╔═══════╗\n" +
                        " ║   O   ║║   O   ║║   O   ║║   O   ║\n" +
                        " ╚═══════╝╚═══════╝╚═══════╝╚═══════╝"),
                arguments("2/11 lamps of five minutes row on for digital minutes equal 10", "00:10:23", "" +
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
                        " ║   O   ║║   O   ║║   O   ║║   O   ║\n" +
                        " ╚═══════╝╚═══════╝╚═══════╝╚═══════╝"),
                arguments("3/11 lamps of five minutes row on for digital minutes equal 15", "00:15:23", "" +
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
                        " ║Y║║Y║║R║ ║O║║O║║O║ ║O║║O║║O║ ║O║║O║\n" +
                        " ╚═╝╚═╝╚═╝ ╚═╝╚═╝╚═╝ ╚═╝╚═╝╚═╝ ╚═╝╚═╝\n" +
                        " ╔═══════╗╔═══════╗╔═══════╗╔═══════╗\n" +
                        " ║   O   ║║   O   ║║   O   ║║   O   ║\n" +
                        " ╚═══════╝╚═══════╝╚═══════╝╚═══════╝"),
                arguments("4/11 lamps of five minutes row on for digital minutes equal 20", "00:20:23", "" +
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
                        " ║Y║║Y║║R║ ║Y║║O║║O║ ║O║║O║║O║ ║O║║O║\n" +
                        " ╚═╝╚═╝╚═╝ ╚═╝╚═╝╚═╝ ╚═╝╚═╝╚═╝ ╚═╝╚═╝\n" +
                        " ╔═══════╗╔═══════╗╔═══════╗╔═══════╗\n" +
                        " ║   O   ║║   O   ║║   O   ║║   O   ║\n" +
                        " ╚═══════╝╚═══════╝╚═══════╝╚═══════╝"),
                arguments("5/11 lamps of five minutes row on for digital minutes equal 25", "00:25:23", "" +
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
                        " ║Y║║Y║║R║ ║Y║║Y║║O║ ║O║║O║║O║ ║O║║O║\n" +
                        " ╚═╝╚═╝╚═╝ ╚═╝╚═╝╚═╝ ╚═╝╚═╝╚═╝ ╚═╝╚═╝\n" +
                        " ╔═══════╗╔═══════╗╔═══════╗╔═══════╗\n" +
                        " ║   O   ║║   O   ║║   O   ║║   O   ║\n" +
                        " ╚═══════╝╚═══════╝╚═══════╝╚═══════╝"),
                arguments("6/11 lamps of five minutes row on for digital minutes equal 30", "00:30:23", "" +
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
                        " ║Y║║Y║║R║ ║Y║║Y║║R║ ║O║║O║║O║ ║O║║O║\n" +
                        " ╚═╝╚═╝╚═╝ ╚═╝╚═╝╚═╝ ╚═╝╚═╝╚═╝ ╚═╝╚═╝\n" +
                        " ╔═══════╗╔═══════╗╔═══════╗╔═══════╗\n" +
                        " ║   O   ║║   O   ║║   O   ║║   O   ║\n" +
                        " ╚═══════╝╚═══════╝╚═══════╝╚═══════╝"),
                arguments("7/11 lamps of five minutes row on for digital minutes equal 35", "00:35:23", "" +
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
                        " ║Y║║Y║║R║ ║Y║║Y║║R║ ║Y║║O║║O║ ║O║║O║\n" +
                        " ╚═╝╚═╝╚═╝ ╚═╝╚═╝╚═╝ ╚═╝╚═╝╚═╝ ╚═╝╚═╝\n" +
                        " ╔═══════╗╔═══════╗╔═══════╗╔═══════╗\n" +
                        " ║   O   ║║   O   ║║   O   ║║   O   ║\n" +
                        " ╚═══════╝╚═══════╝╚═══════╝╚═══════╝"),
                arguments("8/11 lamps of five minutes row on for digital minutes equal 40", "00:40:23", "" +
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
                        " ║Y║║Y║║R║ ║Y║║Y║║R║ ║Y║║Y║║O║ ║O║║O║\n" +
                        " ╚═╝╚═╝╚═╝ ╚═╝╚═╝╚═╝ ╚═╝╚═╝╚═╝ ╚═╝╚═╝\n" +
                        " ╔═══════╗╔═══════╗╔═══════╗╔═══════╗\n" +
                        " ║   O   ║║   O   ║║   O   ║║   O   ║\n" +
                        " ╚═══════╝╚═══════╝╚═══════╝╚═══════╝"),
                arguments("9/11 lamps of five minutes row on for digital minutes equal 45", "00:45:23", "" +
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
                        " ║Y║║Y║║R║ ║Y║║Y║║R║ ║Y║║Y║║R║ ║O║║O║\n" +
                        " ╚═╝╚═╝╚═╝ ╚═╝╚═╝╚═╝ ╚═╝╚═╝╚═╝ ╚═╝╚═╝\n" +
                        " ╔═══════╗╔═══════╗╔═══════╗╔═══════╗\n" +
                        " ║   O   ║║   O   ║║   O   ║║   O   ║\n" +
                        " ╚═══════╝╚═══════╝╚═══════╝╚═══════╝"),
                arguments("10/11 lamps of five minutes row on for digital minutes equal 50", "00:50:23", "" +
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
                        " ║Y║║Y║║R║ ║Y║║Y║║R║ ║Y║║Y║║R║ ║Y║║O║\n" +
                        " ╚═╝╚═╝╚═╝ ╚═╝╚═╝╚═╝ ╚═╝╚═╝╚═╝ ╚═╝╚═╝\n" +
                        " ╔═══════╗╔═══════╗╔═══════╗╔═══════╗\n" +
                        " ║   O   ║║   O   ║║   O   ║║   O   ║\n" +
                        " ╚═══════╝╚═══════╝╚═══════╝╚═══════╝"),
                arguments("all lamps of five minutes row on for digital minutes equal 55", "00:55:23", "" +
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
                        " ║Y║║Y║║R║ ║Y║║Y║║R║ ║Y║║Y║║R║ ║Y║║Y║\n" +
                        " ╚═╝╚═╝╚═╝ ╚═╝╚═╝╚═╝ ╚═╝╚═╝╚═╝ ╚═╝╚═╝\n" +
                        " ╔═══════╗╔═══════╗╔═══════╗╔═══════╗\n" +
                        " ║   O   ║║   O   ║║   O   ║║   O   ║\n" +
                        " ╚═══════╝╚═══════╝╚═══════╝╚═══════╝"),
                arguments("all lamps of five minutes row on for digital minutes above 55", "00:58:23", "" +
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
                        " ║Y║║Y║║R║ ║Y║║Y║║R║ ║Y║║Y║║R║ ║Y║║Y║\n" +
                        " ╚═╝╚═╝╚═╝ ╚═╝╚═╝╚═╝ ╚═╝╚═╝╚═╝ ╚═╝╚═╝\n" +
                        " ╔═══════╗╔═══════╗╔═══════╗╔═══════╗\n" +
                        " ║   Y   ║║   Y   ║║   Y   ║║   O   ║\n" +
                        " ╚═══════╝╚═══════╝╚═══════╝╚═══════╝")
        );
    }

    @DisplayName("5: single minute blocks - should convert digital minutes with different single minutes row in berlin clock time")
    @ParameterizedTest(name = "{0} (for digital time: {1})")
    @MethodSource("digitalTimesWithDifferentSingleMinutesRowInBerlinClockTime")
    void should_convert_digital_minutes_with_different_single_minutes_row_in_berlin_clock_time(String description, String digitalTime, String expectedBerlinClockTime) {

        String berlinClockTime = berlinClock.convert(digitalTime);

        assertThat(berlinClockTime, is(equalTo(expectedBerlinClockTime)));
    }

    private static Stream<Arguments> digitalTimesWithDifferentSingleMinutesRowInBerlinClockTime() {
        return Stream.of(
                arguments("no single minutes row lamps on for digital minutes equal 0", "00:00:23", "" +
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
                        " ║O║║O║║O║ ║O║║O║║O║ ║O║║O║║O║ ║O║║O║\n" +
                        " ╚═╝╚═╝╚═╝ ╚═╝╚═╝╚═╝ ╚═╝╚═╝╚═╝ ╚═╝╚═╝\n" +
                        " ╔═══════╗╔═══════╗╔═══════╗╔═══════╗\n" +
                        " ║   O   ║║   O   ║║   O   ║║   O   ║\n" +
                        " ╚═══════╝╚═══════╝╚═══════╝╚═══════╝"),
                arguments("first lamp of single minutes row on for digital minutes equal 1", "00:01:23", "" +
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
                        " ║O║║O║║O║ ║O║║O║║O║ ║O║║O║║O║ ║O║║O║\n" +
                        " ╚═╝╚═╝╚═╝ ╚═╝╚═╝╚═╝ ╚═╝╚═╝╚═╝ ╚═╝╚═╝\n" +
                        " ╔═══════╗╔═══════╗╔═══════╗╔═══════╗\n" +
                        " ║   Y   ║║   O   ║║   O   ║║   O   ║\n" +
                        " ╚═══════╝╚═══════╝╚═══════╝╚═══════╝"),
                arguments("first and second lamp of single minutes row on for digital minutes equal 2", "00:02:23", "" +
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
                        " ║O║║O║║O║ ║O║║O║║O║ ║O║║O║║O║ ║O║║O║\n" +
                        " ╚═╝╚═╝╚═╝ ╚═╝╚═╝╚═╝ ╚═╝╚═╝╚═╝ ╚═╝╚═╝\n" +
                        " ╔═══════╗╔═══════╗╔═══════╗╔═══════╗\n" +
                        " ║   Y   ║║   Y   ║║   O   ║║   O   ║\n" +
                        " ╚═══════╝╚═══════╝╚═══════╝╚═══════╝"),
                arguments("first, second and third lamp of single minutes row on for digital minutes equal 3", "00:03:23", "" +
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
                        " ║O║║O║║O║ ║O║║O║║O║ ║O║║O║║O║ ║O║║O║\n" +
                        " ╚═╝╚═╝╚═╝ ╚═╝╚═╝╚═╝ ╚═╝╚═╝╚═╝ ╚═╝╚═╝\n" +
                        " ╔═══════╗╔═══════╗╔═══════╗╔═══════╗\n" +
                        " ║   Y   ║║   Y   ║║   Y   ║║   O   ║\n" +
                        " ╚═══════╝╚═══════╝╚═══════╝╚═══════╝"),
                arguments("all lamps of single minutes row on for digital minutes equal 4", "00:04:23", "" +
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
                        " ║O║║O║║O║ ║O║║O║║O║ ║O║║O║║O║ ║O║║O║\n" +
                        " ╚═╝╚═╝╚═╝ ╚═╝╚═╝╚═╝ ╚═╝╚═╝╚═╝ ╚═╝╚═╝\n" +
                        " ╔═══════╗╔═══════╗╔═══════╗╔═══════╗\n" +
                        " ║   Y   ║║   Y   ║║   Y   ║║   Y   ║\n" +
                        " ╚═══════╝╚═══════╝╚═══════╝╚═══════╝"),
                arguments("all lamps of single minutes row on for digital minutes above 5", "23:59:23", "" +
                        "                 * *\n" +
                        "               *     *\n" +
                        "              *   O   *\n" +
                        "               *     *\n" +
                        "                 * *\n" +
                        " ╔═══════╗╔═══════╗╔═══════╗╔═══════╗\n" +
                        " ║   R   ║║   R   ║║   R   ║║   R   ║\n" +
                        " ╚═══════╝╚═══════╝╚═══════╝╚═══════╝\n" +
                        " ╔═══════╗╔═══════╗╔═══════╗╔═══════╗\n" +
                        " ║   R   ║║   R   ║║   R   ║║   O   ║\n" +
                        " ╚═══════╝╚═══════╝╚═══════╝╚═══════╝\n" +
                        " ╔═╗╔═╗╔═╗ ╔═╗╔═╗╔═╗ ╔═╗╔═╗╔═╗ ╔═╗╔═╗\n" +
                        " ║Y║║Y║║R║ ║Y║║Y║║R║ ║Y║║Y║║R║ ║Y║║Y║\n" +
                        " ╚═╝╚═╝╚═╝ ╚═╝╚═╝╚═╝ ╚═╝╚═╝╚═╝ ╚═╝╚═╝\n" +
                        " ╔═══════╗╔═══════╗╔═══════╗╔═══════╗\n" +
                        " ║   Y   ║║   Y   ║║   Y   ║║   Y   ║\n" +
                        " ╚═══════╝╚═══════╝╚═══════╝╚═══════╝")
        );
    }
}
