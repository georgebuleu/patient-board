package com.cegeka.academy.patienthub.DTO;

public class HospitalStaffDTO {
    private Long id;
    private String name;
    private String email;
    private String password;
    private Long specialityId;
    private Long functionId;

    public HospitalStaffDTO() {
    }

    public HospitalStaffDTO(Long id, String name, String email, String password, Long specialityId, Long functionId) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.specialityId = specialityId;
        this.functionId = functionId;
    }

    public HospitalStaffDTO(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getSpecialityId() {
        return specialityId;
    }

    public void setSpecialityId(Long specialityId) {
        this.specialityId = specialityId;
    }

    public Long getFunctionId() {
        return functionId;
    }

    public void setFunctionId(Long functionId) {
        this.functionId = functionId;
    }
}
