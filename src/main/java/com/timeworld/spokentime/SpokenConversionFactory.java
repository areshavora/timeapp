package com.timeworld.spokentime;

import com.timeworld.spokentime.convertor.BritishTimeConvertor;
import com.timeworld.spokentime.convertor.GermanyTimeConvertor;
import com.timeworld.spokentime.convertor.TimeConvertor;

public class SpokenConversionFactory {
    public static TimeConvertor getSpokenConvertor(final SupportedSpokenConversion conversion) {
        if(SupportedSpokenConversion.GERMANY.equals(conversion)){
            return new GermanyTimeConvertor();
        }else{
            return new BritishTimeConvertor();
        }
    }
}
