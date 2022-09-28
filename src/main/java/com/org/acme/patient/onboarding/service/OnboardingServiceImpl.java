package com.org.acme.patient.onboarding.service;


import com.org.acme.patient.onboarding.repository.IOnboardingPatientRepository;
import org.acme.patient.onboarding.model.Doctor;
import org.acme.patient.onboarding.model.Hospital;
import javax.enterprise.context.ApplicationScoped;
import java.util.List;
import java.util.stream.Stream;

@ApplicationScoped
public class OnboardingServiceImpl implements IOnboardingService{


    private final IOnboardingPatientRepository repository;

    public OnboardingServiceImpl(IOnboardingPatientRepository repository) {
        this.repository = repository;
    }

    @Override
    public Hospital getParticipatingHospital(String zip) {
        List<Hospital> hospitalFlux= repository.getParticipatingHospitals();
        Stream<Hospital> hospitals = hospitalFlux.stream();
        Hospital hospital = hospitals.filter(h -> h.getZip().equals(zip))
                .findFirst()
                .orElse(new Hospital("Local Hospital","123 Local Street", "555-55-5555", "12345"));

        return hospital;
    }

    @Override
    public Doctor getParticipatingDoctor(String condition) {
        List<Doctor> doctorFlux= repository.getParticipatingDoctors();
        Stream<Doctor> doctors = doctorFlux.stream();
        Doctor doctor = doctors.filter(d -> d.getSpecialty().equals(condition))
                .findFirst()
                .orElse(new Doctor("Michael Scott", "img/docfemale.png", "General"));

        return doctor;
    }
}
        