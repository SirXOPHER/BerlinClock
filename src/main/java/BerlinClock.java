public class BerlinClock {

    public String convert(String digitalTime) {

        String digitalSeconds = extractDigitalSecondsFromDigitalTime(digitalTime);
        String berlinClockSeconds = convertDigitalSecondsToBerlinClockSeconds(digitalSeconds);

        return  "                 * *\n" +
                "               *     *\n" +
                "              *   "+ berlinClockSeconds +"   *\n" +
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
