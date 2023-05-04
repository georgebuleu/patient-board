package com.cegeka.academy.patienthub.model;

public enum TypeOfAdmission {

    EMERGENCY("emergency"),
    MF_REFERRAL("mf-referral"),
    OUTPATIENT_REFERRAL("outpatient-referral"),
    INTERSPIT_TRANSFER("interspit-transfer"),
    ON_DEMAND("on-demand"),
    OTHER("other");

    private final String value;

    TypeOfAdmission(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
