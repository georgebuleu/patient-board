package com.cegeka.academy.patienthub.model;

public enum StatusOfInsured {

    CNAS_INSURED("cnas-insured"),
    MANDATORY_CAS_INSURED("mandatory-cas-insured"),
    OPTIONAL_CAS_INSURED("optional-cas-insured"),
    VOLUNTARY_INSURANCE("voluntary-insurance"),
    UNINSURED("uninsured"),
    EUROCARD("eurocard"),
    INTERNATIONAL_AGREEMENTS("international-agreements");

    private final String value;

    StatusOfInsured(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
