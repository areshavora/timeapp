package com.timeworld;


import com.timeworld.spokentime.convertor.BritishTimeConvertor;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Unit test to verify static time input getting converted to desired  spoken time as per british spoken time
 */
public class TestBritishSpokenTime {

    @Test
    public void testTimeToWordsOClock() {
        BritishTimeConvertor brtConvertor = new BritishTimeConvertor();
        Assert.assertEquals(brtConvertor.timeToSpokenWords(1, 0), "one o'clock");
        Assert.assertEquals(brtConvertor.timeToSpokenWords(6, 0), "six o'clock");
        Assert.assertEquals(brtConvertor.timeToSpokenWords(13, 0), "one o'clock");
        Assert.assertEquals(brtConvertor.timeToSpokenWords(15, 0), "three o'clock");

    }

    @Test
    public void testTimeToWordsQuarterPast() {
        Assert.assertEquals(new BritishTimeConvertor().timeToSpokenWords(3, 15), "quarter past three");

    }

    @Test
    public void testTimeToWordsHalfPastTime() {
        Assert.assertEquals(new BritishTimeConvertor().timeToSpokenWords(6, 30), "half past six");
    }

    @Test
    public void testTimeToWordsQuarterTo() {
        BritishTimeConvertor brtConvertor = new BritishTimeConvertor();
        Assert.assertEquals(brtConvertor.timeToSpokenWords(9, 45), "quarter to ten");
        Assert.assertEquals(brtConvertor.timeToSpokenWords(12, 45), "quarter to one");
    }

    @Test
    public void testTimeToWordsMidNight() {
        Assert.assertEquals(new BritishTimeConvertor().timeToSpokenWords(0, 0), "midnight");

    }

    @Test
    public void testTimeToWordsNoon() {
        Assert.assertEquals(new BritishTimeConvertor().timeToSpokenWords(12, 0), "noon");
    }

    @Test
    public void testTimeToWordsPastTime() {
        Assert.assertEquals(new BritishTimeConvertor().timeToSpokenWords(10, 20), "twenty past ten");

    }

    @Test
    public void testTimeToWordsToTime() {
        Assert.assertEquals(new BritishTimeConvertor().timeToSpokenWords(11, 55), "five to twelve");
        Assert.assertEquals(new BritishTimeConvertor().timeToSpokenWords(12, 50), "ten to one");
    }

    @Test
    public void testTimeToWordsInvalidHourRange() {
        BritishTimeConvertor brtConvertor = new BritishTimeConvertor();
        Assert.assertNull(brtConvertor.timeToSpokenWords(24, 0));
        Assert.assertNull(brtConvertor.timeToSpokenWords(24, 2));
        Assert.assertNull(brtConvertor.timeToSpokenWords(25, 0));
        Assert.assertNull(brtConvertor.timeToSpokenWords(25, 12));
        Assert.assertNull(brtConvertor.timeToSpokenWords(25, 15));
        Assert.assertNull(brtConvertor.timeToSpokenWords(-1, 0));
    }

    @Test
    public void testTimeToWordsInvalidMinuteRange() {
        BritishTimeConvertor brtConvertor = new BritishTimeConvertor();
        Assert.assertNull(brtConvertor.timeToSpokenWords(23, 60));
        Assert.assertNull(brtConvertor.timeToSpokenWords(11, 60));
        Assert.assertNull(brtConvertor.timeToSpokenWords(11, 65));
        Assert.assertNull(brtConvertor.timeToSpokenWords(12, 60));

        Assert.assertNull(brtConvertor.timeToSpokenWords(12, -1));
    }


    @Test
    public void testTimeToWordsEdgeCaseNonDivisibleByFive() {
        BritishTimeConvertor brtConvertor = new BritishTimeConvertor();

        Assert.assertEquals(brtConvertor.timeToSpokenWords(6, 32), "six thirty two");
        Assert.assertEquals(brtConvertor.timeToSpokenWords(12, 29), "twelve twenty nine");
        Assert.assertEquals(brtConvertor.timeToSpokenWords(12, 59), "twelve fifty nine");
        Assert.assertEquals(brtConvertor.timeToSpokenWords(23, 59), "eleven fifty nine");


    }

}
