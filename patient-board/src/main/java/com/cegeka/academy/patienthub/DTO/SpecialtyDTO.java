package com.cegeka.academy.patienthub.DTO;

public class SpecialtyDTO {

    private Long specialtyId;
    private String name;

    public SpecialtyDTO(Long specialtyId, String name) {
        this.specialtyId = specialtyId;
        this.name = name;
    }

    public Long getSpecialtyId() {
        return specialtyId;
    }

    public void setSpecialtyId(Long specialtyId) {
        this.specialtyId = specialtyId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
