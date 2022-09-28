package com.org.acme.patient.onboarding.service;

import org.acme.patient.onboarding.model.Doctor;
import org.acme.patient.onboarding.model.Hospital;




public interface IOnboardingService {

  Hospital getParticipatingHospital(String zip);

  Doctor getParticipatingDoctor(String condition);
}