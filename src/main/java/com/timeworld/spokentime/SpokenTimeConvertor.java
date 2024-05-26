package com.timeworld.spokentime;

import com.timeworld.spokentime.convertor.TimeConvertor;
import org.apache.commons.lang3.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * <p> class responsible for printing the spoken words to console after converting to british spoken words
 * for example, time value is 1:00 then print spoken words as one o'clock <table>
  if given input is invalid, not in form of 24 hour format, say for example, 24:00 or 25:15 , non-digit value or not in format of hour colon minute [HH:MM] format, then print invalid input error message to console.
 *  */

public class SpokenTimeConvertor {
    /**
     * @param timeValue        (expected String in format of HH:MM in 24-hour format)
     *                         method validate given input, convert to british spoken words and print the output of converted spoken words to console
     * @param conversionOption (option selected for conversion language to convert to time to desire spoken word)
     */

    public void printSpokenWordsOfTime(final String timeValue, final SupportedSpokenConversion conversionOption) {


        if (isValidTime(timeValue)) {
            String[] parts = timeValue.split(":");
            int hour = Integer.parseInt(parts[0]);
            int minute = Integer.parseInt(parts[1]);
            TimeConvertor spokenTimeConvertor = SpokenConversionFactory.getSpokenConvertor(conversionOption);
            String spokenTime = spokenTimeConvertor.timeToSpokenWords(hour, minute);
            if(StringUtils.isNotBlank(spokenTime)) {
                System.out.printf("%s time of %s, is %s %n%n", conversionOption.getType(),timeValue, spokenTime);
            }else{
                System.out.printf("Time %s is in invalid format. lease enter the time in HH:MM format (24 hour) .%n%n",timeValue);

            }
        } else {
            System.out.printf("Time %s is in invalid format. Please enter the time in HH:MM format (24 hour) .%n%n",timeValue);
        }

    }
    private static boolean isValidTime(String time) {
        String timePattern = "^(?:[01]?\\d|2[0-3]):[0-5]\\d$";
        Pattern pattern = Pattern.compile(timePattern);
        Matcher matcher = pattern.matcher(time);
        return matcher.matches();
    }
}
