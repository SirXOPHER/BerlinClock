class BerlinClock {


    private static final int HOURS_THRESHOLD_TO_SWITCH_FIRST_LAMP_OF_TOP_HOURS_ROW = 5;
    private static final int HOURS_THRESHOLD_TO_SWITCH_SECOND_LAMP_OF_TOP_HOURS_ROW = 10;
    private static final int HOURS_THRESHOLD_TO_SWITCH_THIRD_LAMP_OF_TOP_HOURS_ROW = 15;
    private static final int HOURS_THRESHOLD_TO_SWITCH_FOURTH_LAMP_OF_TOP_HOURS_ROW = 20;

    String convert(String digitalTime) {

        String digitalSeconds = extractDigitalSecondsFromDigitalTime(digitalTime);
        String berlinClockSeconds = convertDigitalSecondsToBerlinClockSeconds(digitalSeconds);

        String digitalHours = digitalTime.substring(0, 2);
        int hours = Integer.parseInt(digitalHours);

        String firstLampInTheTopHoursRow = topHoursRowLamp(hours, HOURS_THRESHOLD_TO_SWITCH_FIRST_LAMP_OF_TOP_HOURS_ROW);
        String secondLampInTheTopHoursRow = topHoursRowLamp(hours, HOURS_THRESHOLD_TO_SWITCH_SECOND_LAMP_OF_TOP_HOURS_ROW);
        String thirdLampInTheTopHoursRow = topHoursRowLamp(hours, HOURS_THRESHOLD_TO_SWITCH_THIRD_LAMP_OF_TOP_HOURS_ROW);
        String fourthLampInTheTopHoursRow = topHoursRowLamp(hours, HOURS_THRESHOLD_TO_SWITCH_FOURTH_LAMP_OF_TOP_HOURS_ROW);

        return "                 * *\n" +
                "               *     *\n" +
                "              *   " + berlinClockSeconds + "   *\n" +
                "               *     *\n" +
                "                 * *\n" +
                " ╔═══════╗╔═══════╗╔═══════╗╔═══════╗\n" +
                " ║   " + firstLampInTheTopHoursRow + "   ║║   " + secondLampInTheTopHoursRow + "   ║║   " + thirdLampInTheTopHoursRow + "   ║║   " + fourthLampInTheTopHoursRow + "   ║\n" +
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


    private String topHoursRowLamp(int hours, int hoursThresholdToSwitchLampOn) {
        return isHourAbove(hours, hoursThresholdToSwitchLampOn) ? "R" : "O";
    }

    private boolean isHourAbove(int hours, int threshold) {
        return hours >= threshold;
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
