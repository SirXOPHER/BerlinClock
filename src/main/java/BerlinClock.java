import java.util.stream.IntStream;

class BerlinClock {

    String convert(String digitalTime) {

        String digitalSeconds = extractDigitalSecondsFromDigitalTime(digitalTime);
        String berlinClockSeconds = convertDigitalSecondsToBerlinClockSeconds(digitalSeconds);

        String digitalHours = extractDigitalHoursFromDigitalTime(digitalTime);
        String[] fiveHoursLamp = new String[4];
        String[] oneHourLamp = new String[4];
        convertDigitalHoursToBerlinClockHours(digitalHours, fiveHoursLamp, oneHourLamp);

        return "                 * *\n" +
               "               *     *\n" +
               "              *   " + berlinClockSeconds + "   *\n" +
               "               *     *\n" +
               "                 * *\n" +
               " ╔═══════╗╔═══════╗╔═══════╗╔═══════╗\n" +
               " ║   " + fiveHoursLamp[0] + "   ║║   " + fiveHoursLamp[1] + "   ║║   " + fiveHoursLamp[2] + "   ║║   " + fiveHoursLamp[3] + "   ║\n" +
               " ╚═══════╝╚═══════╝╚═══════╝╚═══════╝\n" +
               " ╔═══════╗╔═══════╗╔═══════╗╔═══════╗\n" +
               " ║   " + oneHourLamp[0] + "   ║║   " + oneHourLamp[1] + "   ║║   " + oneHourLamp[2] + "   ║║   " + oneHourLamp[3] + "   ║\n" +
               " ╚═══════╝╚═══════╝╚═══════╝╚═══════╝\n" +
               " ╔═╗╔═╗╔═╗ ╔═╗╔═╗╔═╗ ╔═╗╔═╗╔═╗ ╔═╗╔═╗\n" +
               " ║Y║║Y║║O║ ║O║║O║║O║ ║O║║O║║O║ ║O║║O║\n" +
               " ╚═╝╚═╝╚═╝ ╚═╝╚═╝╚═╝ ╚═╝╚═╝╚═╝ ╚═╝╚═╝\n" +
               " ╔═══════╗╔═══════╗╔═══════╗╔═══════╗\n" +
               " ║   Y   ║║   Y   ║║   Y   ║║   O   ║\n" +
               " ╚═══════╝╚═══════╝╚═══════╝╚═══════╝";
    }

    private String extractDigitalHoursFromDigitalTime(String digitalTime) {
        return digitalTime.substring(0, 2);
    }

    private String extractDigitalSecondsFromDigitalTime(String digitalTime) {
        return digitalTime.substring(digitalTime.length() - 2);
    }

    private void convertDigitalHoursToBerlinClockHours(String digitalHours, String[] fiveHoursLamp, String[] oneHourLamp) {
        int hours = Integer.parseInt(digitalHours);
        adjustFiveHoursLampsRow(fiveHoursLamp, hours);
        adjustSingleHourLampsRow(oneHourLamp, hours);
    }

    private String convertDigitalSecondsToBerlinClockSeconds(String digitalSeconds) {
        int seconds = Integer.parseInt(digitalSeconds);
        return isEvenSecond(seconds) ? "Y" : "O";
    }

    private void adjustFiveHoursLampsRow(String[] fiveHoursLamp, int hours) {
        IntStream.rangeClosed(1,4).forEach(num -> fiveHoursLamp[num-1] = switchOnFiveHoursLamp(num, hours));
    }

    private void adjustSingleHourLampsRow(String[] oneHourLamp, int hours) {
        IntStream.rangeClosed(1,4).forEach(num -> oneHourLamp[num-1] = switchOnSingleHourLamp(num, hours));
    }

    private String switchOnFiveHoursLamp(int position, int hours) {
        return hours / 5 >= position ? "R" : "O";
    }

    private String switchOnSingleHourLamp(int position, int hours) {
        return hours % 5 >= position ? "R" : "O";
    }

    private boolean isEvenSecond(int seconds) {
        return seconds % 2 == 0;
    }
}
