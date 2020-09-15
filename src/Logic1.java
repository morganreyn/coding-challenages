public class Logic1 {

    public static void main(String[] args) {

    }

    /**
     * Given a day of the week encoded as 0=Sun, 1=Mon, 2=Tue, ...6=Sat, and a boolean indicating if we are on vacation,
     * return a string of the form "7:00" indicating when the alarm clock should ring. Weekdays, the alarm should be
     * "7:00" and on the weekend it should be "10:00". Unless we are on vacation -- then on weekdays it should be
     * "10:00" and weekends it should be "off".
     *
     * alarmClock(1, false) → "7:00"
     * alarmClock(5, false) → "7:00"
     * alarmClock(0, false) → "10:00"
     */
    public static String alarmClock(int day, boolean vacation) {
        final String OFF = "off";
        final String SEVEN = "7:00";
        final String TEN = "10:00";

        if (vacation) {
            switch(day) {
                case 6: // SAT
                case 0: // SUN
                    return OFF;
                default:
                    return TEN;
            }
        }

        switch(day) {
            case 6: // SAT
            case 0: // SUN
                return TEN;
            default:
                return SEVEN;
        }
    }

    /**
     * You and your date are trying to get a table at a restaurant. The parameter "you" is the stylishness of your
     * clothes, in the range 0..10, and "date" is the stylishness of your date's clothes. The result getting the table
     * is encoded as an int value with 0=no, 1=maybe, 2=yes. If either of you is very stylish, 8 or more, then the
     * result is 2 (yes). With the exception that if either of you has style of 2 or less, then the result is 0 (no).
     * Otherwise the result is 1 (maybe).
     *
     * dateFashion(5, 10) → 2
     * dateFashion(5, 2) → 0
     * dateFashion(5, 5) → 1
     */
    public int dateFashion(int you, int date) {
        if (you < 3 || date < 3) {
            return 0;
        }

        if (you > 7 || date > 7) {
            return 2;
        }

        return 1;
    }

}
