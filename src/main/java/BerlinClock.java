public class BerlinClock {

    public String convert(String digitalTime) {

        String digitalSeconds = extractDigitalSecondsFromDigitalTime(digitalTime);
        String berlinClockSeconds = convertDigitalSecondsToBerlinClockSeconds(digitalSeconds);

        String digitalHours = digitalTime.substring(0, 2);
        int hours = Integer.parseInt(digitalHours);

        String thirdLampInTheTopHoursRow = hours >= 15 ? "R" : "O";

        return  "                 * *\n" +
                "               *     *\n" +
                "              *   "+ berlinClockSeconds +"   *\n" +
                "               *     *\n" +
                "                 * *\n" +
                " ╔═══════╗╔═══════╗╔═══════╗╔═══════╗\n" +
                " ║   R   ║║   R   ║║   "+ thirdLampInTheTopHoursRow +"   ║║   O   ║\n" +
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

    private String extractDigitalSecondsFromDigitalTime(String digitalTime) {
        return digitalTime.substring(digitalTime.length()-2);
    }

    private String convertDigitalSecondsToBerlinClockSeconds(String digitalSeconds) {
        int seconds = Integer.parseInt(digitalSeconds);
        return isEvenSecond(seconds) ? "Y" : "O";
    }

    private boolean isEvenSecond(int seconds) {
        return seconds % 2 == 0;
    }
}
