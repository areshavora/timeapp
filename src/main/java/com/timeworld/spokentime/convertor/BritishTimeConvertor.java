package com.timeworld.spokentime.convertor;

/* class responsible for converting to hour and minute input to british spoken words. */
public class BritishTimeConvertor {
    private static final String[] NUMBERS = {
            "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine",
            "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"
    };

    private static final String[] TENS = {
            "", "", "twenty", "thirty", "forty", "fifty"
    };


    /**
     * @param hour   (expected to be between, 0 to 23)
     * @param minute (expected to br between, 0 to 59)
     * @return method return the british spoken words corresponds to given hour and minute param.
     * say for example, 2:04 is five past two. <br> <p> 3:10 is ten past three <br> 4:15 is quarter past four <br>7:30 is half past seven <br>9:45 is quarter to ten <br>11:55 is five to twelve <br>6:32 is six thirty two <br>00:00 is midnight <br>
     * 12:00 is noon <br>
     * 24:00 is null <br>
     * 23:60 is null  <br>
     * 1:-1 null [ if given hour or minute is not in expected range of valid 24-hour format then method return null] </p>
     */
    public String timeToSpokenWords(int hour, int minute) {
        if (!isValidHour(hour) || !isValidMinute(minute)) {
            return null; // Invalid time format
        }

        if (hour == 0 && minute == 0) {
            return "midnight";
        } else if (hour == 12 && minute == 0) {
            return "noon";
        } else {
            String hourWords = convertHourToWords(hour);
            String nextHourWords = convertHourToWords(hour + 1);
            if (minute == 0) {
                return hourWords + " o'clock";
            } else if (minute == 15) {
                return "quarter past " + hourWords;
            } else if (minute == 30) {
                return "half past " + hourWords;
            } else if (minute == 45) {
                return "quarter to " + nextHourWords;
            } else if (minute < 30 && minute % 5 == 0) {
                return convertMinuteToWords(minute) + " past " + hourWords;
            } else if (minute > 30 && minute % 5 == 0) {
                return convertMinuteToWords(60 - minute) + " to " + nextHourWords;
            } else {
                return hourWords + " " + convertMinuteToWords(minute);
            }
        }
    }


    public String convertHourToWords(int hour) {
        return convertToWords(hour % 12 == 0 ? 12 : hour % 12);
    }

    public String convertMinuteToWords(int min) {
        return convertToWords(min);
    }


    private static String convertToWords(int num) {
        if (num < 20) {
            return NUMBERS[num];
        } else {
            int tens = num / 10;
            int ones = num % 10;
            if (ones == 0) {
                return TENS[tens];
            } else {
                return TENS[tens] + " " + NUMBERS[ones];
            }
        }
    }

    private static boolean isValidHour(int hour) {
        return hour >= 0 && hour <= 23;
    }

    private static boolean isValidMinute(int minute) {
        return minute >= 0 && minute <= 59;
    }
}
