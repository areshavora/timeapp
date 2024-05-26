package com.timeworld.spokentime.convertor;

public abstract class TimeConvertor {
    private static final String[] NUMBERS = {
            "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine",
            "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"
    };

    private static final String[] TENS = {
            "", "", "twenty", "thirty", "forty", "fifty"
    };

    /**@param  hour (expected string in range of (0 to 23) as per 24-hour format)
     * @param minute (expected string in range of (0 to 59) as per  24-hour format)
     * @return  method return spoken words corresponds to hour and minute, any class implementing this class requries to implement this method to
     * provide time to word conversion as per the underlying spoken language. */
    abstract public String timeToSpokenWords(int hour, int minute);
    public String convertHourToWords(int hour) {
        return convertToWords(hour % 12 == 0 ? 12 : hour % 12);
    }

    public String convertMinuteToWords(int min) {
        return convertToWords(min);
    }

    protected static boolean isValidHour(int hour) {
        return hour >= 0 && hour <= 23;
    }

    protected static boolean isValidMinute(int minute) {
        return minute >= 0 && minute <= 59;
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
}
