package com.org.acme.patient.onboarding.repository;

import org.acme.patient.onboarding.model.Doctor;
import org.acme.patient.onboarding.model.Hospital;

import java.util.List;


public interface IOnboardingPatientRepository {

    List<Hospital> getParticipatingHospitals();

    List<Doctor> getParticipatingDoctors();
}
