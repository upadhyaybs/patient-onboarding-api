package com.org.acme.patient.onboarding.service;


import com.org.acme.patient.onboarding.model.Doctor;
import com.org.acme.patient.onboarding.model.Hospital;

public interface IOnboardingService {

  Hospital getParticipatingHospital(String zip);

  Doctor getParticipatingDoctor(String condition);
}