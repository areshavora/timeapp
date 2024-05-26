package com.timeworld;

import com.timeworld.spokentime.SpokenTimeConvertor;
import com.timeworld.spokentime.SupportedSpokenConversion;
import org.apache.commons.lang3.StringUtils;

import java.util.Scanner;

/**
 * <p> <b>TimeApp is an application to support various time related operations. </b> <br>sAt present, application support the time to words conversion functionality.
 * <br> say for example, given the time in hour:minute of 24-hour format then application will print the corresponding British Spoken Time format.</p>
 */
public class TimeApp {
    public static void main(String[] args) {

        Scanner scanner = null;
        try {
            System.out.println("================ Welcome to TimeApp! ================");
            System.out.println("---------- Time to Spoken Words Conversion ---------- ");
            System.out.print("Select conversion option [Press 1: For British Spoken Words (Default), Press 2: Germany Spoken Time ] :");
            scanner = new Scanner(System.in);
            String conversionOption = scanner.nextLine();
            SupportedSpokenConversion spokenConversion = getSupportedSpokenConversion(conversionOption);
            do {

                System.out.print("Enter the time in hour:minute format (24 hour HH:MM) [Press q/Q to exit from application] :");
                String inputTime = scanner.nextLine();
                if (StringUtils.isNotBlank(inputTime) && inputTime.equalsIgnoreCase("q")) {
                    break;
                }
                SpokenTimeConvertor spokenTimeConvertor = new SpokenTimeConvertor();
                spokenTimeConvertor.printSpokenWordsOfTime(inputTime,spokenConversion);

            } while (true);
            System.out.println("================ Application Terminated! ================");
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }
    }

    private static SupportedSpokenConversion getSupportedSpokenConversion(final String conversionOption) {
        SupportedSpokenConversion spokenConversion =  SupportedSpokenConversion.BRITISH;
        if( StringUtils.isBlank(conversionOption) || (!conversionOption.equals("1") && !conversionOption.equals("2"))){
            System.out.println("Selected option is not supported!, So, considering default option");
        }else if(conversionOption.equals(SupportedSpokenConversion.GERMANY.getOption())) {
            spokenConversion = SupportedSpokenConversion.GERMANY;
        }
        return spokenConversion;
    }

}
