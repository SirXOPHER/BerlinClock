import java.util.stream.IntStream;

class BerlinClock {

    String convert(String digitalTime) {

        String digitalSeconds = extractDigitalSecondsFromDigitalTime(digitalTime);
        String berlinClockSeconds = convertDigitalSecondsToBerlinClockSeconds(digitalSeconds);

        String digitalHours = extractDigitalHoursFromDigitalTime(digitalTime);
        int hours = Integer.parseInt(digitalHours);

        String[] fiveHoursLamp = new String[4];
        IntStream.rangeClosed(1,4).forEach(num -> fiveHoursLamp[num-1] = switchOnFiveHoursLamp(num, hours));

        return "                 * *\n" +
               "               *     *\n" +
               "              *   " + berlinClockSeconds + "   *\n" +
               "               *     *\n" +
               "                 * *\n" +
               " ╔═══════╗╔═══════╗╔═══════╗╔═══════╗\n" +
               " ║   " + fiveHoursLamp[0] + "   ║║   " + fiveHoursLamp[1] + "   ║║   " + fiveHoursLamp[2] + "   ║║   " + fiveHoursLamp[3] + "   ║\n" +
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
    }

    private String switchOnFiveHoursLamp(int position, int hours) {
        return (hours / 5 >= position) ? "R" : "O";
    }

    private String extractDigitalHoursFromDigitalTime(String digitalTime) {
        return digitalTime.substring(0, 2);
    }

    private String extractDigitalSecondsFromDigitalTime(String digitalTime) {
        return digitalTime.substring(digitalTime.length() - 2);
    }

    private String convertDigitalSecondsToBerlinClockSeconds(String digitalSeconds) {
        int seconds = Integer.parseInt(digitalSeconds);
        return isEvenSecond(seconds) ? "Y" : "O";
    }

    private boolean isEvenSecond(int seconds) {
        return seconds % 2 == 0;
    }
}
