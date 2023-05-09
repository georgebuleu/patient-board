package com.cegeka.academy.patienthub.DTO;

public class GetPatientByHospitalDTO {
    private Long patientId;

    private String name;

    private String roomName;

    public GetPatientByHospitalDTO(Long patientId, String name, String roomName) {
        this.patientId = patientId;
        this.name = name;
        this.roomName = roomName;
    }

    public Long getPatientId() {
        return patientId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }
}
