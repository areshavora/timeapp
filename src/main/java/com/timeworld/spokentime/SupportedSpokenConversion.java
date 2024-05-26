package com.timeworld.spokentime;

public enum SupportedSpokenConversion {
    BRITISH("1","British Spoken"), GERMANY("2","Germany Spoken");
    final String option;
    final String type;
     SupportedSpokenConversion(String option,String type){
        this.option = option;
        this.type = type;
    }

    public String getOption() {
        return option;
    }
    public String getType() {
        return type;
    }


}
