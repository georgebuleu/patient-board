package com.cegeka.academy.patienthub.service;

import com.cegeka.academy.patienthub.dto.User;

import java.util.Optional;

public interface HospitalStaffService  {
   Optional <User> getUserByEmail(String email);
}
