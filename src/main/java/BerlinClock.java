import java.util.stream.IntStream;

class BerlinClock {

    String convert(String digitalTime) {

        String digitalSeconds = extractDigitalSecondsFromDigitalTime(digitalTime);
        String berlinClockSeconds = convertDigitalSecondsToBerlinClockSeconds(digitalSeconds);

        String digitalHours = extractDigitalHoursFromDigitalTime(digitalTime);
        String[] fiveHoursLamp = new String[4];
        String[] oneHourLamp = new String[4];
        convertDigitalHoursToBerlinClockHours(digitalHours, fiveHoursLamp, oneHourLamp);

        String digitalMinutes = extractDigitalMinutesFromDigitalTime(digitalTime);
        String[] fiveMinutesLamp = new String[11];
        String[] oneMinuteLamp = new String[4];

        int minutes = Integer.parseInt(digitalMinutes);
        adjustFiveMinutesLampsRow(fiveMinutesLamp, minutes);

        oneMinuteLamp[0] = minutes % 5 >= 1 ? "Y" : "O";
        oneMinuteLamp[1] = minutes % 5 >= 2 ? "Y" : "O";
        oneMinuteLamp[2] = minutes % 5 >= 3 ? "Y" : "O";
        oneMinuteLamp[3] = minutes % 5 >= 4 ? "Y" : "O";

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
               " ║" + fiveMinutesLamp[0] + "║║" + fiveMinutesLamp[1] + "║║" + fiveMinutesLamp[2] + "║ ║" + fiveMinutesLamp[3] + "║║" + fiveMinutesLamp[4] + "║║" + fiveMinutesLamp[5] + "║ ║" + fiveMinutesLamp[6] + "║║" + fiveMinutesLamp[7] + "║║" + fiveMinutesLamp[8] + "║ ║" + fiveMinutesLamp[9] + "║║" + fiveMinutesLamp[10] + "║\n" +
               " ╚═╝╚═╝╚═╝ ╚═╝╚═╝╚═╝ ╚═╝╚═╝╚═╝ ╚═╝╚═╝\n" +
               " ╔═══════╗╔═══════╗╔═══════╗╔═══════╗\n" +
               " ║   " + oneMinuteLamp[0] + "   ║║   " + oneMinuteLamp[1] + "   ║║   " + oneMinuteLamp[2] + "   ║║   " + oneMinuteLamp[3] + "   ║\n" +
               " ╚═══════╝╚═══════╝╚═══════╝╚═══════╝";
    }

    private String switchOnFiveMinutesLamp(int position, int minutes, String colour) {
        return minutes / 5 >= position ? colour : "O";
    }

    private String extractDigitalHoursFromDigitalTime(String digitalTime) {
        return digitalTime.substring(0, 2);
    }

    private String extractDigitalMinutesFromDigitalTime(String digitalTime) {
        return digitalTime.substring(3, 5);
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

    private void adjustFiveMinutesLampsRow(String[] fiveMinutesLamp, int minutes) {
        IntStream.rangeClosed(1,11).forEach(num -> {
            String colour = num % 3 == 0 ? "R" : "Y";
            fiveMinutesLamp[num - 1] = switchOnFiveMinutesLamp(num, minutes, colour);
        });
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
