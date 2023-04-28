package com.cegeka.academy.patienthub.service;

import com.cegeka.academy.patienthub.dto.User;
import com.cegeka.academy.patienthub.model.HospitalStaff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

public interface HospitalStaffService  {
   Optional <User> getUserByEmail(String email);
}
