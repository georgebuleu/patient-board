package com.cegeka.academy.patienthub.model;

public enum TypeOfInsurance {

    EMPLOYEE("employee"),
    COINSURED("co-insured"),
    RETIREE("retiree"),
    MINOR_UNDER_18_YEARS("minor<18"),
    STUDENT_BTW_18_26_YEARS("student-btw-18-26"),
    PREGNANT("pregnant"),
    VETERAN("veteran"),
    REVOLUTIONIST("revolutionist"),
    HANDICAP("handicap"),
    PNS("pns"),
    SOCIAL_ASSISTANCE("social-assistance"),
    UNEMPLOYMENT("unemployment"),
    OTHER("other");

    private final String value;

    TypeOfInsurance(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
